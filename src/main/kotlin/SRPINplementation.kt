package org.example

/**
 * Single responsibility Principle(SRP)
 */

interface ObjetoCortante {
    fun corta()
}

class Faca : ObjetoCortante {
    override fun corta() {
        ValidaCorte(diasUso = 100, validadeDiasUso = VALIDADE).validaCorte()
        println("Faca cortar")
    }

    private companion object {
        const val VALIDADE = 40
    }
}

class Tesoura : ObjetoCortante {
    override fun corta() {
        ValidaCorte(diasUso = 70, validadeDiasUso = VALIDADE).validaCorte()
        println("Tesoura cortar")
    }

    private companion object {
        const val VALIDADE = 50
    }
}

class Serra : ObjetoCortante {
    override fun corta() {
        println("Serra cortar")
    }
}

class ValidaCorte(private val diasUso: Int, private val validadeDiasUso: Int) {
    fun validaCorte() {
        if (diasUso > validadeDiasUso) throw Exception("Invalidate day")
    }
}

enum class ItensCanivetes {
    LAMINA_TRESOURA,
    LAMINA_FACA,
    LAMINA_SERRA
}

fun SRPImplementation() {
    val objetoCortante: ObjetoCortante = when (ItensCanivetes.LAMINA_FACA) {
        ItensCanivetes.LAMINA_TRESOURA -> Tesoura()
        ItensCanivetes.LAMINA_FACA -> Faca()
        ItensCanivetes.LAMINA_SERRA -> Serra()
    }
    println("objetoCortante = ${objetoCortante.corta()}")
}
