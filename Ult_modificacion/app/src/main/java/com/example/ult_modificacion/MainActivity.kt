package com.example.ult_modificacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : ComponentActivity() {

    private lateinit var cameraExecutor: ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cameraExecutor = Executors.newSingleThreadExecutor()

        setContent {
            CameraPreview()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }

    @Composable
    fun CameraPreview() {
        val context = LocalContext.current
        val cameraProviderFuture = ProcessCameraProvider.getInstance(context)

        AndroidView(
            factory = { ctx ->
                val previewView = PreviewView(ctx)
                val executor = ContextCompat.getMainExecutor(ctx)

                cameraProviderFuture.addListener({
                    val cameraProvider = cameraProviderFuture.get()
                    val preview = Preview.Builder().build()
                    val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

                    preview.setSurfaceProvider(previewView.surfaceProvider)

                    try {
                        cameraProvider.unbindAll()
                        cameraProvider.bindToLifecycle(this, cameraSelector, preview)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }, executor)

                previewView
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}


