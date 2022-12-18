package com.leanderoid.adventofdroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.leanderoid.adventofdroid.ui.Home
import com.leanderoid.adventofdroid.ui.theme.AdventOfDroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AdventOfDroidTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Home()
                }
            }
        }
    }
}
