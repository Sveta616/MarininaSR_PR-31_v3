package com.bignerdranch.android.marininasr_pr_31_03

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.compose.ui.platform.ValueElementSequence

class FlatBank : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var password: EditText
    private lateinit var pref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flat_bank)
        login = findViewById<EditText>(R.id.login);
        password = findViewById(R.id.password);
        pref = getPreferences(MODE_PRIVATE)
        val edit1 = pref.edit()
        edit1.putString("login", intent.getStringExtra("login"))
        edit1.putString("password", intent.getStringExtra("password"))
        edit1.apply()
    }
    fun nextekr(view: View) {
        if (login.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
            if (login.text.toString() == "ekts" && password.text.toString() == "ekts2024") {
                if ((pref.getString("login", "") != "") && (pref.getString("password", "") != "")) {
                    if ((login.text.toString() == pref.getString("login", "")) && (password.text.toString() == pref.getString("password", ""))
                    ) {
                        val alert = AlertDialog.Builder(this)
                            .setTitle("Вход")
                            .setMessage("Успешно")
                            .setPositiveButton("Продолжить", null)
                            .create()
                            .show()

                        val intent = Intent(this, CountPrice::class.java)
                        startActivity(intent)
                    } else {
                        val temp1 = pref.getString("login", "ekts")
                        val temp2 = pref.getString("password", "ekts2024")
                        val alert = AlertDialog.Builder(this)
                            .setTitle("Ошибка")
                            .setMessage("Неверный логин или пароль\nЛогин : " + temp1+"\nПароль : " + temp2 )
                            .setPositiveButton("Повторить", null)
                            .create()
                            .show()
                    }
                } else {
                    val ed = pref.edit()
                    ed.putString("login", login.text.toString())
                    ed.putString("password", password.text.toString())
                    ed.apply()

                    val alert = AlertDialog.Builder(this)
                        .setTitle("Вход")
                        .setMessage("Успешно")
                        .setPositiveButton("Продолжить", null)
                        .create()
                        .show()

                    val intent = Intent(this, CountPrice::class.java)
                    startActivity(intent)
                }

            } else {
                val v1 = pref.getString("login","ekts")
                val v2 = pref.getString("password","ekts2024")
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Неверный логин или пароль)\nЛогин : " +v1+"\n Пароль : " + v2 )
                    .setPositiveButton("Продолжить", null)
                    .create()
                    .show()
            }
        } else {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Введите данные")
                .setPositiveButton("Продолжить", null)
                .create()
                .show()
        }


    }
}








