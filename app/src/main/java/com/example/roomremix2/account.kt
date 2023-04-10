package com.example.roomremix2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.roomremix2.R
import com.example.roomremix2.databinding.ActivityMainBinding

class account : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_account)

        val txtName: TextView = findViewById(R.id.txtviewName)
        val txtAcc: TextView = findViewById(R.id.txtviewAcc)
        val txtEmail: TextView = findViewById(R.id.txtviewEmail)
        val txtEFill: TextView = findViewById(R.id.txtviewEmailFill)
        val txtNFill: TextView = findViewById(R.id.txtviewNameFill)

        txtName.text = "Name"
        txtAcc.text = "Account"
        txtEmail.text = "Email"
        txtEFill.text = "EmailFill"
        txtNFill.text = "NameFill"
    }


}