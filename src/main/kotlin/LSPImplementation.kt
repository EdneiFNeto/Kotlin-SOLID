package org.example

/**
 * Liskov Substitution Principle(LSP)
 */

open class Veiculo(
    open val marca: String,
    open val modelo: String,
    open val ano: Int
) {
    private var velocidade: Double = 0.0

    open fun acelerar(acelerar: Double) {
        velocidade += acelerar
    }

    open fun frear(desacelerar: Double) {
        if (velocidade >= desacelerar) velocidade -= desacelerar
        else velocidade = 0.0
    }

    fun exibeInformacao() {
        println("==================================")
        println("marca = $marca")
        println("modelo = $modelo")
        println("ano = $ano")
        println("velocidade = $velocidade")
    }
}

open class VeiculoMotor(
    override val marca: String,
    override val modelo: String,
    override val ano: Int,
    private var ligado: Boolean = false
) : Veiculo(marca, modelo, ano) {
    override fun acelerar(acelerar: Double) {
        verificarDelsigado()
        super.acelerar(acelerar)
    }

    open fun ligar() {
        ligado = true
    }

    open fun desligar() {
        ligado = false
    }

    private fun verificarDelsigado() {
        if (!ligado) throw Exception("Veiculo desligado")
    }
}

open class VeiculoSemMotor(
    override val marca: String,
    override val modelo: String,
    override val ano: Int
) : Veiculo(marca, modelo, ano)

class Carro(
    override val marca: String,
    override val modelo: String,
    override val ano: Int
) : VeiculoMotor(marca, modelo, ano)

class Moto(
    override val marca: String,
    override val modelo: String,
    override val ano: Int
) : VeiculoMotor(marca, modelo, ano)

class Bicicleta(
    override val marca: String,
    override val modelo: String,
    override val ano: Int
) : VeiculoSemMotor(marca, modelo, ano)

fun LSPImplementation() {
    val carro = Carro(marca = "Carro", modelo = "carro", ano = 1)
    val moto = Moto(marca = "Moto", modelo = "Moto", ano = 2)
    val bicicleta = Bicicleta(marca = "Bicicleta", modelo = "Bicicleta", ano = 3)

    val veiculos = mutableListOf<Veiculo>()

    veiculos.add(carro)
    veiculos.add(moto)
    veiculos.add(bicicleta)

    veiculos.forEach {
        if (it is VeiculoMotor) {
            it.ligar()
            it.exibeInformacao()
            it.desligar()
        }

        it.acelerar(10.0)
        it.frear(5.0)
        it.exibeInformacao()
    }
}


