package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

class HorizontalProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    //进度条总高度
    var progessHeight = 0

    //宽度
    var mWidth = 0

    //高度
    var mHidth = 0
    var mWeightOne = 0


    var progess=20
    init {
        progessHeight = dp2px(20)
        initPaint()
    }

    var  currentProgress = 0f
    lateinit var paint: Paint
    private fun initPaint() {


        paint = Paint()
        paint.strokeWidth = dp2px(10).toFloat()
        //        Paint.ANTI_ALIAS_FLAG ：抗锯齿标志
//        Paint.FILTER_BITMAP_FLAG : 使位图过滤的位掩码标志
//        Paint.DITHER_FLAG : 使位图进行有利的抖动的位掩码标志
//        Paint.UNDERLINE_TEXT_FLAG : 下划线
//        Paint.STRIKE_THRU_TEXT_FLAG : 中划线
//        Paint.FAKE_BOLD_TEXT_FLAG : 加粗
//        Paint.LINEAR_TEXT_FLAG : 使文本平滑线性扩展的油漆标志
//        Paint.SUBPIXEL_TEXT_FLAG : 使文本的亚像素定位的绘图标志
//        Paint.EMBEDDED_BITMAP_TEXT_FLAG : 绘制文本时允许使用位图字体的绘图标志
        paint.flags = Paint.ANTI_ALIAS_FLAG
        //设置颜色
        paint.color = Color.BLUE
//设置抗锯齿,使边界更顺滑
        paint.isAntiAlias = true

//        1.Cap.ROUND(圆形)
//        2.Cap.SQUARE(方形)
//        3.Cap.BUTT(无)
        paint.strokeCap = Paint.Cap.ROUND

//        1.Paint.Style.FILL 填充内部，会把闭合区域填充颜色
//        2.Paint.Style.FILL_AND_STROKE填充内部和描边
//        3.Paint.Style.STROKE 仅描边，仅仅绘制边界
        paint.style = Paint.Style.STROKE


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        MeasureSpec.EXACTLY：使用measureSpec中size的值作为宽高的精确值
//        当我们将控件的layout_width或layout_height指定为具体数值时如andorid:layout_width=”50dip”，或者为FILL_PARENT是，都是控件大小已经确定的情况，都是精确尺寸。
//        MeasureSpec.AT_MOST：使用measureSpec中size的值作为最大值，采用不超过这个值的最大允许值
//        当控件的layout_width或layout_height指定为WRAP_CONTENT时，控件大小一般随着控件的子空间或内容进行变化，此时控件尺寸只要不超过父控件允许的最大尺寸即可。因此，此时的mode是AT_MOST，size给出了父控件允许的最大尺寸。
//        MeasureSpec.UNSPECIFIED是未指定尺寸，这种情况不多


        measureWith(MeasureSpec.getMode(widthMeasureSpec), MeasureSpec.getSize(widthMeasureSpec))

        setMeasuredDimension(
            measureWith(
                MeasureSpec.getMode(widthMeasureSpec),
                MeasureSpec.getSize(widthMeasureSpec)
            ),
            measureHeight(
                MeasureSpec.getMode(heightMeasureSpec),
                MeasureSpec.getSize(heightMeasureSpec)
            )
        )

        mWeightOne = (mWidth-paddingRight-paddingLeft)/100

        currentProgress= (mWeightOne*progess).toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawLine(paddingLeft.toFloat(), progessHeight.toFloat(), (mWidth-paddingRight).toFloat(),progessHeight.toFloat(),paint)

        paint.setColor(Color.GREEN)

        canvas?.drawLine(paddingLeft.toFloat(),progessHeight.toFloat(),
            currentProgress,progessHeight.toFloat(),paint)
    }

    private fun measureHeight(mode: Int, size: Int): Int {
        when (mode) {
            MeasureSpec.UNSPECIFIED, MeasureSpec.AT_MOST -> {

            }
            MeasureSpec.EXACTLY -> mHidth = size
        }
        return mHidth
    }

    private fun measureWith(mode: Int, size: Int): Int {
        when (mode) {
            MeasureSpec.UNSPECIFIED, MeasureSpec.AT_MOST -> {}
            MeasureSpec.EXACTLY -> mWidth = size
        }
        return mWidth
    }

    /**
     * dp 2 px
     *
     * @param dpVal
     */
    protected fun dp2px(dpVal: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpVal.toFloat(), resources.displayMetrics
        ).toInt()
    }


    @JvmName("setProgess1")
    public fun setProgess(prog:Int){
        progess=prog
        currentProgress= (mWeightOne*progess).toFloat()
        invalidate()
    }
}