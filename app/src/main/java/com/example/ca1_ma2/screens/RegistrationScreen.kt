package com.example.ca1_ma2.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    onBackClick: () -> Unit,
    onCreateClick: (String, String, Int) -> Unit
) {

    // ==========================================
    // 1. STUDENT INFORMATION
    // ==========================================

    var name by remember {
        mutableStateOf("")
    }

    var course by remember {
        mutableStateOf("")
    }

    var year by remember {
        mutableStateOf("")
    }


    // ==========================================
    // 2. DROPDOWN STATES
    // ==========================================

    var courseExpanded by remember {
        mutableStateOf(false)
    }

    var yearExpanded by remember {
        mutableStateOf(false)
    }


    // ==========================================
    // 3. DROPDOWN OPTIONS
    // ==========================================

    val courses = listOf(
        "Computer Science",
        "Business",
        "Accounting"
    )

    val years = listOf(
        "1",
        "2",
        "3",
        "4"
    )


    // ==========================================
    // 4. FORM VALIDATION
    // ==========================================

    val isValidName = name.isNotBlank()

    val isValidCourse = course.isNotBlank()

    val yearNumber = year.toIntOrNull()

    val isValidYear =
        yearNumber != null && yearNumber in 1..4

    val isValidForm =
        isValidName && isValidCourse && isValidYear


    // ==========================================
    // 5. USER INTERFACE
    // ==========================================

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF60B270))
            .padding(horizontal = 30.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // TITLE

        Text(
            text = "CREATE ACCOUNT",
            modifier = Modifier.padding(top = 55.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )


        // ======================================
        // NAME FIELD
        // ======================================

        Text(
            text = "NAME:",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            colors = androidx.compose.material3
                .OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray
                )
        )


        // ======================================
        // COURSE DROPDOWN
        // ======================================

        Text(
            text = "COURSE:",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        ExposedDropdownMenuBox(
            expanded = courseExpanded,
            onExpandedChange = {
                courseExpanded = it
            }
        ) {

            OutlinedTextField(
                value = course,
                onValueChange = {},
                readOnly = true,
                singleLine = true,

                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = courseExpanded
                    )
                },

                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),

                colors = androidx.compose.material3
                    .OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.LightGray,
                        unfocusedContainerColor = Color.LightGray
                    )
            )

            ExposedDropdownMenu(
                expanded = courseExpanded,
                onDismissRequest = {
                    courseExpanded = false
                }
            ) {

                courses.forEach { selectedCourse ->

                    DropdownMenuItem(
                        text = {
                            Text(selectedCourse)
                        },

                        onClick = {
                            course = selectedCourse
                            courseExpanded = false
                        }
                    )
                }
            }
        }


        // ======================================
        // YEAR DROPDOWN
        // ======================================

        Text(
            text = "YEAR:",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        ExposedDropdownMenuBox(
            expanded = yearExpanded,
            onExpandedChange = {
                yearExpanded = it
            }
        ) {

            OutlinedTextField(
                value = year,
                onValueChange = {},
                readOnly = true,
                singleLine = true,

                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = yearExpanded
                    )
                },

                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),

                colors = androidx.compose.material3
                    .OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.LightGray,
                        unfocusedContainerColor = Color.LightGray
                    )
            )

            ExposedDropdownMenu(
                expanded = yearExpanded,
                onDismissRequest = {
                    yearExpanded = false
                }
            ) {

                years.forEach { selectedYear ->

                    DropdownMenuItem(
                        text = {
                            Text(selectedYear)
                        },

                        onClick = {
                            year = selectedYear
                            yearExpanded = false
                        }
                    )
                }
            }
        }


        // ======================================
        // CREATE BUTTON
        // ======================================

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Button(
            onClick = {
                if (isValidForm && yearNumber != null) {
                    onCreateClick(
                        name.trim(),
                        course,
                        yearNumber
                    )
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),

            shape = RoundedCornerShape(10.dp),

            border = BorderStroke(
                2.dp,
                Color.Black
            ),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray
            )
        ) {

            Text(
                text = "CREATE",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold
            )
        }


        // ======================================
        // BACK BUTTON
        // ======================================

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Button(
            onClick = onBackClick,

            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),

            shape = RoundedCornerShape(10.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {

            Text(
                text = "BACK",
                fontSize = 20.sp,
                color = Color(0xFF60B270),
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}


// ==========================================
// COMPOSE PREVIEW
// ==========================================

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {

    RegistrationScreen(
        onBackClick = {},
        onCreateClick = { _, _, _ -> },
    )
}