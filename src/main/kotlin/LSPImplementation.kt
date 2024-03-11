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
        if(!ligado) throw Exception("Veiculo desligado")
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

