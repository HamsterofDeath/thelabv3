package hod.euler

import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors
import kotlin.math.log10

fun main() {
    val data = Files.lines(Path.of("resource/p99.txt")).collect(Collectors.toList())
    val solution = data.mapIndexed { index, s ->
        val seq = s.splitToSequence(',').map { it.toInt() }.toList()
        val reduced = log10(seq.first().toDouble()) * seq.last()
        Pair(index + 1, reduced)
    }.maxByOrNull { it.second }
    solution?.let { println(it.first) }
}