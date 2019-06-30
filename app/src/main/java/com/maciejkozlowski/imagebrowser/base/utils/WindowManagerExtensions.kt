package com.maciejkozlowski.imagebrowser.base.utils

import android.graphics.Point
import android.view.WindowManager

/**
 * Created by Maciej Kozłowski on 2019-06-30.
 */

fun WindowManager.getScreenWidth() : Int {
    val point = Point()
    defaultDisplay.getSize(point)
    return point.x
}