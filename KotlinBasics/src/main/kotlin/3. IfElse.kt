fun main() {
    val limit = 18
    val age = 17
    val result = if (age >= limit) "Eligible" else "Not eligible"
    println(result)

    val n = 12
    when {
        n % 15 == 0 -> println("FizzBuzz")
        n % 3 == 0 -> println("Fizz")
        n % 5 == 0 -> println("Buzz")
        else -> println("Nothing")
    }
}