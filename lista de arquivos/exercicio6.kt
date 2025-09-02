import java.io.File

data class Usuario(val nome: String?, val email: String?, val idade: Int?)

fun addUsuario(){
    println("Insira o nome do usuário:")
    val nome: String = readLine().toString()
    println("Insira o email do usuário:")
    val email: String = readLine().toString()
    println("Insira a idade do usuário:")
    val idade: Int? = readLine()?.toInt()

    val usuario = Usuario(nome, email, idade)
    val file = File("usuarios.csv")
    val userData = "${usuario.nome},${usuario.email},${usuario.idade}\n"

    if (!file.exists() || file.length() == 0L) {
        file.writeText("nome,email,idade\n")
    }

    file.appendText(userData)
    println("Usuário '${usuario.nome}' adicionado com sucesso!")
}

fun listarUsuarios(){
    println("Usuários: ")

    File("usuarios.csv").forEachLine { linha ->
        if(!linha.startsWith("nome")){
            val dados = linha.split(",")
            println(dados)
        }
    }
}

fun buscarUsuarios(){
    println("Insira o nome do usuário a ser buscado: ")
    val nomeParaBuscar = readLine().toString()

    val arquivo = File("usuarios.csv")
    var usuarioEncontrado = false

        arquivo.forEachLine{ linha ->
            val dados = linha.split(",")

            if(dados.size == 3 && dados[0].equals(nomeParaBuscar, ignoreCase = true)){
                val nome = dados[0]
                val email = dados[1]
                val idade = dados[2]

                println("Nome: $nome; Email: $email; Idade:$idade")

                usuarioEncontrado = true
            }
        }

    if(!usuarioEncontrado){
        println("Usuário '$nomeParaBuscar' não encontrado no arquivo.")
    }
}

fun main(){
    var escolha: Int? = 0;

    while(escolha != 4){
        println("1. Criar usuário")
        println("2. Listar usuários")
        println("3. Buscar usuário")
        println("4. Sair")

        escolha = readLine()?.toInt()

        when(escolha){
            1 -> addUsuario()
            2 -> listarUsuarios()
            3 -> buscarUsuarios()
            4 -> println("Saindo")
            else -> println("Escolha invalida")
        }
    }
}
