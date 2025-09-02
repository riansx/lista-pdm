class ProdutoNaoEncontradoException(message: String) : RuntimeException(message)

fun calcularMedia(notas: List<Int>): Any{
    var somatoria: Int = 0
    var cont: Int = 0
    var result: Int = 0

    notas.forEach { nota ->
        if(nota != null){
            somatoria += nota
            cont++
        }else{
            ProdutoNaoEncontradoException("A lista de notas não pode estar vazia")
        }
    }

    try{
        notas.forEach { nota ->
            if(nota != null){
                somatoria += nota
                cont++
            }else{
                ProdutoNaoEncontradoException("A lista de notas não pode estar vazia")
            }
        }

        result = somatoria / cont
        return result
    }catch (e: ArithmeticException){
        return "Erro: ${e.message}, nota não pode ser dividida por zero"
    }
}

fun main(){
    println("Lista de notas válidas: ${calcularMedia(listOf(8,7,9,6))}")
    println("Lista vazia: ${calcularMedia(listOf<Int>())}")
}
