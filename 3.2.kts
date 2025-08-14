
fun descreveEndereco(rua: String?, numero: Int?, cidade: String?): String {
    val ruaInfo = rua ?: "Não informado"
    val numeroInfo = numero ?: "Não informado"
    val cidadeInfo = cidade ?: "Não informado"

    return "Rua ${ruaInfo}, Nº ${numeroInfo}, ${cidadeInfo}"
}

fun main() {
    println(descreveEndereco("Av. Brasil", 123, "Rio de Janeiro"))
    println(descreveEndereco(null, 987, "São Paulo"))
    println(descreveEndereco("Rua das Flores", null, null))
}