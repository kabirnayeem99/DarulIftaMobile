package src.core

fun <T> safeCall(block: () -> T): T? {
    return try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

suspend fun <T> safeCallAsync(block: suspend () -> T): T? {
    return try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}


fun String.properCase(): String {
    return split(" ").joinToString(" ") { w ->
        w.replaceFirstChar { ch ->
            if (ch.isLowerCase()) ch.titlecase() else ch.toString()
        }
    }
}