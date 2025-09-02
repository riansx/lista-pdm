import java.io.File

fun criarDiretorio(caminho: String){
    var diretorio = File(caminho)

    if(!diretorio.exists()){
        val criado = diretorio.mkdir()
        if(criado){
            println("Diretório criado com sucesso: ${diretorio.absolutePath}")
        }else{
            println("Falha ao criar diretório: ${diretorio.absolutePath}")
        }
    }else{
        println("Diretório já existe: ${diretorio.absolutePath}")
    }
}

fun moverConteudo(caminhoAtual: String, novoCaminho: String){
    val conteudoAtual = File(caminhoAtual)
    val novoConteudo = File(novoCaminho)

    if(conteudoAtual.exists()){
        if(conteudoAtual.isFile || conteudoAtual.isDirectory){
            val sucesso = conteudoAtual.renameTo(novoConteudo)
            if(sucesso){
                println("Conteudo ${conteudoAtual.absolutePath} movido para ${novoConteudo.absolutePath}")
            }else{
                println("Falha ao mover ${conteudoAtual.absolutePath} para ${novoConteudo.absolutePath}")
            }
        }else{
            println("Conteudo não é arquivo ou diretório")
        }
    }else{
        println("Conteudo não existe")
    }
}

fun listarConteudo(caminho: String){
    val diretorio = File(caminho)

    if(diretorio.exists()){
        val arquivosPastas = diretorio.listFiles()

        arquivosPastas.forEach { item ->
            if(item.isFile){
                println("Arquivo: ${item.name}")
            }else if(item.isDirectory){
                println("Diretório: ${item.name}")
            }
        }
    }else{
        println("Caminho fornecido não é diretório")
    }
}

fun excluir(diretorio: File){
    if(diretorio.isDirectory){
        diretorio.listFiles()?.forEach { item ->
            if(item.isDirectory){
                excluir(item)
            }else{
                item.delete()
            }
        }
    }

    val sucesso = diretorio.delete()
    if(sucesso){
        println("Diretório excluido com sucesso!")
    }else{
        println("Falha ao excluir diretório: ${diretorio.absolutePath}")
    }
}

fun main(){
    criarDiretorio("backup")
    criarDiretorio("fotos")
    criarDiretorio("Documentos")

    moverConteudo("Documentos", "backup/Documentos")
    moverConteudo("fotos", "backup/fotos")

    listarConteudo("backup")

    File("notas.txt").writeText("1,2,3")
    moverConteudo("notas.txt", "backup/Documentos/notas.txt")
    
    val caminhoDoDiretorio = "backup"
    val diretorioParaExcluir = File(caminhoDoDiretorio)

    excluir(diretorioParaExcluir)
}
