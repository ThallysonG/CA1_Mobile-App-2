package com.example.ca1_ma2.screens
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp





@Composable
fun HomeScreen(
    onRegistrationClick: () -> Unit,
    onStudentSearchClick: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF60B270)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "HOME PAGE",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 80.dp), // this say that: use the available space, dont need to use padding with X.dp
                )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = onRegistrationClick,
            modifier = Modifier
                .width(280.dp)
                .height(55.dp),
            shape = RoundedCornerShape(30.dp),
            border = BorderStroke(2.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray
            )

        ) {
            Text(
                text = "REGISTRATION",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold

            )

        }
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Button(
            onClick = onStudentSearchClick,
            modifier = Modifier
                .width(280.dp)
                .height(55.dp),
            shape = RoundedCornerShape(30.dp),
            border = BorderStroke(2.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)


        ) {
            Text(
                text = "STUDENT SEARCH",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(
            modifier = Modifier.height(50.dp)
        )

    }



}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onRegistrationClick = {},
        onStudentSearchClick = {}
    )
}