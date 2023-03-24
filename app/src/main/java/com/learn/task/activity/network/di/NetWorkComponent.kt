package com.learn.grammarenglish.activity.network.di
import com.learn.task.activity.network.NetWorkActivity
import com.learn.task.app.AppActivity
import com.learn.task.app.AppComponent
import dagger.Component


@AppActivity
@Component(modules=[(NetWorkModule::class)], dependencies=[(AppComponent::class)])
interface NetWorkComponent {

    abstract fun inject(netWorkActivity: NetWorkActivity)
}