package com.example.roomremix2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.example.newcanaryproject.ui.theme.*
import com.github.skydoves.colorpicker.compose.*
import java.util.*

class ColorWheel : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewCanaryProjectTheme {
                // on below line we are specifying background color for our application
                Surface(
                    // on below line we are specifying modifier and color for our app
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {

                    // on the below line we are specifying the theme as the scaffold.
                    Scaffold(

                        // in scaffold we are specifying the top bar.
                        topBar = {

                            // inside top bar we are specifying background color.
                            TopAppBar(backgroundColor = greenColor,

                                // along with that we are specifying title for our top bar.
                                title = {

                                    // in the top bar we are specifying tile as a text
                                    Text(

                                        // on below line we are specifying
                                        // text to display in top app bar.
                                        text = "GFG",

                                        // on below line we are specifying
                                        // modifier to fill max width.
                                        modifier = Modifier.fillMaxWidth(),

                                        // on below line we are specifying
                                        // text alignment.
                                        textAlign = TextAlign.Center,

                                        // on below line we are specifying
                                        // color for our text.
                                        color = Color.White
                                    )
                                })
                        }) {
                        // on below line we are
                        // calling color picker method
                        colorPicker()
                    }
                }
            }
        }
    }
}

@Composable
fun colorPicker() {
    // on below line we are creating a variable for controller
    val controller = rememberColorPickerController()

    // on below line we are creating a column,
    Column(
        // on below line we are adding a modifier to it,
        modifier = Modifier
            .fillMaxSize()
            // on below line we are adding a padding.
            .padding(all = 30.dp)
    ) {
        // on below line we are adding a row.
        Row(
            // on below line we are adding a modifier
            modifier = Modifier.fillMaxWidth(),
            // on below line we are adding horizontal
            // and vertical alignment.
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // on below line we are adding a alpha tile.
            AlphaTile(
                // on below line we are
                // adding modifier to it
                modifier = Modifier
                    .fillMaxWidth()
                    // on below line
                    // we are adding a height.
                    .height(60.dp)
                    // on below line we are adding clip.
                    .clip(RoundedCornerShape(6.dp)),
                // on below line we are adding controller.
                controller = controller
            )
        }
        // on below line we are
        // adding horizontal color picker.
        HsvColorPicker(
            // on below line we are
            // adding a modifier to it
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                .padding(10.dp),
            // on below line we are
            // adding a controller
            controller = controller,
            // on below line we are
            // adding on color changed.
            onColorChanged = {}
        )
        // on below line we are adding a alpha slider.
        AlphaSlider(
            // on below line we
            // are adding a modifier to it.
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(35.dp),
            // on below line we are
            // adding a controller.
            controller = controller,
            // on below line we are
            // adding odd and even color.
            tileOddColor = Color.White,
            tileEvenColor = Color.Black
        )
        // on below line we are
        // adding a brightness slider.
        BrightnessSlider(
            // on below line we
            // are adding a modifier to it.
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(35.dp),
            // on below line we are
            // adding a controller.
            controller = controller,
        )
    }
}
