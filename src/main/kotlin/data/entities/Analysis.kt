package data.entities

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class Analysis(
    val id: String,
    var name: String,
    val referenceValue: String? = null,
    val result: MutableState<String> = mutableStateOf("")
)
