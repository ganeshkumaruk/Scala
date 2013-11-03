import scala.collection.mutable.HashMap

trait Censor {

    var curseWords = Map(
        "(?i)Shoot" -> "Pucky",
        "(?i)Darn" -> "Beans"
    )

    def setCurseWords(newCurseWords : Map[String, String]) = {
        curseWords = newCurseWords
    }

    def censorThyselfVillain (suspectPhrase : String) : String = {
       var wholesomePhrase = suspectPhrase

       for ((key, value) <- curseWords) {
            wholesomePhrase = wholesomePhrase.replaceAll(key, value)
       }

       return wholesomePhrase
    }

    def censorThyselfVillain2 (suspectPhrase : String) : String = {
        curseWords.foldLeft(suspectPhrase)((acc, pair) => acc.replaceAll(pair._1, pair._2))
    }
}

class PolitenessEnforcer extends Censor

var enforcer = new PolitenessEnforcer()

val rudePhrase = "Shoot, my darn head is stuck in the dumb freaking door. Holy gosh Batman!"

println("Spoken frankly: ")
println(rudePhrase)

println("The enforcer menaces with spikes of brass: ")
println(enforcer.censorThyselfVillain2(rudePhrase))

import scala.io.Source._

var cursesFromFile = Map.empty[String, String]

fromFile("curseWords.txt").getLines.foreach { line =>
    val curseWordPair = line.split('|')
    if(curseWordPair.length == 2) {
        cursesFromFile += ("(?i)" + curseWordPair(0).trim) -> curseWordPair(1).trim
    }
}

val stricterEnforcer = new PolitenessEnforcer()
stricterEnforcer.setCurseWords(cursesFromFile)

println("The enforcer menaces with spikes of onyx: ")
println(stricterEnforcer.censorThyselfVillain(rudePhrase))
