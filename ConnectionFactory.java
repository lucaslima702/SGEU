package SistemaDeGestaoEscolarUniversitaria;
import java.sql.*;

public class ConnectionFactory {

	public static Connection criarConexao(String msg) throws SQLException, ClassNotFoundException{ 
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + msg + "?serverTimezone=UTC","root","Liminhasz7@"); 
		if(con != null) {
			System.out.println("Conexao realizada com sucesso");
		}else {
			System.out.println("Conexao ainda nao foi realizada");
		}
		return con;
		}     
	}
