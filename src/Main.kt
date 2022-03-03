fun main(args: Array<String>) {
    val jogo = JogoDaForca("BOLA", "Instrumento usado no Futebol",7)

    println("|-------------- JOGO DA FORCA --------------|")
    println("A Palavra a adivinhar tem ${jogo.tamanhoPalavra()}, dentre as quais ${jogo.letrasDistinc()} são distintas")
    println("Dica: ${jogo.dica}")
    while(!jogo.end){
        println("Palavra: " + jogo.palavraSecreta.joinToString(" "))
        println("Você tem ${jogo.tentativa} tentativas, e está na ${jogo.tentativaNew}ª")
        println("Letras utilizadas: ${jogo.letrasUtilizadas}")

        var letra = readLine()!!
        jogo.verifyLetra(letra)
    }
}
