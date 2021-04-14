package com.example.constraintlayouttask

import android.content.ClipData
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.constraintlayouttask.databinding.ActivityMainBinding
import com.example.constraintlayouttask.databinding.RecyclerViewBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var adpter: RecyclerAdapter
    lateinit var recyclerView : RecyclerView
    private lateinit var item:ArrayList<Item>
    private lateinit var item2:ArrayList<Item>

    lateinit var fab_addItem : FloatingActionButton
    lateinit var addedButton: Button
    lateinit var no_item_tv:TextView


    private lateinit var binding: RecyclerViewBinding

    private val recyclerViewAdapter by lazy {

        RecyclerAdapter(
            item2,this,
            {position ->
                onItemUpdate(position)
            }
            ,{
                    position ->
                onItemRemove(position)
            },{
                    position ->
                onItemAdd(position)
            }
        )

    }

    private fun onItemAdd(position: Int) {
        updateItemValueFromList(position)
    }

    private fun onItemRemove(position: Int) {
        item2.removeAt(position)
        adpter.notifyItemRemoved(position)
    }

    private fun onItemUpdate(position: Int) {
        updateItemValueFromList(position)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView=findViewById(R.id.recyclerView)
        fab_addItem=findViewById(R.id.floatingButtin)
        addedButton=findViewById(R.id.addedButton)



        fab_addItem.setOnClickListener {

            updateItemValueFromList(-1)


        }


        initListItem()

        binding.recyclerView.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )


        adpter= recyclerViewAdapter
        recyclerView.adapter=adpter

        addedButton.setOnClickListener {
            var i = 0
            if (item2.size <= item.size) {
                no_item_tv.visibility = View.GONE
                item2.add(item[i])
                item2.add(item[i + 1])
                item2.add(item[i + 2])
                i += 2
                Log.d("TAG", "onCreate: " + item2.size)
            } else {
                Toast.makeText(applicationContext, "no item on list", Toast.LENGTH_SHORT).show()
            }
            adpter.notifyDataSetChanged()


        }


    }

    public fun initListItem(){



        no_item_tv=findViewById(R.id.noItemTV)
        item= ArrayList()
        item2=ArrayList()

        item.add(Item(
            R.drawable.watch_one,
            "Wrist watch for ladies one",
            "2000 taka per piece",
            "Buy 3 pieces get 1 piece "
        ))
        item.add(
            Item(
                R.drawable.watch_two,
                "Wrist watch for ladies two",
                "2000 taka per piece",
                "Buy 3 pieces get 1 piece "
        )
        )
        item.add(
            Item(
                R.drawable.watch_three,
                "Wrist watch for ladies three",
                "2000 taka per piece",
                "Buy 3 pieces get 1 piece "
        )
        )

        item.add(
            Item(
                R.drawable.watch_four,
                "Wrist watch for ladies four",
                "2000 taka per piece",
                "Buy 3 pieces get 1 piece "
        )
        )
        item.add(
            Item(
                R.drawable.watch_five,
                "Wrist watch for ladies five",
                "2000 taka per piece",
                "Buy 3 pieces get 1 piece "
        )
        )
        item.add(
            Item(
                R.drawable.watch_six,
                "Wrist watch for ladies six",
                "2000 taka per piece",
                "Buy 3 pieces get 1 piece "
        )
        )
        item.add(Item(
            R.drawable.watch_seven,
            "Wrist watch for ladies seven",
            "2000 taka per piece",
            "Buy 3 pieces get 1 piece "
        ))
        item.add(
            Item(
                R.drawable.watch_eight,
                "Wrist watch for ladies eight",
                "2000 taka per piece",
                "Buy 3 pieces get 1 piece "


            )
        )
        item.add(Item(
                R.drawable.watch_one,
                "Wrist watch for ladies one",
                "2000 taka per piece",
                "Buy 3 pieces get 1 piece "
        ))
        item.add(
                Item(
                        R.drawable.watch_two,
                        "Wrist watch for ladies two",
                        "2000 taka per piece",
                        "Buy 3 pieces get 1 piece "
                )
        )
        item.add(
                Item(
                        R.drawable.watch_three,
                        "Wrist watch for ladies three",
                        "2000 taka per piece",
                        "Buy 3 pieces get 1 piece "
                )
        )

        item.add(
                Item(
                        R.drawable.watch_four,
                        "Wrist watch for ladies four",
                        "2000 taka per piece",
                        "Buy 3 pieces get 1 piece "
                )
        )
        item.add(
                Item(
                        R.drawable.watch_five,
                        "Wrist watch for ladies five",
                        "2000 taka per piece",
                        "Buy 3 pieces get 1 piece "
                )
        )
        item.add(
                Item(
                        R.drawable.watch_six,
                        "Wrist watch for ladies six",
                        "2000 taka per piece",
                        "Buy 3 pieces get 1 piece "
                )
        )
        item.add(Item(
                R.drawable.watch_seven,
                "Wrist watch for ladies seven",
                "2000 taka per piece",
                "Buy 3 pieces get 1 piece "
        ))
        item.add(
                Item(
                        R.drawable.watch_eight,
                        "Wrist watch for ladies eight",
                        "2000 taka per piece",
                        "Buy 3 pieces get 1 piece "


                )
        )

    }

    private fun updateItemValueFromList(position: Int) {

        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(this)
        // set the custom layout
        val view = layoutInflater.inflate(R.layout.custom_alert_dialog,null)
        // Get Views references from your layout
        val title: TextView = view.findViewById(R.id.dialog_title)
        val name: EditText = view.findViewById(R.id.et_productName)
        val price: EditText = view.findViewById(R.id.et_productPrice)
        val offer: EditText = view.findViewById(R.id.et_productOffer)
        val updateBtn: Button = view.findViewById(R.id.updateBtn)
        val cancel: Button = view.findViewById(R.id.cancelBtn)

        if (position== -1){

            title.text = "Add New Product"
            name.hint = "Enter Product name"
            price.hint="Enter Product Price"
            offer.hint ="Ender if any offer"
            updateBtn.text = "Add item"

            updateBtn.setOnClickListener {
                item2.add(Item(R.drawable.watch_one,"${name.text}", "${price.text}","${offer.text}"))
                Toast.makeText(applicationContext,"Updated",Toast.LENGTH_SHORT).show()
                adpter.notifyItemChanged(position)
                dialog?.dismiss()


            }
        }else{
            title.text = "Update Product"
            name.setText(item2[position].getName())
            price.setText(item2[position].getPrice())
            offer.setText(item2[position].getOffer())

            updateBtn.setOnClickListener {
                val newItem =  Item(R.drawable.watch_one,"${name.text}", "${price.text}","${offer.text}")

                item2[position] = newItem
                Toast.makeText(applicationContext,"Updated",Toast.LENGTH_SHORT).show()
                adpter.notifyItemChanged(position)
                dialog?.dismiss()


            }
        }



        cancel.setOnClickListener {
            dialog?.dismiss()
        }


        builder.setView(view)
// create and show the alert dialog
        dialog = builder.create()
        dialog.show()
    }
}