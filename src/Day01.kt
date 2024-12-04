import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (leftList, rightList) = input.map { line ->
            val left = line.substringBefore(" ")
            val right = line.substringAfterLast(" ")
            left.toInt() to right.toInt()
        }.unzip()

        return leftList.sorted().zip(rightList.sorted()).sumOf { (first, second) ->
            abs(first - second)
        }
    }

    fun part2(input: List<String>): Int {
        val (leftList, rightList) = input.map { line ->
            val left = line.substringBefore(" ")
            val right = line.substringAfterLast(" ")
            left.toInt() to right.toInt()
        }.unzip()
        val leftNumbers = leftList.groupingBy { it }.eachCount()
        val result = leftNumbers.map { (num, count) ->
            rightList.count { it == num } * num * count
        }.sum()
        return result
    }

    val input = readInput("Day01_test")
    part1(input).println()
    part2(input).println()
}
