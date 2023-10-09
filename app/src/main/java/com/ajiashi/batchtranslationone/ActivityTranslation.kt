package com.ajiashi.batchtranslationone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajiashi.batchtranslationone.adapter.CustomAdapter
import com.ajiashi.batchtranslationone.model.ItemsViewModel
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.languageid.LanguageIdentification
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions

class ActivityTranslation : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translation)

        val txt_translation = intent.getStringExtra("txt_translation")
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        val languageIdentifier = LanguageIdentification.getClient()
        languageIdentifier.identifyLanguage(txt_translation.toString())
            .addOnSuccessListener { languageCode ->
                if (languageCode == "und") {
                    Log.i("msg", "Can't identify language.")
                } else {
                    Log.i("msg", "Language: $languageCode")
//                    Toast.makeText(this@ActivityTranslation,languageCode,Toast.LENGTH_LONG).show()
                }
            }
            .addOnFailureListener {
                // Model couldn’t be loaded or other internal error.
                // ...
            }

        //    var data_langauges = ArrayList<ItemsLanguages>()

//        runOnUiThread{
//
//        }
//
//        // This loop will create 20 Views containing
//        // the image with the count of view
//        for (i in 1..20) {
//            data.add(ItemsViewModel(R.drawable.translation, "Item " + i))
//        }
//
//
//
//        // This will pass the ArrayList to our Adapter
//        val adapter = CustomAdapter(data)
//
//        // Setting the Adapter with the recyclerview
//        recyclerview.adapter = adapter

        //Toast.makeText(this@ActivityTranslation,txt_translation,Toast.LENGTH_LONG).show()

        // في النشاط الذي تريد استخدام خدمة الترجمة فيه
        val options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH) // اللغة المصدر
            .setTargetLanguage(TranslateLanguage.ARABIC) // اللغة المستهدفة
            .build()

        val translator = Translation.getClient(options)

        var conditions = DownloadConditions.Builder()
            .requireWifi()
            .build()
        translator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
                // Model downloaded successfully. Okay to start translating.
                // (Set a flag, unhide the translation UI, etc.)
                val textToTranslate = "Hello, world!"
                translator.translate(textToTranslate)
                    .addOnSuccessListener { translatedText ->
                        // قم بعرض النص المترجم هنا
                        println("Translated text: $translatedText")
                        Toast.makeText(this@ActivityTranslation,translatedText,Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener { exception ->
                        // في حالة حدوث خطأ
                        println("Translation failed with exception: $exception")
                    }
            }
            .addOnFailureListener { exception ->
                // Model couldn’t be downloaded or other internal error.
                // ...
            }
    }

    fun translate(text_translate:String): String {

        return TODO("Provide the return value")
    }
}