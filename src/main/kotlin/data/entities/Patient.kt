package data.entities

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotMutableState
import androidx.compose.runtime.snapshots.SnapshotStateList

data class Patient (
        val name: MutableState<String> = mutableStateOf(""),
        val surname: MutableState<String> = mutableStateOf(""),
        val patronymic: MutableState<String> =  mutableStateOf(""),
        val isMan: MutableState<Boolean> = mutableStateOf(true),
        val age: MutableState<String> = mutableStateOf(""),
        val typeBiomat: MutableState<String> = mutableStateOf(""),
        val listAnalyzes: SnapshotStateList<Analysis> = mutableStateListOf(),
        val listAnalyzes_5_6: SnapshotStateList<Analysis_5_6> = mutableStateListOf(),
        val comment: MutableState<String> = mutableStateOf(""),
        val contractor: MutableState<String> = mutableStateOf("")
){
        fun reset(){
                name.value = ""
                surname.value = ""
                patronymic.value = ""
                age.value = ""
                listAnalyzes.clear()
                listAnalyzes_5_6.clear()
                comment.value = ""
                typeBiomat.value=""
                contractor.value =""
        }
}