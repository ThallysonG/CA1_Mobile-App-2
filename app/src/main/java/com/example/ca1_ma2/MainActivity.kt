package com.example.ca1_ma2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.ca1_ma2.ui.theme.CA1_MA2Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.ca1_ma2.screens.HomeScreen
import com.example.ca1_ma2.screens.RegistrationScreen
import com.example.ca1_ma2.screens.StudentSearchScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CA1_MA2Theme {
            var currentScreen by remember {
                mutableStateOf("home")
            }
            when (currentScreen) {
                "home" -> {
                    HomeScreen(
                        onRegistrationClick = {
                            currentScreen = "registration"
                        },
                        onStudentSearchClick = {
                            currentScreen = "search"
                        })
                }

                "registration" -> {
                    RegistrationScreen()
                }

                "search" -> {
                    StudentSearchScreen()
                }
            }
            }
        }
    }
}

