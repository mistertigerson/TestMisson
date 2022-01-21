package com.example.testmisson.ui.main

import android.content.Context
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.example.testmisson.Lion
import com.example.testmisson.Ship
import com.example.testmisson.Zebra
import com.example.testmisson.data.model.Animal
import com.example.testmisson.databinding.ActivityMainBinding

class MainViewModel : ViewModel() {

    var animal: MutableList<Animal> = mutableListOf()

    fun testFun(binding: ActivityMainBinding, context: Context) {
        val int: Int = Integer.parseInt(binding.etNumber.text.toString())
        for (i in 1..int) {
            val animals = mutableListOf(
                Lion(quantity = (1..12).random()),
                Zebra(quantity = (1..12).random()),
                Ship(quantity = (1..12).random())
            )
            animal.add(animals.random())
        }
        val tv = TextView(context)
        tv.text = animal.toString()
        binding.ll.addView(tv)
    }
}