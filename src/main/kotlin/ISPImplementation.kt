package org.example

sealed interface Conector
interface ConectorUSB: Conector {
    fun conectar()
}

interface ConectorMini: Conector {
    fun conectar()
}

interface ConectorUSBC: Conector {
    fun conectar()
}

class AdaptadorUSBImpl: ConectorUSB {
    override fun conectar() {
        println("conectar USB")
    }
}

class AdaptadorMiniImpl: ConectorMini {
    override fun conectar() {
        println("conectar Mini")
    }
}

class AdaptadorUSBCImpl: ConectorUSBC {
    override fun conectar() {
        println("conectar USBC")
    }
}

