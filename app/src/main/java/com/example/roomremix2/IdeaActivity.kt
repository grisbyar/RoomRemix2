package com.example.roomremix2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class IdeaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_idea)

        val decoratorButton = findViewById<Button>(R.id.decorator)
        val shoppingButton = findViewById<Button>(R.id.shopping)
        val ideasButton = findViewById<Button>(R.id.ideas)
        val paletteButton = findViewById<Button>(R.id.palette)
        val accountButton = findViewById<Button>(R.id.account)

        decoratorButton.setOnClickListener(){
            Toast.makeText(this, "Clicked decorator", Toast.LENGTH_SHORT)
        }

        shoppingButton.setOnClickListener(){
            Toast.makeText(this, "Clicked shopping", Toast.LENGTH_SHORT)
        }

        ideasButton.setOnClickListener(){
            Toast.makeText(this, "Clicked ideas", Toast.LENGTH_SHORT)
        }

        paletteButton.setOnClickListener(){
            Toast.makeText(this, "Clicked palette", Toast.LENGTH_SHORT)
        }

        accountButton.setOnClickListener(){
            Toast.makeText(this, "Clicked account", Toast.LENGTH_SHORT)
        }
    }
}