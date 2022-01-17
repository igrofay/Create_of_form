package creating_form

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun Comment(
    comment: MutableState<String>,
    width: Float
){

    Card(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .width( with(LocalDensity.current){width.toDp()}),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.primarySurface)
    ){
        Row(
            Modifier.padding(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Комментарий",
                style = typography.subtitle2
            )
            Spacer(Modifier.width(15.dp))
            OutlinedTextField(
                value = comment.value,
                onValueChange = { comment.value = it },
                textStyle =  typography.subtitle2,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}