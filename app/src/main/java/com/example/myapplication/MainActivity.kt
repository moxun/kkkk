package com.example.myapplication

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,IconStudent{




    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        checkNnmber(1)


        var s = "Kolint"

        s.uppercase()
        SignleUntils.getSingle()
        var mutableListOf = mutableListOf<String>("ss1", "ss1", "ss1")
        mutableListOf.add("ss1")
        for (i in mutableListOf){
            Log.d("大家好",i)
        }


        val empty = "ssss".isEmpty()


        Log.d("是空不",empty.toString())
        Log.d("大家好",mutableListOf.all { it.equals("ss1") }.toString())
        mutableListOf.maxByOrNull {
            it.length
        }
        val mutableMapOf = mutableMapOf("token" to "kkkkk", "loser" to "llll")
        for(key in mutableMapOf){

            Log.d("map便利",key.key)
        }
        val arr = intArrayOf(1, 5, 6, 0, 7, 4, 9, 3)
        val index = intArrayOf(0, 1, 2, 3, 4, 0, 5, 1, 2, 6, 7)
        var tel = ""
        for (i in index) {
            tel += arr[i]
        }

        Log.d("手机号码是",screesSize.toString())
        when(5){
            0,1->checkNnmber(2)
            else -> checkNnmber(3)
        }


        toast("大记号")
        text_nm.setOnIntervalClickListener {
            text_nm.resize(500,500)
        }

        llAddAccount.setOnClickListener {
            /*
            第一个参数为要实现动画效果的View，例如这里整体效果的LinearLayout；
            第二个参数为属性名，translationX,translationY,alpha,rotation,scaleX,scaleY等
            第三参数为可变长参数，第一个值为动画开始的位置，第二个值为结束值得位置，如果数组大于3位数，那么前者将是后者的起始位置。

             */
            val oftranslationX = ObjectAnimator.ofFloat(llAddAccount, "translationX", 0f, -llAddAccount.width.toFloat())
            val alpha = ObjectAnimator.ofFloat(llAddAccount, "alpha", 1f, 0f,1f)

            AnimatorSet().apply {
                play(oftranslationX).with(alpha)
                duration=5000
                start()
            }
            recy_info.setProgess(50)
        }

      var a=  getNum(5,7){
            n,n1 -> n+n1
        }



    }

    @SuppressLint("ShowToast")
    fun checkNnmber(number:Number){
        when(number){
            is Int -> Log.d("大家好","我是Int")
            is Double -> Toast.makeText(this,"jjjj",Toast.LENGTH_LONG)
        }
    }

    fun getNum(num:Int,num1:Int,func:(num:Int,num1:Int) ->Unit){
        func(num,num1)
    }


    override fun getStudy() {

    }

    companion object{
        fun startActicon(context: Context){
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
}