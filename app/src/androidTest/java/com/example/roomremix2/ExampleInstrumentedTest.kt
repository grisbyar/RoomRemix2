package com.example.roomremix2

import android.graphics.Color
import android.graphics.Path
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.roomremix2.R.id.*
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.roomremix2", appContext.packageName)
    }
}
class MainActivityTest {
    @Test
    fun onClick_drawButtonBlack() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(draw)).perform(click())
        assert(DrawView.currentColor == Color.BLACK)
    }
    @Test
    fun onClick_eraserButtonWhite(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(eraser)).perform(click())
        assert(DrawView.currentColor == Color.WHITE)
    }
    @Test
    fun onClick_deleteButtonWorks(){
        ActivityScenario.launch(MainActivity::class.java)
        DrawView.pathList.add(Path())
        DrawView.colorList.add(Color.BLACK)
        onView(withId(delete)).perform(click())
        assert(DrawView.pathList.isEmpty())
        assert(DrawView.colorList.isEmpty())
    }
}