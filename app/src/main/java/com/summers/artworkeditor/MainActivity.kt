package com.summers.artworkeditor

import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val bitmap: Bitmap = Bitmap.createBitmap(700, 600, Bitmap.Config.ARGB_8888)
    private val canvas: Canvas = Canvas(bitmap)
    private var path = Path()
    private var paint = Paint()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var drawView = DrawView(this)
//        findViewById<FrameLayout>(R.id.flFrameLayout).addView(drawView)

        setUpRadioButtons()
        paint.color = Color.BLACK
        paint.strokeWidth = 10f

        findViewById<Button>(R.id.btnDraw).setOnClickListener {
//            drawShape()
            findViewById<FrameLayout>(R.id.flFrameLayout).addView(drawView)
        }
//        findViewById<Button>(R.id.btnClear).setOnClickListener {
//            canvas.drawColor(Color.WHITE)
//        }

    }

    private fun setUpRadioButtons() {
        findViewById<RadioButton>(R.id.radbTopLeft).isChecked = true
        findViewById<RadioButton>(R.id.radbSquare).isChecked = true
    }

    private fun drawShape() {
        var startX = 0f
        var startY = 0f

        //Set the startX and startY values depending on which radio button is selected.
        when (findViewById<RadioGroup>(R.id.rgrpDrawingLocation).checkedRadioButtonId) {
            R.id.radbTopLeft -> {
                startX = 10f
                startY = 10f
            }
            R.id.radbBottomLeft -> {
                startX = 10f
                startY = 500f
            }
            R.id.radbTopRight -> {
                startX = 100f
                startY = 10f
            }
            R.id.radbBottomRight -> {
                startX = 100f
                startY = 500f
            }
        }

        //Call the right draw function depending on the radio button selected.
        when (findViewById<RadioGroup>(R.id.rgrpDrawingShape).checkedRadioButtonId) {
            R.id.radbSquare -> {drawSquare(startX, startY)}
            R.id.radbCircle -> {}
            R.id.radbTriangle -> {}
            R.id.radbHalfCircle -> {}
        }

    }

    private fun drawSquare(startX: Float, startY: Float) {
        val right = startX + 50f
        val bottom = startY + 50f

        path.moveTo(startX, startY)
        path.lineTo(right, startY)
        path.lineTo(right, bottom)
        path.lineTo(startX, bottom)
        path.lineTo(startX, startY)
        path.close()


        canvas.drawColor(Color.BLACK)
        canvas.drawPath(path, paint)
    }

}

class DrawView(context: Context) : View(context) {
    private var path = Path()
    private var paint = Paint()

    override fun onDraw(canvas: Canvas) {
        paint.color = Color.BLACK
        paint.strokeWidth = 10f

        drawSquare(10f, 10f)

        canvas.drawPath(path, paint)

    }

    private fun drawSquare(startX: Float, startY: Float) {
        val right = startX + 50f
        val bottom = startY + 50f

        path.moveTo(startX, startY)
        path.lineTo(right, startY)
        path.lineTo(right, bottom)
        path.lineTo(startX, bottom)
        path.lineTo(startX, startY)
        path.close()

//        canvas.drawColor(Color.BLACK)
//        canvas.drawPath(path, paint)
    }
}