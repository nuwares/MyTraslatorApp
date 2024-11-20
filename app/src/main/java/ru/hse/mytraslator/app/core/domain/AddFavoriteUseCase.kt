package ru.hse.mytraslator.app.core.domain

import ru.hse.mytraslator.app.core.data.TranslationHistoryDao
import javax.inject.Inject

class AddFavoriteUseCase @Inject constructor(
    private val translationHistoryDao: TranslationHistoryDao,
) {
    suspend fun add (id: Long) {
        translationHistoryDao.addFavorite(id)
    }
}