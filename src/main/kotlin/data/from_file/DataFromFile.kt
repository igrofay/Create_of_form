package data.from_file

import androidx.compose.runtime.MutableState
import data.entities.Analysis
import data.entities.Analysis_5_6
import java.io.File

var inputFolder = "C:\\resDocFolder\\input"
var manInputFile = "C:\\resDocFolder\\input\\manInputFile.txt"
var womanInputFile = "C:\\resDocFolder\\input\\womanInputFile.txt"

class DataFromFile(private val isMan: MutableState<Boolean>) {

    fun getListAnalyzes_1(): List<Analysis> {
        print(isMan.value)
        return if (isMan.value) {
            manListAnalyzes_1
        } else {
            womanListAnalyzes_1
        }
    }

    private val manListAnalyzes_1 = mutableListOf<Analysis>()

    private val womanListAnalyzes_1 = mutableListOf<Analysis>()

    private val manAnalyzes_1_1 = mutableListOf<Analysis>()

    private val womanAnalyzes_1_1 = mutableListOf<Analysis>()

    fun getListAnalyzes_1_1(): List<Analysis> {
        return if (isMan.value) {
            manAnalyzes_1_1
        } else {
            womanAnalyzes_1_1
        }
    }

    val manListAnalyzes_2 = mutableListOf<Analysis>()

    val womanListAnalyzes_2 = mutableListOf<Analysis>()

    fun getListAnalyzes_2(): List<Analysis> {
        return if (isMan.value) {
            manListAnalyzes_2
        } else {
            womanListAnalyzes_2
        }
    }

    private val manListAnalyzes_3 = mutableListOf<Analysis>()

    private val womanListAnalyzes_3 = mutableListOf<Analysis>()

    fun getListAnalyzes_3(): List<Analysis> {
        return if (isMan.value) {
            manListAnalyzes_3
        } else {
            womanListAnalyzes_3
        }
    }

    private val manListAnalyzes_4 = mutableListOf<Analysis>()

    private val womanListAnalyzes_4 = mutableListOf<Analysis>()

    fun getListAnalyzes_4(): List<Analysis> {
        return if (isMan.value) {
            manListAnalyzes_4
        } else {
            womanListAnalyzes_4
        }
    }

    private var manListAnalyzes_5 = mutableListOf<Analysis>()

    private val womanListAnalyzes_5 = mutableListOf<Analysis>()

    fun getListAnalyzes_5(): List<Analysis> {
        return if (isMan.value) {
            manListAnalyzes_5
        } else {
            womanListAnalyzes_5
        }
    }

    private val manAnalyzes_5_1 = mutableListOf<Analysis>()

    private val womanAnalyzes_5_1 = mutableListOf<Analysis>()

    fun getListAnalyzes_5_1(): List<Analysis> {
        return if (isMan.value) {
            manAnalyzes_5_1
        } else {
            womanAnalyzes_5_1
        }
    }

    private val manAnalysis_5_3 = mutableListOf<Analysis>()

    private val womanAnalysis_5_3 = mutableListOf<Analysis>()

    fun getListAnalyzes_5_3(): List<Analysis> {
        return if (isMan.value) {
            manAnalysis_5_3
        } else {
            womanAnalysis_5_3
        }
    }

    private val manAnalysis_5_5 = mutableListOf<Analysis>()

    private val womanAnalysis_5_5 = mutableListOf<Analysis>()

    fun getListAnalyzes_5_5(): List<Analysis> {
        return if (isMan.value) {
            manAnalysis_5_5
        } else {
            womanAnalysis_5_5
        }
    }

    private val manAnalysis_5_6 = mutableListOf<Analysis_5_6>()

    private val womanAnalysis_5_6 = mutableListOf<Analysis_5_6>()

    fun getListAnalyzes_5_6(): List<Analysis_5_6> {
        return if (isMan.value) {
            manAnalysis_5_6
        } else {
            womanAnalysis_5_6
        }
    }

    private val manAnalysis_5_7 = mutableListOf<Analysis>()

    private val womanAnalysis_5_7 = mutableListOf<Analysis>()

    fun getListAnalyzes_5_7(): List<Analysis> {
        return if (isMan.value) {
            manAnalysis_5_7
        } else {
            womanAnalysis_5_7
        }
    }

    init {
        val f = File(inputFolder)
        f.mkdir()
        var manFile = File(manInputFile)
        if (!manFile.exists()) {
            manFile.createNewFile()
            manFile.appendText("1.1 | ?????????? (??????????????????????) ???????????? ?????????? | null\n" +
                    "1.1.1 | ???????????????????? | 117-155 ??/??\n" +
                    "1.1.2 | ??????????????????(WBC) | 4.00 - 10.00*10^9/??\n" +
                    "1.1.3 | ????????????????????(RBC) | 3.80 - 5.10*10^12/??\n" +
                    "1.1.4 | ????????????????????(HCT) | 35.0 - 45.0%\n" +
                    "1.1.5 | ???????????????????? (PLT) | 150 - 400*10^9/??\n" +
                    "1.1.6 | ??????????????????, % (LY%) | 19.0 - 37.0%\n" +
                    "1.1.7 | ????????????????, % (MO%) | 3.0 - 12.0%\n" +
                    "1.1.8 | ????????????????????, % (EO%) | 1.0 - 5.0%\n" +
                    "1.1.9 | ?????? | 26,5-33,5 pg\n" +
                    "1.1.10 | ???????????????????????????? ?????????????????? | 1-6%\n" +
                    "1.1.11 | ?????????????????????????????? ???????????????????? | 47-72%\n" +
                    "1.2 | ???????????????????????? | 0,59-2,07%\n" +
                    "1.3 | ???????????????? ???????????????? ?????????????????????? (??????) | 2 ??? 20 ????/??\n" +
                    "2.1.1 | ?????????? ?????????? | ?????????? ??????????\n" +
                    "2.1.2 | ?????????????????? | 35-50 ??/??\n" +
                    "2.1.3 | ?????? | ??????????????????????????\n" +
                    "2.1.4 | ?????????????? | 32-64 ????.\n" +
                    "2.1.5 | ???????????????? | 2,50-8,3 ????????????/??\n" +
                    "2.1.6 | ?????????????? ?????????????? | 202,30-416,50 ????????????/??\n" +
                    "2.1.7 | ?????????????????? | 4 ???124 ????????????/??\n" +
                    "2.1.8 | ???????????????? ?????????????????? | 122-469 ????/??\n" +
                    "2.1.9 | ??????????-???? | 6-42 ????/??\n" +
                    "2.1.10 | ?????????????????? ?????????? | 8,4-20,5 ????????????/??\n" +
                    "2.1.11 | ?????????????????? ???????????? | 0,00-5,00 ????????????/??\n" +
                    "2.1.12 | ?????? | 135-214 ????/??\n" +
                    "2.1.13 | ????????????????????. ???????????? | ???14 ????/????\n" +
                    "2.1.14 | ?????? | ???? 25 ??/??\n" +
                    "2.1.15 | ?????? | ???? 25 ??/??\n" +
                    "2.1.16 | ?????????????? | 3,3-5,5 ??????????/??\n" +
                    "2.1.17 | ???????????????????? | 5,2-6,5 ??????????/??\n" +
                    "2.1.18 | ???????? | ???1,00 ??????????/??\n" +
                    "2.1.19 | ???????? | ???3,00 ??????????/??\n" +
                    "2.1.20 | ??????. ?????????????????????????? | 0-167 ????/??\n" +
                    "2.1.21 | ??????.???????????????????????? ?????????????????????????? | 0-25????/??\n" +
                    "2.1.22 | ???????????????????????? | ???1,70 ??????????/??\n" +
                    "2.1.23 | ?????????????? 98-107 | ??????????/??\n" +
                    "2.1.24 | ???????????? | 4,8-26,0 ??????????/??\n" +
                    "2.1.25 | ?????????? | 3,5-5,0 ??????????/??\n" +
                    "2.1.26 | ???????????? | 35-45 ??????????/??\n" +
                    "2.1.27 | ?????????????? | 2,20-2,55 ??????????/??\n" +
                    "2.1.28 | ?????????????????????? | 2,00-3,60 ??/??\n" +
                    "2.1.29 | ???????????????? | 10,00-120,00 ??????/??\n" +
                    "2.1.30 | ?????????????????????????? ???????????????????? | 5,70%\n" +
                    "3.1 | ???????????????????????? ???????????? ?????????????????????? ?? ?????????? | 1.80 - 3.50 ??/??\n" +
                    "3.2 | ?????????????????????? ?????????????????????????????? (????????????????????????????????????) ?????????????? ?? ?????????? ?????? ???????????? (??????) | 11.00 - 16.00 ??????\n" +
                    "3.3 | ?????????????????????? ?????????????????????????????? ???????????????????? ???????????????????????????????????? ?????????????? (????????) | 21.1 - 36.5 ??????\n" +
                    "3.4 | ?????????????????????? ???????????????????????? D-???????????? ?? ?????????? | 0.00 - 0.55 ??????FEU/????\n" +
                    "4.1.1 | ?????? | 0.270 - 4.200 ????????/????\n" +
                    "4.1.2 | ??3 ?????????? | 1.20 - 3.10 ??????????/??\n" +
                    "4.1.3 | ??3 ?????????????????? | 3.10 - 6.80 ??????????/??\n" +
                    "4.1.4 | ??4 ?????????? | 66.00 - 181.00 ??????????/??\n" +
                    "4.1.5 | ??4 ?????????????????? | 10.80 - 22.00 ??????????/??\n" +
                    "4.1.6 | ?????????????????????? ???????????????????? ?????????????? ?? ???????????????????????????????? ?? ?????????? (????????-??????) | 0.00 - 34.00 ????/????\n" +
                    "4.2.1 | ???????????????????????? ???????????? ?????????????????????????????????????????????????????????? ???????????? ?? ?????????? (??????) | 0.000 - 4.000 ????/????\n" +
                    "4.3.1 | ?????????????????????? ???????????????????????? N-?????????????????????????? ?????????????????? ?????????????????????????????? ?????????????????? ???????????????????????????????????? ???????????????????? ?????????????????? ??????????. | <125.00 ????/????\n" +
                    "4.4.1 | ?????????????? C, anti-HCV ????????. (??????) | ????????????????????????\n" +
                    "4.4.2 | ?????????????? ??, HBs Ag (??????) | ????????????????????????\n" +
                    "4.5.1 | ?????????????? ??????. ???? (IgG ?? IgM) (??????) | ????????????????????????\n" +
                    "4.5.2 | ?????????????? RPR (??/??????) | ????????????????????????\n" +
                    "5.1 | ?????????? (??????????????????????) ???????????? ???????? | null\n" +
                    "5.1.1 | ???????? | ???? ??????????????????-?????????????? ???? ??????????????\n" +
                    "5.1.2 | ???????????????????????? | ????????????????????\n" +
                    "5.1.3 | ???????????????? ?????? | 1.003 - 1.030\n" +
                    "5.1.4 | ?????????????? | 5.0 - 7.5\n" +
                    "5.1.5 | ?????????? | ???? ???????????????????? ?????? ?????????? 0,1 ??/??\n" +
                    "5.1.6 | ?????????????????? | ???? ????????????????????\n" +
                    "5.1.7 | ?????????????????? | ???? ????????????????????\n" +
                    "5.1.8 | ???????????????????????? | ???? ???????????????????? ?????? ??????????\n" +
                    "5.1.9 | ?????????????????? | ???????? ???? ????????????????????\n" +
                    "5.1.10 | ?????????????? | ???? ????????????????????\n" +
                    "5.1.11 | ?????????????? ???? ?????????? (????????????????????) | ???? ????????????????????\n" +
                    "5.1.12 | ?????????????????????????? ???????????????? | ???? ???????????????????? ?????? ??????????\n" +
                    "5.1.13 | ?????????????????????? ???????? | null\n" +
                    "5.1.14 | ????????????????: ?????????????? | 0.0 - 15.0 ????????/??????\n" +
                    "5.1.15 | ?????????????????? | 0.0 - 27.5 ????????/??????\n" +
                    "5.1.16 | ???????????????????? | 0.0 - 11.0 ????????/??????\n" +
                    "5.1.17 | ???????????????? | ???? ????????????????????\n" +
                    "5.1.18 | ?????????????????? | ???? ????????????????????\n" +
                    "5.1.19 | ???????????????? | ???? ???????????????????? ?????? ?????????????????? ????????????????????\n" +
                    "5.1.20 | ?????????? | ?????????????????? ????????????????????\n" +
                    "5.2.1 | ?????????? ????????-???????????? | ???? ????????????????????\n" +
                    "5.3 | ???????????????????????????????? ???????????????????????? ???????? ???? ???????? ?? ?????????????? ???????????????????? | null\n" +
                    "5.3.1 | Diphyllobothriumlatum | ???? ????????????????????\n" +
                    "5.3.2 | Ascarislumbricoides | ???? ????????????????????\n" +
                    "5.3.3 | Trichocephalustrichiurus | ???? ????????????????????\n" +
                    "5.3.4 | Thominxaerophilus | ???? ????????????????????\n" +
                    "5.3.5 | Ancylostomatidaegenussp | ???? ????????????????????\n" +
                    "5.3.6 | Fasciolahepatica | ???? ????????????????????\n" +
                    "5.3.7 | Opisthorchisfelineus | ???? ????????????????????\n" +
                    "5.3.8 | Trichostrongylidaesp | ???? ????????????????????\n" +
                    "5.3.9 | Dicrocoeliumlanceatum | ???? ????????????????????\n" +
                    "5.3.10 | Schistosomamanson | ???? ????????????????????\n" +
                    "5.3.11 | Schistosomajaponicum | ???? ????????????????????\n" +
                    "5.4.1 | ?????????????? ???? ?????????????? ?????????? | ????????????????????????\n" +
                    "5.5 | ?????????? ???????????? ?????????????? | null\n" +
                    "5.5.1 | ???????????????????? | null\n" +
                    "5.5.2 | ???????? | null\n" +
                    "5.5.3 | ?????????? | null\n" +
                    "5.5.4 | ???????????????? | null\n" +
                    "5.5.5 | ???????????????????????? | null\n" +
                    "5.5.6 | ?????????????? | null\n" +
                    "5.5.7 | ???????????????? (??/????) | null\n" +
                    "5.5.8 | ???????????????????????? ?????????????????? (??/????) | null\n" +
                    "5.5.9 | ?????????????????? (??/????) | null\n" +
                    "5.5.10 | ???????????????????? (??/????) | null\n" +
                    "5.5.11 | ???????????????????? (??/????) | null\n" +
                    "5.5.12 | ?????????????? ???????????????????????? | null\n" +
                    "5.5.13 | ???????????? ?????????? | null\n" +
                    "5.5.14 | ?????????????? ???????????????? | null\n" +
                    "5.5.15 | ?????????????????? ??????????-?????????????? | null\n" +
                    "5.5.16 | ???????????? ?? ???????????????????? ???????????? | null\n" +
                    "5.6 | ???????????? ???????? ???? ???????????????????? | null\n" +
                    "5.6.1 | 1\n" +
                    "5.6.2 | 2\n" +
                    "5.6.3 | 3\n" +
                    "5.6.4 | 4\n" +
                    "5.6.5 | 5\n" +
                    "5.6.6 | 6\n" +
                    "5.6.7 | 7\n" +
                    "5.6.8 | 8\n" +
                    "5.6.9 | ?????????????? ????????????\n" +
                    "5.6.10 | ???????????? ????????????\n" +
                    "5.6.11 | ?????????? ????????????\n" +
                    "5.7 | ???????????? ???????? ???? ?????????????????????? | null\n" +
                    "5.7.1 | ?????????????????? | 0,00-2,00\n" +
                    "5.7.2 | ???????????????????? | 0,00-1,00\n" +
                    "5.7.3 | ???????????????? | 0-0,02\n"
            )
        }

        var womanFile = File(womanInputFile)
        if (!womanFile.exists()) {
            womanFile.createNewFile()
            womanFile.appendText("1.1 | ?????????? (??????????????????????) ???????????? ?????????? | null\n" +
                    "1.1.1 | ???????????????????? | 117-155 ??/??\n" +
                    "1.1.2 | ??????????????????(WBC) | 4.00 - 10.00*10^9/??\n" +
                    "1.1.3 | ????????????????????(RBC) | 3.80 - 5.10*10^12/??\n" +
                    "1.1.4 | ????????????????????(HCT) | 35.0 - 45.0%\n" +
                    "1.1.5 | ???????????????????? (PLT) | 150 - 400*10^9/??\n" +
                    "1.1.6 | ??????????????????, % (LY%) | 19.0 - 37.0%\n" +
                    "1.1.7 | ????????????????, % (MO%) | 3.0 - 12.0%\n" +
                    "1.1.8 | ????????????????????, % (EO%) | 1.0 - 5.0%\n" +
                    "1.1.9 | ?????? | 26,5-33,5 pg\n" +
                    "1.1.10 | ???????????????????????????? ?????????????????? | 1-6%\n" +
                    "1.1.11 | ?????????????????????????????? ???????????????????? | 47-72%\n" +
                    "1.2 | ???????????????????????? | 0,59-2,07%\n" +
                    "1.3 | ???????????????? ???????????????? ?????????????????????? (??????) | 2 ??? 20 ????/??\n" +
                    "2.1.1 | ?????????? ?????????? | ?????????? ??????????\n" +
                    "2.1.2 | ?????????????????? | 35-50 ??/??\n" +
                    "2.1.3 | ?????? | ??????????????????????????\n" +
                    "2.1.4 | ?????????????? | 32-64 ????.\n" +
                    "2.1.5 | ???????????????? | 2,50-8,3 ????????????/??\n" +
                    "2.1.6 | ?????????????? ?????????????? | 202,30-416,50 ????????????/??\n" +
                    "2.1.7 | ?????????????????? | 4 ???124 ????????????/??\n" +
                    "2.1.8 | ???????????????? ?????????????????? | 122-469 ????/??\n" +
                    "2.1.9 | ??????????-???? | 6-42 ????/??\n" +
                    "2.1.10 | ?????????????????? ?????????? | 8,4-20,5 ????????????/??\n" +
                    "2.1.11 | ?????????????????? ???????????? | 0,00-5,00 ????????????/??\n" +
                    "2.1.12 | ?????? | 135-214 ????/??\n" +
                    "2.1.13 | ????????????????????. ???????????? | ???14 ????/????\n" +
                    "2.1.14 | ?????? | ???? 25 ??/??\n" +
                    "2.1.15 | ?????? | ???? 25 ??/??\n" +
                    "2.1.16 | ?????????????? | 3,3-5,5 ??????????/??\n" +
                    "2.1.17 | ???????????????????? | 5,2-6,5 ??????????/??\n" +
                    "2.1.18 | ???????? | ???1,00 ??????????/??\n" +
                    "2.1.19 | ???????? | ???3,00 ??????????/??\n" +
                    "2.1.20 | ??????. ?????????????????????????? | 0-167 ????/??\n" +
                    "2.1.21 | ??????.???????????????????????? ?????????????????????????? | 0-25????/??\n" +
                    "2.1.22 | ???????????????????????? | ???1,70 ??????????/??\n" +
                    "2.1.23 | ?????????????? 98-107 | ??????????/??\n" +
                    "2.1.24 | ???????????? | 0,7-21,5 ??????????/??\n" +
                    "2.1.25 | ?????????? | 3,5-5,0 ??????????/??\n" +
                    "2.1.26 | ???????????? | 35-45 ??????????/??\n" +
                    "2.1.27 | ?????????????? | 2,20-2,55 ??????????/??\n" +
                    "2.1.28 | ?????????????????????? | 2,00-3,60 ??/??\n" +
                    "2.1.29 | ???????????????? | 10,00-120,00 ??????/??\n" +
                    "2.1.30 | ?????????????????????????? ???????????????????? | 5,70%\n" +
                    "3.1 | ???????????????????????? ???????????? ?????????????????????? ?? ?????????? | 1.80 - 3.50 ??/??\n" +
                    "3.2 | ?????????????????????? ?????????????????????????????? (????????????????????????????????????) ?????????????? ?? ?????????? ?????? ???????????? (??????) | 11.00 - 16.00 ??????\n" +
                    "3.3 | ?????????????????????? ?????????????????????????????? ???????????????????? ???????????????????????????????????? ?????????????? (????????) | 21.1 - 36.5 ??????\n" +
                    "3.4 | ?????????????????????? ???????????????????????? D-???????????? ?? ?????????? | 0.00 - 0.55 ??????FEU/????\n" +
                    "4.1.1 | ?????? | 0.270 - 4.200 ????????/????\n" +
                    "4.1.2 | ??3 ?????????? | 1.20 - 3.10 ??????????/??\n" +
                    "4.1.3 | ??3 ?????????????????? | 3.10 - 6.80 ??????????/??\n" +
                    "4.1.4 | ??4 ?????????? | 66.00 - 181.00 ??????????/??\n" +
                    "4.1.5 | ??4 ?????????????????? | 10.80 - 22.00 ??????????/??\n" +
                    "4.1.6 | ?????????????????????? ???????????????????? ?????????????? ?? ???????????????????????????????? ?? ?????????? (????????-??????) | 0.00 - 34.00 ????/????\n" +
                    "4.2.1 | ???????????????????????? ???????????? ?????????????????????????????????????????????????????????? ???????????? ?? ?????????? (??????) | 0.000 - 4.000 ????/????\n" +
                    "4.3.1 | ?????????????????????? ???????????????????????? N-?????????????????????????? ?????????????????? ?????????????????????????????? ?????????????????? ???????????????????????????????????? ???????????????????? ?????????????????? ??????????. | <125.00 ????/????\n" +
                    "4.4.1 | ?????????????? C, anti-HCV ????????. (??????) | ????????????????????????\n" +
                    "4.4.2 | ?????????????? ??, HBs Ag (??????) | ????????????????????????\n" +
                    "4.5.1 | ?????????????? ??????. ???? (IgG ?? IgM) (??????) | ????????????????????????\n" +
                    "4.5.2 | ?????????????? RPR (??/??????) | ????????????????????????\n" +
                    "5.1 | ?????????? (??????????????????????) ???????????? ???????? | null\n" +
                    "5.1.1 | ???????? | ???? ??????????????????-?????????????? ???? ??????????????\n" +
                    "5.1.2 | ???????????????????????? | ????????????????????\n" +
                    "5.1.3 | ???????????????? ?????? | 1.003 - 1.030\n" +
                    "5.1.4 | ?????????????? | 5.0 - 7.5\n" +
                    "5.1.5 | ?????????? | ???? ???????????????????? ?????? ?????????? 0,1 ??/??\n" +
                    "5.1.6 | ?????????????????? | ???? ????????????????????\n" +
                    "5.1.7 | ?????????????????? | ???? ????????????????????\n" +
                    "5.1.8 | ???????????????????????? | ???? ???????????????????? ?????? ??????????\n" +
                    "5.1.9 | ?????????????????? | ???????? ???? ????????????????????\n" +
                    "5.1.10 | ?????????????? | ???? ????????????????????\n" +
                    "5.1.11 | ?????????????? ???? ?????????? (????????????????????) | ???? ????????????????????\n" +
                    "5.1.12 | ?????????????????????????? ???????????????? | ???? ???????????????????? ?????? ??????????\n" +
                    "5.1.13 | ?????????????????????? ???????? | null\n" +
                    "5.1.14 | ????????????????: ?????????????? | 0.0 - 15.0 ????????/??????\n" +
                    "5.1.15 | ?????????????????? | 0.0 - 27.5 ????????/??????\n" +
                    "5.1.16 | ???????????????????? | 0.0 - 11.0 ????????/??????\n" +
                    "5.1.17 | ???????????????? | ???? ????????????????????\n" +
                    "5.1.18 | ?????????????????? | ???? ????????????????????\n" +
                    "5.1.19 | ???????????????? | ???? ???????????????????? ?????? ?????????????????? ????????????????????\n" +
                    "5.1.20 | ?????????? | ?????????????????? ????????????????????\n" +
                    "5.2.1 | ?????????? ????????-???????????? | ???? ????????????????????\n" +
                    "5.3 | ???????????????????????????????? ???????????????????????? ???????? ???? ???????? ?? ?????????????? ???????????????????? | null\n" +
                    "5.3.1 | Diphyllobothriumlatum | ???? ????????????????????\n" +
                    "5.3.2 | Ascarislumbricoides | ???? ????????????????????\n" +
                    "5.3.3 | Trichocephalustrichiurus | ???? ????????????????????\n" +
                    "5.3.4 | Thominxaerophilus | ???? ????????????????????\n" +
                    "5.3.5 | Ancylostomatidaegenussp | ???? ????????????????????\n" +
                    "5.3.6 | Fasciolahepatica | ???? ????????????????????\n" +
                    "5.3.7 | Opisthorchisfelineus | ???? ????????????????????\n" +
                    "5.3.8 | Trichostrongylidaesp | ???? ????????????????????\n" +
                    "5.3.9 | Dicrocoeliumlanceatum | ???? ????????????????????\n" +
                    "5.3.10 | Schistosomamanson | ???? ????????????????????\n" +
                    "5.3.11 | Schistosomajaponicum | ???? ????????????????????\n" +
                    "5.4.1 | ?????????????? ???? ?????????????? ?????????? | ????????????????????????\n" +
                    "5.5 | ?????????? ???????????? ?????????????? | null\n" +
                    "5.5.1 | ???????????????????? | null\n" +
                    "5.5.2 | ???????? | null\n" +
                    "5.5.3 | ?????????? | null\n" +
                    "5.5.4 | ???????????????? | null\n" +
                    "5.5.5 | ???????????????????????? | null\n" +
                    "5.5.6 | ?????????????? | null\n" +
                    "5.5.7 | ???????????????? (??/????) | null\n" +
                    "5.5.8 | ???????????????????????? ?????????????????? (??/????) | null\n" +
                    "5.5.9 | ?????????????????? (??/????) | null\n" +
                    "5.5.10 | ???????????????????? (??/????) | null\n" +
                    "5.5.11 | ???????????????????? (??/????) | null\n" +
                    "5.5.12 | ?????????????? ???????????????????????? | null\n" +
                    "5.5.13 | ???????????? ?????????? | null\n" +
                    "5.5.14 | ?????????????? ???????????????? | null\n" +
                    "5.5.15 | ?????????????????? ??????????-?????????????? | null\n" +
                    "5.5.16 | ???????????? ?? ???????????????????? ???????????? | null\n" +
                    "5.6 | ???????????? ???????? ???? ???????????????????? | null\n" +
                    "5.6.1 | 1\n" +
                    "5.6.2 | 2\n" +
                    "5.6.3 | 3\n" +
                    "5.6.4 | 4\n" +
                    "5.6.5 | 5\n" +
                    "5.6.6 | 6\n" +
                    "5.6.7 | 7\n" +
                    "5.6.8 | 8\n" +
                    "5.6.9 | ?????????????? ????????????\n" +
                    "5.6.10 | ???????????? ????????????\n" +
                    "5.6.11 | ?????????? ????????????\n" +
                    "5.7 | ???????????? ???????? ???? ?????????????????????? | null\n" +
                    "5.7.1 | ?????????????????? | 0,00-2,00\n" +
                    "5.7.2 | ???????????????????? | 0,00-1,00\n" +
                    "5.7.3 | ???????????????? | 0-0,02\n"
            )
        }

        manFile.readLines().forEach {

            var wordArr = it.split("|").toMutableList()
            repeat(wordArr.size) { pos ->
                wordArr[pos] = wordArr[pos].trim()
            }

            wordArr.forEach { word ->
                print(word)
            }

            if (wordArr[0].length == 3) {
                if (wordArr[0][0] == '1') {
                    manListAnalyzes_1 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
                if (wordArr[0][0] == '3') {
                    manListAnalyzes_3 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
            }

            if (wordArr[0].length >= 5) {
                if (wordArr[0][0] == '1') {
                    manAnalyzes_1_1 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
                if (wordArr[0][0] == '2') {
                    manListAnalyzes_2 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
                if (wordArr[0][0] == '4') {
                    manListAnalyzes_4 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
            }

            if (wordArr[0][0] == '5') {
                if (wordArr[0].length == 3) {
                    manListAnalyzes_5 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
                if (wordArr[0] == "5.2.1") {
                    manListAnalyzes_5 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
                if (wordArr[0] == "5.4.1") {
                    manListAnalyzes_5 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }

                if (wordArr[0].length >= 5) {
                    if (wordArr[0][2] == '1') {
                        manAnalyzes_5_1 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                    }
                    if (wordArr[0][2] == '3') {
                        manAnalysis_5_3 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                    }
                    if (wordArr[0][2] == '5') {
                        manAnalysis_5_5 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                    }
                    if (wordArr[0][2] == '7') {
                        manAnalysis_5_7 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                    }

                    if (wordArr[0][2] == '6') {
                        manAnalysis_5_6 += Analysis_5_6(wordArr[0], wordArr[1])
                    }
                }

            }

        }

        womanFile.readLines().forEach {

            var wordArr = it.split("|").toMutableList()
            repeat(wordArr.size) { pos ->
                wordArr[pos] = wordArr[pos].trim()
            }

            wordArr.forEach { word ->
                print(word)
            }

            if (wordArr[0].length == 3) {
                if (wordArr[0][0] == '1') {
                    womanListAnalyzes_1 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
                if (wordArr[0][0] == '3') {
                    womanListAnalyzes_3 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
            }

            if (wordArr[0].length >= 5) {
                if (wordArr[0][0] == '1') {
                    womanAnalyzes_1_1 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
                if (wordArr[0][0] == '2') {
                    womanListAnalyzes_2 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
                if (wordArr[0][0] == '4') {
                    womanListAnalyzes_4 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
            }

            if (wordArr[0][0] == '5') {
                if (wordArr[0].length == 3) {
                    womanListAnalyzes_5 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
                if (wordArr[0] == "5.2.1") {
                    womanListAnalyzes_5 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }
                if (wordArr[0] == "5.4.1") {
                    womanListAnalyzes_5 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                }

                if (wordArr[0].length >= 5) {
                    if (wordArr[0][2] == '1') {
                        womanAnalyzes_5_1 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                    }
                    if (wordArr[0][2] == '3') {
                        womanAnalysis_5_3 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                    }
                    if (wordArr[0][2] == '5') {
                        womanAnalysis_5_5 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                    }
                    if (wordArr[0][2] == '7') {
                        womanAnalysis_5_7 += Analysis(wordArr[0], wordArr[1], if (wordArr[2] != "null") wordArr[2] else null)
                    }

                    if (wordArr[0][2] == '6') {
                        womanAnalysis_5_6 += Analysis_5_6(wordArr[0], wordArr[1])
                    }
                }
            }
        }
    }
}