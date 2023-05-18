package com.example.tvseries

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import kotlin.math.cos
import kotlin.math.sin


class NpsRatingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val starDrawable: Drawable? = ContextCompat.getDrawable(context, R.drawable.star)
    private val starSize = 100
    private val starSpacing = 20
    private val maxRating = 5
    private var currentRating = 0
    private val starRects: MutableList<Rect> = mutableListOf()

    init {
        starDrawable?.setBounds(0, 0, starSize, starSize)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = paddingLeft + paddingRight + maxRating * starSize + (maxRating - 1) * starSpacing
        val height = paddingTop + paddingBottom + starSize
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        starRects.clear()

        var left = paddingLeft
        val centerY = paddingTop + starSize / 2
        for (i in 0 until maxRating) {
            val starRect = Rect(left, centerY - starSize / 2, left + starSize, centerY + starSize / 2)
            starRects.add(starRect)

            if (i < currentRating) {
                starDrawable?.setColorFilter(Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN)
                starDrawable?.draw(canvas)
            } else {
                starDrawable?.setColorFilter(null)
                starDrawable?.draw(canvas)
            }

            left += starSize + starSpacing
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val x = event.x.toInt()
            val y = event.y.toInt()
            for (i in 0 until starRects.size) {
                if (starRects[i].contains(x, y)) {
                    setRating(i + 1)
                    return true
                }
            }
        }
        return super.onTouchEvent(event)
    }

    fun setRating(rating: Int) {
        currentRating = when {
            rating < 0 -> 0
            rating > maxRating -> maxRating
            else -> rating
        }
        invalidate()
    }
}