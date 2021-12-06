package com.example.tastebuds.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tastebuds.R

class RestaurantAdapter (private val restaurantArrayList: MutableList<Restaurant>) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {
    /*
         * Inflate our views using the layout defined in row_layout.xml
         */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.restaurant_row_layout, parent, false)

        return ViewHolder(v)
    }

    /*
     * Bind the data to the child views of the ViewHolder
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = restaurantArrayList[position]

        holder.imgView.setImageResource(info.getImages())
        holder.name.text = info.getNames()
        holder.distance.text = info.getRestaurantDistance().toString() + "km"
        holder.rating.rating = info.getRestaurantRating().toFloat()
    }

    /*
     * Get the maximum size of the
     */
    override fun getItemCount(): Int {
        return restaurantArrayList.size
    }

    /*
     * The parent class that handles layout inflation and child view use
     */
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        var imgView = itemView.findViewById<View>(R.id.icon) as ImageView
        var name = itemView.findViewById<View>(R.id.firstLine) as TextView
        var distance = itemView.findViewById<View>(R.id.distance) as TextView
        var rating = itemView.findViewById<View>(R.id.ratingBar2) as RatingBar

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val msg = name.text
            //val snackbar = Snackbar.make(v, "$msg" + R.string.msg, Snackbar.LENGTH_LONG)
            //snackbar.show()
        }
    }
}