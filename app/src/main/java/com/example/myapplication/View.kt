package com.example.myapplication

import android.annotation.TargetApi
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewTreeObserver
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi

private var clickInterval = 400L
private var lastTime = 0L

/*
防止重复点击
 */
fun View.setOnIntervalClickListener(onIntervalClick : (View) -> Unit){

    this.setOnClickListener{
        if (System.currentTimeMillis() - lastTime > clickInterval) {
            lastTime = System.currentTimeMillis()
            onIntervalClick.invoke(it)
        }else{
            Toast.makeText(this.context,"您点的太快了，请稍后重试",Toast.LENGTH_LONG).show()
        }
    }
}

/*3
Edittext文字监听
 */
fun EditText.setTextChange(onclick:(String) -> Unit){
    this.addTextChangedListener(object :TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            onclick.invoke(s.toString())
        }

        override fun afterTextChanged(s: Editable?) {

        }

    })

}

/*
设置Padding
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun View.updatePadding(
    paddingStart: Int = getPaddingStart(),
    paddingTop: Int = getPaddingTop(),
    paddingEnd: Int = getPaddingEnd(),
    paddingBottom: Int = getPaddingBottom()
) {
    setPaddingRelative(paddingStart, paddingTop, paddingEnd, paddingBottom)
}



fun View.setPaddingLeft(value: Int) = setPadding(value, paddingTop, paddingRight, paddingBottom)

fun View.setPaddingRight(value: Int) = setPadding(paddingLeft, paddingTop, value, paddingBottom)

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun View.setPaddingTop(value: Int) = setPaddingRelative(paddingStart, value, paddingEnd, paddingBottom)

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun View.setPaddingBottom(value: Int) = setPaddingRelative(paddingStart, paddingTop, paddingEnd, value)

/*
改变大小
 */
fun View.resize(width: Int, height: Int) {
    if (width < 0 || height < 0) return
    val lp = layoutParams
    lp?.let {
        lp.width = width
        lp.height = height
        layoutParams = lp
    }
}


fun View.updateHeight(value: Int) {
    if (value < 0) return
    val lp = layoutParams
    lp?.let {
        lp.height = value
        layoutParams = lp
    }
}

fun View.updateWidth(value: Int) {
    if (value < 0) return
    val lp = layoutParams
    lp?.let {
        lp.width = value
        layoutParams = lp
    }
}





