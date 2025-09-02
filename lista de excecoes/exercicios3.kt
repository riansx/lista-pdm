class SenhaInvalidaException(message: String) : IllegalArgumentException(message)

fun validarSenha(senha: String): Any{
    try {
        if(senha.length < 8){
            throw SenhaInvalidaException("Senha deve ter 8 ou mais caracteres")
        }

        val contNum = senha.any {it.isDigit()}
        if(!contNum){
            throw SenhaInvalidaException("Senha deve ter pelo menos um número")
        }

        return "Senha válida"
    }catch (e: SenhaInvalidaException){
        return "Erro: ${e.message}"
    }
}

fun main(){
    println(validarSenha("Senha"))
    println(validarSenha("gustavoN"))
    println(validarSenha("gustavoN1"))
}
