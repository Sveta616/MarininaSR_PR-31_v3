package com.bignerdranch.android.marininasr_pr_31_03

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView

class CountPrice : AppCompatActivity() {
    private var sp: Spinner? = null
    private var rez: TextView? = null
    private var choose: TextView? = null
    private var m: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_price)
        sp = findViewById(R.id.spinner)
        rez = findViewById(R.id.res)
        choose = findViewById(R.id.text)
        m = findViewById(R.id.editt)

    }


    fun ras(view: View) {
        val vibor = sp!!.selectedItem
        val num = m!!.text.toString().toInt()


        var finish = 0
        choose!!.text = vibor.toString()
        when (vibor.toString()) {
            "1-о комнатная квартира" -> {
                if (num >20&&num<30) finish = (num * 108712 * 1.4).toInt()
            }
            "2-х комнатная квартира" -> {
                if (num>30&&num<50 ) finish = num * 108712
            }
            "3-х комнатная квартира" -> {
                if (num>50 &&num<70) finish = (num * 108712 * 1.2).toInt()
            }
            "Студия" -> {
                if (num>15 && num<20) finish = (num * 108712 * 1.1).toInt()
            }
        }

        if (finish > 0) {
            rez!!.text = finish.toString() + " м"
            val intent = Intent(this, Result::class.java)
            intent.putExtra("meters", num)
            intent.putExtra("result", finish.toString())
            startActivity(intent)
        } else {
            rez!!.text = "Недопустимый диапазон"
        }
    }


        fun back(view: View) {
            val intent = Intent(this, FlatBank::class.java)
            startActivity(intent)
            }

    }








