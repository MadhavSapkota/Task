package com.learn.task.activity.country.adapters
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.learn.task.databinding.CountryDataBinding


class CountryHolder(binding: CountryDataBinding) : RecyclerView.ViewHolder(binding.root) {
    var tvProvienceName: TextView = binding!!.tvTitleName
    var rlTitle: RelativeLayout = binding!!.rlTitle
    var cardName: CardView = binding!!.cVCountry
    var tvGrammarDetails = binding!!.countryInfo
}







