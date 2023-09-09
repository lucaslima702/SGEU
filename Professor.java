package SistemaDeGestaoEscolarUniversitaria;

import java.sql.SQLException;
import java.util.Scanner;

public class Professor extends Pessoa{
	static String categoria = "professor";
	public Professor(String nome, int registro, String login, String senha) {
		super(nome, registro, login, senha, categoria);
	}
	
	public static void criaProfessor() throws ClassNotFoundException, SQLException {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Qual o seu nome?");
		String nome = teclado.next();
		System.out.println("Digite seu CFEP aqui: ");
		int cfep = Integer.parseInt(teclado.next());
		System.out.println("Crie um usuario para acesso: ");
		String login = teclado.next();
		System.out.println("Crie uma senha: ");
		String senha = teclado.next();
		Professor professor = new Professor(nome, cfep, login, senha);
		Database.criaPessoa(professor);
	}
}