fun main() {
    println(sum(5, 6, 7))
}

fun sum(vararg nums: Int): Int {
    var sum = 0
    for (num in nums)
        sum += num
    return sum
}