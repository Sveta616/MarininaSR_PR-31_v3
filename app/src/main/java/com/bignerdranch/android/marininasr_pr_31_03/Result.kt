package com.bignerdranch.android.marininasr_pr_31_03

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Result : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val intent = intent
        val meters = intent.getIntExtra("meters", 0)
        val result = intent.getStringExtra("result") ?: "0"
        val textViewMet: TextView = findViewById(R.id.editt)
        val t: TextView = findViewById(R.id.res)
        textViewMet.text = "количество метров: $meters"
        t.text = "результат: $result"
    }
    fun backto(view: View) {
        val intent = Intent(this, FlatBank::class.java)
        startActivity(intent)
    }
}