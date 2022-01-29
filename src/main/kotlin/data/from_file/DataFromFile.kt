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
            manFile.appendText("1.1 | Общий (клинический) анализ крови | null\n" +
                    "1.1.1 | Гемоглобин | 117-155 г/л\n" +
                    "1.1.2 | Лейкоциты(WBC) | 4.00 - 10.00*10^9/л\n" +
                    "1.1.3 | Эритроциты(RBC) | 3.80 - 5.10*10^12/л\n" +
                    "1.1.4 | Гематокрит(HCT) | 35.0 - 45.0%\n" +
                    "1.1.5 | Тромбоциты (PLT) | 150 - 400*10^9/л\n" +
                    "1.1.6 | Лимфоциты, % (LY%) | 19.0 - 37.0%\n" +
                    "1.1.7 | Моноциты, % (MO%) | 3.0 - 12.0%\n" +
                    "1.1.8 | Эозинофилы, % (EO%) | 1.0 - 5.0%\n" +
                    "1.1.9 | МСН | 26,5-33,5 pg\n" +
                    "1.1.10 | Палочкоядерные нейрофилы | 1-6%\n" +
                    "1.1.11 | Сегментоядерные нейтрофилы | 47-72%\n" +
                    "1.2 | Ретикулоциты | 0,59-2,07%\n" +
                    "1.3 | Скорость оседания эритроцитов (СОЭ) | 2 – 20 мм/ч\n" +
                    "2.1.1 | Общий белок | Общий белок\n" +
                    "2.1.2 | Альбумины | 35-50 г/л\n" +
                    "2.1.3 | СРБ | отрицательные\n" +
                    "2.1.4 | Амилаза | 32-64 ед.\n" +
                    "2.1.5 | Мочевина | 2,50-8,3 мкмоль/л\n" +
                    "2.1.6 | Мочевая кислота | 202,30-416,50 мкмоль/л\n" +
                    "2.1.7 | Креатинин | 4 –124 мкмоль/л\n" +
                    "2.1.8 | Щелочная фосфотаза | 122-469 Ед/л\n" +
                    "2.1.9 | Гамма-ГТ | 6-42 Ед/л\n" +
                    "2.1.10 | Билирубин общий | 8,4-20,5 мкмоль/л\n" +
                    "2.1.11 | Билирубин прямой | 0,00-5,00 мкмоль/л\n" +
                    "2.1.12 | ЛДГ | 135-214 Ед/л\n" +
                    "2.1.13 | Ревматоидн. фактор | ≤14 МЕ/мл\n" +
                    "2.1.14 | АЛТ | До 25 Е/л\n" +
                    "2.1.15 | АСТ | До 25 Е/л\n" +
                    "2.1.16 | Глюкоза | 3,3-5,5 ммоль/л\n" +
                    "2.1.17 | Холестерин | 5,2-6,5 ммоль/л\n" +
                    "2.1.18 | ЛПВП | ≥1,00 ммоль/л\n" +
                    "2.1.19 | ЛПНП | ≤3,00 ммоль/л\n" +
                    "2.1.20 | Акт. креатинкиназы | 0-167 Ед/л\n" +
                    "2.1.21 | Акт.изоферментов креатинкиназы | 0-25Ед/л\n" +
                    "2.1.22 | Триглицериды | ≤1,70 ммоль/л\n" +
                    "2.1.23 | Хлориды 98-107 | ммоль/л\n" +
                    "2.1.24 | Железо | 4,8-26,0 ммоль/л\n" +
                    "2.1.25 | Калий | 3,5-5,0 ммоль/л\n" +
                    "2.1.26 | Натрий | 35-45 ммоль/л\n" +
                    "2.1.27 | Кальций | 2,20-2,55 ммоль/л\n" +
                    "2.1.28 | Трансферрин | 2,00-3,60 г/л\n" +
                    "2.1.29 | Ферритин | 10,00-120,00 мкг/л\n" +
                    "2.1.30 | Гликированный гемоглобин | 5,70%\n" +
                    "3.1 | Исследование уровня фибриногена в крови | 1.80 - 3.50 г/л\n" +
                    "3.2 | Определение протромбинового (тромбопластинового) времени в крови или плазме (ПТВ) | 11.00 - 16.00 сек\n" +
                    "3.3 | Определение Активированного частичного тромбопластинового времени (АЧТВ) | 21.1 - 36.5 сек\n" +
                    "3.4 | Определение концентрации D-димера в крови | 0.00 - 0.55 мкгFEU/мл\n" +
                    "4.1.1 | ТТГ | 0.270 - 4.200 мкМЕ/мл\n" +
                    "4.1.2 | Т3 общий | 1.20 - 3.10 нмоль/л\n" +
                    "4.1.3 | Т3 свободный | 3.10 - 6.80 пмоль/л\n" +
                    "4.1.4 | Т4 общий | 66.00 - 181.00 нмоль/л\n" +
                    "4.1.5 | Т4 свободный | 10.80 - 22.00 пмоль/л\n" +
                    "4.1.6 | Определение содержания антител к тиреопероксидазе в крови (анти-ТПО) | 0.00 - 34.00 МЕ/мл\n" +
                    "4.2.1 | Исследование уровня простатспецифическогоантигена общего в крови (ПСА) | 0.000 - 4.000 нг/мл\n" +
                    "4.3.1 | Определение концентрации N-терминального фрагмента предшественника мозгового натрийуретического пептида  в сыворотке крови. | <125.00 пг/мл\n" +
                    "4.4.1 | Гепатит C, anti-HCV сумм. (кач) | отрицательно\n" +
                    "4.4.2 | Гепатит В, HBs Ag (кач) | отрицательно\n" +
                    "4.5.1 | Сифилис сум. АТ (IgG и IgM) (кач) | отрицательно\n" +
                    "4.5.2 | Сифилис RPR (п/кол) | отрицательно\n" +
                    "5.1 | Общий (клинический) анализ мочи | null\n" +
                    "5.1.1 | Цвет | от соломенно-желтого до желтого\n" +
                    "5.1.2 | Прозрачность | прозрачная\n" +
                    "5.1.3 | Удельный вес | 1.003 - 1.030\n" +
                    "5.1.4 | Реакция | 5.0 - 7.5\n" +
                    "5.1.5 | Белок | не обнаружено или менее 0,1 г/л\n" +
                    "5.1.6 | Билирубин | не обнаружено\n" +
                    "5.1.7 | Билирубин | не обнаружено\n" +
                    "5.1.8 | Уробилиноген | не обнаружено или следы\n" +
                    "5.1.9 | Кетоновые | тела не обнаружено\n" +
                    "5.1.10 | Нитриты | не обнаружено\n" +
                    "5.1.11 | Реакция на кровь (гемоглобин) | не обнаружено\n" +
                    "5.1.12 | Лейкоцитарная эстераза | Не обнаружено или следы\n" +
                    "5.1.13 | Микроскопия мочи | null\n" +
                    "5.1.14 | Эпителий: плоский | 0.0 - 15.0 клет/мкл\n" +
                    "5.1.15 | Лейкоциты | 0.0 - 27.5 клет/мкл\n" +
                    "5.1.16 | Эритроциты | 0.0 - 11.0 клет/мкл\n" +
                    "5.1.17 | Цилиндры | не обнаружено\n" +
                    "5.1.18 | Кристаллы | не обнаружено\n" +
                    "5.1.19 | Бактерии | не обнаружено или небольшое количество\n" +
                    "5.1.20 | Слизь | небольшое количество\n" +
                    "5.2.1 | Белок Бенс-Джонса | не обнаружено\n" +
                    "5.3 | Микроскопическое исследование кала на яйца и личинки гельминтов | null\n" +
                    "5.3.1 | Diphyllobothriumlatum | не обнаружены\n" +
                    "5.3.2 | Ascarislumbricoides | не обнаружены\n" +
                    "5.3.3 | Trichocephalustrichiurus | не обнаружены\n" +
                    "5.3.4 | Thominxaerophilus | не обнаружены\n" +
                    "5.3.5 | Ancylostomatidaegenussp | не обнаружены\n" +
                    "5.3.6 | Fasciolahepatica | не обнаружены\n" +
                    "5.3.7 | Opisthorchisfelineus | не обнаружены\n" +
                    "5.3.8 | Trichostrongylidaesp | не обнаружены\n" +
                    "5.3.9 | Dicrocoeliumlanceatum | не обнаружены\n" +
                    "5.3.10 | Schistosomamanson | не обнаружены\n" +
                    "5.3.11 | Schistosomajaponicum | не обнаружены\n" +
                    "5.4.1 | Реакция на скрытую кровь | отрицательно\n" +
                    "5.5 | Общий анализ мокроты | null\n" +
                    "5.5.1 | Количество | null\n" +
                    "5.5.2 | Цвет | null\n" +
                    "5.5.3 | Запах | null\n" +
                    "5.5.4 | Характер | null\n" +
                    "5.5.5 | Консистенция | null\n" +
                    "5.5.6 | Примеси | null\n" +
                    "5.5.7 | Эпителий (п/зр) | null\n" +
                    "5.5.8 | Альвеолярные макрофаги (п/зр) | null\n" +
                    "5.5.9 | Лейкоциты (п/зр) | null\n" +
                    "5.5.10 | Эритроциты (п/зр) | null\n" +
                    "5.5.11 | Эозинофилы (п/зр) | null\n" +
                    "5.5.12 | Волокна эластические | null\n" +
                    "5.5.13 | Прочая флора | null\n" +
                    "5.5.14 | Спирали Куршмана | null\n" +
                    "5.5.15 | Кристаллы Шарко-Лейдена | null\n" +
                    "5.5.16 | Клетки с признаками атипии | null\n" +
                    "5.6 | Анализ мочи по Зимницкому | null\n" +
                    "5.6.1 | 1\n" +
                    "5.6.2 | 2\n" +
                    "5.6.3 | 3\n" +
                    "5.6.4 | 4\n" +
                    "5.6.5 | 5\n" +
                    "5.6.6 | 6\n" +
                    "5.6.7 | 7\n" +
                    "5.6.8 | 8\n" +
                    "5.6.9 | Дневной диурез\n" +
                    "5.6.10 | Ночной диурез\n" +
                    "5.6.11 | Общий диурез\n" +
                    "5.7 | Анализ мочи по Нечипоренко | null\n" +
                    "5.7.1 | Лейкоциты | 0,00-2,00\n" +
                    "5.7.2 | Эритроциты | 0,00-1,00\n" +
                    "5.7.3 | Цилиндры | 0-0,02\n"
            )
        }

        var womanFile = File(womanInputFile)
        if (!womanFile.exists()) {
            womanFile.createNewFile()
            womanFile.appendText("1.1 | Общий (клинический) анализ крови | null\n" +
                    "1.1.1 | Гемоглобин | 117-155 г/л\n" +
                    "1.1.2 | Лейкоциты(WBC) | 4.00 - 10.00*10^9/л\n" +
                    "1.1.3 | Эритроциты(RBC) | 3.80 - 5.10*10^12/л\n" +
                    "1.1.4 | Гематокрит(HCT) | 35.0 - 45.0%\n" +
                    "1.1.5 | Тромбоциты (PLT) | 150 - 400*10^9/л\n" +
                    "1.1.6 | Лимфоциты, % (LY%) | 19.0 - 37.0%\n" +
                    "1.1.7 | Моноциты, % (MO%) | 3.0 - 12.0%\n" +
                    "1.1.8 | Эозинофилы, % (EO%) | 1.0 - 5.0%\n" +
                    "1.1.9 | МСН | 26,5-33,5 pg\n" +
                    "1.1.10 | Палочкоядерные нейрофилы | 1-6%\n" +
                    "1.1.11 | Сегментоядерные нейтрофилы | 47-72%\n" +
                    "1.2 | Ретикулоциты | 0,59-2,07%\n" +
                    "1.3 | Скорость оседания эритроцитов (СОЭ) | 2 – 20 мм/ч\n" +
                    "2.1.1 | Общий белок | Общий белок\n" +
                    "2.1.2 | Альбумины | 35-50 г/л\n" +
                    "2.1.3 | СРБ | отрицательные\n" +
                    "2.1.4 | Амилаза | 32-64 ед.\n" +
                    "2.1.5 | Мочевина | 2,50-8,3 мкмоль/л\n" +
                    "2.1.6 | Мочевая кислота | 202,30-416,50 мкмоль/л\n" +
                    "2.1.7 | Креатинин | 4 –124 мкмоль/л\n" +
                    "2.1.8 | Щелочная фосфотаза | 122-469 Ед/л\n" +
                    "2.1.9 | Гамма-ГТ | 6-42 Ед/л\n" +
                    "2.1.10 | Билирубин общий | 8,4-20,5 мкмоль/л\n" +
                    "2.1.11 | Билирубин прямой | 0,00-5,00 мкмоль/л\n" +
                    "2.1.12 | ЛДГ | 135-214 Ед/л\n" +
                    "2.1.13 | Ревматоидн. фактор | ≤14 МЕ/мл\n" +
                    "2.1.14 | АЛТ | До 25 Е/л\n" +
                    "2.1.15 | АСТ | До 25 Е/л\n" +
                    "2.1.16 | Глюкоза | 3,3-5,5 ммоль/л\n" +
                    "2.1.17 | Холестерин | 5,2-6,5 ммоль/л\n" +
                    "2.1.18 | ЛПВП | ≥1,00 ммоль/л\n" +
                    "2.1.19 | ЛПНП | ≤3,00 ммоль/л\n" +
                    "2.1.20 | Акт. креатинкиназы | 0-167 Ед/л\n" +
                    "2.1.21 | Акт.изоферментов креатинкиназы | 0-25Ед/л\n" +
                    "2.1.22 | Триглицериды | ≤1,70 ммоль/л\n" +
                    "2.1.23 | Хлориды 98-107 | ммоль/л\n" +
                    "2.1.24 | Железо | 0,7-21,5 ммоль/л\n" +
                    "2.1.25 | Калий | 3,5-5,0 ммоль/л\n" +
                    "2.1.26 | Натрий | 35-45 ммоль/л\n" +
                    "2.1.27 | Кальций | 2,20-2,55 ммоль/л\n" +
                    "2.1.28 | Трансферрин | 2,00-3,60 г/л\n" +
                    "2.1.29 | Ферритин | 10,00-120,00 мкг/л\n" +
                    "2.1.30 | Гликированный гемоглобин | 5,70%\n" +
                    "3.1 | Исследование уровня фибриногена в крови | 1.80 - 3.50 г/л\n" +
                    "3.2 | Определение протромбинового (тромбопластинового) времени в крови или плазме (ПТВ) | 11.00 - 16.00 сек\n" +
                    "3.3 | Определение Активированного частичного тромбопластинового времени (АЧТВ) | 21.1 - 36.5 сек\n" +
                    "3.4 | Определение концентрации D-димера в крови | 0.00 - 0.55 мкгFEU/мл\n" +
                    "4.1.1 | ТТГ | 0.270 - 4.200 мкМЕ/мл\n" +
                    "4.1.2 | Т3 общий | 1.20 - 3.10 нмоль/л\n" +
                    "4.1.3 | Т3 свободный | 3.10 - 6.80 пмоль/л\n" +
                    "4.1.4 | Т4 общий | 66.00 - 181.00 нмоль/л\n" +
                    "4.1.5 | Т4 свободный | 10.80 - 22.00 пмоль/л\n" +
                    "4.1.6 | Определение содержания антител к тиреопероксидазе в крови (анти-ТПО) | 0.00 - 34.00 МЕ/мл\n" +
                    "4.2.1 | Исследование уровня простатспецифическогоантигена общего в крови (ПСА) | 0.000 - 4.000 нг/мл\n" +
                    "4.3.1 | Определение концентрации N-терминального фрагмента предшественника мозгового натрийуретического пептида  в сыворотке крови. | <125.00 пг/мл\n" +
                    "4.4.1 | Гепатит C, anti-HCV сумм. (кач) | отрицательно\n" +
                    "4.4.2 | Гепатит В, HBs Ag (кач) | отрицательно\n" +
                    "4.5.1 | Сифилис сум. АТ (IgG и IgM) (кач) | отрицательно\n" +
                    "4.5.2 | Сифилис RPR (п/кол) | отрицательно\n" +
                    "5.1 | Общий (клинический) анализ мочи | null\n" +
                    "5.1.1 | Цвет | от соломенно-желтого до желтого\n" +
                    "5.1.2 | Прозрачность | прозрачная\n" +
                    "5.1.3 | Удельный вес | 1.003 - 1.030\n" +
                    "5.1.4 | Реакция | 5.0 - 7.5\n" +
                    "5.1.5 | Белок | не обнаружено или менее 0,1 г/л\n" +
                    "5.1.6 | Билирубин | не обнаружено\n" +
                    "5.1.7 | Билирубин | не обнаружено\n" +
                    "5.1.8 | Уробилиноген | не обнаружено или следы\n" +
                    "5.1.9 | Кетоновые | тела не обнаружено\n" +
                    "5.1.10 | Нитриты | не обнаружено\n" +
                    "5.1.11 | Реакция на кровь (гемоглобин) | не обнаружено\n" +
                    "5.1.12 | Лейкоцитарная эстераза | Не обнаружено или следы\n" +
                    "5.1.13 | Микроскопия мочи | null\n" +
                    "5.1.14 | Эпителий: плоский | 0.0 - 15.0 клет/мкл\n" +
                    "5.1.15 | Лейкоциты | 0.0 - 27.5 клет/мкл\n" +
                    "5.1.16 | Эритроциты | 0.0 - 11.0 клет/мкл\n" +
                    "5.1.17 | Цилиндры | не обнаружено\n" +
                    "5.1.18 | Кристаллы | не обнаружено\n" +
                    "5.1.19 | Бактерии | не обнаружено или небольшое количество\n" +
                    "5.1.20 | Слизь | небольшое количество\n" +
                    "5.2.1 | Белок Бенс-Джонса | не обнаружено\n" +
                    "5.3 | Микроскопическое исследование кала на яйца и личинки гельминтов | null\n" +
                    "5.3.1 | Diphyllobothriumlatum | не обнаружены\n" +
                    "5.3.2 | Ascarislumbricoides | не обнаружены\n" +
                    "5.3.3 | Trichocephalustrichiurus | не обнаружены\n" +
                    "5.3.4 | Thominxaerophilus | не обнаружены\n" +
                    "5.3.5 | Ancylostomatidaegenussp | не обнаружены\n" +
                    "5.3.6 | Fasciolahepatica | не обнаружены\n" +
                    "5.3.7 | Opisthorchisfelineus | не обнаружены\n" +
                    "5.3.8 | Trichostrongylidaesp | не обнаружены\n" +
                    "5.3.9 | Dicrocoeliumlanceatum | не обнаружены\n" +
                    "5.3.10 | Schistosomamanson | не обнаружены\n" +
                    "5.3.11 | Schistosomajaponicum | не обнаружены\n" +
                    "5.4.1 | Реакция на скрытую кровь | отрицательно\n" +
                    "5.5 | Общий анализ мокроты | null\n" +
                    "5.5.1 | Количество | null\n" +
                    "5.5.2 | Цвет | null\n" +
                    "5.5.3 | Запах | null\n" +
                    "5.5.4 | Характер | null\n" +
                    "5.5.5 | Консистенция | null\n" +
                    "5.5.6 | Примеси | null\n" +
                    "5.5.7 | Эпителий (п/зр) | null\n" +
                    "5.5.8 | Альвеолярные макрофаги (п/зр) | null\n" +
                    "5.5.9 | Лейкоциты (п/зр) | null\n" +
                    "5.5.10 | Эритроциты (п/зр) | null\n" +
                    "5.5.11 | Эозинофилы (п/зр) | null\n" +
                    "5.5.12 | Волокна эластические | null\n" +
                    "5.5.13 | Прочая флора | null\n" +
                    "5.5.14 | Спирали Куршмана | null\n" +
                    "5.5.15 | Кристаллы Шарко-Лейдена | null\n" +
                    "5.5.16 | Клетки с признаками атипии | null\n" +
                    "5.6 | Анализ мочи по Зимницкому | null\n" +
                    "5.6.1 | 1\n" +
                    "5.6.2 | 2\n" +
                    "5.6.3 | 3\n" +
                    "5.6.4 | 4\n" +
                    "5.6.5 | 5\n" +
                    "5.6.6 | 6\n" +
                    "5.6.7 | 7\n" +
                    "5.6.8 | 8\n" +
                    "5.6.9 | Дневной диурез\n" +
                    "5.6.10 | Ночной диурез\n" +
                    "5.6.11 | Общий диурез\n" +
                    "5.7 | Анализ мочи по Нечипоренко | null\n" +
                    "5.7.1 | Лейкоциты | 0,00-2,00\n" +
                    "5.7.2 | Эритроциты | 0,00-1,00\n" +
                    "5.7.3 | Цилиндры | 0-0,02\n"
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