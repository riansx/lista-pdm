data class Aluno(
    val nome: String,
    val matricula: String,
    val notas: List<Double>
) {
    fun calculaMedia(): Double {
        if (notas.isEmpty()) {
            return 0.0
        }
        var soma = 0.0
        for (nota in notas) {
            soma += nota
        }
        return soma / notas.size
    }
}

fun main() {
    val aluno1 = Aluno("Rian", "2024-1", listOf(8.5, 9.0, 7.5))
    println("Aluno: ${aluno1.nome}")
    println("Média: ${aluno1.calculaMedia()}")
}