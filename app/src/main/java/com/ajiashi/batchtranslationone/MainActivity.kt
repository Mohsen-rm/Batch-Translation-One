package com.ajiashi.batchtranslationone

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ajiashi.batchtranslationone.app.BottomSheetDialogHomeMenu
import com.ajiashi.batchtranslationone.app.LanguagesApp
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var btn_translation : Button
    lateinit var btn_go_activity_downloads : LinearLayout
    lateinit var btn_choices_languages : LinearLayout
    lateinit var editText_translation : EditText
    lateinit var coordinatorLayout : RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        btn_translation = findViewById(R.id.btn_translation)
        editText_translation = findViewById(R.id.editTextTextMultiLine)
        btn_go_activity_downloads = findViewById(R.id.linear_translation_downloads)
        btn_choices_languages = findViewById(R.id.linear_choices_languages)


        btn_translation.setOnClickListener {
          var text_edit = editText_translation.editableText.toString()
          if (!text_edit.trim().isEmpty()){
              val intent = Intent(this@MainActivity,ActivityTranslation::class.java)
              intent.putExtra("txt_translation",text_edit)
              startActivity(intent)
          }else{
              Snackbar.make(coordinatorLayout,"Not found text", Snackbar.LENGTH_LONG).show()
          }
        }

        btn_go_activity_downloads.setOnClickListener {
            val intent = Intent(this@MainActivity,ActivityTranslationDownloads::class.java)
            startActivity(intent)
        }

        btn_choices_languages.setOnClickListener {
            val languagesApp = LanguagesApp() // Create an instance of LanguagesApp
            showLanguageSelectionDialog(this, languagesApp)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu -> {
                val dialogQuranMenu = BottomSheetDialogHomeMenu(this@MainActivity)
                dialogQuranMenu.showBottomSheetDialog()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun showLanguageSelectionDialog(context:Context, languagesApp: LanguagesApp) {

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Select a Language")

        val itemsLanguagesList = languagesApp.getItemsLanguagesList()
        val languageNames = ArrayList<String>()

        // Extract language names from the ItemsLanguages list
        for (language in itemsLanguagesList) {
            languageNames.add(language.name)
        }

        val languageArray = languageNames.toTypedArray()

        builder.setItems(languageArray) { dialog, which ->
            val selectedLanguage = itemsLanguagesList[which]
            // Handle the selected language here
            Toast.makeText(context, "Selected language: ${selectedLanguage.name}", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()

    }

}