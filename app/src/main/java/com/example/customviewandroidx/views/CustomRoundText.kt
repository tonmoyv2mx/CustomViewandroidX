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

class CustomRoundText :View {
    var list:List<Int> = arrayListOf(1,2,3,4,5,6,7,8,9,10,11,12)
    var cx:Float = 0f
    var cy:Float =0f
    var isInit:Boolean = false
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
    var xc:Float=0f;
    override fun onDraw(canvas: Canvas?) {
        if(!isInit){
            cx = (canvas!!.width/2).toFloat()
            cy = (canvas!!.height/2).toFloat()
            isInit =true
        }
        var paint = Paint()
        paint.isAntiAlias = true
        paint.textSize = 20f
        paint.color = Color.RED
        var paint2 = Paint()
        paint2.isAntiAlias = true
        paint2.strokeWidth =4f
        paint2.color = Color.GREEN
        paint2.style = Paint.Style.STROKE

        canvas!!.drawCircle((canvas!!.width/2).toFloat(),(canvas!!.height/2).toFloat(),300f,paint2)
        canvas!!.drawCircle(cx,cy,20f,paint)
        for(i in 0..100){
            xc +=60f
            var angle = Math.PI/50*(i)
            var xx:Float = (Math.cos(angle)*300).toFloat() + canvas!!.width/2
            var yy:Float = (Math.sin(angle)*300).toFloat() + canvas!!.height/2
           // canvas!!.drawText(i.toString(),xx,yy,paint)
            canvas!!.drawLine(cx,cy,xx,yy,paint)
            canvas.drawCircle(xx,yy,5f,paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event!!.actionMasked == MotionEvent.ACTION_MOVE){
            cx = event.x
            cy = event.y
            postInvalidate()
        }
        return true
    }

}