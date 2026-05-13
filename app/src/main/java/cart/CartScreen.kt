package cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun CartScreen() {

    val cartItems = CartManager.cartItems

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F0E8))
            .padding(16.dp)

    ) {

        Text(
            text = "Your Cart",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3E2723)
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (cartItems.isEmpty()) {

            Text(
                text = "No items in cart",
                fontSize = 18.sp,
                color = Color.DarkGray
            )

        } else {

            LazyColumn {

                items(cartItems) { product ->

                    Card(

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)

                    ) {

                        Column(

                            modifier = Modifier
                                .background(Color.White)

                        ) {

                            AsyncImage(

                                model = product.image,

                                contentDescription = null,

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(240.dp),

                                contentScale = ContentScale.Crop
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = product.title,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF3E2723),
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = product.price,
                                fontSize = 18.sp,
                                color = Color(0xFF8B4513),
                                modifier = Modifier.padding(
                                    start = 12.dp,
                                    bottom = 14.dp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}