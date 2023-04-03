package com.example.roomremix2.data
import android.widget.Toast
import com.google.gson.Gson
import java.io.File
import java.io.FileOutputStream
/**
@property id; id of floorplan
@property x; input x for room size.
@property y; input y for room size.
*/
class FloorPlanData {

    data class FloorPlanItem(
        val id: Int,
        val resourceId: Int,
        val x: Float,
        val y: Float
    )

    data class FloorPlan(
        val pathList: List<Path>,
        val colorList: List<Int>,
        val items: List<FloorPlanItem>
    )

    private fun saveFloorplanFile(floorPlan: FloorPlan, fileName: String) {
        //gson serializes JSON
        val gson = Gson()
        val json = gson.toJson(floorPlan)

        try {
            val file = File(filesDir, fileName)
            val floorplanfile = FileOutputStream(file).use { outputStream ->
                outputStream.write(json.toByteArray())
            }
            Toast.makeText(this, "Floorplan saved", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error saving floorplan", Toast.LENGTH_SHORT).show()
        }
    }
}