package ru.hse.mytraslator.app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TranslationResult(result: String, onAddFavorite: () -> Unit, modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = result,
        onValueChange = {},
        readOnly = true,
        modifier = modifier.fillMaxWidth(),
        trailingIcon = {
            IconButton(onClick = onAddFavorite) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = "Add favorite")
            }
        }
    )
}