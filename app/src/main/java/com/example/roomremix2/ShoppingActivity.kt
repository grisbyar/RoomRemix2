package com.example.roomremix2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val decoratorButton = findViewById<Button>(R.id.decorator);
        val shoppingButton = findViewById<Button>(R.id.shopping);
        val ideasButton = findViewById<Button>(R.id.ideas);
        val paletteButton = findViewById<Button>(R.id.palette);
        val accountButton = findViewById<Button>(R.id.account);

        decoratorButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        shoppingButton.setOnClickListener {
            val intent = Intent(this, ShoppingActivity::class.java)
            startActivity(intent)
        }

        ideasButton.setOnClickListener {
            val intent = Intent(this, IdeaActivity::class.java)
            startActivity(intent)
        }

        paletteButton.setOnClickListener {
            val intent = Intent(this, PaletteActivity::class.java)
            startActivity(intent)
        }

        accountButton.setOnClickListener {
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
        }
    }
}