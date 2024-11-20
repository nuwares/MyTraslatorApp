package ru.hse.mytraslator.app.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.hse.mytraslator.app.core.data.TranslationLanguage
import ru.hse.mytraslator.app.core.domain.AddFavoriteUseCase
import ru.hse.mytraslator.app.core.domain.SaveHistoryUseCase
import ru.hse.mytraslator.app.core.domain.TranslationUseCase
import ru.hse.mytraslator.app.ui.TranslationUiState
import javax.inject.Inject

@HiltViewModel
class TranslationViewModel @Inject constructor(
    private val translationUseCase: TranslationUseCase,
    private val saveHistoryUseCase: SaveHistoryUseCase,
    private val addFavoriteUseCase: AddFavoriteUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(TranslationUiState())
    val uiState: StateFlow<TranslationUiState> = _uiState

    fun updateInputText(text: String) {
        _uiState.update { it.copy(inputText = text) }
    }

    fun clearInputText() {
        _uiState.update { it.copy(inputText = "") }
    }

    fun swapLanguages() {
        _uiState.update {
            it.copy(
                sourceLang = it.targetLang,
                targetLang = it.sourceLang
            )
        }
    }
    fun changeSourceLang(lang: String){
        _uiState.update { it.copy(sourceLang = lang) }
    }

    fun changeTargetLang(lang: String){
        _uiState.update { it.copy(targetLang = lang) }
    }

    fun translateText() {
        viewModelScope.launch {
            val language = TranslationLanguage.getLanguageList()
            val result = translationUseCase.translate(
                sl = language.getValue(_uiState.value.sourceLang), // _uiState.value.sourceLang,
                dl = language.getValue(_uiState.value.targetLang), // _uiState.value.targetLang,
                text = _uiState.value.inputText,
            )
            val id = saveHistoryUseCase.save(_uiState.value.inputText, result.translations.possibleTranslations.firstOrNull() ?: _uiState.value.inputText)
            _uiState.update {
                it.copy(
                    translatedText = result.translations.possibleTranslations.firstOrNull()
                        ?: _uiState.value.inputText,
                    historyId = id
                )
            }

        }

    }
    fun addFavorite(id: Long)
    {
        viewModelScope.launch {
            addFavoriteUseCase.add(id)
        }
    }

}