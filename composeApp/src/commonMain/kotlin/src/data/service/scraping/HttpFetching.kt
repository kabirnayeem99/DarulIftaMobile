package src.data.service.scraping

import io.ktor.client.HttpClient
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class HttpFetching {
    private val client by lazy { HttpClient { install(HttpCache) } }

    private val cacheMap = mutableMapOf<String, String>()

    suspend fun parseGetRequestAsHtmlString(url: String): String {
        if (cacheMap.containsKey(url)) return cacheMap[url]!!
        val html = client.get("url").bodyAsText().trimIndent()
        cacheMap[url] = html
        return html
    }
}