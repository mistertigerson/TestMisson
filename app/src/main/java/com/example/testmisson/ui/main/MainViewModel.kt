package com.example.testmisson.ui.main

import android.content.Context
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
    var randomAnimals: MutableList<Animal> = mutableListOf()


    //при нажатии кнопки старт, создается лист из рандомных животных и их количество
    fun onCreateList(binding: ActivityMainBinding, context: Context) {
        binding.ll.removeAllViews()
        animal.clear()
        var input: Int = Integer.parseInt(binding.etNumber.text.toString())
        var item: Int = 0
        for (i in 1..input) {
            item++
            randomAnimals.add(Lions(enclosure = item, quantity = (1..12).random()))
            randomAnimals.add(Zebres(enclosure = item, quantity = (1..12).random()))
            randomAnimals.add(Ships(enclosure = item, quantity = (1..12).random()))

            animal.add(randomAnimals.random())

            randomAnimals.clear()

        }
        var tv: TextView = generateTextView(context)
        tv.text = animal.toString()

        binding.ll.addView(tv)
    }

    //логика перемещения еды в клетки
    fun moveEat(binding: ActivityMainBinding, context: Context) {
        binding.btnStart.text = "next"

        var food: String = binding.etCount.text.toString() + " " + binding.etFood.text.toString()

        var enclosure: Int = Integer.parseInt(binding.cletka.text.toString())

        for (i in animal) {
            if (i.enclosure == enclosure) {
                i.food = food
                break
            } else {
                Toast.makeText(context, "такой клетки не существует", Toast.LENGTH_SHORT).show()
            }
        }
        var tv: TextView = generateTextView(context)
        binding.ll.removeAllViews()
        tv.text = animal.toString()
        binding.ll.addView(tv)
    }

    private fun generateTextView(context: Context): TextView {

        val textView = TextView(context)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        textView.layoutParams = params
        textView.id = View.generateViewId()
        return textView
    }
}
