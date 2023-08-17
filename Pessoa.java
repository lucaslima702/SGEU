package SistemaDeGestaoEscolarUniversitaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Pessoa {
	protected String nome;
	protected int registro;
	protected String login;
	protected String senha;
	protected String categoria;
	
	public Pessoa(String nome, int registro, String login, String senha, String categoria) {
		this.nome = nome;
		this.registro = registro;
		this.login = login;
		this.senha = senha;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public int getRegistro() {
		return registro;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public static int criaRegistro() throws SQLException, ClassNotFoundException {
		while(true) {
			Connection conexao = ConnectionFactory.criarConexao("SGEU");
			String sql = "SELECT registro from pessoa";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ArrayList<Integer> lista = new ArrayList<Integer>();
			Random random = new Random();
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {
				int registro = rs.getInt("registro");
				lista.add(registro);
			}
			int rand = random.nextInt(100000, 1000000);
			if(lista.contains(rand) == false) {
				return rand;
			}
		}
	}
	
	public static Pessoa retornaPessoa(int registro) throws ClassNotFoundException, SQLException {
		Connection conexao = ConnectionFactory.criarConexao("SGEU");
		int registroPessoa = 0;
		String nomePessoa = null;
		String loginPessoa = null;
		String senhaPessoa = null;
		String categoriaPessoa = null;
		String sql = "SELECT * from pessoa where registro = " + registro;
		PreparedStatement ps = conexao.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(sql);
		while(rs.next()) {
			registroPessoa = rs.getInt("registro");
			nomePessoa = rs.getString("nome");
			loginPessoa = rs.getString("login");
			senhaPessoa = rs.getString("senha");
			categoriaPessoa = rs.getString("categoria");
		}
		Pessoa pessoa = new Pessoa(nomePessoa, registroPessoa, loginPessoa, senhaPessoa, categoriaPessoa);
		return pessoa;
	}
}
