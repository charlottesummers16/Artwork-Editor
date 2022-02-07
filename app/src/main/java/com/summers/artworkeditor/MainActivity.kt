package com.summers.artworkeditor

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val bitmap: Bitmap = Bitmap.createBitmap(700, 600, Bitmap.Config.ARGB_8888)
    private val canvas: Canvas = Canvas(bitmap)
    private var colourTracker = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawShapes("#E60000", "#03A9F4")

        findViewById<Button>(R.id.btnChangeColour).setOnClickListener { changeRectangleColour() }
//        val view = findViewById<View>(R.id.view)
//        view.setOnClickListener { changeRectangleColour() }

    }

    private fun changeRectangleColour() {
        colourTracker++
        if (colourTracker % 2 == 0) {
            drawShapes("#03A9F4", "#E60000")
        } else {
            drawShapes("#E60000", "#03A9F4")
        }
    }

    private fun drawShapes(rectangleColor: String, ovalColor: String) {
        // rectangle positions
        var left = 200
        var top = 100
        var right = 500
        var bottom = 300

        // draw rectangle shape to canvas
        var shapeDrawable: ShapeDrawable = ShapeDrawable(RectShape())
        shapeDrawable.setBounds( left, top, right, bottom)
        shapeDrawable.paint.color = Color.parseColor(rectangleColor)
        shapeDrawable.draw(canvas)

        // oval positions
        left = 100
        top = 400
        right = 600
        bottom = 550

        // draw oval shape to canvas
        shapeDrawable = ShapeDrawable(OvalShape())
        shapeDrawable.setBounds( left, top, right, bottom)
        shapeDrawable.paint.color = Color.parseColor(ovalColor)
        shapeDrawable.draw(canvas)

        // set bitmap as background to ImageView
        val view = findViewById<View>(R.id.view)
        view.background = BitmapDrawable(resources, bitmap)
    }


}