class Retangulo(val largura: Double, val altura: Double) {

    fun calculaArea(): Double {
        return largura * altura
    }

    fun calculaPerimetro(): Double {
        return 2 * (largura + altura)
    }

    fun tipo(): String {
        return if (largura == altura) "Quadrado" else "Retângulo"
    }
}

fun main() {
    val r1 = Retangulo(10.0, 5.0)
    println("Tipo: ${r1.tipo()}") // Retângulo
    println("Área: ${r1.calculaArea()}") // 50.0
    println("Perímetro: ${r1.calculaPerimetro()}") // 30.0


    val r2 = Retangulo(6.0, 6.0)
    println("Tipo: ${r2.tipo()}") // Quadrado
    println("Área: ${r2.calculaArea()}") // 36.0
    println("Perímetro: ${r2.calculaPerimetro()}") // 24.0
}