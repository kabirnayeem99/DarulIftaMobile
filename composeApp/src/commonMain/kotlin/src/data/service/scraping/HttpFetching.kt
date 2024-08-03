package src.data.service.scraping

import io.ktor.client.HttpClient
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import src.core.datastructure.lruCacheOf

class HttpFetching {
    private val client by lazy { HttpClient { install(HttpCache) } }

    private val responseLruCache = lruCacheOf<String, String>(10)

    suspend fun parseGetRequestAsHtmlString(url: String): Result<String> {
        return runCatching {
            if (responseLruCache.containsKey(url)) return@runCatching responseLruCache.get(url)!!
            val html = client.get(url).bodyAsText().trimIndent()
            responseLruCache.put(url, html)
            html
        }
    }
}