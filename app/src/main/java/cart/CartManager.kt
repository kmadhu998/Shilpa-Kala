package cart

import androidx.compose.runtime.mutableStateListOf
import com.example.shilpa_kala.model.Product

object CartManager {

    val cartItems = mutableStateListOf<Product>()

    fun addToCart(product: Product) {

        cartItems.add(product)
    }
}