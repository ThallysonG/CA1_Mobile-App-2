package com.example.ca1_ma2
import androidx.room.Room
import com.example.ca1_ma2.data.StudentDatabase
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.ca1_ma2.data.Student
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.ca1_ma2.ui.theme.CA1_MA2Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import com.example.ca1_ma2.screens.HomeScreen
import com.example.ca1_ma2.screens.RegistrationScreen
import com.example.ca1_ma2.screens.StudentSearchScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = Room.databaseBuilder(
            applicationContext,
            StudentDatabase::class.java,
            "student_database"
        ).build()
        val studentDao = database.StudentDao()

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
                        RegistrationScreen(
                            onBackClick = {
                                currentScreen = "home"
                            },
                            onCreateClick = { name, course, year ->

                                lifecycleScope.launch {

                                    val student = Student(
                                        name = name,
                                        course = course,
                                        year = year.toInt()
                                    )

                                    val studentId = studentDao.insertStudent(student)

                                    currentScreen = "created"
                                }
                            }
                        )
                    }
                }
            }
        }
    }
    }

