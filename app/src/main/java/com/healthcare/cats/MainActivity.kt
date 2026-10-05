package com.healthcare.cats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.healthcare.cats.features.cat.presentation.CatScreen
import com.healthcare.cats.ui.theme.CatsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CatsTheme {
                CatScreen()
            }
        }
    }
}




