package com.example.constraintlayouttask

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.constraintlayouttask.RecyclerAdapter.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerAdapter(
    private val itemList: List<Item>,
    private val mContext: Context,
    private val onItemUpdate: (position: Int) -> Unit,
    private val onItemRemove: (position: Int) -> Unit,
    private val onItemAdd: (position: Int) -> Unit

) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    lateinit var listener: AdapterClickListner




    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView= itemView.findViewById(R.id.imageView)
        val name: TextView=itemView.findViewById(R.id.productMane)
        val price: TextView=itemView.findViewById(R.id.productPrice)
        val offerdetails:TextView=itemView.findViewById(R.id.offerDetails)
        val cross:ImageButton=itemView.findViewById(R.id.crossButton)

        init {
            itemView.setOnClickListener {
                itemView.setBackgroundColor(Color.BLUE)
                onItemUpdate(adapterPosition)

            }
            cross.setOnClickListener {
                onItemRemove(adapterPosition)
            }

        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v:View=LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.name.text = item.getName()
        holder.price.text=item.getPrice()
        holder.offerdetails.text=item.getOffer()
        holder.image.setImageResource(item.getImage())

    }




    override fun getItemCount(): Int {
        return itemList.size
    }
}