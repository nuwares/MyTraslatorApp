package ru.hse.mytraslator.app.core.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Translations(
    @SerialName("possible-translations") val possibleTranslations: List<String>,
)
