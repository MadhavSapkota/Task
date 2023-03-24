package com.learn.task.activity.country_details.di
import androidx.appcompat.app.AppCompatActivity
import com.learn.task.activity.country_details.mvp.CountryDetailsModel
import com.learn.task.activity.country_details.mvp.CountryDetailsPresenter
import com.learn.task.activity.country_details.mvp.CountryDetailsView
import com.learn.task.app.AppActivity
import dagger.Module
import dagger.Provides

@Module
class CountryDetailsModule(private val appCompatActivity: AppCompatActivity) {

    @AppActivity
    @Provides
    fun getCountryListView(): CountryDetailsView {
        return CountryDetailsView(appCompatActivity)
    }

    @Provides
    fun getCountryListModel(): CountryDetailsModel {
        return CountryDetailsModel(appCompatActivity)
    }

    @Provides
    fun getCountryListPresenter(
        newsListView: CountryDetailsView,
        newsListModel: CountryDetailsModel,
    ): CountryDetailsPresenter {
        return CountryDetailsPresenter(newsListView,newsListModel)
    }
}