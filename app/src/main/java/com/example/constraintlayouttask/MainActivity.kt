package com.example.constraintlayouttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.constraintlayouttask.databinding.RecyclerViewBinding

class MainActivity : AppCompatActivity() {
    lateinit var adpter: RecyclerAdapter
    lateinit var recyclerView : RecyclerView
    private lateinit var item:ArrayList<Item>
    private var item2:ArrayList<Item> =ArrayList()

    private lateinit var binding: RecyclerViewBinding
    private val recyclerViewAdapter by lazy {

        RecyclerAdapter(
            item2,this,
            {position, view ->
                onItemUpdate(position, view)
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
        adpter.notifyItemRemoved(position-1)
    }

    private fun onItemUpdate(position: Int, view: View) {
        //updateItemValueFromList(position)
       //bottomSheet(position,view)
        view.setOnClickListener {
            BottomSheetDialog(position+1,item2.get(position).getName().toString()).show(
                supportFragmentManager,
                "Tag"
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClickListener()
        //initListItem()

        binding.recyclerView.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )
        adpter= recyclerViewAdapter
        binding.recyclerView.adapter=adpter

        //recyclerView.scrollToPosition(item2.size+1)

        //setupActionBarWithNavController(findNavController(R.id.firstFragment))

    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController =findNavController(R.id.firstFragment)
//        return navController.navigateUp()|| super.onSupportNavigateUp()
//    }

    private fun onClickListener() {
        binding.floatingButtin.setOnClickListener {

            updateItemValueFromList(-1)


        }
        var buttonClick=1

        binding.addedButton.setOnClickListener {

            for (i in 0..9){
                var k=i+buttonClick
                item2.add(Item(
                        R.drawable.watch_two,
                        "Wrist watch for ladies $k",
                        "2000 taka per piece",
                        "Buy 3 pieces get 1 piece button clicked $buttonClick "
                ))
            }
            buttonClick+=10

            adpter.notifyDataSetChanged()

        }

    }

    public fun initListItem(){



        //binding.noItemTV=findViewById(R.id.noItemTV)
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