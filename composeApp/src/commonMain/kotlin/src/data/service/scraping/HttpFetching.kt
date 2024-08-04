package src.data.service.scraping

import io.ktor.client.HttpClient
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import src.core.datastructure.lruCacheOf

class HttpFetching {
    private val client by lazy {
        HttpClient {
            install(HttpCache)
            install(Logging) {
                level = LogLevel.ALL
            }
        }
    }

    private val responseLruCache = lruCacheOf<String, String>(10)

    /**
     * Fetches the HTML content of a given URL using a provided HTTP client.
     *
     * Implements a basic LRU cache to store fetched HTML content for performance optimization.
     *
     * @param url The URL to fetch the HTML content from.
     * @return The fetched HTML content as a string, or an empty string if an error occurs.
     */
    suspend fun parseGetRequestAsHtmlString(url: String): String {
        if (responseLruCache.containsKey(url)) return responseLruCache.get(url)!!
        val html = client.get(url).bodyAsText().trimIndent()
        responseLruCache.put(url, html)
        return html
    }
}