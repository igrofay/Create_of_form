package list_analyzes

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import data.entities.Analysis

private val  listAnalyzes = listOf(
    Analysis("2.1.1", "Общий белок", "Общий белок"),
    Analysis("2.1.2", "Альбумины", "35-50 г/л"),
    Analysis("2.1.3", "СРБ", "отрицательные"),
    Analysis("2.1.4", "Амилаза", "32-64 ед."),
    Analysis("2.1.5", "Мочевина", "2,50-8,3 мкмоль/л"),
    Analysis("2.1.6", "Мочевая кислота", "202,30-416,50 мкмоль/л"),
    Analysis("2.1.7", "Креатинин", "4 –124 мкмоль/л"),
    Analysis("2.1.8", "Щелочная фосфотаза", "122-469 Ед/л"),
    Analysis("2.1.9", "Гамма-ГТ", "6-42 Ед/л"),
    Analysis("2.1.10", "Билирубин общий", "8,4-20,5 мкмоль/л"),
    Analysis("2.1.11", "Билирубин прямой", "0,00-5,00 мкмоль/л"),
    Analysis("2.1.12", "ЛДГ", "135-214 Ед/л"),
    Analysis("2.1.13", "Ревматоидн. фактор", "≤14 МЕ/мл"),
    Analysis("2.1.14", "АЛТ", "До 25 Е/л"),
    Analysis("2.1.15", "АСТ", "До 25 Е/л"),
    Analysis("2.1.16", "Глюкоза", "3,3-5,5 ммоль/л"),
    Analysis("2.1.17", "Холестерин", "5,2-6,5 ммоль/л"),
    Analysis("2.1.18", "ЛПВП", "≥1,00 ммоль/л"),
    Analysis("2.1.19", "ЛПНП", "≤3,00 ммоль/л"),
    Analysis("2.1.20", "Акт. креатинкиназы", "0-167 Ед/л"),
    Analysis("2.1.21", "Акт.изоферментов креатинкиназы", "0-25Ед/л"),
    Analysis("2.1.22", "Триглицериды", "≤1,70 ммоль/л"),
    Analysis("2.1.23", "Хлориды", "98-107 ммоль/л"),
    Analysis("2.1.24", "Железо"),
    Analysis("2.1.25", "Калий", "3,5-5,0 ммоль/л"),
    Analysis("2.1.26", "Натрий", "35-45 ммоль/л"),
    Analysis("2.1.27", "Кальций", "2,20-2,55 ммоль/л"),
    Analysis("2.1.28", "Трансферрин", "2,00-3,60 г/л"),
    Analysis("2.1.29", "Ферритин", "10,00-120,00 мкг/л"),
    Analysis("2.1.30", "Гликированный гемоглобин", "5,70%")
)

@Composable
fun BiochemicalOptions(
    addAnalysis: (analysis : Analysis)->Unit
){
    var search by remember {
        mutableStateOf("")
    }

    val searchList = remember {
        mutableStateListOf<Analysis>()
    }
    if (search.isEmpty()){
        searchList.clear()
        searchList.addAll(listAnalyzes)
    } else {
        searchList.clear()
        listAnalyzes.forEach { analysis ->
            if (analysis.name.lowercase().contains(search.lowercase())
                || analysis.id.contains(search)
            ){
                searchList.add(analysis)
            }
        }
    }
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        val stateVertical = rememberScrollState(0)
        Column(
            Modifier.verticalScroll(stateVertical),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = search,
                singleLine = true,
                leadingIcon = {
                    Icon(Icons.Default.Search , null)
                },
                onValueChange = { search = it },
                textStyle = typography.subtitle1,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            searchList.forEach { analysis ->
                if (analysis.referenceValue!=null){
                    ItemAnalysis(
                        analysis
                    ) {
                        addAnalysis(analysis)
                    }
                    Spacer(Modifier.height(12.dp))
                }else{
                    ItemAnalysisIron(analysis){
                        addAnalysis(it)
                    }
                    Spacer(Modifier.height(12.dp))
                }
            }
        }
        VerticalScrollbar(
            modifier = Modifier.align(Alignment.CenterEnd)
                .fillMaxHeight(),
            adapter = rememberScrollbarAdapter(stateVertical)
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemAnalysisIron(
    analysis: Analysis,
    onClick: (analysis: Analysis)-> Unit
){
    var isMan by remember {
        mutableStateOf(true)
    }
    Card(
        onClick = {
            onClick(
                if (isMan) analysis.copy(referenceValue = "4,8-26,0 ммоль/л")
                else analysis.copy(referenceValue = "0,7-21,5 ммоль/л")
            )
        },
        Modifier.fillMaxWidth(0.6f),
        shape = RoundedCornerShape(5),
        border = BorderStroke(1.dp, MaterialTheme.colors.primarySurface)
    ) {
        Column(
            Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                Modifier.padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Box(
                    Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primarySurface),
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
                    maxLines = 1 , overflow = TextOverflow.Ellipsis
                )
            }
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = isMan,
                    onClick = {isMan = true},
                    Modifier.size(16.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text(text = "Мужской", style = typography.subtitle2)
                Spacer(Modifier.width(15.dp))
                RadioButton(
                    selected =!isMan,
                    onClick = {isMan = false},
                    Modifier.size(16.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text(text = "Женский", style = typography.subtitle2)
            }
        }
    }
}