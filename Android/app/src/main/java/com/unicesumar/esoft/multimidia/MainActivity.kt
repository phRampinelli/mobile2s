package com.unicesumar.esoft.multimidia

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileInputStream
import android.widget.MediaController


class MainActivity : AppCompatActivity() {
    companion object {
        private const val PERMISSION_CODE = 1000
        private const val IMAGE_PICK_CODE = 1001
        private const val CAMERA_CODE = 1002
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (
            checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED &&
            checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA),
                PERMISSION_CODE
            );
        } else {
            loadImage()
            playSound()
            loadVideo()
            openGallery()
            openCamera()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == IMAGE_PICK_CODE)
                image_view.setImageURI(data?.data)

            if (requestCode == CAMERA_CODE) {
                val cameraImage: Bitmap = data!!.extras!!.get("data") as Bitmap
                image_view.setImageBitmap(cameraImage)
            }
        }
    }

    private fun openCamera() {
        open_camera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAMERA_CODE)
        }
    }

    private fun openGallery() {
        open_gallery.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, IMAGE_PICK_CODE)
        }
    }

    private fun loadVideo() {
        val file = File(
            Environment.getExternalStorageDirectory(),
            "/Movies/Aerial_Shot_Of_City.mp4"
        )

        video_view.setVideoPath(file.path)

        val mediaController = MediaController(this)
        mediaController?.setAnchorView(video_view)
        video_view.setMediaController(mediaController)

        video_view.start()
    }

    private fun playSound() {
        play_sound.setOnClickListener {
            val uri: Uri = Uri.fromFile(
                File(
                    Environment.getExternalStorageDirectory(),
                    "/Music/GENERAL_SKY_A_QUESTAO.mp3"
                )
            )
            val mediaPlayer: MediaPlayer? = MediaPlayer().apply {
                setAudioStreamType(AudioManager.STREAM_MUSIC)
                setDataSource(applicationContext, uri)
                prepare()
                start()
            }
        }
    }

    private fun loadImage() {
        load_image.setOnClickListener {
            val file = File(
                Environment.getExternalStorageDirectory(),
                "/Pictures/capa_single.png"
            )
            val decodeStream = BitmapFactory.decodeStream(FileInputStream(file))
            image_view.setImageBitmap(decodeStream)
        }
    }
}