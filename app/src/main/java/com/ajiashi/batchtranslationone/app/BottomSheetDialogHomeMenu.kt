package com.ajiashi.batchtranslationone.app

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.text.ClipboardManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ajiashi.batchtranslationone.ActivityTranslationDownloads
import com.ajiashi.batchtranslationone.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class BottomSheetDialogHomeMenu(context: Context) {
    var context = context

    fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_home_menu_layout)

        bottomSheetDialog.show()
    }



    private fun shareApp() {
        val appPackageName = "packageName"
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        val shareMessage = "Check out this awesome app: https://play.google.com/store/apps/details?id=$appPackageName"
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
        context.startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
    
    private fun goActivityDownloads() {
        val intent = Intent(context,ActivityTranslationDownloads::class.java)
        intent.putExtra("key", "value")
        context.startActivity(intent)
    }
    
    private fun likeApp(){
        // في داخل نشاط أو فرع الكود الخاص بك
        val appPackageName = "packageName" // احصل على اسم حزمة التطبيق الخاصة بك

        try {
            // قم بفتح تقييم التطبيق على Google Play
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
        } catch (e: android.content.ActivityNotFoundException) {
            // إذا لم يكن تطبيق متجر Google Play مثبتًا على الجهاز
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")))
        }
    }

    private fun closeApp(){
        System.exit(0)
    }


}