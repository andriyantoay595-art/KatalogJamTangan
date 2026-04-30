package com.example.katalogjamtangan6

data class Jam(
    val nama: String,
    val brand: String,
    val harga: Int
)

object JamData {
    val listJam = mutableListOf<Jam>()
}