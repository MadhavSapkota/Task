@file:Suppress("DEPRECATION")

package com.learn.task.apputlis
import android.content.Context
import android.net.ConnectivityManager


object NetworkUtil {

    fun checkInternetConnection(context: Context): Boolean {
        var haveConnectedWifi=false
        var haveConnectedMobile=false
        val cm=context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        try {
            val netInfo=cm.allNetworkInfo
            for (ni in netInfo) {
                if (ni.typeName.equals("WIFI", ignoreCase=true))
                    if (ni.isConnected)
                        haveConnectedWifi=true
                if (ni.typeName.equals("MOBILE", ignoreCase=true))
                    if (ni.isConnected)
                        haveConnectedMobile=true
            }
        } catch (e: Exception) {
            e.stackTrace
        }

        return haveConnectedWifi || haveConnectedMobile
    }

}