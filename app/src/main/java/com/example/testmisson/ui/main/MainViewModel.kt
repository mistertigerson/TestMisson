package com.example.testmisson.ui.main

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.opengl.Visibility
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.testmisson.data.model.Lions
import com.example.testmisson.data.model.Ships
import com.example.testmisson.data.model.Zebres
import com.example.testmisson.data.model.Animal
import com.example.testmisson.databinding.ActivityMainBinding

class MainViewModel : ViewModel() {

    var animal: MutableList<Animal> = mutableListOf()
    var animals: MutableList<Animal> = mutableListOf()
    var item: Int = 0
    var id: Int = 0


    //создание листа
    fun onCreateList(binding: ActivityMainBinding, context: Context) {
        var input: Int = Integer.parseInt(binding.etNumber.text.toString())
            for (i in 1..input) {
                item++
                animals.add(Lions(enclosure = item, quantity = (1..12).random()))
                animals.add(Zebres(enclosure = item, quantity = (1..12).random()))
                animals.add(Ships(enclosure = item, quantity = (1..12).random()))

                animal.add(animals.random())

                animals.clear()

            }
            var tv : TextView = generateImageView(context)
            id = tv.id
            tv.text = animal.toString()

            binding.ll.addView(tv)
            binding.tvPrintInvise.text = animal.toString()
        }


    fun moveEat(binding: ActivityMainBinding, context: Context) {
        binding.btnStart.text = "next"

        // 20 + tttttt
        var food: String = binding.etCount.text.toString() + " " + binding.etFood.text.toString()

        // index ====== 1
        var enclosure: Int = Integer.parseInt(binding.cletka.text.toString())

        for (i in animal) {
            if (i.enclosure == enclosure) {
                animal[enclosure].food = food
                break
            } else {
                Toast.makeText(context, "такой клетки не существует", Toast.LENGTH_SHORT).show()
                break
            }
        }
        val tv : TextView = generateImageView(context)
        binding.ll.removeAllViews()
        tv.text = animal.toString()
        binding.ll.addView(tv)
        binding.tvPrintInvise.text = animal.toString()

//        binding.ll.removeAllViews()
//        binding.ll.addView(tv)
//        tv.text.removeRange(0,Integer.parseInt(binding.etNumber.text.toString()))
    }

    private fun generateImageView(context: Context): TextView {

        val imageView = TextView(context)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        imageView.layoutParams = params
        imageView.id = View.generateViewId()
        return imageView
    }
}
