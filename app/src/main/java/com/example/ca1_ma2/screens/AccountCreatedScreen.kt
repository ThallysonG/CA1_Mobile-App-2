package com.example.ca1_ma2.screens

import android.accounts.Account
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.util.TableInfo

@Composable
fun AccountCreatedScreen(
    studentId: Long,
    name: String,
    course: String,
    year: String,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF60B270))
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "ACCOUNT CREATED",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text("Name: $name")
        Text("Course: $course")
        Text("Year: $year")

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "YOUR STUDENT ID IS:",
            fontWeight = FontWeight.Bold
        )

        Text(
            text = studentId.toString(),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onBackClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "BACK",
                color = Color(0xFF60B270)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AccountCreatedScreenPreview() {
    AccountCreatedScreen(
        studentId = 1234567L,
        name = "John Smith",
        course = "Computer Science",
        year = "2",
        onBackClick = {}
    )
}