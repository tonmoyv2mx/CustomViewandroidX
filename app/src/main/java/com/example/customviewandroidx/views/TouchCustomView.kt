package com.example.customviewandroidx.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.os.Handler
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi

class TouchCustomView :View {


    lateinit var canvas:Canvas
    lateinit var paint:Paint
     var windoHight:Int=0
    var windoWidth:Int =0
    val TAG_ ="TouchCustomView"
     var cx:Float=0f
     var cy:Float=0f
    var cr:Float =20f
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
        this.canvas = canvas!!
        windoHight = canvas!!.height
        windoWidth = canvas!!.width
         paint = Paint()
        paint.color = Color.GREEN
        paint.isAntiAlias = true

        drowCanvers()
       // super.onDraw(canvas)

    }
    fun drowCanvers(){

        canvas!!.drawCircle(cx,cy,cr,paint)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var action:Int = event!!.actionMasked

        when(action){

            MotionEvent.ACTION_DOWN -> {
               // cr +=10
                cx = event!!.x
                cy = event!!.y
                drowCanvers()
                if(!isOpen) {
                    dropBall()
                }
            }
           MotionEvent.ACTION_MOVE -> {
               cx = event!!.x
               cy = event!!.y
           }
            MotionEvent.ACTION_SCROLL -> {
                Toast.makeText(context, "ACTION_SCROLL", Toast.LENGTH_SHORT).show();
            }
            MotionEvent.ACTION_HOVER_MOVE -> {
                Toast.makeText(context, "ACTION_HOVER_MOVE", Toast.LENGTH_SHORT).show();
            }


        }
       // Toast.makeText(context, "$x $y", Toast.LENGTH_SHORT).show();
        postInvalidate()

        return true
    }
    var isDown:Boolean =true
    var isOpen:Boolean = false
    private fun dropBall() {


            Handler().postDelayed(Runnable {


                cy += 5


                postInvalidate()
                dropBall()

            }, 10)
            isOpen = true


    }


}