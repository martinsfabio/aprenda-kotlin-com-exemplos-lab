enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

class Usuario(val nome: String, val email: String) {

    override fun toString(): String = """
        Nome:  $nome
        Email: $email
   """.trimIndent()

}
data class ConteudoEducacional(val nome: String, val duracao: String, val nivel: Nivel) {
    override fun toString(): String = """
        Nome:    $nome
        Duração: $duracao
        Nivel:   $nivel
   """.trimIndent()
}

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

}

fun main() {
    
    // Criando os conteúdos educacionais
    val kotlin = ConteudoEducacional("Desenvolvedor Kotlin", "78h", Nivel.INTERMEDIARIO)
    val java = ConteudoEducacional("Desenvolvedor Java", "96h", Nivel.AVANÇADO)

    println("Cursos disponíveis:\n" +
            "$kotlin\n" +
            "$java")


    // Criando uma formação
    val formacao1 = Formacao("Desenvolvedor Kotlin", listOf(kotlin,java))
    val formacao2 = Formacao("Desenvolvedor Java", listOf(kotlin,java))

    // Criando um usuário na formação e executando sua matrícula
    val usuario1 = Usuario("Fabio Martins", "fabio@email.com")
    formacao1.matricular(usuario1)

    val usuario2 = Usuario("John Doe", "joh@email.com")
    formacao2.matricular(usuario2)


    println("Usuário:\n $usuario1\n Matriculado na formação: ${formacao1.nome}")

    println("Usuário:\n $usuario2\n Matriculado na formação: ${formacao2.nome}")

}
