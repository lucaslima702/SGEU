package SistemaDeGestaoEscolarUniversitaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Database {
	
	public static PreparedStatement abreConexao(String msg) throws SQLException, ClassNotFoundException {		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.criarConexao("SGEU");
		PreparedStatement stm = connection.prepareStatement(msg);
		return stm;
	}
	
	public static void criaPessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException {
		try {
			String sql = "INSERT INTO pessoa(nome,registro,login,senha,categoria) VALUES ('"+ pessoa.getNome() + "'," + "'" + pessoa.getRegistro() + "'," + "'" + pessoa.getLogin() + "'," + "'" + pessoa.getSenha() + "'," + "'" + pessoa.getCategoria() + "')";
			Connection conexao = ConnectionFactory.criarConexao("SGEU");
			PreparedStatement ps = conexao.prepareStatement(sql);
			int rs = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deletaPessoa(int registro) throws SQLException, ClassNotFoundException {
		try {
			String sql = "delete from pessoa where registro = " + registro;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void mostraAlunos() throws SQLException, ClassNotFoundException{
		try {
			String sql = "select nome from pessoa where categoria = nome";
			Connection conexao = ConnectionFactory.criarConexao("SGEU");
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String nome = rs.getString("nome");
				System.out.println(nome);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public static boolean verificacaoDeLogin(int registro, String login, String senha) throws ClassNotFoundException, SQLException {
		boolean confirmacao = false;
		Pessoa pessoa = Pessoa.retornaPessoa(registro);
		if(pessoa.getLogin() == login && pessoa.getSenha() == senha) {
			confirmacao = true;
			System.out.println("Validado");
		}else {
			System.out.println("Nao validado");
		}
		return confirmacao;
	}

	public static void adicionaTarefa(String nomeDaTarefa, Pessoa pessoa) {
		
	}
}