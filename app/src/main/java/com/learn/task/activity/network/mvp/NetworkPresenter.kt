package com.learn.task.activity.network.mvp

import android.os.Handler

class NetworkPresenter(private val networkView: NetworkView, private val networkModel: NetworkModel) {
var types:Int=0
    fun onCreateView(type:Int){
        types=type
        onClick(type)
    }

    fun onClick(type:Int){
        networkView.getNetWorkObserable().doOnNext {
            when {
                networkView.checkNetwork() -> {
                    when(type){
                       0->  networkModel.getMainActivity()
                        else-> networkModel.getSplashActivity()
                    }
                }
                else -> {

                    networkView.showProgressDialog()
                    useThread()
                }
            }
        }.subscribe ()

        }


    private fun useThread() {
        val handler = Handler()
        val r = Runnable {
            networkView.hidProgressDialog()
            onCreateView(types) }
        handler.postDelayed(r, 2000)

    }



}