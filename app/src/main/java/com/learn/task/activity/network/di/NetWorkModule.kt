package com.learn.grammarenglish.activity.network.di
import androidx.appcompat.app.AppCompatActivity
import com.learn.task.activity.network.mvp.NetworkModel
import com.learn.task.activity.network.mvp.NetworkPresenter
import com.learn.task.activity.network.mvp.NetworkView
import com.learn.task.app.AppActivity
import dagger.Module
import dagger.Provides

@Module

class NetWorkModule(private val appCompatActivity: AppCompatActivity) {
    @AppActivity

    @Provides

    fun getNetwoKView(): NetworkView {

        return NetworkView(appCompatActivity)

    }

    @Provides
    fun getNetworkModel(): NetworkModel {
        return NetworkModel(appCompatActivity)
    }

    @Provides

    fun getNetWorkPresenter(
        networkView: NetworkView,
        networkModel: NetworkModel
    ): NetworkPresenter {
        return NetworkPresenter(networkView, networkModel)
    }
}