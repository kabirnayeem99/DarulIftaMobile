package src.data.datasource

import src.data.service.scraping.DarulIftaDeobandScrapingService
import src.data.service.scraping.HttpFetching
import src.data.service.scraping.dto.DarulIftaDeobandQADto

class DarulIftaDeobandRemoteDataSource(
    private val httpFetching: HttpFetching,
    private val scrapingService: DarulIftaDeobandScrapingService,
) {

    /**
     * Fetches the HTML content of a given URL, parses it into a `DarulIftaDeobandQADto` object.
     *
     * @param url The URL of the Darul Ifta Deoband page to parse.
     * @return A `DarulIftaDeobandQADto` object containing the parsed data.
     */
    suspend fun parseQuestionAndAnswer(url: String): DarulIftaDeobandQADto {
        val html = httpFetching.parseGetRequestAsHtmlString(url)
        val dto = scrapingService.parseQuestionAndAnswer(html)
        return dto
    }
}