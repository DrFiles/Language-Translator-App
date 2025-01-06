package com.arrowwould.workout.languagetranslatorapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.Translator
import com.google.mlkit.nl.translate.TranslatorOptions


class MainActivity : AppCompatActivity() {

    private lateinit var translator: Translator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val inputEditText = findViewById<EditText>(R.id.inputEditText)
        val translateButton = findViewById<Button>(R.id.translateButton)
        val outputText = findViewById<TextView>(R.id.outputText)
//        val inputEditText = findViewById<EditText>(R.id.inputEditText)

        // Create an English-German translator:
        val options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.HINDI)
            .build()
        val translator = Translation.getClient(options)


        val conditions = DownloadConditions.Builder()
            .requireWifi()
            .build()
        translator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
                // Model downloaded successfully. Okay to start translating.

                translateButton.setOnClickListener {
                    val textToTranslate = inputEditText.text.toString()
                    translateText(textToTranslate, outputText)
                }

                // (Set a flag, unhide the translation UI, etc.)
            }
            .addOnFailureListener { exception ->
                outputText.text = "Model Download Failed"
            }


    }

    private fun translateText(inputText: String, outputText: TextView) {
        translator.translate(inputText)
            .addOnSuccessListener { translatedText ->
                // Translation successful.
                outputText.text = translatedText
            }
            .addOnFailureListener { exception ->
                // Error.
                outputText.text = "Translation Failded"
                // ...
            }
    }


    override fun onDestroy() {
        super.onDestroy()
        translator.close()
    }


}
