package org.example

/**
 * Open close Principle(OSP)
 */
data class Imagem(val nome: String) {
    fun visualizar() {
        println("Visualizar imagem $nome")
    }
}

class AplicatovoEdicaoFotos {
    private val filtros: MutableList<Filtro> = mutableListOf()

    fun adicionaFiltro(filtro: Filtro) {
        filtros.add(filtro)
    }

    fun aplicaFiltro(imagem: Imagem) {
        for (filtro in filtros) {
            filtro.aplicarFiltro(imagem)
        }
    }
}

class FiltroPretoBranco : Filtro {
    override fun aplicarFiltro(imagem: Imagem) {
        println("FiltroPretoBranco na imagem = ${imagem.nome}")
    }
}

class FiltroVintage : Filtro {
    override fun aplicarFiltro(imagem: Imagem) {
        println("FiltroVintage na imagem = ${imagem.nome}")
    }
}

class FiltroInfraVermelho : Filtro {
    override fun aplicarFiltro(imagem: Imagem) {
        println("FiltroInfraVermelho na imagem = ${imagem.nome}")
    }
}

interface Filtro {
    fun aplicarFiltro(imagem: Imagem)
}

fun OSPImplementation() {
    val imagem = Imagem("Foto.jpg")
    val aplicatovoEdicaoFotos = AplicatovoEdicaoFotos()
    aplicatovoEdicaoFotos.adicionaFiltro(FiltroVintage())
    aplicatovoEdicaoFotos.adicionaFiltro(FiltroPretoBranco())
    aplicatovoEdicaoFotos.adicionaFiltro(FiltroInfraVermelho())

    println("Origianl = ${imagem.visualizar()}")
    println("aplicaFiltro = ${aplicatovoEdicaoFotos.aplicaFiltro(imagem)}")
}
