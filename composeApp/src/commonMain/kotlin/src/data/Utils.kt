package src.data

import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.datetime.Clock
import kotlinx.datetime.asTimeSource
import org.koin.core.time.TimeInMillis
import src.core.EmptyHtmlException
import src.core.FailedToParseException
import src.domain.entity.DarulIftaErrors
import src.domain.entity.QuestionAnswer
import kotlin.random.Random


val Throwable?.darulIftaErrors: DarulIftaErrors
    get() {
        return when (this) {
            is ClientRequestException -> DarulIftaErrors.NETWORK_UNREACHABLE

            is SocketTimeoutException, is ConnectTimeoutException -> DarulIftaErrors.NETWORK_TIMEOUT

            is ServerResponseException -> when (response.status.value) {
                401 -> DarulIftaErrors.API_BLOCKED
                404 -> DarulIftaErrors.INVALID_DATA_STRUCTURE
                429 -> DarulIftaErrors.API_RATE_LIMITED
                else -> DarulIftaErrors.UNKNOWN_ERROR
            }

            is EmptyHtmlException -> DarulIftaErrors.MALFORMED_HTML

            is FailedToParseException -> DarulIftaErrors.DATA_PROCESSING_ERROR

            else -> DarulIftaErrors.UNKNOWN_ERROR
        }
    }


val mockedQuestions: List<QuestionAnswer>
    get() {
        val random = Random(Clock.System.now().nanosecondsOfSecond)
        val idPrefix = random.nextLong(283474)
        return (1..20).map { index ->
            val titles = listOf(
                "ٹیسٹنگ ایپ، یہ ڈیٹا کا مذاق اڑایا گیا ہے، لہذا اس کے بارے میں زیادہ فکر نہ کریں۔",
                "طنزیہ ڈیٹا طویل سوال۔ اس کے بارے میں زیادہ فکر نہ کریں۔ دے دو۔ تو اب کام کریں۔ اس ایپ کو حقیقت بنانے کے لیے سخت محنت کریں۔",
                "یہ صرف ایک ٹیسٹ ہے، حقیقی ڈیٹا نہیں۔",
                "ایک اور طویل اور بے معنی جملہ۔",
                "یہاں کچھ اور ڈمی ڈیٹا ہے جو آپ استعمال کر سکتے ہیں۔",
                "یہاں ایک بہت ہی طویل جملہ ہے جو کہیں سے بھی نہیں آیا۔",
                "آپ اس فہرست کو اپنی مرضی کے مطابق بڑھا سکتے ہیں۔",
                "یہاں کچھ اور بے معنی الفاظ ہیں جو کہیں سے بھی نہیں آئے۔",
                "یہ ایک اور ٹیسٹ ہے، حقیقی ڈیٹا نہیں۔",
                "یہاں کچھ اور ڈمی ڈیٹا ہے جو آپ استعمال کر سکتے ہیں۔",
            )
            QuestionAnswer(
                id = idPrefix + index.toLong(),
                title = titles.random(random),
                url = "https://example.com/question/$index",
                categoryId = index.toLong() % 3 + 1,
            )
        }
    }
