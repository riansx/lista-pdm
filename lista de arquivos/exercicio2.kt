import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class ConfiguracaoUsuario(
    val nome: String,
    val idioma: String,
    val tema: String
)

fun main(){
    val usuario = ConfiguracaoUsuario("Rian", "Portugues", "escuro")
    val json = Json { prettyPrint = true }.encodeToString(usuario)

    File("config.json").writeText(json)

    val jsonLido = File("config.json").readText()
    val pessoaJson = Json.decodeFromString<ConfiguracaoUsuario>(jsonLido)
    println("Pessoa do JSON: $pessoaJson\n" +
            "Nome: ${pessoaJson.nome}\n" +
            "Idioma: ${pessoaJson.idioma}\n" +
            "Tema: ${pessoaJson.tema}\n")
}
