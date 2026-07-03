// FILE 1: MainActivity.kt
package com.aifitness.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aifitness.app.ui.theme.AiFitnessTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AiFitnessTheme {
                AiFitnessApp()
            }
        }
    }
}