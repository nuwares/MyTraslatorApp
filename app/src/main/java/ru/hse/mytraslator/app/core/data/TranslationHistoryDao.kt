package ru.hse.mytraslator.app.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.hse.mytraslator.app.core.data.db.TranslationHistory

@Dao
interface TranslationHistoryDao {
    @Insert
    suspend fun insertHistory(history: TranslationHistory): Long

    @Query("SELECT * FROM translation_history ORDER BY timestamp")
    fun getTranslationHistory(): Flow<List<TranslationHistory>>

    @Query("SELECT * FROM translation_history  WHERE isFavorite = 1 ORDER BY timestamp")
    fun getTranslationFavorite(): Flow<List<TranslationHistory>>

    @Query("UPDATE translation_history SET isFavorite = 1 WHERE id=:id")
    suspend fun addFavorite(id: Long)
}