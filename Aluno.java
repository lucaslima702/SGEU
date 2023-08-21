package SistemaDeGestaoEscolarUniversitaria;

import java.sql.SQLException;
import java.util.Scanner;

public class Aluno extends Pessoa{
	static Scanner teclado = new Scanner(System.in);
	static String categoria = "aluno";
	
	public Aluno(String nome, int registro, String login, String senha) {
		super(nome, registro, login, senha, categoria);
	}	
	
	public static void criaAluno() throws SQLException, ClassNotFoundException {
		System.out.println("Qual o nome do aluno?");
		String nome = teclado.next();
		int registro = Pessoa.criaRegistro();
		System.out.println("Qual o usuário para login do aluno?");
		String login = teclado.next();
		System.out.println("Crie uma senha para o login");
		String senha = teclado.next();
		Aluno aluno = new Aluno(nome, registro, login, senha);
		Database.criaPessoa(aluno);
	}
	
	public static void deletaAluno() throws SQLException, ClassNotFoundException {
		System.out.println("Qual o registro da pessoa");
		int registro = teclado.nextInt();
		System.out.println("Qual o login dessa pessoa?");
		String login = teclado.next();
		System.out.println("Qual a senha?");
		String senha = teclado.next();
		if(Database.verificacaoDeLogin(registro, login, senha)) {
			Database.deletaPessoa(registro);
		}
	}
}
