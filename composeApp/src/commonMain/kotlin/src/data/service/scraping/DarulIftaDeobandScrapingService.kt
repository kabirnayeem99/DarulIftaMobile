package src.data.service.scraping

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.nodes.Element
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import src.core.EmptyHtmlException
import src.core.properCase
import src.core.safeCall
import src.data.service.scraping.dto.DarulIftaDeobandQADto


class DarulIftaDeobandScrapingService {

    suspend fun parseQuestionAndAnswer(html: String?): DarulIftaDeobandQADto {
        return withContext(Dispatchers.IO) {
            html?.let {
                if (html.isBlank()) throw EmptyHtmlException()

                val parsedHtml = Ksoup.parse(html)

                val parsedHtmlBody = parsedHtml.body()

                val answerDetailElements = parsedHtmlBody.selectFirst(".answer_detail li")
                    ?: throw IllegalStateException("Answer detail element not found from HTML.")

                val title = answerDetailElements.extractTitleFromAnswerDetailElementForQa()
                val question = answerDetailElements.extractQuestionFromAnswerDetailElementForQa()
                val questionId =
                    answerDetailElements.extractQuestionIdFromAnswerDetailElementForQa()
                val country = answerDetailElements.extractCountryFromAnswerDetailElementForQa()
                val answerId = answerDetailElements.extractAnswerIdFromAnswerDetailElementForQa()
                val answerDate =
                    answerDetailElements.extractAnswerDateFromAnswerDetailElementForQa()
                val answer = answerDetailElements.extractAnswerFromAnswerDetailElementForQa()
                val fatwaNumber = answer.extractFatwaNumberForQa()
                val rootCatCatPair =
                    answerDetailElements.extractCategoryNameFromAnswerDetailElementForQa()

                val dto = DarulIftaDeobandQADto(
                    title = title,
                    question = question,
                    questionId = questionId,
                    answerId = answerId,
                    country = country,
                    fatwaNo = fatwaNumber,
                    answer = answer,
                    answerDate = answerDate,
                    rootCategory = rootCatCatPair.first,
                    category = rootCatCatPair.second,
                )
                dto
            } ?: throw EmptyHtmlException()
        }
    }

    private fun Element?.extractAnswerFromAnswerDetailElementForQa() = safeCall {
        val answerDetailElements = this
        var answer = (answerDetailElements?.childElementsList()?.filter { it.normalName() == "p" }
            ?.filterNot { it.className() == "fatwa_answer" }?.map { it.wholeText() }
            ?.joinToString("\n") { it }
            ?: "").replace(Regex("Answer ID: \\d+Posted on: \\w+ \\d+, \\d+"), "")
        answer += answerDetailElements?.wholeOwnText() ?: ""
        answer += """
            Allah (سبحانه وتعالى) knows Best
            Darul Ifta,
            Darul Uloom Deoband, India
        """.trimIndent()
        answer = answer.trimIndent().replaceBismillahWithArabic().removeExtraNewlines()
            .stripAnswerIdAndDateForQa()
        answer.trimIndent()
    } ?: ""

    private fun Element?.extractAnswerDateFromAnswerDetailElementForQa() = safeCall {
        (this?.selectFirst(".ans_date")?.wholeText() ?: "").replace("\n", "")
            .replace("Posted on:", "").trim()
    } ?: ""

    private fun Element?.extractAnswerIdFromAnswerDetailElementForQa() = safeCall {
        (this?.selectFirst(".ans_id")?.wholeText() ?: "").replace(
            "Answer ID:", ""
        ).trim().toLongOrNull() ?: 0
    } ?: 0

    private fun Element?.extractTitleFromAnswerDetailElementForQa() = safeCall {
        this?.selectFirst("h2")?.wholeText()?.replace("Title:", "")?.trim() ?: ""
    } ?: ""

    private fun Element?.extractQuestionFromAnswerDetailElementForQa() = safeCall {
        this?.select("h2")?.lastOrNull()?.wholeText()?.replace("Question:", "")?.trim() ?: ""
    } ?: ""

    private fun Element?.extractCategoryNameFromAnswerDetailElementForQa() = safeCall {
        val categoryNameElements = this?.selectFirst(".category_name")?.childElementsList()
        val rootCategory =
            (categoryNameElements?.firstOrNull { it.normalName() == "span" }?.wholeText()?.trim())
                ?: ""
        val category =
            (categoryNameElements?.lastOrNull { it.normalName() == "span" }?.wholeText()?.trim())
                ?: ""
        Pair(rootCategory, category)
    } ?: Pair("", "")

    private fun Element?.extractQuestionIdFromAnswerDetailElementForQa() = safeCall {
        ((this?.selectFirst(".ques_id")?.wholeText()?.lowercase()?.replace("question id:", "")
            ?.trim() ?: "").toLongOrNull()) ?: 0L
    } ?: 0L

    private fun Element?.extractCountryFromAnswerDetailElementForQa() = safeCall {
        (this?.selectFirst(".country_id")?.wholeText()?.lowercase()?.replace("country:", "")?.trim()
            ?.properCase() ?: "")
    } ?: ""

    private val answerIdAndDateRegexForQa by lazy { Regex("Answer ID: \\d+Posted on: \\w+ \\d+, \\d+") }
    private fun String?.stripAnswerIdAndDateForQa() = safeCall {
        answerIdAndDateRegexForQa.replace(this ?: "", "")
    } ?: ""

    private val fatwaNoRegexForQa by lazy { Regex("Fatwa:\\s*(\\S+)\\s*\\)") }
    private fun String?.extractFatwaNumberForQa() = safeCall {
        fatwaNoRegexForQa.find(this ?: "")?.groupValues?.get(1) ?: ""
    } ?: ""

    private fun String?.removeExtraNewlines() =
        safeCall { this?.replace("\n\n+".toRegex(), "\n") ?: "" } ?: ""

    private val basamilahFindingRegex by lazy { Regex(englishBismillahRegexString) }
    private fun String?.replaceBismillahWithArabic() = safeCall {
        basamilahFindingRegex.replace(this ?: "") { arabicBismillah }.replace("!", "").trim()
    } ?: ""

}

private const val englishBismillahRegexString =
    "Bismillah( hir-Rahman nir-Rahim)?( ar-Rahman ar-Rahim)?( al-Rahman al-Rahim)?( hirrahman nirrahim)?( ir-rahman ir-rahim)?( hirrahman nirrahim)?"
private const val arabicBismillah = "بسم الله الرحمن الرحيم"

