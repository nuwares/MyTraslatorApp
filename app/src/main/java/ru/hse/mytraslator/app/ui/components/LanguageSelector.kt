package ru.hse.mytraslator.app.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.hse.mytraslator.app.R
import ru.hse.mytraslator.app.core.data.TranslationLanguage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSelector(
    sourceLanguage: String,
    targetLanguage: String,
    onSwapLanguages: () -> Unit,
    onSourceLanguageChange: (String) -> Unit,
    onTargetLanguageChange: (String) -> Unit,
) {
    val context = LocalContext.current
    val languages = TranslationLanguage.getLanguageList()
    var expandedSource by remember { mutableStateOf(false) }
    var expandedTarget by remember { mutableStateOf(false) }
    var selectedSource by remember { mutableStateOf(sourceLanguage) }
    var selectedTarget by remember { mutableStateOf(targetLanguage) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        Box (
            modifier = Modifier.width(140.dp)
        ) {
            ExposedDropdownMenuBox(
                expanded = expandedSource,
                onExpandedChange = {
                    expandedSource = !expandedSource
                }
            ) {
                TextField(
                    value = selectedSource,
                    onValueChange = {  },
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedSource) },
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expandedSource,
                    onDismissRequest = { expandedSource = false }
                ) {
                    languages.keys.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                selectedSource = item
                                expandedSource = false
                                onSourceLanguageChange(selectedSource)
                            }
                        )
                    }
                }
            }
        }
        Box (
            modifier = Modifier.width(50.dp)
        )
        {
            IconButton(
                onClick = {
                    val source = selectedSource
                    selectedSource = selectedTarget
                    selectedTarget = source
                    onSwapLanguages()
                }
            )
            {
                Icon(painterResource(R.drawable.ic_swap_lang), contentDescription = "Swap language")
            }
        }
        Box (
            modifier = Modifier.width(140.dp)
        ) {
            ExposedDropdownMenuBox(
                expanded = expandedTarget,
                onExpandedChange = {
                    expandedTarget = !expandedTarget
                }
            ) {
                TextField(
                    value = selectedTarget,
                    onValueChange = {  },
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedTarget) },
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expandedTarget,
                    onDismissRequest = { expandedTarget = false }
                ) {
                    languages.keys.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                selectedTarget = item
                                expandedTarget = false
                                onTargetLanguageChange(selectedTarget)
                            }
                        )
                    }
                }
            }
        }

    }
}