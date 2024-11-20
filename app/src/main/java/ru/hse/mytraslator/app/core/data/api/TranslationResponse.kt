package ru.hse.mytraslator.app.core.data.api

import kotlinx.serialization.Serializable

@Serializable
data class TranslationResponse(
    val pronunciation: Pronunciation,
    val translations: Translations,
)