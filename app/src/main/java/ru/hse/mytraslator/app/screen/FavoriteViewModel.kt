package ru.hse.mytraslator.app.screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.hse.mytraslator.app.core.data.TranslationHistoryDao
import ru.hse.mytraslator.app.core.data.db.TranslationHistory
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val translationHistoryDao: TranslationHistoryDao,
): ViewModel() {
    fun getFavorite(): Flow<List<TranslationHistory>> {
        return translationHistoryDao.getTranslationFavorite()
    }
}