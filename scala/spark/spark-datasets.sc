/** Notes in form of code from going through:
 *  http://spark.apache.org/docs/latest/sql-programming-guide.html
 *
 * Run with spark-shell, i.e.
 * $ spark-shell -i spark-datasets.sc
 */

val newNames = Seq("last Name", "first Name", "SSN",
  "test1", "Test2", "test3", "test4", "final", "Grade")
val df = (
  spark.read
    .option("header", "true")
    .option("inferSchema", "true")
    // .format("csv")
    // .load("grades.csv")
    .csv("data/grades.csv")
    .toDF(newNames: _*)
)

df.show()
df.schema.printTreeString()
df.createOrReplaceTempView("grades")


spark.sql("SELECT grade FROM grades").show()

// spark.sqlContext.setConf("spark.sql.caseSensitive", "true");
