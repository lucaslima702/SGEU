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
			String msg = "SGEU";
			Connection conexao = ConnectionFactory.criarConexao(msg);
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
}
