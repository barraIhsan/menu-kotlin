package com.barra.ujikomandroid

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class MenuActivity : AppCompatActivity() {

    private lateinit var menuRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_list)

        // Get a reference to the RecyclerView
        menuRecyclerView = findViewById(R.id.menu_recycler_view)

        // Set the layout manager for the RecyclerView
        menuRecyclerView.layoutManager = LinearLayoutManager(this)

        // Create a list of menu items
        val menuItems = listOf(
            MenuItem("Nasi Goreng", "Nasi Goreng is a popular fried rice dish in Indonesia. The dish is made with rice that has been stir-fried with various spices, vegetables, and often includes meat, such as chicken or shrimp.", "Rp 25.000", R.drawable.nasi_goreng),
            MenuItem("Sate Ayam", "Sate Ayam is a classic Indonesian street food made with grilled chicken skewers. The chicken is marinated in a mixture of soy sauce, garlic, and other spices, and then grilled to perfection.", "Rp 20.000", R.drawable.sate_ayam),
            MenuItem("Gado-gado", "Gado-gado is a traditional Indonesian salad made with a mix of vegetables, tofu, and tempeh, topped with a peanut sauce dressing. It is a healthy and filling dish that is perfect for a light lunch or dinner.", "Rp 18.000", R.drawable.gado_gado),
            MenuItem("Rendang", "Rendang is a slow-cooked beef dish that originates from the Minangkabau people of West Sumatra. The dish is made with beef that has been simmered for hours in a mixture of coconut milk and spices, resulting in a tender and flavorful dish.", "Rp 35.000", R.drawable.rendang),
            MenuItem("Nasi Padang", "Nasi Padang is a traditional Indonesian rice dish that originated from the Padang region in Sumatra. The dish consists of steamed rice served with a variety of small side dishes, such as meat, vegetables, and curry.", "Rp 30.000", R.drawable.nasi_padang),
            MenuItem("Soto Ayam", "Soto Ayam is a traditional Indonesian chicken soup made with chicken broth, turmeric, and other spices. It is typically served with shredded chicken, rice noodles, and a variety of herbs and condiments.", "Rp 15.000", R.drawable.soto_ayam),
            MenuItem("Sop Buntut", "Sop Buntut is a hearty Indonesian oxtail soup that is typically served as a main course. The dish is made with oxtail that has been simmered for several hours in a mixture of herbs and spices, resulting in a flavorful and tender meat.", "Rp 40.000", R.drawable.sop_buntut),
            MenuItem("Sambal Udang", "Sambal Udang is a spicy shrimp dish that is often served as a side dish or appetizer. The shrimp is sautéed in a mixture of spices, such as chili, garlic, and ginger, resulting in a spicy and flavorful dish.", "Rp 25.000", R.drawable.sambal_udang),
            MenuItem("Bakso", "Bakso is an Indonesian meatball soup that is typically made with beef or pork. The meatballs are served in a clear broth with noodles and various condiments, such as fried onions and chili sauce.", "Rp 12.000", R.drawable.bakso),
            MenuItem("Nasi Uduk", "Nasi Uduk is a traditional Indonesian rice dish that is made with coconut milk and various spices. The dish is often served with a variety of side dishes, such as fried chicken, tofu, and tempeh.", "Rp 20.000", R.drawable.nasi_uduk)
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

    data class MenuItem(val name: String?, val description: String?, val price: String?, val imageId: Int) : Parcelable {

        constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt()
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeString(description)
            parcel.writeString(price)
            parcel.writeInt(imageId)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<MenuItem> {
            override fun createFromParcel(parcel: Parcel): MenuItem {
                return MenuItem(parcel)
            }

            override fun newArray(size: Int): Array<MenuItem?> {
                return arrayOfNulls(size)
            }
        }
    }


}
