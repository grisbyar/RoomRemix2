package com.example.roomremix2

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.roomremix2.DrawView.Companion.colorList
import com.example.roomremix2.DrawView.Companion.currentColor
import com.example.roomremix2.DrawView.Companion.pathList

class MainActivity : AppCompatActivity() {

    companion object{
        //import tools to draw
        //equivalent of public static

        var path = Path()
        var drawTool = Paint()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val drawButton = findViewById<ImageButton>(R.id.draw);
        val eraserButton = findViewById<ImageButton>(R.id.eraser);
        val deleteButton = findViewById<ImageButton>(R.id.delete)

        drawButton.setOnClickListener{
            //Toast.makeText(this,"Clicked draw", Toast.LENGTH_SHORT).show()
            drawTool.color = Color.BLACK
            currentColorPicker(drawTool.color)
        }
        eraserButton.setOnClickListener {
            //Toast.makeText(this,"Clicked erase", Toast.LENGTH_SHORT).show()
            //***
            drawTool.color = Color.WHITE
            currentColorPicker(drawTool.color)
        }
        deleteButton.setOnClickListener {
            //Toast.makeText(this,"Clicked delete", Toast.LENGTH_SHORT).show()
            //***
            pathList.clear()
            colorList.clear()
            path.reset()
        }

        //decorating part

    }

    private fun currentColorPicker(color: Int){
        currentColor = color
        path = Path()
    }
}