package ru.hse.mytraslator.app.core.domain

import ru.hse.mytraslator.app.core.TranslationApi
import javax.inject.Inject

class TranslationUseCase @Inject constructor(
    private val translationApi: TranslationApi
) {
    suspend fun translate() {

    }
}