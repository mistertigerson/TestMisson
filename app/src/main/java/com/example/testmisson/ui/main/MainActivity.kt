package com.example.testmisson.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testmisson.*
import com.example.testmisson.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.btnNext.setOnClickListener{
            viewModel.moveEat(binding, this)

        }
        clickButton()
        nextBtn()
    }

    private fun nextBtn() {

    }

    private fun clickButton() {
        binding.btnStart.setOnClickListener {
            binding.ll.removeAllViews()
            viewModel.animal.clear()
            viewModel.onCreateList(binding, this)

        }
    }




}


