package com.example.shilpa_kala.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun HeritageScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F0E6))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "Heritage of Shilpa Kala",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4E342E)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.sculpture_banner),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(24.dp))

        HeritageCard(
            title = "Ancient Stone Craft",
            content =
                "Indian stone carving is one of the oldest art forms in the world. Skilled artisans known as Shilpis carved temples, idols and monuments completely by hand using traditional tools."
        )

        HeritageCard(
            title = "Hoysala Architecture",
            content =
                "The Hoysala temples of Karnataka are famous for their detailed carvings, symmetrical pillars and artistic sculptures that represent India's rich cultural history."
        )

        HeritageCard(
            title = "Modern Preservation",
            content =
                "Shilpa Kala helps local artisans showcase their work digitally so that traditional craftsmanship reaches modern buyers across the country."
        )

        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun HeritageCard(
    title: String,
    content: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF8D4B14)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = content,
                fontSize = 16.sp,
                color = Color.DarkGray,
                lineHeight = 24.sp
            )
        }
    }
}