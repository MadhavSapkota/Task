package com.learn.task.activity.country_details
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.learn.task.activity.country_details.CountryDetailsActivity.countryDetails.countryInfo
import com.learn.task.activity.country_details.CountryDetailsActivity.info.countryId
import com.learn.task.activity.country_details.mvp.CountryDetailsPresenter
import com.learn.task.activity.country_details.CountryDetailsActivity.tag.countryName
import com.learn.task.activity.country_details.di.CountryDetailsModule
import com.learn.task.databinding.CountryContentsBinding
import com.learn.task.activity.country_details.di.DaggerCountryDetailsComponent
import com.learn.task.activity.country_details.mvp.CountryDetailsView
import com.learn.task.app.AppApplication
import javax.inject.Inject

class CountryDetailsActivity : AppCompatActivity() {

    @Inject
    lateinit var countryListView: CountryDetailsView

    @Inject
    lateinit var countryListPresenter: CountryDetailsPresenter


    private lateinit var binding: CountryContentsBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mvpKotlinApplication= AppApplication()
        DaggerCountryDetailsComponent.builder()
            .appComponent(mvpKotlinApplication.get(this).appComponent)
            .countryDetailsModule(CountryDetailsModule(this))
            .build()
            .inject(this)
        binding=CountryContentsBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        countryListView.start(binding)
        countryId?.let { countryName?.let { it1 -> countryInfo?.let { it2 ->
            countryListPresenter.onCreate(
                it, it1
            )
        } } }
    }

    companion object {
        fun start(context: Context, id:Int, countryUrl: String, countryInf:String) {
            countryId=id
            countryName= countryUrl
            countryInfo = countryInf
            context.startActivity(Intent(context, CountryDetailsActivity::class.java))
        }
    }

    override fun onBackPressed() {
        countryListPresenter.getBackOnClick()
    }

    object info{
        var countryId: Int?=null
    }

    object  tag{
        var countryName:String? = null
    }

    object  countryDetails{
        var countryInfo:String? = null
    }
}
