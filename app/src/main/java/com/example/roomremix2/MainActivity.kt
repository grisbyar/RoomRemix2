package com.example.roomremix2

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.View.*
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.roomremix2.DrawView.Companion.colorList
import com.example.roomremix2.DrawView.Companion.currentColor
import com.example.roomremix2.DrawView.Companion.pathList
import com.example.roomremix2.MainActivity.Companion.path


class MainActivity : AppCompatActivity() {

    companion object {
        //import tools to draw
        //equivalent of public static

        var path = Path()
        var drawTool = Paint()
    }

    var msg: String? = null
    private var layoutParams: RelativeLayout.LayoutParams? = null
    var x_cord = 0
    var y_cord = 0
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val drawButton = findViewById<ImageButton>(R.id.draw);
        val eraserButton = findViewById<ImageButton>(R.id.eraser);
        val deleteButton = findViewById<ImageButton>(R.id.delete)

        drawButton.setOnClickListener {
            //Toast.makeText(this,"Clicked draw", Toast.LENGTH_SHORT).show()
            drawTool.color = Color.BLACK
            currentColorPicker(drawTool.color)
        }
        eraserButton.setOnClickListener {
            Toast.makeText(this,"Clicked erase", Toast.LENGTH_SHORT).show()
            //***
            drawTool.color = Color.WHITE
            currentColorPicker(drawTool.color)
        }
        deleteButton.setOnClickListener {
            Toast.makeText(this,"Clicked delete", Toast.LENGTH_SHORT).show()
            //***
            pathList.clear()
            colorList.clear()
            path.reset()
        }

        //decorating part
//val couchStamp = findViewById<ImageButton>(R.id.couch).drawable
        val couchStamp = findViewById<ImageButton>(R.id.couch)
        val tableStamp = findViewById<ImageButton>(R.id.table)
        val bedStamp = findViewById<ImageButton>(R.id.bed)
        val chairStamp = findViewById<ImageButton>(R.id.chair)
        val dresserStamp = findViewById<ImageButton>(R.id.dresser)
        val televisionStamp = findViewById<ImageButton>(R.id.television)
        val floorLampStamp = findViewById<ImageButton>(R.id.lamp)
        val laptopStamp = findViewById<ImageButton>(R.id.laptop)
        val doorStamp = findViewById<ImageButton>(R.id.door)
        val windowStamp = findViewById<ImageButton>(R.id.window)


        ///////////


        //////////////


    }


}


private fun currentColorPicker(color: Int) {
    currentColor = color
    path = Path()
}


//ability to copy and drag

