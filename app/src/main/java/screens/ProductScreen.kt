package com.example.shilpa_kala.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.shilpa_kala.model.Product
import cart.CartManager

@Composable
fun ProductScreen(
    product: Product
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5EFE6))
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AsyncImage(
            model =
                if (product.imageUri.isNotEmpty())
                    product.imageUri
                else
                    product.image,

            contentDescription = null,

            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .clip(RoundedCornerShape(20.dp)),

            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = product.title,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4E2C2A)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = product.price,
            fontSize = 24.sp,
            color = Color(0xFF8B5E3C)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Handcrafted Heritage Sculpture",
            fontSize = 16.sp,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(

            onClick = {
                CartManager.cartItems.add(product)
            },

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFA3520D)
            ),

            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),

            shape = RoundedCornerShape(20.dp)

        ) {

            Text(
                text = "Add to Cart",
                fontSize = 20.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(

            onClick = {

                val message =
                    "Hello, I am interested in ${product.title} priced at ${product.price}"

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        "https://wa.me/?text=${Uri.encode(message)}"
                    )
                )

                context.startActivity(intent)
            },

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4E2C2A)
            ),

            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),

            shape = RoundedCornerShape(20.dp)

        ) {

            Text(
                text = "Enquiry on WhatsApp",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}
