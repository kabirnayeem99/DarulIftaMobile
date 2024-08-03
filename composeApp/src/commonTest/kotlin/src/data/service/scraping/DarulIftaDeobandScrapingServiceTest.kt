package src.data.service.scraping

import kotlinx.coroutines.runBlocking
import kotlin.test.*

class DarulIftaDeobandScrapingServiceTest {
    private val service = DarulIftaDeobandScrapingService()

    @Test
    fun `parseQuestionAndAnswer with valid HTML should return DTO with valid data`() = runBlocking {
        val result = service.parseQuestionAndAnswer(staticQuestionAndAnswerValidHtml)

        val expectedTitle = "Plastic tank and dead animal"
        assertEquals(
            expected = expectedTitle,
            actual = result.title,
        )

        val expectedQuestion =
            "I would like to ask that if there is a dead animal like mouse or any other animal in the water tank made of plastic do we have to replace the tank or it can be purified only by washing? And can this tank be used after washing? Is the water pure because I heard somewhere that islamically plastic cannot be purified?"
        assertEquals(
            expected = expectedQuestion,
            actual = result.question,
        )

        val expectedQuestionId = 55998L
        assertEquals(
            expected = expectedQuestionId,
            actual = result.questionId,
        )

        val expectedCountry = "India"
        assertEquals(
            expected = expectedCountry,
            actual = result.country,
        )

        val expectedAnswerId = 55998L
        assertEquals(
            expected = expectedAnswerId,
            actual = result.answerId,
        )

        val expectedRootCategory = "Prayers & Duties"
        assertEquals(
            expected = expectedRootCategory,
            actual = result.rootCategory,
        )

        val expectedCategory = "Taharah (Purity)"
        assertEquals(
            expected = expectedCategory,
            actual = result.category,
        )

        val expectedAnswer = """
بسم الله الرحمن الرحيم 
 (Fatwa: 1317/1039/D=12/1435)
The things which do not absorb water such as the utensil of plastic etc shall be pure after washing three times. Thus you may use the said water tank after washing and the waster filled in it shall be pure. There is no need to replace the water tank.
Allah (سبحانه وتعالى) knows Best
Darul Ifta,
Darul Uloom Deoband, India
        """.trimIndent()
        assertEquals(
            expected = expectedAnswer,
            actual = result.answer,
        )

    }
}