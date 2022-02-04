package list_analyzes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import data.entities.Analysis
import org.jetbrains.skia.FontWeight


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemAnalysis(
    analysis: Analysis,
    onClick: ()-> Unit
){
    Card(
        onClick = onClick,
        Modifier.fillMaxWidth(0.6f),
        shape = RoundedCornerShape(5),
        border = BorderStroke(1.dp, colors.primarySurface)
    ) {
        Row(
            Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(colors.primarySurface),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = analysis.id,
                    style = typography.subtitle2,
                    color = Color.White
                )
            }
            Spacer(Modifier.width(25.dp))
            Text(
                text = analysis.name,
                style = typography.subtitle1,
                maxLines = 3 , overflow = TextOverflow.Ellipsis
            )
        }
    }
}