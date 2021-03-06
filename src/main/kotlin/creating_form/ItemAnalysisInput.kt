package creating_form

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import data.entities.Analysis
import data.entities.Analysis_5_6

@Composable
fun ItemAnalysisInput(
    analysis: Analysis,
    width: Float,
    onDelete: ()->Unit
){
    Box(
        contentAlignment = Alignment.CenterStart
    ){
        Box(Modifier
            .offset(x= -40.dp)
            .clip(RoundedCornerShape(topStart= 25.dp, bottomStart = 25.dp))
            .background(colors.primarySurface)
            .clickable(onClick = onDelete)
            .padding(8.dp)
        ){
            Icon(
                Icons.Default.Add,
                null,
                modifier = Modifier.rotate(45f).size(30.dp),
                tint = Color.White
            )
        }
        Card(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .width( with(LocalDensity.current){width.toDp()}),
            shape = RoundedCornerShape(5.dp),
            border = BorderStroke(1.dp, colors.primarySurface)
        ){
            Row(
                Modifier.padding(30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primarySurface),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = analysis.id,
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.White
                    )
                }
                Spacer(Modifier.width(25.dp))
                Column(Modifier.weight(1f)) {
                    Text(
                        text = "????????????????????????: ${analysis.name}",
                        style = MaterialTheme.typography.subtitle2,
                        overflow = TextOverflow.Ellipsis
                    )
                    analysis.referenceValue?.let {
                        Spacer(Modifier.height(16.dp))
                        Text(
                            text = "?????????????????????? ????????????????: $it",
                            style = MaterialTheme.typography.subtitle2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
                Spacer(Modifier.width(30.dp))
                Text("??????????????????",style = MaterialTheme.typography.subtitle2)
                Spacer(Modifier.width(15.dp))
                OutlinedTextField(
                    value = analysis.result.value,
                    onValueChange = { analysis.result.value = it },
                    textStyle =  MaterialTheme.typography.subtitle2,
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
            }
        }
    }
}

@Composable
fun ItemAnalysis_5_6_Input(
    analysis: Analysis_5_6,
    width: Float,
    onDelete: ()->Unit
){
    Box(
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            Modifier
                .offset(x = -40.dp)
                .clip(RoundedCornerShape(topStart = 25.dp, bottomStart = 25.dp))
                .background(colors.primarySurface)
                .clickable(onClick = onDelete)
                .padding(8.dp)
        ) {
            Icon(
                Icons.Default.Add,
                null,
                modifier = Modifier.rotate(45f).size(30.dp),
                tint = Color.White
            )
        }
        Card(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .width( with(LocalDensity.current){width.toDp()}),
            shape = RoundedCornerShape(5.dp),
            border = BorderStroke(1.dp, MaterialTheme.colors.primarySurface)
        ){
            Row(
                Modifier.padding(30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primarySurface),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = analysis.id,
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.White
                    )
                }
                Spacer(Modifier.width(25.dp))
                Text(
                    text = "??? ????????????: ${analysis.name}",
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(Modifier.width(30.dp))
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text("????????",style = MaterialTheme.typography.subtitle2)
                        Spacer(Modifier.width(15.dp))
                        OutlinedTextField(
                            value = analysis.hours.value,
                            onValueChange = { analysis.hours.value = it },
                            textStyle =  MaterialTheme.typography.subtitle2,
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )
                    }
                    Spacer(Modifier.height(6.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("???????????????? ??????",style = MaterialTheme.typography.subtitle2)
                        Spacer(Modifier.width(15.dp))
                        OutlinedTextField(
                            value = analysis.specificGravity.value,
                            onValueChange = { analysis.specificGravity.value = it },
                            textStyle =  MaterialTheme.typography.subtitle2,
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )
                    }
                    Spacer(Modifier.height(6.dp))
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text("????????????????????, ????",style = MaterialTheme.typography.subtitle2)
                        Spacer(Modifier.width(15.dp))
                        OutlinedTextField(
                            value = analysis.quantity.value,
                            onValueChange = { analysis.quantity.value = it },
                            textStyle =  MaterialTheme.typography.subtitle2,
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true
                        )
                    }
                }
            }
        }
    }
}