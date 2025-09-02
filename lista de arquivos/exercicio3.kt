import java.io.File
import java.io.FileOutputStream

fun inserirArqBinario(caminhoArquivo: String, dados: ByteArray){
    try {
        FileOutputStream(caminhoArquivo).use { outputStream ->
            outputStream.write(dados)
        }
        println("Arquivo binário escricto com sucesso!")
    }catch (e: Exception){
        println("Erro: ${e.message}")
    }
}

fun verificarBytes(): Boolean{
    val bytesArquivo = File("app.dat").readBytes()
    val dadosVerificar = byteArrayOf(0x4B, 0x4F, 0x54, 0x4C, 0x4E)

    for(i in dadosVerificar.indices){
        if(bytesArquivo[i] != dadosVerificar[i]) return false
    }
    return true
}

fun main(){
    val dadosParaGravar = byteArrayOf(0x4B, 0x4F, 0x54, 0x4C, 0x4E)

    inserirArqBinario("app.dat", dadosParaGravar)

    val bytesLidos = File("app.dat").readBytes().joinToString()
    println("Bytes lidos: ${bytesLidos}")

    println("Arquivo de bytes é igual? ${verificarBytes()}")
}
