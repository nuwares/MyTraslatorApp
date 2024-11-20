package ru.hse.mytraslator.app.core.domain

import ru.hse.mytraslator.app.core.data.TranslationHistoryDao
import ru.hse.mytraslator.app.core.data.db.TranslationHistory
import javax.inject.Inject

class SaveHistoryUseCase @Inject constructor(
    private val translationHistoryDao: TranslationHistoryDao,
) {
    suspend fun save(sourceText: String, translatedText: String): Long {
        return translationHistoryDao.insertHistory(
            TranslationHistory(
                sourceText = sourceText,
                translatedText = translatedText
            )
        )
    }
}