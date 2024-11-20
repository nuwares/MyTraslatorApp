package ru.hse.mytraslator.app.core.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pronunciation(
    @SerialName("source-text-audio") val sourceTextAudio: String?,
    @SerialName("destination-text-audio") val destinationTextAudio: String?,
)
