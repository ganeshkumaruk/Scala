var stringList = List("here", "is", "a", "list", "of", "strings")
var totalStringSize = stringList.foldLeft(0)((total, string) => total + string.length)
var totalStringSize2 = (0 /: stringList) {(total, string) => total + string.length }

println(totalStringSize)
println(totalStringSize2)