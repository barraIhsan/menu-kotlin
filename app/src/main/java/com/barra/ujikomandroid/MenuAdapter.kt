package com.barra.ujikomandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val menuList: List<MenuActivity.MenuItem>) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    // Define a click listener interface
    interface OnItemClickListener {
        fun onItemClick(item: MenuActivity.MenuItem)
    }

    private var listener: OnItemClickListener? = null

    // Set the click listener
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.menu_item_image)
        val nameView: TextView = itemView.findViewById(R.id.menu_item_name)
        val priceView: TextView = itemView.findViewById(R.id.menu_item_price)
        val descView: TextView = itemView.findViewById(R.id.menu_item_description)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(menuList[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = menuList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.nameView.text = currentItem.name
        holder.priceView.text = currentItem.price
        holder.descView.text = currentItem.description
    }

    override fun getItemCount() = menuList.size
}
