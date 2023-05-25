package com.example.fibonaccinumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fibonaccinumbers.FibonacciRVAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fibonaccinumbers.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    override fun onResume() {
        super.onResume()
        displayNumList()

    }
    fun displayNumList() {
        val numbers = fibonacciNums(100)
        binding.rvFibonacci.layoutManager = LinearLayoutManager(this)
        val numberAdapter = FibonacciRVAdapter(numbers)
        binding.rvFibonacci.adapter = numberAdapter
    }

    fun fibonacciNums(count: Int): List<Int> {
        val fibonacciNumbers = mutableListOf(0, 1)

        for (i in 2 until count) {
            val nextNumber = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2]
            fibonacciNumbers.add(nextNumber)
        }

        return fibonacciNumbers
    }
}









