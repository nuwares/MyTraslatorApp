package ru.hse.mytraslator.app.ui

data class TranslationUiState(
    val sourceLang: String = "English",
    val targetLang: String = "Russia",
    val inputText: String = "",
    val translatedText: String? = null,
    val historyId: Long? = null,
)
