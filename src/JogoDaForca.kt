class JogoDaForca {
    public val palavra: String
    public val dica: String
    public val tentativa: Int
    public var palavraSecreta = mutableListOf<Char>()
    public var tentativaNew = 1
    public var end = false
    public var letrasUtilizadas: String = String()

    constructor(palavra: String, dica: String, tentativa: Int){
        this.palavra = palavra
        this.dica = dica
        this.tentativa = tentativa
    }

    fun tamanhoPalavra(): String {
        for (i in 0 until palavra.length) {
            palavraSecreta.add('_')
        }
        return "A palavra tem contém ${palavraSecreta.size} letras."
    }

    fun letrasDistinc(): Int {
        return palavra.lowercase().chars().distinct().count().toInt()
    }

    fun verifyLetra(letra: String) {
        letrasUsed(letra)
        for ((i, item) in palavra.lowercase().withIndex()) {
            if (letra[0].lowercaseChar() == item.lowercaseChar()) {
                palavraSecreta[i] =  letra[0].uppercaseChar()
            }
        }
        if (!palavraSecreta.contains('_')) {
            EndGame()
            return
        }
        tentativas()
    }

    fun letrasUsed(letra: String): String {
        if (letrasUtilizadas.contains(letra)) {
            println("Letra Utilizada: $letra")
        }
        else {
            letrasUtilizadas += "$letra "
        }
        return letrasUtilizadas
    }

    private fun tentativas() {
        ++tentativaNew
        if (tentativaNew == tentativa) {
            EndGame()
        }
    }

    private fun EndGame() {
        end = true
        if (palavraSecreta.contains('_')) {
            println("Perdeu!")
            println("A palavra era $palavra")
        } else {
            println("Ganhou!")
            println("Tentativas $tentativaNew")
            println("A palavra era $palavra")
        }

    }
 }
