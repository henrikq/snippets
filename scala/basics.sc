#!/usr/bin/env scala

// Run:
// $ ./basics.sc
// $ scala basics.sc

// Save compiled:
// #!/bin/sh
// exec scala -savecompiled "$0" "$@"
// !#

// following along: http://docs.scala-lang.org/tutorials/tour/basics.html


println(1) // 1
println(1 + 1) // 2
println("Hello!") // Hello!
println("Hello," + " world!") // Hello, world

val x = 1 + 1
println(s"val - $x") // 2

val x2: Int = 1 + 1

var x3 = 1 + 1
x3 = 3 // This compiles because "x" is declared with the "var" keyword.

// blocks:
val x4 = {
  val x = 1 + 1
  x + 1 // last statement is return
}
println(s"blocks - x4:$x4") // 3

// functions
val add = (x: Int, y: Int) => x + y
println(s"add(1, 2): ${add(1, 2)}") // 3
val getTheAnswer = () => 42
println(s"getTheAnswer(): ${getTheAnswer()}") // 42


// methodes
def add2(x: Int, y: Int): Int = x + y
println(s"add2(1, 2): ${add2(1, 2)}") // 3
def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
println(s"addThenMultiply(1, 2)(3): ${addThenMultiply(1, 2)(3)}") // 9
def name: String = System.getProperty("name")
println("Hello, " + name + "!")


// classes
class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}
val greeter = new Greeter("Hello, ", "!")
greeter.greet("Scala developer") // Hello, Scala developer!


// case classes, By default, case classes are immutable and compared by value.
case class Point(x: Int, y: Int)
val point = Point(1, 2)
val anotherPoint = Point(1, 2)
val yetAnotherPoint = Point(2, 2)

if (point == anotherPoint) {
  println(point + " and " + anotherPoint + " are the same.")
} else {
  println(point + " and " + anotherPoint + " are different.")
}
// Point(1,2) and Point(1,2) are the same.
if (point == yetAnotherPoint) {
  println(point + " and " + yetAnotherPoint + " are the same.")
} else {
  println(point + " and " + yetAnotherPoint + " are different.")
}
// Point(1,2) and Point(2,2) are different.
