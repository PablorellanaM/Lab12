package com.example.sightsnap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.material3.Text

class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen()
        }
    }
}

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x827FC5D0))
    ) {
        // Logo Image
        Image(
            painter = rememberAsyncImagePainter("https://via.placeholder.com/500x500"),
            contentDescription = "Logo",
            modifier = Modifier
                .size(500.dp)
                .offset(x = (-71).dp, y = (-13).dp),
            contentScale = ContentScale.FillBounds
        )

        // Text "SightSnap"
        Text(
            text = "SightSnap",
            style = TextStyle(
                color = Color.Black,
                fontSize = 50.sp,
                fontFamily = FontFamily.Serif,  // Replace with 'Kavoon' if available
                fontWeight = FontWeight.W400,
            ),
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 144.dp)  // Adjust position based on your layout
        )
    }
}
