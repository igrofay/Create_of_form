package creating_form

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import data.entities.Patient
import data.state.listTypeBiomaterial
import org.jetbrains.skia.FontWidth

@Composable
fun StandardData(
    patient: Patient,
    widthView: (LayoutCoordinates)->Unit
){
    val styleText = MaterialTheme.typography.subtitle2
    val height = 25.dp
    val delimiterWidth = 15.dp
    val width = 40.dp
    Card(
        modifier = Modifier.padding(vertical = 16.dp).onGloballyPositioned(widthView),
        shape = RoundedCornerShape(2),
        border = BorderStroke(1.dp, MaterialTheme.colors.primarySurface)
    ){
        Column(
            Modifier.padding(width).width(IntrinsicSize.Min)
        ) {
            Row {
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Имя", style = styleText)
                        Spacer(Modifier.width(delimiterWidth))
                        OutlinedTextField(
                            value = patient.name.value,
                            singleLine = true,
                            onValueChange = { patient.name.value = it },
                            textStyle = styleText
                        )
                    }
                    Spacer(Modifier.height(height))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "Фамилия", style = styleText)
                        Spacer(Modifier.width(delimiterWidth))
                        OutlinedTextField(
                            value = patient.surname.value,
                            singleLine = true,
                            onValueChange = { patient.surname.value = it },
                            textStyle = styleText
                        )
                    }
                }
                Spacer(Modifier.width(width))
                Column(
                    horizontalAlignment = Alignment.End
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "Отчество", style = styleText)
                        Spacer(Modifier.width(delimiterWidth))
                        OutlinedTextField(
                            value = patient.patronymic.value,
                            singleLine = true,
                            onValueChange = { patient.patronymic.value = it },
                            textStyle = styleText
                        )
                    }
                    Spacer(Modifier.height(height))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(text = "Возраст", style = styleText)
                        Spacer(Modifier.width(delimiterWidth))
                        OutlinedTextField(
                            value = patient.age.value,
                            singleLine = true,
                            onValueChange = { patient.age.value = it },
                            textStyle = styleText
                        )
                    }
                }

            }
            Spacer(Modifier.height(height))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.align(Alignment.End)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Пол:", style = styleText)
                    Spacer(Modifier.width(delimiterWidth))
                    RadioButton(
                        selected = patient.isMan.value,
                        onClick = {patient.isMan.value = true}
                    )
                    Spacer(Modifier.width(delimiterWidth/4))
                    Text(text = "Мужской", style = styleText)
                    Spacer(Modifier.width(delimiterWidth/2))
                    RadioButton(
                        selected =!patient.isMan.value,
                        onClick = {patient.isMan.value = false}
                    )
                    Spacer(Modifier.width(delimiterWidth/4))
                    Text(text = "Женский", style = styleText)
                }
                Spacer(Modifier.width(width))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Вид биоматериала", style = styleText)
                    Spacer(Modifier.width(delimiterWidth))
                    DropDownMenu(patient.typeBiomat)
                }
            }
        }
    }
}


@Composable
fun DropDownMenu(selectedItem: MutableState<String>){
    var expanded by remember { mutableStateOf(false) }
    var textfieldSize by remember { mutableStateOf(Size.Zero)}
    val rotate by animateFloatAsState(
        if (expanded) 180f else 0f
    )
    val list = listTypeBiomaterial
    Column {
        OutlinedTextField(
            value = selectedItem.value,
            onValueChange = {},
            singleLine = true,
            modifier = Modifier
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                } ,
            trailingIcon = {
                IconButton(onClick = { expanded = true }){
                    Icon(
                        Icons.Filled.ArrowDropDown,null,
                        Modifier.rotate(rotate)
                    )
                }
            },
            textStyle = MaterialTheme.typography.subtitle2
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textfieldSize.width.toDp()})
        ) {
            list.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedItem.value = label
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }
}