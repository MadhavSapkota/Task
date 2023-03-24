package com.learn.task.activity.network.mvp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.learn.task.activity.country.CountryActivity
import com.learn.task.activity.country_details.CountryDetailsActivity

class NetworkModel(private val appCompatActivity: AppCompatActivity) {

    fun getMainActivity(){
        val intent=Intent(appCompatActivity, CountryActivity::class.java)
        appCompatActivity.startActivity(intent)
        appCompatActivity.finish()
    }

    fun getSplashActivity(){
        val intent=Intent(appCompatActivity, CountryDetailsActivity::class.java)
        appCompatActivity.startActivity(intent)
        appCompatActivity.finish()
    }

}