package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)

        val extraResult = intent.getStringExtra("result");

        var calculationsResult = "No result!";

        if (extraResult != "" && extraResult != null) {
            calculationsResult = extraResult
        }

        val resultTV: TextView = findViewById(R.id.resultTV);

        resultTV.text = calculationsResult
    }

    fun goToCalculator(view: View){
        val intent = Intent(this, MainActivity::class.java);
        startActivity(intent)
    }
}