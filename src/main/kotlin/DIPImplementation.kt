package org.example

fun DIPImplementation() {

    val di = DIP(SQLConnectorImplement())
    val conectar = di.connection(ip = "", nomeDB = "SQL", usuario = "root", senha = "root", porta = "8080")
    println("sqlServerConnector = $conectar")

    val query = di.query("", limitador = 1, ordenacao = "ASC")
    println("query = $query")
}

class SQLServerConnector {
    fun efetuaConexao(conexao: SqlServerInfoConexao): Boolean {
        return true
    }

    fun executeQuery(query: String, sqlServerInfoConexao: SqlServerInfoQuery): String {
        return "Query executada com sucesso"
    }
}

data class SqlServerInfoConexao(
    val porta: String,
    val usuario: String,
    val senha: String
)

data class SqlServerInfoQuery(
    val limitador: Int,
    val ordenacao: String,
)

class SQLConnectorImplement : BancDadosConector {
    private val connector: SQLServerConnector = SQLServerConnector()
    override fun conectar(ip: String, nomeDB: String, usuario: String, senha: String, porta: String): String {
        val sqlServerInfoConexao = SqlServerInfoConexao(porta = porta, usuario = usuario, senha = senha)
        val efetuaConexao = connector.efetuaConexao(sqlServerInfoConexao)
        return if (efetuaConexao) "Sucesso" else "falha"
    }

    override fun query(query: String, limitador: Int, ordenacao: String): String {
        return connector.executeQuery(query, sqlServerInfoConexao = SqlServerInfoQuery(limitador, ordenacao))
    }
}

interface BancDadosConector {
    fun conectar(ip: String, nomeDB: String, usuario: String, senha: String, porta: String): String
    fun query(query: String, limitador: Int, ordenacao: String): String
}

class DIP(private val bancDadosConector: BancDadosConector) {
    fun connection(ip: String, nomeDB: String, usuario: String, senha: String, porta: String): String {
        return bancDadosConector.conectar(ip, nomeDB, usuario, senha, porta)
    }

    fun query(query: String, limitador: Int, ordenacao: String): String {
        return bancDadosConector.query(query, limitador, ordenacao)
    }
}