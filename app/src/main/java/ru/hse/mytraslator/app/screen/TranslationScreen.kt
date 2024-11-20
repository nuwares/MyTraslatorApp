package ru.hse.mytraslator.app.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.hse.mytraslator.app.core.data.TranslationLanguage
import ru.hse.mytraslator.app.ui.components.LanguageSelector
import ru.hse.mytraslator.app.ui.components.TextInput
import ru.hse.mytraslator.app.ui.components.TranslateButton
import ru.hse.mytraslator.app.ui.components.TranslationResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TranslationScreen(
    viewModel: TranslationViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()
    val languages = TranslationLanguage.getLanguageList()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(title = { Text("Translation App") })
        LanguageSelector(
            sourceLanguage = uiState.value.sourceLang,
            targetLanguage = uiState.value.targetLang,
            onSwapLanguages = { viewModel.swapLanguages() },
            onSourceLanguageChange = { viewModel.changeSourceLang(it) },
            onTargetLanguageChange = { viewModel.changeTargetLang(it) }
        )
        TextInput(
            text = uiState.value.inputText,
            onTextChange = { viewModel.updateInputText(it) },
            onClearText = { viewModel.clearInputText() },
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        TranslateButton(
            onTranslate = { viewModel.translateText() },
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        uiState.value.translatedText?.let { it ->
            TranslationResult(
                result = it,
                onAddFavorite = {
                    uiState.value.historyId?.let { id ->
                        viewModel.addFavorite(id)
                    }
                },
                modifier = Modifier.padding(horizontal = 16.dp),
            )
        }
    }

}