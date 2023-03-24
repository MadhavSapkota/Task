package com.learn.task.activity.country
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learn.task.databinding.ActivityCountryLayoutBinding
import com.learn.task.app.AppApplication
import com.learn.task.activity.country.di.CountryModule
import com.learn.task.activity.country.di.DaggerCountryComponent
import com.learn.task.activity.country.mvp.CountryPresenter
import com.learn.task.activity.country.mvp.CountryView
import javax.inject.Inject


class CountryActivity : AppCompatActivity() {
    @Inject
    lateinit var countryView: CountryView

    @Inject
    lateinit var countryPresenter: CountryPresenter


    private lateinit var binding: ActivityCountryLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mvpKotlinApplication = AppApplication()
        DaggerCountryComponent.builder()
            .appComponent(mvpKotlinApplication.get(this).appComponent)
            .countryModule(CountryModule(this))
            .build()
            .inject(this)
        binding = ActivityCountryLayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        countryView.start(binding)
        countryPresenter.onCreateView()
    }

    override fun onResume() {
        super.onResume()
    }

    companion object {
        fun start(context: Context)
        {
            context.startActivity(Intent(context, CountryActivity::class.java))
        }
    }

    override fun onBackPressed() {
        countryPresenter.getBackOnClick()
    }

}