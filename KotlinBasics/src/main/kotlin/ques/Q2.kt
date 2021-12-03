package ques

fun main() {
    var sum = 0
    for (i in 0..5) {
        sum += when {
            i % 2 == 0 -> 1
            else -> 0
        }
    }
    println(sum)
}

// Link: https://pl.kotl.in/thusgh8YF