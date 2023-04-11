package com.barra.ujikomandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.barra.ujikomandroid.MenuActivity.MenuItem

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item = intent?.getParcelableExtra<MenuItem>("item")

        item?.let {
            val itemNameTextView = findViewById<TextView>(R.id.item_name)
            val itemImageView = findViewById<ImageView>(R.id.item_image)
            val itemDescriptionTextView = findViewById<TextView>(R.id.item_description)
            val itemPriceTextView = findViewById<TextView>(R.id.item_price)

            itemNameTextView.text = it.name
            itemImageView.setImageResource(it.imageId)
            itemDescriptionTextView.text = it.description
            itemPriceTextView.text = it.price
        }
    }
}

