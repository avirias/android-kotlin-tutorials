package com.company

//Simple Abstract classes and Interfaces using Kotlin

fun main() {
 val apple = Apple("Apple 1",70,300)
    apple.chopAndEat()
    apple.skinAndEat()
}

class Apple(name: String, quality: Int, override val calorieCount: Int) : Fruit(name, quality) {
    override fun skinAndEat() {
        super.skinAndEat()
        println("Goodness Index is : $goodnessIndex , hasSkin is: $hasSkin")
    }

    override fun chopAndEat() {
        println("You Gained $calorieCount calories")
    }


}

abstract class Fruit(private val name: String, private val quality: Int) : Eatable {

    // a value that tells how good a Eatable tastes
    var goodnessIndex = (7 * quality) / 100
    var hasSkin = true
    abstract val calorieCount: Int

    override fun skinAndEat() {
        goodnessIndex--
        hasSkin = !hasSkin
    }


}


interface Eatable {
    fun skinAndEat()
    fun chopAndEat()
}