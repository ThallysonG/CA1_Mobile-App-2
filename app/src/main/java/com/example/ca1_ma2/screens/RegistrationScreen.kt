package com.example.ca1_ma2.screens
import android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistrationScreen(

) {
    Text("CREATE ACCOUNT")
    var name by remember{
        mutableStateOf("")
    }
    var course by remember{
        mutableStateOf("")
    }
    var year by remember{
        mutableStateOf("")
    }
    OutlinedTextField(
        value = course, onValueChange = {course = it},
        label = {Text("COURSE")}

    )
    OutlinedTextField(
        value = name, onValueChange = {name = it},
        label = {Text("NAME")}

    )
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF60B270))
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "CREATE ACCOUNT",
            modifier = Modifier.padding(top = 55.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold, color = Color.Black
        )
        Text(
            text = "NAME:",
            modifier = Modifier.fillMaxWidth()
                .padding(top = 15.dp)
        )
        OutlinedTextField(
            value = name, onValueChange = {name = it}
        )
        Text(
            text = "COURSE:",
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp)
        )
        OutlinedTextField(
            value = course, onValueChange = {course = it},
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "YEAR:",
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp)
        )
        OutlinedTextField(
            value = year, onValueChange = {year = it},
            modifier = Modifier.fillMaxWidth()
        )

    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreePreview(){
RegistrationScreen()
}
