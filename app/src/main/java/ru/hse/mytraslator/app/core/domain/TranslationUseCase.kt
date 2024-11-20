package ru.hse.mytraslator.app.core.domain

import ru.hse.mytraslator.app.core.data.TranslationApi
import ru.hse.mytraslator.app.core.data.api.TranslationResponse
import javax.inject.Inject

class TranslationUseCase @Inject constructor(
    private val translationApi: TranslationApi
) {
    suspend fun translate(sl: String, dl: String, text: String): TranslationResponse {
        return translationApi.translate(sl, dl, text)
    }
}