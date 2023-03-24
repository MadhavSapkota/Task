package com.learn.task.activity.country.mvp
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.task.activity.country.adapters.CountryAdapter
import com.learn.task.databinding.ActivityCountryLayoutBinding
import com.learn.task.activity.country.dto.CountryData
import io.reactivex.Observable
import java.util.ArrayList

class CountryView(
    val appCompatActivity: AppCompatActivity,
    private val countryAdapter: CountryAdapter
)

{
    var binding: ActivityCountryLayoutBinding?=null

    fun start(binding_dashboard: ActivityCountryLayoutBinding) {
        binding=binding_dashboard
        setCountryAdapter()
    }

    fun showListItems(countryData: ArrayList<CountryData>, aboolean: Boolean) {
        countryAdapter.showGrammarItem(countryData, aboolean)
    }



    fun setCountryAdapter() {
        var layoutmanager: LinearLayoutManager? = LinearLayoutManager(
            appCompatActivity, LinearLayoutManager.VERTICAL, false)
        binding!!.includesGrammarList.dashboardRecyclerView.setHasFixedSize(true)
        binding!!.includesGrammarList.dashboardRecyclerView.layoutManager = layoutmanager
        binding!!.includesGrammarList.dashboardRecyclerView.adapter = countryAdapter
    }


    //news list clickable
    fun getCountryViewClickedObservable(): Observable<CountryData> {
        return countryAdapter.clickSubject1
    }

}

