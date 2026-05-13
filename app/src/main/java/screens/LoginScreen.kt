package com.example.shilpa_kala.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shilpa_kala.R
import com.example.shilpa_kala.ui.theme.*

@Composable
fun LoginScreen(
    onUserLogin: () -> Unit,
    onArtisanLogin: () -> Unit
) {

    var name by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CreamBg),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.sculpture_banner),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "SHILPA KALA",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = DarkBrown
        )

        Text(
            text = "Ancient Art • Modern Marketplace",
            fontSize = 18.sp,
            color = TextGray
        )

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Enter your name")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),

            shape = RoundedCornerShape(20.dp),

            colors = OutlinedTextFieldDefaults.colors(

                focusedBorderColor = SoftBrown,

                unfocusedBorderColor = LightBrown,

                focusedTextColor = DarkBrown,

                unfocusedTextColor = DarkBrown,

                cursorColor = DarkBrown,

                focusedLabelColor = SoftBrown,

                unfocusedLabelColor = TextGray
            )
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                onUserLogin()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .height(58.dp),

            shape = RoundedCornerShape(20.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = SoftBrown,
                contentColor = Color.White
            )
        ) {

            Text(
                text = "Continue as User",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton(
            onClick = {
                onArtisanLogin()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .height(58.dp),

            shape = RoundedCornerShape(20.dp),

            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = DarkBrown
            )
        ) {

            Text(
                text = "Continue as Artisan",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}