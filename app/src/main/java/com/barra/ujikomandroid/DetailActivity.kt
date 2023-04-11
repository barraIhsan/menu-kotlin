package com.barra.ujikomandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item = intent.getSerializableExtra("item") as MenuItem

        val imageView: ImageView = findViewById(R.id.detail_image_view)
        imageView.setImageResource(item.imageResource)

        val nameView: TextView = findViewById(R.id.detail_name_view)
        nameView.text = item.name

        val priceView: TextView = findViewById(R.id.detail_price_view)
        priceView.text = item.price

        val descView: TextView = findViewById(R.id.detail_desc_view)
        descView.text = item.desc
    }
}
