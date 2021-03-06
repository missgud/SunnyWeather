package com.sunnyweather.android.ui.place

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sunnyweather.android.R
import com.sunnyweather.android.logic.model.Place
import com.sunnyweather.android.ui.weather.WeatherActivity
import kotlinx.android.synthetic.main.place_item.view.*

class PlaceAdapter(private val fragment: PlaceFragment, private val placeList: List<Place>) :
    RecyclerView.Adapter<PlaceAdapter.ViewHodler>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHodler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        val holder = ViewHodler(view)
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            val place = placeList[position]
            val intent = Intent(parent.context, WeatherActivity::class.java).apply {
                putExtra("location_lng", place.location.lng)
                putExtra("location_lat", place.location.lat)
                putExtra("place_name", place.name)
            }
            fragment.viewModel.savePlace(place)
            fragment.startActivity(intent)
            fragment.activity?.finish()
        }
        return holder
    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    override fun onBindViewHolder(holder: ViewHodler, position: Int) {
        val place = placeList[position]
        holder.placeName.text = place.name
        holder.placeAddress.text = place.address
    }

    class ViewHodler(view: View) : RecyclerView.ViewHolder(view) {
        val placeName = view.findViewById<TextView>(R.id.placeName)
        val placeAddress = view.findViewById<TextView>(R.id.placeAddress)
    }


}