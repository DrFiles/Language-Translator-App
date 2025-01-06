package com.arrowwould.workout.languagetranslatorapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: EditText
    private lateinit var translateButton: Button
    private lateinit var outputTextView: TextView
    private lateinit var languageFromDropdown: AutoCompleteTextView
    private lateinit var languageToDropdown: AutoCompleteTextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        inputEditText = findViewById(R.id.input)
        translateButton = findViewById(R.id.translate)
        outputTextView = findViewById(R.id.output)
        languageFromDropdown = findViewById(R.id.language_from)
        languageToDropdown = findViewById(R.id.language_to)

        // Populate language dropdowns

    }


}
