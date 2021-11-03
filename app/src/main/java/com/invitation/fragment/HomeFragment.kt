package com.invitation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.os.CountDownTimer
import com.invitation.R
import java.util.*


class HomeFragment : androidx.fragment.app.Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.wedding_fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendarnow = Calendar.getInstance()
        val calendar = Calendar.getInstance()
        calendar.set(2019, 1, 10, 20, 0, 0)
        val startTime =calendar.getTimeInMillis()- calendarnow.getTimeInMillis()

        val text_timer=getView()!!.findViewById<TextView>(R.id.text_timer)
        object : CountDownTimer(startTime, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = seconds / 60
                val hours = minutes / 60
                val days = hours / 24


               var  time =StringBuilder()

                time.append("Days: "+days.toString() + "Hours: " + hours % 24 + ":" + minutes % 60 + ":" + seconds % 60)



                text_timer.setText(time)
            }

            override fun onFinish() {
                text_timer.setText("done!")
            }
        }.start()
    }

    override fun onResume() {
        super.onResume()
        val layoutRelative = getView()!!.findViewById<RelativeLayout>(R.id.layout_relative)
        val loadAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        layoutRelative.startAnimation(loadAnimation)

        val layoutFrom = getView()!!.findViewById<RelativeLayout>(R.id.layoutFrom)
        layoutFrom.startAnimation(loadAnimation)

        val text_timing=getView()!!.findViewById<TextView>(R.id.text_timing)
        text_timing.startAnimation(loadAnimation)
    }
}
