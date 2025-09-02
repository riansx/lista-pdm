import java.io.File

fun verificarFreq(){
    val arquivo = File("quest7.txt").readText().split(" ")
    var mapPalavras = mutableMapOf<String, Int>()

    arquivo.forEach { palavra ->
        val cont = mapPalavras.getOrDefault(palavra, 0)

        mapPalavras[palavra] = cont+1
    }

    val maior = mapPalavras.maxByOrNull { it.value }

    println("Palavra '${maior?.key}' possui a maior frequência, pois apareceu ${maior?.value} vezes")
}

fun main(){
    File("quest7.txt").writeText("Repetindo frases ")
    File("quest7.txt").appendText("Gustavo Gustavo Gustavo Gustavo Nunes Nunes oi oi la la la  ")

    verificarFreq()
}
