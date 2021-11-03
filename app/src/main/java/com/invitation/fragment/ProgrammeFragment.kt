package com.invitation.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import com.invitation.R
import com.invitation.databinding.GuideFragmentBinding


class ProgrammeFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = GuideFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireView().findViewById<LinearLayoutCompat>(
            R.id.mapLayout
        ).setOnClickListener {
            val gmmIntentUri: Uri = Uri.parse("https://www.google.com/maps/place/Jashnn+E'+Hisar+,The+Banquet/@29.2000235,75.6871528,17z/data=!4m12!1m6!3m5!1s0x3913d29fef4cc431:0x60f0063640b5c0a1!2sJashnn+E'+Hisar+,The+Banquet!8m2!3d29.2000235!4d75.6893415!3m4!1s0x3913d29fef4cc431:0x60f0063640b5c0a1!8m2!3d29.2000235!4d75.6893415")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
        }
    }
}
