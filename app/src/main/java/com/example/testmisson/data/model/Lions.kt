package com.example.testmisson.data.model


data class Lions(
    override var enclosure: Int,
    override var name: String = "Lion",
    override var quantity: Int = 2,
    override var eat: String = "meat",
    override var food: String = "hay") : Animal()

data class Zebres(
    override var enclosure: Int,
    override var name: String = "Lion",
    override var quantity: Int,
    override var eat: String = "hay",
    override var food: String = "hay" ) : Animal()

data class Ships(
    override var enclosure: Int,
    override var name: String = "Ship",
    override var quantity: Int,
    override var eat: String = "hay",
    ) : Animal()

