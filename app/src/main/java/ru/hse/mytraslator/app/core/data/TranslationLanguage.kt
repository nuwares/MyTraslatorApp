package ru.hse.mytraslator.app.core.data

class TranslationLanguage {
    companion object {
        fun getLanguageList() = mapOf(
            "English" to "en",
            "Russia" to "ru",
            "Arabic" to "ar",
            "French" to "fr",
            "Latin" to "la",
        )
    }
}