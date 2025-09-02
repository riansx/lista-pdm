import java.io.File

fun addTexto(lista: MutableList<String>){
    println("Insira sua frase")
    val frase: String= readLine().toString()
    lista.add(frase)
}

fun salvarTexto(lista: MutableList<String>){
    lista.forEach { item ->
        File("quest5.txt").appendText(item.toString() + " ")
    }
    lista.clear()
}

fun listarArquivo(){
    val conteudo = File("quest5.txt").readText()
    println(conteudo)
}

fun main(){
    var escolha: Int? = 0;
    var lista: MutableList<String> = mutableListOf()

    while(escolha != 4){
        println("1. Adicionar texto")
        println("2. Salvar texto")
        println("3. Mostrar arquivo")
        println("4. Sair")
        
        escolha = readLine()?.toInt()

        when(escolha){
            1 -> addTexto(lista)
            2 -> salvarTexto(lista)
            3 -> listarArquivo()
            4 -> println("Saindo")
            else -> println("Escolha invalida")
        }
    }
}
