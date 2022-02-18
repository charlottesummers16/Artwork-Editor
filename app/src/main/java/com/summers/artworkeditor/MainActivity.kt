package com.summers.artworkeditor

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var drawView: DrawView
    private var startX = 0f
    private var startY = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpRadioButtons()

        findViewById<Button>(R.id.btnDraw).setOnClickListener {
            drawView = DrawView(this, drawShape(), startX, startY)
            findViewById<FrameLayout>(R.id.flFrameLayout).addView(drawView)
        }

        findViewById<Button>(R.id.btnBezier).setOnClickListener {
            drawView = DrawView(this, 4, startX, startY)
            findViewById<FrameLayout>(R.id.flFrameLayout).addView(drawView)
        }

    }

    private fun setUpRadioButtons() {
        findViewById<RadioButton>(R.id.radbTopLeft).isChecked = true
        findViewById<RadioButton>(R.id.radbSquare).isChecked = true
    }

    private fun drawShape(): Int {

        //Set the startX and startY values depending on which radio button is selected.
        when (findViewById<RadioGroup>(R.id.rgrpDrawingLocation).checkedRadioButtonId) {
            R.id.radbTopLeft -> {
                startX = 100f
                startY = 100f
            }
            R.id.radbBottomLeft -> {
                startX = 100f
                startY = 1000f
            }
            R.id.radbTopRight -> {
                startX = 700f
                startY = 100f
            }
            R.id.radbBottomRight -> {
                startX = 700f
                startY = 1000f
            }
        }

        //Call the right draw function depending on the radio button selected.
        return when (findViewById<RadioGroup>(R.id.rgrpDrawingShape).checkedRadioButtonId) {
            R.id.radbSquare -> {
                0
            }
            R.id.radbCircle -> {
                1
            }
            R.id.radbTriangle -> {
                2
            }
            R.id.radbHalfCircle -> {
                3
            }
            else -> 5
        }

    }

}

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