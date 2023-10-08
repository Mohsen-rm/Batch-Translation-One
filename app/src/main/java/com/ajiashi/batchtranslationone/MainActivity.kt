package com.ajiashi.batchtranslationone

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.ajiashi.batchtranslationone.app.BottomSheetDialogHomeMenu
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var btn_translation : Button
    lateinit var editText_translation : EditText
    lateinit var coordinatorLayout : RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        btn_translation = findViewById(R.id.btn_translation)
        editText_translation = findViewById(R.id.editTextTextMultiLine)

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

    }

    //menu

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


}