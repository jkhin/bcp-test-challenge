package pe.com.test.utils

interface Mapper<in I, out O> {
    fun map(entry: I): O
}