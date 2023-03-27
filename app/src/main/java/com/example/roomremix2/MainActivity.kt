package com.example.roomremix2

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
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

  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val drawButton = findViewById<ImageButton>(R.id.draw);
        val eraserButton = findViewById<ImageButton>(R.id.eraser);
        val deleteButton = findViewById<ImageButton>(R.id.delete)

        drawButton.setOnClickListener {
            Log.d("Test", "clicked draw")
            //Toast.makeText(this,"Clicked draw", Toast.LENGTH_SHORT).show()
            drawTool.color = Color.BLACK
            currentColorPicker(drawTool.color)
        }
        eraserButton.setOnClickListener {
            Toast.makeText(this,"Clicked erase", Toast.LENGTH_SHORT).show()
            //***
            Log.d("Test", "clicked erase")
            drawTool.color = Color.WHITE
            currentColorPicker(drawTool.color)
        }
        deleteButton.setOnClickListener {
            Toast.makeText(this,"Clicked delete", Toast.LENGTH_SHORT).show()
            //***
            Log.d("Test", "clicked delete")
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

      val layout = findViewById<ConstraintLayout>(R.id.relativeLayout)

      copyDragDrop(couchStamp, layout)
      copyDragDrop(tableStamp, layout)
      copyDragDrop(bedStamp, layout)
      copyDragDrop(chairStamp, layout)
      copyDragDrop(dresserStamp, layout)
      copyDragDrop(televisionStamp, layout)
      copyDragDrop(floorLampStamp, layout)
      copyDragDrop(laptopStamp, layout)
      copyDragDrop(doorStamp, layout)
      copyDragDrop(windowStamp, layout)


    }


}


private fun currentColorPicker(color: Int) {
    currentColor = color
    path = Path()
}


//ability to copy and drag
private fun copyDragDrop(sourceView: View, parentLayout: ViewGroup) {
    sourceView.setOnTouchListener { v, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                val newCouchStamp = ImageButton(this).apply {
                    layoutParams = v.layoutParams
                    setImageDrawable((v as ImageButton).drawable)
                }
                copyDragDrop(View.drawable, parentLayout)
                val data = ClipData.newPlainText("", "")
                val shadowBuilder = View.DragShadowBuilder(newCouchStamp)
                v.startDragAndDrop(data, shadowBuilder, newCouchStamp, 0)
                parentLayout.addView(newCouchStamp)
                true
            }
            else -> false
        }
    }

    parentLayout.setOnDragListener { v, event ->
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                true
            }
            DragEvent.ACTION_DROP -> {
                val view = event.localState as View
                view.x = event.x - view.width / 2
                view.y = event.y - view.height / 2
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                true
            }
            else -> false
        }
    }
}

fun saveFloorplan(){
    //Implement Later
}
