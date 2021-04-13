package com.example.constraintlayouttask

import android.widget.ImageView
import android.widget.TextView

class Item(
    val imageView: Int,
    val tittle:String,
    private val price: String,
    private val offer: String
) {
    fun getName(): String { return tittle  }
    fun getPrice(): String { return price  }
    fun getOffer(): String { return offer  }
    fun getImage(): Int { return imageView }
}