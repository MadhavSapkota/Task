package com.learn.task.activity.country_details.mvp
import android.os.Build
import androidx.annotation.RequiresApi
import com.learn.task.apputlis.ApiConstants.selectedUrl


class CountryDetailsPresenter(
    private val coutryDetailsView: CountryDetailsView,
    private val countryDetailsModel: CountryDetailsModel,
) {

    @RequiresApi(Build.VERSION_CODES.O)
    fun onCreate(countryId: Int, countryName: String) {

        onClick()
        getCountryContents(countryId,countryName)
    }

    private fun onClick() {
        coutryDetailsView.getBackObserable().doOnNext {countryDetailsModel.getCountryDashboardView()}.subscribe()
    }

    fun getBackOnClick(){
        countryDetailsModel.getCountryDashboardView()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun getCountryContents(grammarId: Int, grammarName: String) {

        when {coutryDetailsView.checkNetwork() -> {
                countryDetailsModel.getCountryContents(grammarId, grammarName)
                coutryDetailsView.grammarContentsWebView(selectedUrl)
            }
            else ->{
                countryDetailsModel.getNetworkInfo()
            }
        }
    }
}



