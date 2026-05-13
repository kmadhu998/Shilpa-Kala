package com.example.shilpa_kala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.shilpa_kala.navigation.AppNavigation
import com.example.shilpa_kala.ui.theme.Shilpa_KalaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Shilpa_KalaTheme {
                AppNavigation()
            }
        }
    }
}