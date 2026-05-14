package com.example.shilpa_kala.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import coil.compose.AsyncImage
import com.example.shilpa_kala.model.Product
import cart.ProductManager

@Composable
fun HomeScreen(
    onProductClick: (Product) -> Unit,
    onHeritageClick: () -> Unit
) {

    val products = ProductManager.products

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F0E6))
    ) {

        Text(
            text = "Shilpa Kala",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4E2A1E),
            modifier = Modifier.padding(16.dp)
        )

        Button(

            onClick = {
                onHeritageClick()
            },

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4E2A1E)
            ),

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),

            shape = RoundedCornerShape(18.dp)

        ) {

            Text(
                text = "Explore Heritage Stories",
                color = Color.White,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyVerticalGrid(

            columns = GridCells.Fixed(2),

            modifier = Modifier.padding(8.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp),

            horizontalArrangement = Arrangement.spacedBy(12.dp)

        ) {

            items(products) { product ->

                Card(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onProductClick(product)
                        },

                    shape = RoundedCornerShape(20.dp),

                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )

                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        if (product.imageUri.isNotEmpty()) {

                            AsyncImage(

                                model = product.imageUri,

                                contentDescription = null,

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp)
                                    .clip(
                                        RoundedCornerShape(
                                            topStart = 20.dp,
                                            topEnd = 20.dp
                                        )
                                    ),

                                contentScale = ContentScale.Crop
                            )

                        } else {

                            Image(

                                painter = painterResource(id = product.image),

                                contentDescription = null,

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp)
                                    .clip(
                                        RoundedCornerShape(
                                            topStart = 20.dp,
                                            topEnd = 20.dp
                                        )
                                    ),

                                contentScale = ContentScale.Crop
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = product.title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4E2A1E)
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = product.price,
                            fontSize = 16.sp,
                            color = Color(0xFF8B5E3C)
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}
