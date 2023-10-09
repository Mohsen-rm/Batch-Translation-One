package com.ajiashi.batchtranslationone.app

import com.ajiashi.batchtranslationone.R
import com.ajiashi.batchtranslationone.model.ItemsLanguages
import com.ajiashi.batchtranslationone.model.ItemsViewModel

class LanguagesApp {
    // Property to hold an instance of ItemsLanguages

    private val itemsLanguagesList: MutableList<ItemsLanguages> = mutableListOf()

    // Constructor to initialize the list with some items
    init {
        // Add instances of ItemsLanguages to the list
        // Add English
        itemsLanguagesList.add(ItemsLanguages(1, R.drawable.ic_baseline_share_white_24, "English", "en"))

        // Add Arabic
        itemsLanguagesList.add(ItemsLanguages(2, R.drawable.ic_baseline_share_white_24, "Arabic", "ar"))

        // Add French
        itemsLanguagesList.add(ItemsLanguages(3, R.drawable.ic_baseline_share_white_24, "French", "fr"))

        // Add German
        itemsLanguagesList.add(ItemsLanguages(4, R.drawable.ic_baseline_share_white_24, "German", "de"))

        // Add Russian
        itemsLanguagesList.add(ItemsLanguages(5, R.drawable.ic_baseline_share_white_24, "Russian", "ru"))

        // Add Chinese
        itemsLanguagesList.add(ItemsLanguages(6, R.drawable.ic_baseline_share_white_24, "Chinese", "zh"))

        // Add Portuguese
        itemsLanguagesList.add(ItemsLanguages(7, R.drawable.ic_baseline_share_white_24, "Portuguese", "pt"))

        // Add Bengali
        itemsLanguagesList.add(ItemsLanguages(8, R.drawable.ic_baseline_share_white_24, "Bengali", "bn"))

        // Add Spanish
        itemsLanguagesList.add(ItemsLanguages(9, R.drawable.ic_baseline_share_white_24, "Spanish", "es"))

        // Add Hindi
        itemsLanguagesList.add(ItemsLanguages(10, R.drawable.ic_baseline_share_white_24, "Hindi", "hi"))
    }

    // You can access the itemsLanguagesList property from other methods or classes
    fun getItemsLanguagesList(): List<ItemsLanguages> {
        return itemsLanguagesList
    }
}