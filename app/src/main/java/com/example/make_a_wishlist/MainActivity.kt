package com.example.make_a_wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var itemName: String = ""
    var price: String = ""
    var url: String = ""

    lateinit var items: List<Wish>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameTag = findViewById<EditText>(R.id.EnterName)
        val priceTag = findViewById<EditText>(R.id.EnterNumber)
        val urlTag = findViewById<EditText>(R.id.EnterURL)
        val submitButton = findViewById<Button>(R.id.moreButton)
        val itemsRv = findViewById<RecyclerView>(R.id.itemsRv)

        items = WishFetcher.getWish()
        val adapter = WishAdapter(items)
        itemsRv.adapter = adapter
        itemsRv.layoutManager = LinearLayoutManager(this)

        submitButton.setOnClickListener {
            itemName = nameTag.text.toString()
            price = priceTag.text.toString()
            url = urlTag.text.toString()
            val wish = Wish(itemName, price, url)
            (items as MutableList<Wish>).add(wish)

            adapter.notifyDataSetChanged()
        }



    }
}