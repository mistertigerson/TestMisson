package com.example.testmisson

import com.example.testmisson.data.model.Animal

data class Lion(

    val name: String = "Lion",
    var quantity: Int  ,
    val eat: String = "meat",
    var food: String = "no") : Animal()

data class Zebra(
    val name: String = "Lion",
    var quantity: Int  ,
    val eat: String = "hay",
    var food: String = "no" ) : Animal()

data class Ship(
    val name: String = "Ship",
    var quantity: Int ,
    val eat: String = "hay",
    var food: String = "no") : Animal()

