package com.example.roomremix2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomremix2.R
import com.example.roomremix2.databinding.ActivityMainBinding

class account : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_account)

        binding.
    }
}