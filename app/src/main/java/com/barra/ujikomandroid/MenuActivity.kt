package com.barra.ujikomandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class MenuActivity : AppCompatActivity() {

    private lateinit var menuRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_list)

        // Get a reference to the RecyclerView
        menuRecyclerView = findViewById(R.id.menu_recycler_view)

        // Set the layout manager for the RecyclerView
        menuRecyclerView.layoutManager = LinearLayoutManager(this)

        // Create a list of menu items
        val menuItems = listOf(
            MenuItem(R.drawable.nasi_goreng, "Nasi Goreng", "Rp 25.000", "Nasi Goreng is a popular fried rice dish in Indonesia. The dish is made with rice that has been stir-fried with various spices, vegetables, and often includes meat, such as chicken or shrimp."),
            MenuItem(R.drawable.sate_ayam, "Sate Ayam", "Rp 20.000", "Sate Ayam is a classic Indonesian street food made with grilled chicken skewers. The chicken is marinated in a mixture of soy sauce, garlic, and other spices, and then grilled to perfection."),
            MenuItem(R.drawable.gado_gado, "Gado-gado", "Rp 18.000", "Gado-gado is a traditional Indonesian salad made with a mix of vegetables, tofu, and tempeh, topped with a peanut sauce dressing. It is a healthy and filling dish that is perfect for a light lunch or dinner."),
            MenuItem(R.drawable.rendang, "Rendang", "Rp 35.000", "Rendang is a slow-cooked beef dish that originates from the Minangkabau people of West Sumatra. The dish is made with beef that has been simmered for hours in a mixture of coconut milk and spices, resulting in a tender and flavorful dish."),
            MenuItem(R.drawable.nasi_padang, "Nasi Padang", "Rp 30.000", "Nasi Padang is a traditional Indonesian rice dish that originated from the Padang region in Sumatra. The dish consists of steamed rice served with a variety of small side dishes, such as meat, vegetables, and curry."),
            MenuItem(R.drawable.soto_ayam, "Soto Ayam", "Rp 15.000", "Soto Ayam is a traditional Indonesian chicken soup made with chicken broth, turmeric, and other spices. It is typically served with shredded chicken, rice noodles, and a variety of herbs and condiments."),
            MenuItem(R.drawable.sop_buntut, "Sop Buntut", "Rp 40.000", "Sop Buntut is a hearty Indonesian oxtail soup that is typically served as a main course. The dish is made with oxtail that has been simmered for several hours in a mixture of herbs and spices, resulting in a flavorful and tender meat."),
            MenuItem(R.drawable.sambal_udang, "Sambal Udang", "Rp 25.000", "Sambal Udang is a spicy shrimp dish that is often served as a side dish or appetizer. The shrimp is sautéed in a mixture of spices, such as chili, garlic, and ginger, resulting in a spicy and flavorful dish."),
            MenuItem(R.drawable.bakso, "Bakso", "Rp 12.000", "Bakso is an Indonesian meatball soup that is typically made with beef or pork. The meatballs are served in a clear broth with noodles and various condiments, such as fried onions and chili sauce."),
            MenuItem(R.drawable.nasi_uduk, "Nasi Uduk", "Rp 20.000", "Nasi Uduk is a traditional Indonesian rice dish that is made with coconut milk and various spices. The dish is often served with a variety of side dishes, such as fried chicken, tofu, and tempeh.")
        )

        // Create an instance of the MenuAdapter and set it as the adapter for the RecyclerView
        val adapter = MenuAdapter(menuItems)
        menuRecyclerView.adapter = adapter

        // Set the click listener on the adapter
        adapter.setOnItemClickListener(object : MenuAdapter.OnItemClickListener {
            override fun onItemClick(item: MenuItem) {
                val intent = Intent(this@MenuActivity, DetailActivity::class.java)
                intent.putExtra("item", item)
                startActivity(intent)
            }
        })
    }

    data class MenuItem(val imageResource: Int, val name: String, val price: String, val description: String): Serializable
}
