package kg.nurtelecom.design.chili2.view.container.shadow_layout.utils

import android.graphics.Color
import kg.nurtelecom.design.chili2.view.container.shadow_layout.model.ColorModel

object Util {

    fun intToColorModel(color: Int): ColorModel {

        val alpha = Color.alpha(color)
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)

        return ColorModel(alpha, red, green, blue)
    }

    fun onSetAlphaFromAlpha(alpha: Float, currentAlpha: Int): Boolean {

        if (alpha !in 0f..1f) {
            return false
        }

        return (alpha * 255) < currentAlpha
    }

    fun onSetAlphaFromColor(alpha: Float, color: Int): Boolean {

        if (alpha !in 0f..1f) {
            return false
        }

        return (alpha * 255) < Color.alpha(color)
    }

    fun getIntAlpha(alpha: Float): Int {

        if (alpha !in 0f..1f) {
            return 255
        }

        return (255 * alpha).toInt()
    }
}