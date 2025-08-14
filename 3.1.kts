fun comprimentoOuZero(texto: String?): Int {
    return texto?.length ?: 0
}

fun main() {
    val s1: String? = "Rian"
    val s2: String? = null

    println("Comprimento de s1: ${comprimentoOuZero(s1)}") // Saída: 4
    println("Comprimento de s2: ${comprimentoOuZero(s2)}") // Saída: 0
}