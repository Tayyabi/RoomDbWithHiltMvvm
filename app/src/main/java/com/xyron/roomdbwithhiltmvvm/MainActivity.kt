package com.xyron.roomdbwithhiltmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.xyron.roomdbwithhiltmvvm.screens.ContactScreen
import com.xyron.roomdbwithhiltmvvm.ui.theme.RoomDbWithHiltMvvmTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomDbWithHiltMvvmTheme {

                ContactScreen()

            }
        }
    }
}