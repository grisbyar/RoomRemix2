package com.example.roomremix2.ui.canvas

import android.Manifest
import android.app.Activity
import android.content.ClipData
import android.content.ClipDescription
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.LinearInterpolator
import android.widget.HorizontalScrollView
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.afollestad.materialdialogs.LayoutMode
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.bottomsheets.BasicGridItem
import com.afollestad.materialdialogs.bottomsheets.BottomSheet
import com.afollestad.materialdialogs.bottomsheets.gridItems
import com.afollestad.materialdialogs.color.colorChooser
import com.afollestad.materialdialogs.list.listItems
import com.example.roomremix2.DragRectView
import com.example.roomremix2.DragRectView.OnUpCallback
import com.example.roomremix2.R
import com.example.roomremix2.databinding.FragmentCanvasBinding
import com.example.roomremix2.utils.Constants
import com.example.roomremix2.utils.Constants.STORAGE_PERMISSION_CODE
import com.example.roomremix2.utils.snackBarMsg
import kotlinx.android.synthetic.main.fragment_canvas.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CanvasFragment : Fragment() {

    private var _binding: FragmentCanvasBinding? = null
    private val binding get() = _binding!!

    private var brushColor: Int = Color.BLACK

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCanvasBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        binding.canvas = this
        binding.drawing = binding.drawingView

        // Initiate for long click.
        eraser()
        brush()

        setHasOptionsMenu(true)
        onBackPressed()

        binding.llIcons.setOnDragListener(dragListener)
        binding.drawingView.setOnDragListener(dragListener)
        binding.ibed.setOnLongClickListener {
            val clipText = "Bed"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            true
        }
        binding.ichair.setOnLongClickListener {
            val clipText = "Chair"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            true
        }
        binding.icouch.setOnLongClickListener {
            val clipText = "Couch"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            true
        }
        binding.idesk.setOnLongClickListener {
            val clipText = "Desk"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            true
        }
        binding.idoor.setOnLongClickListener {
            val clipText = "Door"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            true
        }

        binding.idresser.setOnLongClickListener {
            val clipText = "Dresser"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            true
        }

        binding.ilamp.setOnLongClickListener {
            val clipText = "Lamp"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            true
        }

        binding.ilaptop.setOnLongClickListener {
            val clipText = "Laptop"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            true
        }
        binding.itable.setOnLongClickListener {
            val clipText = "Table"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            true
        }
        binding.itelevision.setOnLongClickListener {
            val clipText = "Television"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            true
        }
        binding.iclosedwindow.setOnLongClickListener {
            val clipText = "Closed Window"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
            true
        }

        val view = binding.dragReact as DragRectView?

        view?.setOnUpCallback(object : OnUpCallback {
            override fun onRectFinished(rect: Rect?) {

                binding.drawingView.pivotX = rect?.exactCenterX()!!
                binding.drawingView.pivotY = rect?.exactCenterY()!!

                binding.drawingView.rotation = 45F

            }
        })

        return binding.root
    }


    val dragListener = View.OnDragListener { view, event ->
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                val item = event.clipData.getItemAt(0)
                val dragData = item.text
                Toast.makeText(activity, dragData, Toast.LENGTH_SHORT).show()

                view.invalidate()
                val v = event.localState as ImageButton
                if (view is DrawingView) {
                    val destination = view as DrawingView
                    when (dragData) {
                        "Bed" -> {
                            destination.addIcon(
                                event.x,
                                event.y,
                                resources.getDrawable(R.drawable.bed)
                            )
                        }
                        "Chair" -> {
                            destination.addIcon(
                                event.x,
                                event.y,
                                resources.getDrawable(R.drawable.chair)
                            )
                        }
                        "Couch" -> {
                            destination.addIcon(
                                event.x,
                                event.y,
                                resources.getDrawable(R.drawable.couch)
                            )
                        }
                        "Desk" -> {
                            destination.addIcon(
                                event.x,
                                event.y,
                                resources.getDrawable(R.drawable.desk)
                            )
                        }
                        "Door" -> {
                            destination.addIcon(
                                event.x,
                                event.y,
                                resources.getDrawable(R.drawable.door)
                            )
                        }
                        "Dresser" -> {
                            destination.addIcon(
                                event.x,
                                event.y,
                                resources.getDrawable(R.drawable.dresser)
                            )
                        }
                        "Lamp" -> {
                            destination.addIcon(
                                event.x,
                                event.y,
                                resources.getDrawable(R.drawable.floor_lamp)
                            )
                        }
                        "Laptop" -> {
                            destination.addIcon(
                                event.x,
                                event.y,
                                resources.getDrawable(R.drawable.laptop)
                            )
                        }
                        "Table" -> {
                            destination.addIcon(
                                event.x,
                                event.y,
                                resources.getDrawable(R.drawable.table)
                            )
                        }
                        "Television" -> {
                            destination.addIcon(
                                event.x,
                                event.y,
                                resources.getDrawable(R.drawable.television)
                            )
                        }
                        "Closed Window" -> {
                            destination.addIcon(
                                event.x,
                                event.y,
                                resources.getDrawable(R.drawable.window_closed_variant)
                            )
                        }
                    }
                }

                v.visibility = View.VISIBLE
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                view.invalidate()
                true
            }
            else -> false
        }
    }

    /* ===================================== Permissions ===================================== */

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when {
            resultCode == Activity.RESULT_OK && requestCode == Constants.GALLERY -> {
                try {
                    when {
                        data!!.data != null -> binding.ivBackground.setImageURI(data.data)
                        else -> snackBarMsg(requireView(), getString(R.string.error_parsing))
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun isReadStorageAllowed(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestStoragePermission() {
        ActivityCompat.requestPermissions(
            requireActivity(), arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ), STORAGE_PERMISSION_CODE
        )
    }

    /* ===================================== Options Menu ===================================== */

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_canvas, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.option_save_drawing -> saveDrawing()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun saveDrawing() {
        when {
            isReadStorageAllowed() -> saveBitmap()
            else -> requestStoragePermission()
        }
    }



    /* ===================================== Tools Panel ===================================== */

    fun brush() {
        binding.dragReact.visibility = GONE
        binding.drawingView.setBrushColor(brushColor)

        binding.ibBrushSize.setOnLongClickListener {
            showBrushSizeDialog(false)
            binding.drawingView.setBrushColor(brushColor)
            return@setOnLongClickListener true
        }

    }

    fun eraser() {
        binding.drawingView.setBrushColor(Color.WHITE)

        binding.ibEraseDraw.setOnLongClickListener {
            showBrushSizeDialog(true)
            binding.drawingView.setBrushColor(Color.WHITE)
            return@setOnLongClickListener true
        }
    }

    fun rotate(){
        binding.dragReact.visibility = VISIBLE
    }

    fun brushColor() {
        @Suppress("DEPRECATION")
        val colors = intArrayOf(
            Color.BLACK, Color.RED, Color.BLUE, Color.GREEN,
            Color.YELLOW, Color.MAGENTA, Color.GRAY, Color.CYAN,
            resources.getColor(R.color.beige), resources.getColor(R.color.orange),
            resources.getColor(R.color.greenLight), resources.getColor(R.color.purpleBlue)
        )

        MaterialDialog(requireContext(), BottomSheet(LayoutMode.WRAP_CONTENT)).show {
            title(R.string.dialog_choose_color)
            colorChooser(colors, allowCustomArgb = true, showAlphaSelector = true) { _, color ->
                brushColor = color
                binding.drawingView.setBrushColor(brushColor)
            }
            positiveButton(R.string.dialog_select)
            negativeButton(R.string.dialog_negative)
        }
    }

    fun imageBackground() {
        val options = listOf(
            getString(R.string.background_image_add), getString(R.string.background_image_clear)
        )

        MaterialDialog(requireContext(), BottomSheet(LayoutMode.WRAP_CONTENT)).show {
            title(R.string.dialog_background_image)
            listItems(items = options) { _, index, _ ->
                when (index) {
                    0 -> when {
                        isReadStorageAllowed() -> requestImage()
                        else -> requestStoragePermission()
                    }
                    1 -> binding.ivBackground.setImageURI(null)
                }
            }
        }
    }

    fun shareDrawing() {
        binding.drawingView.saveBitmap(binding.drawingView.getBitmap(flDrawingViewContainer))

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "image/jpeg"
            putExtra(Intent.EXTRA_STREAM, Uri.parse(binding.drawingView.result))
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        }

        startActivity(Intent.createChooser(intent, getString(R.string.share_drawing)))
    }

    fun moveScroll(direction: Int) {
        when (direction) {
            0 -> {
                binding.hsvRight.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
                binding.ibMoveRight.visibility = View.INVISIBLE
                binding.ibMoveLeft.visibility = View.VISIBLE
            }
            1 -> {
                binding.hsvRight.fullScroll(HorizontalScrollView.FOCUS_LEFT)
                binding.ibMoveLeft.visibility = View.INVISIBLE
                binding.ibMoveRight.visibility = View.VISIBLE
            }
        }
    }

    fun moveScroll2(direction: Int) {
        when (direction) {
            0 -> {
                binding.hsvRight2.fullScroll(HorizontalScrollView.FOCUS_RIGHT)
                binding.ibMoveRight2.visibility = View.INVISIBLE
                binding.ibMoveLeft2.visibility = View.VISIBLE
            }
            1 -> {
                binding.hsvRight2.fullScroll(HorizontalScrollView.FOCUS_LEFT)
                binding.ibMoveLeft2.visibility = View.INVISIBLE
                binding.ibMoveRight2.visibility = View.VISIBLE
            }
        }
    }

    /* ===================================== Tools Panel Utils ===================================== */

    private fun showBrushSizeDialog(eraser: Boolean) {
        val sizes = listOf(
            BasicGridItem(R.drawable.brush_small, getString(R.string.brush_small)),
            BasicGridItem(R.drawable.brush_medium, getString(R.string.brush_medium)),
            BasicGridItem(R.drawable.brush_large, getString(R.string.brush_large))
        )

        MaterialDialog(requireContext(), BottomSheet(LayoutMode.WRAP_CONTENT)).show {
            when (eraser) {
                true -> title(R.string.dialog_choose_eraser_size)
                else -> title(R.string.dialog_choose_brush_size)
            }

            gridItems(sizes) { _, index, _ ->
                when (index) {
                    0 -> binding.drawingView.setBrushSize(5F)
                    1 -> binding.drawingView.setBrushSize(10F)
                    2 -> binding.drawingView.setBrushSize(20F)
                }
            }
        }
    }

    private fun requestImage() {
        try {
            val pickPhotoIntent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(pickPhotoIntent, Constants.GALLERY)
        } catch (e: Exception) {
            snackBarMsg(requireView(), getString(R.string.gallery_not_available))
        }
    }

    private fun saveBitmap() {
        viewLifecycleOwner.lifecycleScope.launch {
            binding.drawingView.saveBitmap(binding.drawingView.getBitmap(flDrawingViewContainer))
            snackBarMsg(requireView(), getString(R.string.drawing_saved))
        }
    }

    /* ===================================== On app exit. ===================================== */

    private fun onBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                    MaterialDialog(requireContext(), BottomSheet(LayoutMode.WRAP_CONTENT)).show {
                        title(R.string.dialog_exit)
                        message(R.string.dialog_exit_message)

                        positiveButton(R.string.option_save_drawing) {
                            saveDrawing()

                            GlobalScope.launch(Dispatchers.Main) {
                                delay(1500L)
                                if (isEnabled) {
                                    isEnabled = false
                                    requireActivity().onBackPressed()
                                }
                            }
                        }
                        negativeButton(R.string.dialog_exit_confirmation) {
                            if (isEnabled) {
                                isEnabled = false
                                requireActivity().onBackPressed()
                            }
                        }
                    }
                }
            }
        )
    }
}