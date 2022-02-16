package com.summers.artworkeditor

import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var path = Path()
    private var paint = Paint()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bitmap: Bitmap = Bitmap.createBitmap(700, 700, Bitmap.Config.ARGB_8888)
        val canvas: Canvas = Canvas(bitmap)
//
//        // rectangle positions
//        var left = 100
//        var top = 100
//        var right = 600
//        var bottom = 400
//
//        // draw rectangle shape to canvas
//        var shapeDrawable: ShapeDrawable = ShapeDrawable(RectShape())
//        shapeDrawable.setBounds( left, top, right, bottom)
//        shapeDrawable.paint.color = Color.parseColor("#009944")
//        shapeDrawable.draw(canvas)
//
//
//        // oval positions
//        left = 100
//        top = 500
//        right = 600
//        bottom = 800
//
//        // draw oval shape to canvas
//        shapeDrawable = ShapeDrawable(OvalShape())
//        shapeDrawable.setBounds( left, top, right, bottom)
//        shapeDrawable.paint.color = Color.parseColor("#009191")
//        shapeDrawable.draw(canvas)
//
//        // set bitmap as background to ImageView
//        val imageV = findViewById<ImageView>(R.id.imageV)
//        imageV.background = BitmapDrawable(resources, bitmap)

        val myCanvasView = MyCanvasView(this)
        // No XML file; just one custom view created programmatically.
        // Request the full available screen for layout.
        myCanvasView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
        myCanvasView.contentDescription = getString(R.string.canvasContentDescription)
        setContentView(myCanvasView)

    }
}