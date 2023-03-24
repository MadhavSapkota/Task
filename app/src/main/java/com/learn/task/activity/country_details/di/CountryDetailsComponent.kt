package com.learn.task.activity.country_details.di
import com.learn.task.activity.country_details.CountryDetailsActivity
import com.learn.task.app.AppActivity
import com.learn.task.app.AppComponent
import dagger.Component

@AppActivity
@Component(modules=[(CountryDetailsModule::class)],dependencies=[(AppComponent::class)])
interface CountryDetailsComponent {
    abstract fun inject(countryDetailsActivity: CountryDetailsActivity)
}