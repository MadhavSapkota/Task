package com.learn.task.activity.network
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.task.activity.network.NetWorkActivity.networkInfo.act_type
import com.learn.grammarenglish.activity.network.di.DaggerNetWorkComponent
import com.learn.grammarenglish.activity.network.di.NetWorkModule
import com.learn.task.activity.network.mvp.NetworkPresenter
import com.learn.task.activity.network.mvp.NetworkView
import com.learn.task.app.AppApplication


import javax.inject.Inject


class NetWorkActivity : AppCompatActivity() {

    @Inject
    lateinit var networkView: NetworkView

    @Inject
    lateinit var networkPresenter: NetworkPresenter

    object typeInfo {
        var activityType: Int?=0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mvpKotlinApplication= AppApplication()
        DaggerNetWorkComponent.builder()
            .appComponent(mvpKotlinApplication.get(this).appComponent)
            .netWorkModule(NetWorkModule(this))
            .build()
            .inject(this)
        setContentView(networkView)
        networkPresenter.onCreateView(act_type)
    }

    companion object {
        fun start(context: Context, types: Int) {
            act_type=types
            context.startActivity(Intent(context, NetWorkActivity::class.java))
        }
    }

    object networkInfo {
    var act_type:Int=0
}


}
