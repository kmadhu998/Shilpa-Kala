package com.example.shilpa_kala.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*

import cart.CartScreen

import com.example.shilpa_kala.model.Product
import com.example.shilpa_kala.screens.*
import com.example.shilpa_kala.screens.LoginScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    var selectedProduct by remember {
        mutableStateOf<Product?>(null)
    }

    var userRole by remember {
        mutableStateOf("User")
    }

    Scaffold(

        bottomBar = {

            val currentRoute =
                navController.currentBackStackEntryAsState()
                    .value
                    ?.destination
                    ?.route

            if (currentRoute != "login") {

                NavigationBar {

                    NavigationBarItem(
                        selected = currentRoute == "home",
                        onClick = {
                            navController.navigate("home")
                        },
                        icon = {
                            Text("🏠")
                        },
                        label = {
                            Text("Home")
                        }
                    )

                    if (userRole == "User") {

                        NavigationBarItem(
                            selected = currentRoute == "cart",
                            onClick = {
                                navController.navigate("cart")
                            },
                            icon = {
                                Text("🛒")
                            },
                            label = {
                                Text("Cart")
                            }
                        )
                    }

                    NavigationBarItem(
                        selected = currentRoute == "chat",
                        onClick = {
                            navController.navigate("chat")
                        },
                        icon = {
                            Text("💬")
                        },
                        label = {
                            Text("Chat")
                        }
                    )

                    if (userRole == "Artisan") {

                        NavigationBarItem(
                            selected = currentRoute == "upload",
                            onClick = {
                                navController.navigate("upload")
                            },
                            icon = {
                                Text("⬆️")
                            },
                            label = {
                                Text("Upload")
                            }
                        )
                    }
                }
            }
        }

    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "login",
            modifier = Modifier.padding(paddingValues)
        ) {

            composable("login") {

                LoginScreen(

                    onUserLogin = {

                        userRole = "User"

                        navController.navigate("home")
                    },

                    onArtisanLogin = {

                        userRole = "Artisan"

                        navController.navigate("home")
                    }
                )
            }

            composable("home") {

                HomeScreen(

                    onProductClick = { product ->

                        selectedProduct = product

                        navController.navigate("product")
                    }
                )
            }

            composable("product") {

                selectedProduct?.let {

                    ProductScreen(
                        product = it
                    )
                }
            }

            composable("cart") {

                CartScreen()
            }

            composable("chat") {

                ChatScreen()
            }

            composable("upload") {

                UploadScreen()
            }

            composable("heritage") {

                HeritageScreen()
            }
        }
    }
}
