package org.example


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    ISPImplement()
}

private fun ISPImplement() {
    when (val conector: Conector = AdaptadorUSBImpl()) {
        is ConectorMini -> conector.conectar()
        is ConectorUSB -> conector.conectar()
        is ConectorUSBC -> conector.conectar()
    }
}

private fun OSPImplementation() {
    val imagem = Imagem("Foto.jpg")
    val aplicatovoEdicaoFotos = AplicatovoEdicaoFotos()
    aplicatovoEdicaoFotos.adicionaFiltro(FiltroVintage())
    aplicatovoEdicaoFotos.adicionaFiltro(FiltroPretoBranco())
    aplicatovoEdicaoFotos.adicionaFiltro(FiltroInfraVermelho())

    println("Origianl = ${imagem.visualizar()}")
    println("aplicaFiltro = ${aplicatovoEdicaoFotos.aplicaFiltro(imagem)}")
}

private fun SRPImplementation() {
    val objetoCortante: ObjetoCortante = when (ItensCanivetes.LAMINA_FACA) {
        ItensCanivetes.LAMINA_TRESOURA -> Tesoura()
        ItensCanivetes.LAMINA_FACA -> Faca()
        ItensCanivetes.LAMINA_SERRA -> Serra()
    }
    println("objetoCortante = ${objetoCortante.corta()}")
}

private fun LSPImplementation() {
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
