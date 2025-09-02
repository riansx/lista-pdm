import java.io.File

fun addDiretorio(caminho: String){
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

fun fazerBackup(caminho: String){
    val diretorioOrigem = File(caminho)
    val diretorioBackup = File("pastaBackup")

    diretorioOrigem.listFiles()?.forEach { arquivoOrigem ->
        if (arquivoOrigem.isFile) {
            val arquivoDestino = File(diretorioBackup, arquivoOrigem.name)
            try {
                arquivoOrigem.copyTo(arquivoDestino, overwrite = true)
                println("'${arquivoOrigem.name}' copiado para '${diretorioBackup.name}'")
            } catch (e: Exception) {
                println("Falha ao copiar '${arquivoOrigem.name}': ${e.message}")
            }
        }
    }

    val arquivosNaOrigem = diretorioOrigem.listFiles()
        ?.filter { it.isFile }
        ?.sortedBy { it.name }

    if(arquivosNaOrigem != null && arquivosNaOrigem.size > 5){
        val arquivosParaDeletar = arquivosNaOrigem.drop(5)

        arquivosParaDeletar.forEach { arquivo ->
            try {
                if(arquivo.delete()){
                    println("Arquivo removido da pasta original: '${arquivo.name}'")
                } else {
                    println("Falha ao remover o arquivo: '${arquivo.name}'")
                }
            } catch (e: Exception) {
                println("Erro ao remover '${arquivo.name}': ${e.message}")
            }
        }
    }
}
fun main(){
    addDiretorio("pasta1")
    addDiretorio("pastaBackup")

    File("pasta1/texto1.txt").writeText("texto numero 1")
    File("pasta1/texto2.txt").writeText("texto numero 2")
    File("pasta1/texto3.txt").writeText("texto numero 3")
    File("pasta1/texto4.txt").writeText("texto numero 4")
    File("pasta1/texto5.txt").writeText("texto numero 5")
    File("pasta1/texto6.txt").writeText("texto numero 6")
    File("pasta1/texto7.txt").writeText("texto numero 7")
    File("pasta1/texto8.txt").writeText("texto numero 8")
    File("pasta1/texto9.txt").writeText("texto numero 9")
    File("pasta1/texto10.txt").writeText("texto numero 10")

    fazerBackup("pasta1")
}
