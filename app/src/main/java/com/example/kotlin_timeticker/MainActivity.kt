package com.example.kotlin_timeticker

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var hTv:TextView
    lateinit var mTv:TextView
    lateinit var time:TimeReciver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hTv=findViewById(R.id.hourTv)
        mTv=findViewById(R.id.minutTv)

        hTv.text= Calendar.getInstance().get(Calendar.HOUR_OF_DAY).toString()
        mTv.text= Calendar.getInstance().get(Calendar.MINUTE).toString()

        time= TimeReciver(hTv,mTv)
        registerReceiver(time, IntentFilter( Intent.ACTION_TIME_TICK))
    }

    override fun onStop() {
        super.onStop()
        if(time!=null)
            unregisterReceiver(time)

    }
}