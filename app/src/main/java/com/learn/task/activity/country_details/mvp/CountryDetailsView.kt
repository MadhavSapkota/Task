package com.learn.task.activity.country_details.mvp
import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Build
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.learn.task.activity.country_details.CountryDetailsActivity.countryDetails.countryInfo
import com.learn.task.activity.country_details.CountryDetailsActivity.info.countryId
import com.learn.task.activity.country_details.CountryDetailsActivity.tag.countryName
import com.jakewharton.rxbinding2.view.RxView
import com.learn.task.databinding.CountryContentsBinding
import com.learn.task.dialog.ErrorDailog
import com.learn.task.activity.country.dto.CountryData
import com.learn.task.apputlis.NetworkUtil
import io.reactivex.Observable


class CountryDetailsView(
    private val appCompatActivity: AppCompatActivity,

) {
    var binding: CountryContentsBinding? = null

    var countryData = countryId?.let { countryInfo?.let { it1 ->
        CountryData(it, countryName!!,
            it1
        )
    } }

    fun start(binding_countryDetails: CountryContentsBinding) {
        binding = binding_countryDetails
        binding!!.tvHeading.text = countryData!!.getCountryName()

    }

    fun getBackObserable(): Observable<Any> {
        return RxView.clicks(binding!!.ivBack)
    }

    fun checkNetwork(): Boolean {
        return NetworkUtil.checkInternetConnection(appCompatActivity)
    }

    fun getErrorMessage(message: String) {
        appCompatActivity.runOnUiThread(Runnable {
            ErrorDailog(appCompatActivity, message!!)
        })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    fun grammarContentsWebView(url: String) {
        binding!!.webView.settings.javaScriptEnabled = true
        binding!!.webView.settings.builtInZoomControls = true
        binding!!.webView.settings.setSupportZoom(true)
        binding!!.webView.settings.useWideViewPort = true
        binding!!.webView.settings.loadWithOverviewMode = true
        binding!!.webView.webViewClient = CustomClient(binding!!.progressBar)
        binding!!.webView.loadUrl(url)

    }
}
        class CustomClient(private val progress: ProgressBar) : WebViewClient() {
            var progressDialog: ProgressDialog? = null

            fun onPageStarted(view: WebView?, url: String?) {
                progressDialog!!.progress = View.GONE
                progressDialog!!.setTitle("Loading...")
            }

            override fun shouldOverrideUrlLoading(webview: WebView, url: String): Boolean {
                webview.loadUrl(url)
                return true
            }

            override fun onPageFinished(webview: WebView?, url: String?) {
                progress!!.visibility = View.GONE
                try {
                } catch (exception: Exception) {
                    exception.printStackTrace()
                }
            }
        }
