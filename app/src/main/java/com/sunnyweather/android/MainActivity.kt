package com.sunnyweather.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunnyweather.android.logic.model.PlaceResponse
import com.sunnyweather.android.logic.network.ServiceCreator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}
