package com.learn.task.app
import android.content.Context
import com.learn.task.app.*
import com.learn.task.databasemanager.ApplicationDatabase
import dagger.Component
import dagger.android.AndroidInjectionModule


@AppScope
@Component(modules=[AndroidInjectionModule::class, AppModule::class, NetworkModule::class, DatabaseModule::class])
interface AppComponent {
    fun context(): Context
    fun webservice(): Webservice
    fun database(): ApplicationDatabase


}
