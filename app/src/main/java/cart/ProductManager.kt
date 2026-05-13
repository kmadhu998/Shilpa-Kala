package cart

import com.example.shilpa_kala.R
import com.example.shilpa_kala.model.Product

object ProductManager {

    val products = mutableListOf(

        Product(
            id = "1",
            title = "Ganesha Idol",
            price = "₹12,000",
            image = R.drawable.ganesha
        ),

        Product(
            id = "2",
            title = "Nandi Sculpture",
            price = "₹18,000",
            image = R.drawable.nandi
        ),

        Product(
            id = "3",
            title = "Krishna Statue",
            price = "₹15,000",
            image = R.drawable.krishna
        ),

        Product(
            id = "4",
            title = "Shiva Sculpture",
            price = "₹25,000",
            image = R.drawable.shiva
        ),

        Product(
            id = "5",
            title = "Buddha Art",
            price = "₹20,000",
            image = R.drawable.budda
        ),

        Product(
            id = "6",
            title = "Durga Idol",
            price = "₹30,000",
            image = R.drawable.durga
        )
    )
}