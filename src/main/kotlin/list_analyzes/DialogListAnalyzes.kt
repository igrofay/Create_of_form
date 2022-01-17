package list_analyzes

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogState
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberDialogState
import data.entities.Analysis
import data.entities.Analysis_5_6

@Composable
fun DialogListAnalyzes(
    visible: Boolean,
    closeDialog: ()-> Unit,
    listAnalyzes: MutableList<Analysis>,
    listAnalyzes_5_6: MutableList<Analysis_5_6>,
    sizeDialog: DialogState = rememberDialogState(
        size =  DpSize(600.dp, 500.dp)
    )
) {
    if (visible)Dialog(
        onCloseRequest = closeDialog,
        state = sizeDialog,
        title = "Добавить анализ в бланк",
    ) {
        ViewListAnalyzes(listAnalyzes, listAnalyzes_5_6 )
    }

}