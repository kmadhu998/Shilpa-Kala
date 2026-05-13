package com.example.shilpa_kala.screens

import android.net.Uri
import com.example.shilpa_kala.ui.theme.*
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.shilpa_kala.R
import cart.ProductManager
import com.example.shilpa_kala.model.Product

@Composable
fun UploadScreen() {

    val context = LocalContext.current

    var title by remember {
        mutableStateOf("")
    }

    var price by remember {
        mutableStateOf("")
    }

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val launcher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) {
            imageUri = it
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CreamBg)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Upload Artwork",
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold,
            color =  DarkBrown
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = title,
            onValueChange = {
                title = it
            },

            label = {
                Text(
                    "Artwork Title",
                    color = Color.Gray
                )
            },

            modifier = Modifier.fillMaxWidth(),

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

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = price,
            onValueChange = {
                price = it
            },

            label = {
                Text(
                    "Price",
                    color = Color.Gray
                )
            },

            modifier = Modifier.fillMaxWidth(),

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

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                launcher.launch("image/*")
            },

            colors = ButtonDefaults.buttonColors(
                containerColor =  SoftBrown
            ),

            shape = RoundedCornerShape(20.dp),

            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {

            Text(
                text = "Choose Image",
                fontSize = 20.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        imageUri?.let {

            AsyncImage(
                model = it,
                contentDescription = null,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(20.dp)),

                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(

            onClick = {

                if (
                    title.isNotEmpty() &&
                    price.isNotEmpty() &&
                    imageUri != null
                ) {

                    val product = Product(

                        id = System.currentTimeMillis().toString(),

                        title = title,

                        price = "₹$price",

                        image = 0,

                        imageUri = imageUri.toString()
                    )

                    ProductManager.products.add(product)

                    Toast.makeText(
                        context,
                        "Artwork Uploaded",
                        Toast.LENGTH_SHORT
                    ).show()

                    title = ""
                    price = ""
                    imageUri = null
                }

                else {

                    Toast.makeText(
                        context,
                        "Fill all fields",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },

            colors = ButtonDefaults.buttonColors(
                containerColor =  DarkBrown
            ),

            shape = RoundedCornerShape(20.dp),

            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)

        ) {

            Text(
                text = "Upload Artwork",
                fontSize = 22.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(100.dp))
    }
}