package com.learn.task.activity.country.adapters
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding2.view.RxView
import com.learn.task.R
import com.learn.task.databinding.CountryDataBinding
import com.learn.task.activity.country.dto.CountryData
import io.reactivex.subjects.PublishSubject


class CountryAdapter(var context: Context) : RecyclerView.Adapter<CountryHolder>() {
    private var countryList = ArrayList<CountryData>()
    var clickSubject1 = PublishSubject.create<CountryData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val inflator = LayoutInflater.from(parent.context)
        val view = CountryDataBinding.inflate(inflator, parent, false)
        val viewHolder = CountryHolder(view)
        performCardListener(viewHolder, parent)
        return viewHolder
    }

    //action listner when a user clicks news headings
    @SuppressLint("NotifyDataSetChanged")
    private fun performCardListener(
        viewHolder: CountryHolder,
        parent: ViewGroup
    ) {
        RxView.clicks(viewHolder.rlTitle as View)
            .takeUntil(RxView.detaches(parent))
            .map { countryList[viewHolder.adapterPosition] }
            .doOnEach {
                val position: Int = viewHolder.adapterPosition
                notifyItemChanged(position)
            }
            .subscribe(clickSubject1)
    }



    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        val result = countryList[position]
        holder.tvProvienceName.text = result.getCountryName()
        holder.tvGrammarDetails.text = result.getCountryInfo()


        when {
            position % 2 == 0 -> {
                //cardView normally doesnot show the backgroundColor, so we have to use ContextCompat with context
                holder.cardName.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.linkColor1
                    )
                )
            }
            else -> {
                holder.cardName.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorSecond
                    )
                )
            }
        }

    }


    //show news list
    @SuppressLint("NotifyDataSetChanged")
    fun showGrammarItem(countryData: ArrayList<CountryData>, aboolean: Boolean) {
        when {
            aboolean -> countryList.clear()
        }
        if (countryData != null)
            this.countryList.addAll((countryData))
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return countryList.size
    }

}