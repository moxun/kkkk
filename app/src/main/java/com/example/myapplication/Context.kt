package com.example.myapplication

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.util.TypedValue
import android.util.TypedValue.applyDimension
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.getSystemService

fun Context.px2dip(px: Float): Float = px / resources.displayMetrics.density +0.5f
fun Context.px2dip(px: Int): Int =px2dip(px.toFloat()).toInt()
/**
转
 * dp
px
 */
fun Context.dip2px(dp: Float): Float =applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    dp,
    resources.displayMetrics
)
fun Context.dip2px(dp: Int): Int =applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    dp.toFloat(),
    resources.displayMetrics
).toInt()
/**
转
 * sp
px
 */
fun Context.sp2px(sp: Float): Float =applyDimension(
    TypedValue.COMPLEX_UNIT_SP,
    sp,
    resources.displayMetrics
)
fun Context.sp2px(sp: Int): Int =applyDimension(
    TypedValue.COMPLEX_UNIT_SP,
    sp.toFloat(),
    resources.displayMetrics
).toInt()


/**
 * toast
 */
fun Context.toast(msg: CharSequence, duration: Int = Toast.LENGTH_SHORT)=
    Toast.makeText(this, msg, duration).show()
fun Context.toast(resId: Int, duration: Int = Toast.LENGTH_SHORT)=
    Toast.makeText(this, resId, duration).show()

/**
获取屏幕的宽度和⾼度
 *
 */
val Context.screesSize: Point
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    get(){
        val p = Point()
        val wm = getSystemService<WindowManager>()?:return p
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            val bounds = wm.currentWindowMetrics.bounds
            p.x = bounds.width()
            p.y = bounds.height()
        }else{
            @Suppress("DEPRECATION")
            wm.defaultDisplay?.getRealSize(p)
        }
        return p
    }



