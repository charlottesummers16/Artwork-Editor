package com.summers.artworkeditor

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class DrawView(context: Context, private val shape: Int, private val startX: Float, private val startY: Float) : View(context) {
    private var path = Path()
    private var paint = Paint()

    override fun onDraw(canvas: Canvas) {
        paint.color = Color.RED
        paint.strokeWidth = 10f
        paint.style = Paint.Style.STROKE

        when (shape) {
            0 -> drawSquare()
            1 -> drawCircle()
            2 -> drawTriangle()
            3 -> drawHalfCircle()
            4 -> drawBezier()
        }

        canvas.drawPath(path, paint)

    }

    private fun drawSquare() {
        val right = startX + 200f
        val bottom = startY + 200f

        path.moveTo(startX, startY)
        path.lineTo(right, startY)
        path.lineTo(right, bottom)
        path.lineTo(startX, bottom)
        path.close()
    }

    private fun drawCircle() {
        path.addCircle(startX, startY, 75f, Path.Direction.CW)
        path.close()
    }

    private fun drawTriangle() {
        val size = 200f
        val halfSize = 100f

        path.moveTo(startX+halfSize, startY)
        path.lineTo(startX+size, startY+size)
        path.lineTo(startX, startY+size)
        path.close()
    }

    private fun drawHalfCircle() {
        path.arcTo(startX, startY, startX+200f, startY+200, 180f, 180f, true)
        path.close()
    }

    private fun drawBezier() {
        path.moveTo(100f, 500f)
        path.cubicTo(200f, 400f, 600f, 600f, 900f, 350f)
    }

}