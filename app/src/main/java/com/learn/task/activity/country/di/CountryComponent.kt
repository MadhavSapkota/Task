package com.learn.task.activity.country.di
import com.learn.task.activity.country.CountryActivity
import com.learn.task.app.AppActivity
import com.learn.task.app.AppComponent
import dagger.Component

@AppActivity
@Component(modules=[(CountryModule::class)], dependencies=[(AppComponent::class)])
interface CountryComponent {
    abstract fun inject(dashboardActivity: CountryActivity)
}