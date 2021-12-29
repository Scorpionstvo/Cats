package com.example.cats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBreedFragment()
    }

    private fun startBreedFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.space, BreedsFragment.newInstance()).commit()
    }
}