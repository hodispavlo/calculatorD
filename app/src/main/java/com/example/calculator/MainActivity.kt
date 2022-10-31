package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var res: Float? = null;

    private var firstNumber: Float? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun getResultFieldValue(): Float  {
        var input = binding.resultsET;

        return input.text.toString().toFloat();
    }

    fun clearInput() {
        var input = binding.resultsET
        input.setText("");
    }

    fun clear(view: View) {
        this.res = null;
        clearInput()
    }

    fun add(view: View) {
        var secondNumber = getResultFieldValue();

        this.res = this.firstNumber!! + secondNumber;
        clearInput();
    }

    fun subtract(view: View) {
        var secondNumber = getResultFieldValue();

        this.res = this.firstNumber!! - secondNumber;
        clearInput();
    }

    fun multiply(view: View) {
        var secondNumber = getResultFieldValue();

        this.res = this.firstNumber!! * secondNumber;
        clearInput();
    }

    fun divide(view: View) {
        var secondNumber = getResultFieldValue();

        this.res = this.firstNumber!! / secondNumber;
        clearInput();
    }

    fun count(view: View) {

        val intent = Intent(this, CountActivity::class.java);

        var extraResult = ""

        if (this.res != null) {
            extraResult = this.res.toString();
        }

        intent.putExtra("result", extraResult)
        startActivity(intent)

        this.res = null
        clearInput();
    }

    fun and(view: View) {
        this.firstNumber = getResultFieldValue()

        clearInput();
    }
}