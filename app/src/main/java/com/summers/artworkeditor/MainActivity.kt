package com.summers.artworkeditor

import android.os.Bundle
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

