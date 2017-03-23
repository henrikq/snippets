val list = List(1, 2, 3)
val list2 = list map (item => item + 1)
println(list2)
// List(2, 3, 4)

val ages = Map("alice" -> 21, "bob" -> 22)
val ages2 = ages map {case (name, age) => (name, age + 1)}
