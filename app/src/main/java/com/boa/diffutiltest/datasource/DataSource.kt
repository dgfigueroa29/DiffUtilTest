package com.boa.diffutiltest.datasource

import com.boa.diffutiltest.model.Order

object DataSource {
    val stuff: List<Order>
        get() {
            return mutableListOf(
                Order(1, "Fruits"),
                Order(2, "Meat"),
                Order(3, "Eggs"),
                Order(4, "Sugar")
            )
        }
    val drinks: List<Order>
        get() {
            return mutableListOf(
                Order(5, "Wines"),
                Order(6, "Beers"),
                Order(7, "Water"),
                Order(8, "Soda")
            )
        }
}