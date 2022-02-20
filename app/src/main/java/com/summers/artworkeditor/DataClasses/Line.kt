package com.summers.artworkeditor.DataClasses

import android.graphics.Color

data class Line(override var x: Float, override var y: Float, override var colour: Color,
                override var type: String = "Line", override var radius: Float = 0f) : ObjectShape(x, y, colour, type, radius) {

}
