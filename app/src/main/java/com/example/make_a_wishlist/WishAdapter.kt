package com.example.make_a_wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class WishAdapter (private val items: List<Wish>): RecyclerView.Adapter<WishAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView
        val priceName: TextView
        val urlName: TextView

        init {
            itemName = itemView.findViewById(R.id.itemName)
            priceName = itemView.findViewById(R.id.price)
            urlName = itemView.findViewById(R.id.url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val contactView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val wish = items[position]

            holder.itemName.text = wish.name
            holder.priceName.text = wish.price
            holder.urlName.text = wish.url
    }


}