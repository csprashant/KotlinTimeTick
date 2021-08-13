package com.example.kotlin_timeticker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView
import java.util.*

class TimeReciver(var hTv:TextView,var mTv:TextView):BroadcastReceiver()  {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null) {
            if(intent.action.toString().compareTo(Intent.ACTION_TIME_TICK)==0){
                hTv.text=Calendar.getInstance().get(Calendar.HOUR_OF_DAY).toString()
                mTv.text=Calendar.getInstance().get(Calendar.MINUTE).toString()
            }

        }
    }
}