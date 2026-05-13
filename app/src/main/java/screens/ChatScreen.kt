package com.example.shilpa_kala.screens

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.shilpa_kala.model.ChatManager

@Composable
fun ChatScreen() {

    val context = LocalContext.current

    var message by remember { mutableStateOf("") }

    // 🔥 SHARED CHAT (User + Artisan see same)
    val messages = ChatManager.messages

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(12.dp)
            .imePadding()
    ) {

        // 🔥 CHAT LIST
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            reverseLayout = true
        ) {
            items(messages.reversed()) { msg ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = msg,
                        color = Color.White,
                        modifier = Modifier
                            .padding(6.dp)
                            .background(
                                Color(0xFF075E54),
                                RoundedCornerShape(12.dp)
                            )
                            .padding(10.dp)
                    )
                }
            }
        }

        // 🔽 INPUT AREA
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextField(
                value = message,
                onValueChange = { message = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Type message") }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {

                    if (message.isNotBlank()) {

                        // 🔥 ADD TO CHAT (VISIBLE TO BOTH USER + ARTISAN)
                        messages.add(message)

                        // 🔥 WHATSAPP NOTIFICATION
                        val phoneNumber = "918310034998" // change to artisan number

                        val intent = Intent(Intent.ACTION_VIEW).apply {
                            setPackage("com.whatsapp")
                            data = Uri.parse(
                                "https://wa.me/$phoneNumber?text=${Uri.encode(message)}"
                            )
                        }

                        try {
                            context.startActivity(intent)
                        } catch (e: Exception) {
                            Toast.makeText(
                                context,
                                "WhatsApp not installed",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        message = ""
                    }
                }
            ) {
                Text("Send")
            }
        }
    }
}