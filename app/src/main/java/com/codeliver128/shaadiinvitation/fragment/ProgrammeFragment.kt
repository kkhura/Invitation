package com.codeliver128.shaadiinvitation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.content.Intent
import android.net.Uri
import com.codeliver128.shaadiinvitation.R


class ProgrammeFragment : androidx.fragment.app.Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.guide_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getView()!!.findViewById<ImageView>(R.
            id.imgMap).setOnClickListener({
            val gmmIntentUri =
                Uri.parse("https://www.google.co.in/maps/place/Paschim+Puri+Agra/@27.20042,77.9414038,16.28z/data=!4m12!1m6!3m5!1s0x397477ee6fffffff:0xe555b5c683fadf71!2sPaschim+Puri+Agra!8m2!3d27.2005793!4d77.9445951!3m4!1s0x397477ee6fffffff:0xe555b5c683fadf71!8m2!3d27.2005793!4d77.9445951")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(context!!.getPackageManager()) != null) {
                startActivity(mapIntent)
            }
        })
    }
}
