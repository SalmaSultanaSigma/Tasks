package com.example.constraintlayouttask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetDialog(
        val p:Int,
        val details: String
) : BottomSheetDialogFragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val v:View= inflater.inflate(R.layout.button_sheet,container,false)

        var sheetText = v.findViewById<TextView>(R.id.tv1)
        var detailsTextView=v.findViewById<TextView>(R.id.listItemDetails)
        sheetText.setText("Selected item number "+p)
        detailsTextView.setText("Details: \n"+details)

        return v
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //tv1.setText("details for item $position"+BottomSheetDialog(position))

    }

}