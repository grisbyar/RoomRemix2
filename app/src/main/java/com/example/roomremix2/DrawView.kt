package com.example.roomremix2
//
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.roomremix2.MainActivity.Companion.drawTool
import com.example.roomremix2.MainActivity.Companion.path

class DrawView : View {

    var params : ViewGroup.LayoutParams? = null
    companion object{
        var pathList = ArrayList<Path>() // stores all paths drawn on screen
        var colorList = ArrayList<Int>()
        var currentColor = Color.BLACK
    }
    //import constructor view
    constructor(context: Context) : this(context, null){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }
    private fun init(){
        /* initialize function
        makes texture smooth for drawing */

        /*
            chained the setters so that it dosnt just say "drawtool." over and over again.
         */
        drawTool.apply {
            isAntiAlias = true
            color = currentColor
            style = Paint.Style.STROKE
            strokeJoin = Paint.Join.ROUND
            strokeWidth = 8f
        }
        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        /*register draw movement on screen*/
        var xCord = event.x
        var yCord = event.y

        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                //detect when user is pressing down on screen
                path.moveTo(xCord, yCord)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                //detect when user is moving on screen
                path.lineTo(xCord,yCord)
                pathList.add(path)
                colorList.add(currentColor)
            }
            else -> return false
        }
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas) {

        for(i in pathList.indices){
            drawTool.setColor(colorList[i])
            canvas.drawPath(pathList[i],drawTool)
            invalidate()
        }

    }

}