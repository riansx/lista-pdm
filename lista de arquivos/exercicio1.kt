import java.io.File

fun criar(lista: List<String>){
    lista.forEach { tarefa ->
        File("tarefas.txt").appendText("$tarefa\n")
    }
}

fun listar(){
    var linhas: Int = 1
    File("tarefas.txt").forEachLine {
        println("${linhas++}. $it")
    }
}

fun inserir(tarefa: String){
    File("tarefas.txt").appendText("$tarefa\n")
}

fun main(){
    val lista: List<String> = listOf("Fazer exercicios", "Estudar", "Limpar casa")

    criar(lista)
    listar()
    inserir("Cozinhar")
    listar()
}
