package src.core.datastructure


inline fun <K, V> lruCacheOf(capacity: Int): LruCache<K, V> = LruCache(capacity = capacity)

class LruCache<K, V>(private val capacity: Int) {
    private val cache = LinkedHashMap<K, V>()

    fun get(key: K): V? {
        if (!containsKey(key)) return null

        val value = remove(key)!!
        cache[key] = value
        return value
    }

    fun clear() = cache.clear()

    fun remove(key: K) = cache.remove(key)

    fun put(key: K, value: V) {
        if (cache.containsKey(key)) {
            cache.remove(key)
        } else if (cache.size == capacity) {
            cache.remove(cache.keys.first())
        }
        cache[key] = value
    }

    val size: Int
        get() = cache.size

    fun isEmpty() = cache.isEmpty()

    fun containsKey(key: K) = cache.containsKey(key)

    fun containsValue(value: V) = cache.containsValue(value)

    fun putAll(from: Map<out K, V>) = cache.putAll(from)

    val keys: MutableSet<K>
        get() = cache.keys

    val values: MutableCollection<V>
        get() = cache.values

    val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() = cache.entries
}