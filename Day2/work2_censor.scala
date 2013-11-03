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