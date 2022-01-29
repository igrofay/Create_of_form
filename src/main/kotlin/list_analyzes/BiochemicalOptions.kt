package list_analyzes

import allData
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import data.entities.Analysis

private val listAnalyzes = allData.getListAnalyzes_2()

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