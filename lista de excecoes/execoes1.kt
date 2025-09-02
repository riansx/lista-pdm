fun lerIdade(){
    println("Insira sua idade")
    val idade = readLine()

    try {
        val idadeInt = idade?.toInt()

        println("Você possui $idadeInt anos")
    }catch (e: NumberFormatException){
        println("Erro: ${e.message}, texto deve ser numérico")
    }
}

fun main(){
    lerIdade()
}
