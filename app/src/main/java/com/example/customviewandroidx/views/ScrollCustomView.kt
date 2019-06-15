package com.example.customviewandroidx.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi


class ScrollCustomView :View {
    var cx:Float = 0.0f
    var cy:Float = 0.0f
    var windoHeight:Float =0f
    var isFirst:Boolean = false

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    override fun onDraw(canvas: Canvas?) {
        windoHeight = canvas!!.height.toFloat()
        if(!isFirst) {
            cy = windoHeight/2
        }
        var paint:Paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.BLACK
        canvas!!.drawCircle(100f,cy,20f,paint)
        isFirst =true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var action:Int = event!!.actionMasked
        when(action){
            MotionEvent.ACTION_DOWN ->{

            }
            MotionEvent.ACTION_MOVE ->{
                cx = event!!.x
                cy = event!!.y

            }
        }
        postInvalidate()
        return true
    }
}