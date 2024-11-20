package ru.hse.mytraslator.app.core.data

import retrofit2.http.GET
import retrofit2.http.Query
import ru.hse.mytraslator.app.core.data.api.TranslationResponse

interface TranslationApi {

    @GET("translate")
    suspend fun translate(
        @Query("sl") sourceLanguage: String,
        @Query("dl") destinationLanguage: String,
        @Query("text") text: String,
    ): TranslationResponse
}