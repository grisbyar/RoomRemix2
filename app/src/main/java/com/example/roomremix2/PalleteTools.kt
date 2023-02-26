package com.example.roomremix2

import android.graphics.Color
import androidx.core.graphics.ColorUtils

class PalleteTools {

    //pallete creator tools

    fun getComplementaryColor(hexColor: String): String {
        // Convert hex color to RGB
        val red = Integer.parseInt(hexColor.substring(1, 3), 16)
        val green = Integer.parseInt(hexColor.substring(3, 5), 16)
        val blue = Integer.parseInt(hexColor.substring(5, 7), 16)

        // Calculate the complementary color
        val complementaryRed = 255 - red
        val complementaryGreen = 255 - green
        val complementaryBlue = 255 - blue

        // Convert the complementary RGB values back to hex color
        val complementaryHexColor = String.format("#%02X%02X%02X", complementaryRed, complementaryGreen, complementaryBlue)

        // Return the complementary hex color
        return complementaryHexColor
    }

    fun getMonochromaticColor(hexColor: String): String {
        // Convert hex color to RGB
        val red = Integer.parseInt(hexColor.substring(1, 3), 16)
        val green = Integer.parseInt(hexColor.substring(3, 5), 16)
        val blue = Integer.parseInt(hexColor.substring(5, 7), 16)

        // Calculate the average of RGB values to get the gray level
        val gray = (red + green + blue) / 3

        // Convert the gray level back to a hex color value and return it
        val monochromaticHexColor = String.format("#%02X%02X%02X", gray, gray, gray)
        return monochromaticHexColor
    }

    fun getAnalogousColors(hexColor: String): Pair<String, String> {
        // Convert hex color to RGB
        val red = Integer.parseInt(hexColor.substring(1, 3), 16)
        val green = Integer.parseInt(hexColor.substring(3, 5), 16)
        val blue = Integer.parseInt(hexColor.substring(5, 7), 16)

        // Calculate the hue, saturation, and brightness of the color
        val hsv = FloatArray(3)
        Color.RGBToHSV(red, green, blue, hsv)
        val hue = hsv[0]
        val saturation = hsv[1]
        val brightness = hsv[2]

        // Calculate the analogous hues (30 degrees apart)
        val analogousHue1 = if (hue >= 30) hue - 30 else hue + 330
        val analogousHue2 = if (hue <= 330) hue + 30 else hue - 330

        // Convert the analogous hues back to RGB and then to hex color values
        val analogousColor1 = String.format(
            "#%06X",
            (Color.HSVToColor(floatArrayOf(analogousHue1, saturation, brightness))) and 0xFFFFFF
        )
        val analogousColor2 = String.format(
            "#%06X",
            (Color.HSVToColor(floatArrayOf(analogousHue2, saturation, brightness))) and 0xFFFFFF
        )

        // Return the analogous color hex values
        return Pair(analogousColor1, analogousColor2)
    }

    fun getTriadicColors(hexColor: String): Pair<String, String> {
        // Convert hex color to RGB
        val red = Integer.parseInt(hexColor.substring(1, 3), 16)
        val green = Integer.parseInt(hexColor.substring(3, 5), 16)
        val blue = Integer.parseInt(hexColor.substring(5, 7), 16)

        // Calculate the hue, saturation, and brightness of the color
        val hsv = FloatArray(3)
        Color.RGBToHSV(red, green, blue, hsv)
        val hue = hsv[0]
        val saturation = hsv[1]
        val brightness = hsv[2]

        // Calculate the triadic hues (120 degrees apart)
        val triadicHue1 = if (hue >= 120) hue - 120 else hue + 240
        val triadicHue2 = if (hue <= 240) hue + 120 else hue - 240

        // Convert the triadic hues back to RGB and then to hex color values
        val triadicColor1 = String.format(
            "#%06X",
            (Color.HSVToColor(floatArrayOf(triadicHue1, saturation, brightness))) and 0xFFFFFF
        )
        val triadicColor2 = String.format(
            "#%06X",
            (Color.HSVToColor(floatArrayOf(triadicHue2, saturation, brightness))) and 0xFFFFFF
        )

        // Return the triadic color hex values
        return Pair(triadicColor1, triadicColor2)
    }

    fun getTetradicColors(hexColor: String): Triple<String, String, String> {
        // Convert hex color to RGB
        val red = Integer.parseInt(hexColor.substring(1, 3), 16)
        val green = Integer.parseInt(hexColor.substring(3, 5), 16)
        val blue = Integer.parseInt(hexColor.substring(5, 7), 16)

        // Calculate the hue, saturation, and brightness of the color
        val hsv = FloatArray(3)
        Color.RGBToHSV(red, green, blue, hsv)
        val hue = hsv[0]
        val saturation = hsv[1]
        val brightness = hsv[2]

        // Calculate the tetradic hues (90 degrees apart)
        val tetradicHue1 = if (hue >= 90) hue - 90 else hue + 270
        val tetradicHue2 = if (hue <= 270) hue + 90 else hue - 270
        val tetradicHue3 = if (hue >= 180) hue - 180 else hue + 180

        // Convert the tetradic hues back to RGB and then to hex color values
        val tetradicColor1 = String.format(
            "#%06X",
            (Color.HSVToColor(floatArrayOf(tetradicHue1, saturation, brightness))) and 0xFFFFFF
        )
        val tetradicColor2 = String.format(
            "#%06X",
            (Color.HSVToColor(floatArrayOf(tetradicHue2, saturation, brightness))) and 0xFFFFFF
        )
        val tetradicColor3 = String.format(
            "#%06X",
            (Color.HSVToColor(floatArrayOf(tetradicHue3, saturation, brightness))) and 0xFFFFFF
        )

        // Return the tetradic color hex values
        return Triple(tetradicColor1, tetradicColor2, tetradicColor3)
    }

    fun getLighterShades(hexColor: String): List<String> {
        // Convert hex color to RGB
        val red = Integer.parseInt(hexColor.substring(1, 3), 16)
        val green = Integer.parseInt(hexColor.substring(3, 5), 16)
        val blue = Integer.parseInt(hexColor.substring(5, 7), 16)

        // Calculate the lightness of the color
        val hsl = FloatArray(3)
        ColorUtils.RGBToHSL(red, green, blue, hsl)
        val lightness = hsl[2]

        // Calculate the lighter shades (increment lightness by 20% for each shade)
        val lighterShades = mutableListOf<String>()
        for (i in 1..5) {
            val newLightness = lightness + (i * 0.2f)
            val rgb = ColorUtils.HSLToColor(floatArrayOf(hsl[0], hsl[1], newLightness))
            lighterShades.add(String.format("#%06X", rgb and 0xFFFFFF))
        }

        // Return the lighter shades
        return lighterShades
    }

    fun getDarkerShades(hexColor: String): List<String> {
        // Convert hex color to RGB
        val red = Integer.parseInt(hexColor.substring(1, 3), 16)
        val green = Integer.parseInt(hexColor.substring(3, 5), 16)
        val blue = Integer.parseInt(hexColor.substring(5, 7), 16)

        // Calculate the darkness of the color
        val hsl = FloatArray(3)
        ColorUtils.RGBToHSL(red, green, blue, hsl)
        val lightness = hsl[2]

        // Calculate the darker shades (decrement lightness by 20% for each shade)
        val darkerShades = mutableListOf<String>()
        for (i in 1..5) {
            val newLightness = lightness - (i * 0.2f)
            val rgb = ColorUtils.HSLToColor(floatArrayOf(hsl[0], hsl[1], newLightness))
            darkerShades.add(String.format("#%06X", rgb and 0xFFFFFF))
        }

        // Return the darker shades
        return darkerShades
    }


}