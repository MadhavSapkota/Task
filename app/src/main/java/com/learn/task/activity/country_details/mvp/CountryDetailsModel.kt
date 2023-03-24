package com.learn.task.activity.country_details.mvp
import androidx.appcompat.app.AppCompatActivity
import com.learn.task.activity.country.CountryActivity

import com.learn.task.apputlis.ApiConstants
import com.learn.task.apputlis.ApiConstants.selectedUrl
import com.learn.task.activity.network.NetWorkActivity

class CountryDetailsModel(
    private val appCompatActivity: AppCompatActivity,
) {
    fun getCountryDashboardView() {
       CountryActivity.start(appCompatActivity)
    }

    fun getNetworkInfo() {
        NetWorkActivity.start(appCompatActivity,0)
        appCompatActivity.finish()
    }

    fun getCountryContents(countryId: Int, myurl:String): String {
        selectedUrl = myurl
        when {
            countryId == ApiConstants.NEPAL-> selectedUrl = ApiConstants.nepalLink
            countryId == ApiConstants.INDIA-> selectedUrl = ApiConstants.indiaLink
            countryId == ApiConstants.CHINA-> selectedUrl = ApiConstants.chinaLink
            countryId == ApiConstants.AMERICA-> selectedUrl = ApiConstants.americaLink
            countryId == ApiConstants.GERMANY-> selectedUrl = ApiConstants.germanyLink
            countryId == ApiConstants.BHUTAN-> selectedUrl = ApiConstants.bhutanLink
            countryId == ApiConstants.UNITEDKINGDOM-> selectedUrl = ApiConstants.ukLink
            countryId == ApiConstants.RUSSIA-> selectedUrl = ApiConstants.russiaLink
            countryId == ApiConstants.SRILANKA-> selectedUrl = ApiConstants.srilankaLink
            countryId == ApiConstants.PAKISTAN-> selectedUrl = ApiConstants.pakistanLink
        }
        return selectedUrl
        }
    }