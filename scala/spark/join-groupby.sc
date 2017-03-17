val people = Seq((1,"foo",11),(2,"foo",12),(3,"bar",23),(4,"bar",24),(5,"bar",25),(6,"zap",36)).toDF("id","group","number").alias("people")
people.show()
// +---+-----+------+
// | id|group|number|
// +---+-----+------+
// |  1|  foo|    11|
// |  2|  foo|    12|
// |  3|  bar|    23|
// |  4|  bar|    24|
// |  5|  bar|    25|
// |  6|  zap|    36|
// +---+-----+------+

val others = people.alias("others")
val peopleInGroup = (
  people
    .join(others, $"people.group" === $"others.group", "left_outer")
    .groupBy($"people.id")
)
peopleInGroup.count().show()
// +---+-----+
// | id|count|
// +---+-----+
// |  1|    2|
// |  6|    1|
// |  3|    3|
// |  5|    3|
// |  4|    3|
// |  2|    2|
// +---+-----+

val othersInGroup = (
  people
    .join(others, $"people.group" === $"others.group", "left_outer")
    .filter($"people.id" =!= $"others.id")
    .groupBy($"people.id")
)
othersInGroup.count().show()
// +---+-----+
// | id|count|
// +---+-----+
// |  1|    1|
// |  3|    2|
// |  5|    2|
// |  4|    2|
// |  2|    1|
// +---+-----+



val otherWithLowerNumber = (
  people
    .join(others, $"people.group" === $"others.group", "left_outer")
    .filter($"people.number" > $"others.number")
    .groupBy($"people.id")
)
otherWithLowerNumber.count().show()
// +---+-----+
// | id|count|
// +---+-----+
// |  5|    2|
// |  4|    1|
// |  2|    1|
// +---+-----+


val isSameGroup = $"people.group" === $"others.group"
val isOtherNumberLower = $"people.number" > $"others.number"
val otherWithLowerNumber = (
  people
    .join(others, isSameGroup && isOtherNumberLower, "left_outer")
    .groupBy($"people.id")
)
otherWithLowerNumber.count().show()
// +---+-----+
// | id|count|
// +---+-----+
// |  1|    1|
// |  6|    1|
// |  3|    1|
// |  5|    2|
// |  4|    1|
// |  2|    1|
// +---+-----+
