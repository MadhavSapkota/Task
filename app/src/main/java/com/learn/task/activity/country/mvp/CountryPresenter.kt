package com.learn.task.activity.country.mvp
import com.learn.task.activity.country.dto.CountryData
import com.learn.task.databasemanager.ApplicationDatabase
import com.learn.task.databasemanager.CountryDbModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import timber.log.Timber

class CountryPresenter(
    private val countryView: CountryView,
    private val countryModel: CountryModel,
    private val database: ApplicationDatabase
) {

    private val compositeDisposable = CompositeDisposable()
    var countryData = ArrayList<CountryData>()
    var gramId: Int? = null
    var gramName: String = ""
    var countryDescription: String = ""

    fun onCreateView() {
        setGrammarList()
        setAdapter()
        onClickCard()
        onClick()
        getGrammarData()
        insertFavDB()
    }

    fun getBackOnClick() {
        countryModel.finished()
    }

    fun onClick() {

    }



    private fun setAdapter() {
        countryView.showListItems(countryData, true)
    }

    private fun setGrammarList() {
        countryData = ArrayList()
        countryData.add(CountryData(1, "Nepal", "(A country of Mountains)"))
        countryData.add(CountryData(2, "India", "(A country of Hinduism)"))
        countryData.add(CountryData(3, "China", "(A new rising power)"))
        countryData.add(CountryData(4, "America", "(An innovative nation of the world)"))
        countryData.add(CountryData(5, "Germany", "(Past nazi county)"))
        countryData.add(CountryData(6, "Bhutan", "A country of peace"))
        countryData.add(CountryData(7, "United Kingdom", "(Past big power)"))
        countryData.add(CountryData(8, "Russia", "(Leader of arctic Reason)"))
        countryData.add(CountryData(9, "Srilanka", "(Country where Lanka was believed to have)"))
        countryData.add(CountryData(10, "Pakistan", "(Muslim dominant nation)"))

   }
    fun getGrammarData() {
        for (data in countryData) {
            gramId = data.countryId
            gramName = data.countryName
            countryDescription = data.countryInfo
        }
    }


    private fun onClickCard() {
        val disposableObserver = getBackgroundImageListItemClickObserver()
        countryView.getCountryViewClickedObservable().subscribe(disposableObserver)
        compositeDisposable.add(disposableObserver)
    }

    private fun getBackgroundImageListItemClickObserver(): DisposableObserver<CountryData> {
        return object : DisposableObserver<CountryData>() {
            override fun onNext(countryData: CountryData) {
                countryModel.getGrammarContents(
                    countryData.getCountryId(),
                    countryData.getCountryName(), countryData.getCountryInfo()
                )
            }

            override fun onError(e: Throwable) {
                System.err.println("Error" + e)
            }

            override fun onComplete() {
                Timber.e("Clicked")
            }
        }
    }


    fun removeFavDb() {
        database.favoriteDao().deleteFav1()
    }



    private fun insertFavDB() {
        val countryList = mutableListOf<CountryDbModel>()
        for (data in countryData) {
            val country = CountryDbModel(
                countryId = data.countryId,
                countryName = data.countryName,
                countryDescription = data.countryInfo
            )
            countryList.add(country)
        }
        database.favoriteDao().insertSingleCard(countryList)
    }

}