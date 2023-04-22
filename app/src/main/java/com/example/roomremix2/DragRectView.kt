package com.example.roomremix2

import android.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.text.TextPaint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs


class DragRectView : View {
    private var mRectPaint: Paint? = null
    private var mStartX = 0
    private var mStartY = 0
    private var mEndX = 0
    private var mEndY = 0
    private var mDrawRect = false
    private var mTextPaint: TextPaint? = null
    private var mCallback: OnUpCallback? = null

    interface OnUpCallback {
        fun onRectFinished(rect: Rect?)
    }

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init()
    }

    fun setOnUpCallback(callback: OnUpCallback?) {
        mCallback = callback
    }

    private fun init() {
        mRectPaint = Paint()
        mRectPaint!!.color = context.resources.getColor(R.color.holo_green_light)
        mRectPaint!!.style = Paint.Style.STROKE
        mRectPaint!!.strokeWidth = 5f // TODO: should take from resources
        mTextPaint = TextPaint()
        mTextPaint!!.color = context.resources.getColor(R.color.holo_green_light)
        mTextPaint!!.textSize = 20f
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        // TODO: be aware of multi-touches
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mDrawRect = false
                mStartX = event.x.toInt()
                mStartY = event.y.toInt()
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                val x = event.x.toInt()
                val y = event.y.toInt()
                if (!mDrawRect || abs(x - mEndX) > 5 || abs(y - mEndY) > 5) {
                    mEndX = x
                    mEndY = y
                    invalidate()
                }
                mDrawRect = true
            }
            MotionEvent.ACTION_UP -> {
                if (mCallback != null) {
                    mCallback!!.onRectFinished(
                        Rect(
                            Math.min(mStartX, mEndX), Math.min(mStartY, mEndY),
                            Math.max(mEndX, mStartX), Math.max(mStartY, mEndY)
                        )
                    )
                }
                invalidate()
            }
            else -> {}
        }
        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (mDrawRect) {
            canvas.drawRect(
                Math.min(mStartX, mEndX).toFloat(), Math.min(mStartY, mEndY).toFloat(),
                Math.max(mEndX, mStartX).toFloat(), Math.max(mEndY, mStartY).toFloat(),
                mRectPaint!!
            )
            canvas.drawText(
                "  (" + abs(mStartX - mEndX) + ", " + abs(mStartY - mEndY) + ")",
                Math.max(mEndX, mStartX).toFloat(), Math.max(mEndY, mStartY).toFloat(),
                mTextPaint!!
            )
        }
    }
}
