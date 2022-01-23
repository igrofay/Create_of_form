package data.entities

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class Analysis_5_6(
    val id: String,
    val name: String,
    val hours: MutableState<String> = mutableStateOf(""),
    val specificGravity: MutableState<String> = mutableStateOf(""),
    val quantity: MutableState<String> = mutableStateOf("")
)
