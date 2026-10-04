package com.healtcare.cats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.healtcare.cats.features.cat.presentation.CatScreen
import com.healtcare.cats.features.cat.presentation.components.CatBottomBar
import com.healtcare.cats.features.cat.presentation.components.CatCentreAlignTopAppBar
import com.healtcare.cats.ui.theme.CatsTheme

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




