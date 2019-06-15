package com.example.customviewandroidx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
   /* override fun onTouchEvent(event: MotionEvent?): Boolean {
        var action:Int = event!!.actionMasked

        when(action){
            MotionEvent.ACTION_DOWN -> Toast.makeText(this, "ACTION_DOWN", Toast.LENGTH_SHORT).show()
            MotionEvent.ACTION_MOVE -> Toast.makeText(this, "ACTION_MOVE", Toast.LENGTH_SHORT).show();
            //  MotionEvent.ACTION_DOWN -> Toast.makeText(context, "ACTION_DOWN", Toast.LENGTH_SHORT).show();
        }
        // Toast.makeText(context, "$x $y", Toast.LENGTH_SHORT).show();
      //  postInvalidate()

        return super.onTouchEvent(event)
    }*/
}
