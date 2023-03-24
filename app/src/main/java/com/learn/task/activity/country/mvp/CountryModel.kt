package com.learn.task.activity.country.mvp
import androidx.appcompat.app.AppCompatActivity
import com.learn.task.activity.country_details.CountryDetailsActivity
import com.learn.task.apputlis.AppUtils

class CountryModel(
    private val appCompatActivity: AppCompatActivity) {

    fun getGrammarContents(grammarId: Int, grammarName: String,grammarInfo:String){
        CountryDetailsActivity.start(appCompatActivity,grammarId,grammarName,grammarInfo)

    }

    fun finished(){

        AppUtils.goBack(appCompatActivity)
    }

}

