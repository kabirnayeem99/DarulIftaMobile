package src.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.datetime.Clock
import src.domain.entity.QuestionAnswer
import kotlin.random.Random

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        var tabIndex by remember { mutableStateOf(0) }
        val tabs = listOf("تازه ترین فتاوی", "خصوصی فتاوی", "جدید مسائل")

        Scaffold { scaffoldPadding ->
            val questions = remember(tabIndex) {
                val random = Random(Clock.System.now().toEpochMilliseconds())
                val big = 284L * (tabIndex + 1)
                ((tabIndex + 1)..big).map { index ->
                    QuestionAnswer(
                        id = index * big,
                        title = listOf(
                            "في حلّت ويتّفق دنو, وقد ثم وحرمان استبدال. واعتلاء بالإنزال انتصارهم بل بين. هو ارتكبها التّحول قام. الطرفين الدنمارك أم دول, بل أمّا الشهير استطاعوا كلّ.",
                            "رئيس عليها أخذ بل, حلّت تمهيد العالم، بال قد. إيو لأداء ألمانيا و, ان إجلاء سليمان، دون, لكل بل استمرار المتساقطة،! تكاليف تزامناً بل الى! إختار الشطر لم ضرب. قد بشكل وقوعها، أسر, بها أحكم الأولى مكثّفة في. أما ان بداية الولايات.",
                            "تلك بل وباءت بمحاولة. قد هاربر انذار اليابانية جعل, انه هو خلاف مرجع الفرنسية, كل اليها الدنمارك الأوروبية، فصل. في ولم تسمّى أعلنت البشريةً, اتفاقية والنرويج نفس قد, بين بـ العالم الأوروبي. إيو وحتى القادة الأرواح ثم?",
                            "ونتج السيء الخطّة ٣٠ مكن, عل ليتسنّى الشتاء، تحت? دول عن جورج الحرة المتحدة! الأرض مكثّفة واشتدّت قبل هو, وقد والمعدات ايطاليا، المؤلّفة عن, الأسيوي واشتدّت والمعدات ثم كلّ! تم أضف فرنسا الطرفين, تلك إتفاقية الإحتفاظ إذ? أمّا أطراف من أخذ. لكون الصفحات وقد لم, إذ بعض وأزيز قتيل،, الخاسر وتزويده أم جُل.",
                            "ذات إذ وحتّى علاقة انتصارهم, دون شرسة استعملت أم. أم أسيا البرية الأمريكي غير. نفس ان تسمّى التبرعات بالمطالبة, هذه بل مليون الجنوبي بالمطالبة. ودول وقبل الأوروبية، كل بحث, وصل تاريخ مشاركة الشرقية مع.",
                            "مدرسین کی تنخواہ کی شرعی حیثیت",
                            "پروپرٹی جس پر مدرسہ کی عمارت بنائی گئی ہے کا رجسٹریشن ناظم کے نام ہے اور اس کی وجہ سے وہ ادارے کے مالک ہیں۔ سوال یہ ہے کہ کیا زکاة اور فطرہ ایسے دارے میں دیا جاسکتاہے؟ براہ کرم، شریعت کی روشنی میں بتائیں۔",
                            "واقف نے جس کومتولی قرار دیا ہے اس کو دوسرا شخص موقوف كرسكتا ہے؟",
                            "آج کل یہ بات ایک عام ہوگئی ہے کہ مسجدوں سے کچھ سامان بیچنے کا بھی اعلان ہونے لگاہے، جیسے کہ کوئی مچھلی والا، کوئی سبزی والا، کسی کے یہاں دعوت ہے تو اس کا بھی اعلان مسجد سے کیا جانے لگاہے۔ اذان کے علاوہ یہ بات کہاں تک صحیح ہے؟ کیا مسجد کے لاؤڈ اسپیکر سے ذاتی کاموں کا بھی اعلان ہو۔ آپ مناسب جواب دیں۔",
                        ).random(random),
                        categoryId = 284L,
                        question = "",
                        url = "",
                    )
                }
            }
            Column(
                modifier = Modifier.fillMaxSize().padding(scaffoldPadding),
            ) {
                TabRow(selectedTabIndex = tabIndex) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(title) },
                            selected = tabIndex == index,
                            onClick = { tabIndex = index },
                        )
                    }
                }
                FatwaByCategoryTab(questions)
            }
        }
    }
}