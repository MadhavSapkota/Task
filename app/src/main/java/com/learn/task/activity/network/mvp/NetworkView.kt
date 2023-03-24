package com.learn.task.activity.network.mvp
import android.app.ProgressDialog
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.learn.task.R
import com.learn.task.apputlis.NetworkUtil


import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.network.view.*

class NetworkView(private val appCompatActivity: AppCompatActivity):FrameLayout(appCompatActivity) {
    private val progressDialog=ProgressDialog(context, R.style.MyProgressDialogStyle)
    init {

        View.inflate(appCompatActivity, R.layout.network, this)
        progressDialog.setCancelable(false)
    }

    fun checkNetwork(): Boolean {
        return NetworkUtil.checkInternetConnection(appCompatActivity)
    }

    fun showProgressDialog() {
        progressDialog.show()
        progressDialog.setMessage("Loading...")
    }

    fun hidProgressDialog() {
        progressDialog.dismiss()
    }

    fun getNetWorkObserable():Observable<Any>{
        return RxView.clicks(btnNoNetwork)
    }
}