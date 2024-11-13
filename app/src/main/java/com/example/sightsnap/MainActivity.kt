package com.example.sightsnap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.sightsnap.ui.theme.SightSnapTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SightSnapTheme {
                var showSplash by remember { mutableStateOf(true) }

                if (showSplash) {
                    SplashScreen {
                        showSplash = false // Cambia el estado para mostrar MainScreen
                    }
                } else {
                    MainScreen() // Navega a MainScreen
                }
            }
        }
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    // Simular un retraso para la pantalla de bienvenida
    LaunchedEffect(Unit) {
        delay(2000) // 2 segundos
        onTimeout() // Cambiar a la MainScreen después del retraso
    }

    // Contenido de la SplashScreen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://via.placeholder.com/500x500"),
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "SightSnap",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}
