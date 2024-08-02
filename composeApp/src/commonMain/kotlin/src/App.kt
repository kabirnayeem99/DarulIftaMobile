package src

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fleeksoft.ksoup.Ksoup
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import daruliftamobile.composeapp.generated.resources.Res
import daruliftamobile.composeapp.generated.resources.compose_multiplatform
import io.ktor.client.HttpClient
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

@Composable
@Preview
fun App() {
    MaterialTheme {
        var count by remember { mutableIntStateOf(1) }
        LaunchedEffect(count) {
            withContext(Dispatchers.IO) {
                val client = HttpClient {
                    install(HttpCache)
                }
                val response =
                    client.get("https://darulifta-deoband.com/home/ur/islamic-beliefs/612232")
//                    client.get("https://darulifta-deoband.com/home/en/taharah-purity/185079")
                val html = response.bodyAsText().trimIndent()
                val parseHtml = Ksoup.parse(html)


                println("\n\nPrinting HTML With CSS Query")
                println("===")
                val answerDetailElements =
                    parseHtml.body().selectFirst(".answer_detail li")
                val questionTitle = answerDetailElements?.selectFirst("h2")?.wholeText() ?: ""
                println(questionTitle)
                val question = answerDetailElements?.select("h2")?.lastOrNull()?.wholeText() ?: ""
                println(question)
                val questionIdAndCountry =
                    answerDetailElements?.selectFirst(".quesid")?.wholeText() ?: ""
                val questionIdCountryPair = extractQuestionIdAndCountry(questionIdAndCountry)
                println("Question Id: ${questionIdCountryPair.first}")
                println("Country: ${questionIdCountryPair.second}")
                val answerId = (answerDetailElements?.selectFirst(".ans_id")?.wholeText() ?: "").replace("Answer ID:", "").trim()
                println("Answer Id: $answerId")
                val answerDate = (answerDetailElements?.selectFirst(".ans_date")?.wholeText()
                    ?: "").replace("\n", "").replace("Posted on:", "").trim()
                println("Answer Date: $answerDate")
                var answer =
                    (answerDetailElements?.childElementsList()?.filter { it.normalName() == "p" }
                        ?.filterNot { it.className() == "fatwa_answer" }
                        ?.map { it.wholeText() }
                        ?.joinToString("\n") { it } ?: "").replace(Regex("Answer ID: \\d+Posted on: \\w+ \\d+, \\d+"), "")
                answer += answerDetailElements?.wholeOwnText() ?: ""
                answer = replaceBismillah(removeMultipleNewlines(removeAnswerIdAndDate(answer.trimIndent())))
                println(answer)

                val fatwaNumber = extractFatwaNumber(answer)
                println(fatwaNumber)
                println("===")

//                println("\n\nPrinting HTML With Elements")
//                println("===")
//
//                val answerDetailElements =
//                    parseHtml.body().getElementsByClass("answer_detail").firstOrNull()
//                val questionTitle = (answerDetailElements
//                    ?.childElementsList()?.firstOrNull()?.childElementsList()
//                    ?.firstOrNull { it.normalName() == "h2" }?.wholeText() ?: "").replace(
//                    "Title: ",
//                    ""
//                )
//                println(questionTitle)
//                val questionText = (answerDetailElements
//                    ?.childElementsList()?.firstOrNull()?.childElementsList()
//                    ?.lastOrNull { it.normalName() == "h2" }?.wholeText() ?: "")
//                    .replace(
//                        "Question: ",
//                        ""
//                    )
//                println(questionText)
//
//                val rootCategoryName =
//                    answerDetailElements?.childElementsList()?.firstOrNull()?.childElementsList()
//                        ?.firstOrNull { it.normalName() == "div" && it.className() == "cate_sec" }
//                        ?.childElementsList()?.filter { it.normalName() == "span" }
//                        ?.joinToString(", ") { it.wholeText() }
//                println(rootCategoryName)
//
//                val fatwaAnswer = answerDetailElements
//                    ?.childElementsList()?.firstOrNull()?.childElementsList()
//                    ?.joinToString("\n") { it.wholeText() }
//                println(fatwaAnswer)
//                println(parseHtml.selectFirst("ul")?.className())
//                println("===")
            }
        }
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                count += 1
                showContent = !showContent
            }) {

                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(
//                    Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
            }
        }
    }
}

fun extractQuestionIdAndCountry(text: String?): Pair<Int, String> {
    if (text.isNullOrBlank()) return Pair(0, "")

    val regex = Regex("Question ID: (\\d+)Country: (.+)")
    val matchResult = regex.find(text)

    return matchResult?.destructured?.let { (questionId, country) ->
        Pair(questionId.toInt(), country)
    } ?: Pair(0, "")
}

fun removeAnswerIdAndDate(text: String): String {
    val regex = Regex("Answer ID: \\d+Posted on: \\w+ \\d+, \\d+")
    return regex.replace(text, "")
}

fun extractFatwaNumber(text: String): String {
    val regex = Regex("\\(Fatwa: (\\d+/\\d+/\\w+/Mulhaqa=\\d+/\\d+)\\)")
    val matchResult = regex.find(text)
    return matchResult?.groupValues?.get(1) ?: ""
}

fun removeMultipleNewlines(text: String): String {
    return text.replace("\n\n+".toRegex(), "\n")
}

fun replaceBismillah(text: String): String {
    val arabicBismillah = "بسم الله الرحمن الرحيم"
    val bismillahRegex = Regex("Bismillah( hir-Rahman nir-Rahim)?( ar-Rahman ar-Rahim)?( al-Rahman al-Rahim)?( hirrahman nirrahim)?( ir-rahman ir-rahim)?( hirrahman nirrahim)?")
    return bismillahRegex.replace(text) { arabicBismillah }
}