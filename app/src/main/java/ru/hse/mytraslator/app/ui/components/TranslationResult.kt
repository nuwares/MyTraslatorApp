package ru.hse.mytraslator.app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TranslationResult(result: String) {
    OutlinedTextField(
        value = result,
        onValueChange = {},
        readOnly = true,
        modifier = Modifier.fillMaxWidth()
    )
}