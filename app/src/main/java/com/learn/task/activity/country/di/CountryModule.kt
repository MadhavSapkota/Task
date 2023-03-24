package com.learn.task.activity.country.di
import androidx.appcompat.app.AppCompatActivity
import com.learn.task.activity.country.adapters.CountryAdapter
import com.learn.task.activity.country.mvp.CountryModel
import com.learn.task.activity.country.mvp.CountryPresenter
import com.learn.task.activity.country.mvp.CountryView
import com.learn.task.databasemanager.ApplicationDatabase

import com.learn.task.app.AppActivity
import dagger.Module
import dagger.Provides

@Module
class CountryModule(private val appCompatActivity: AppCompatActivity) {

    @AppActivity
    @Provides
    fun getCountryView(countryAdapter: CountryAdapter): CountryView {
        return CountryView(appCompatActivity,countryAdapter)
    }

    @Provides
    fun getCountryModel(): CountryModel {
        return CountryModel(appCompatActivity)
    }

    @Provides
    fun getCountryPresenter(
        countryView: CountryView,
        countryModel: CountryModel,
        database: ApplicationDatabase
    ): CountryPresenter {
        return CountryPresenter(countryView,countryModel,database)
    }

    @Provides
    fun getCountryAdapter(): CountryAdapter {
        return CountryAdapter(appCompatActivity)
    }


}