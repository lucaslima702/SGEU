package SistemaDeGestaoEscolarUniversitaria;
import java.sql.SQLException;
import java.util.Scanner;

public class Tarefas {
	static Scanner teclado = new Scanner(System.in);
	
	public static void adicionaTarefa(Pessoa pessoa) throws ClassNotFoundException, SQLException {
		if(Database.verificacaoDeLogin(pessoa.getRegistro(), pessoa.getLogin(), pessoa.getSenha())) {
			System.out.println("Digite o nome da tarefa");
			String nomeDaTarefa = teclado.next();
			Database.adicionaTarefa(nomeDaTarefa, pessoa.getRegistro());
			System.out.println("Tarefa: " + nomeDaTarefa + " adicionada com sucesso !");
		}else{
			System.out.println("Autenticação de login falhou, tente novamente.");
		}
	}
	
	public static void concluiTarefa(String nomeDaTarefaParaConcluir, Pessoa pessoa) throws ClassNotFoundException, SQLException {
		if(Database.verificacaoDeLogin(pessoa.getRegistro(), pessoa.getLogin(), pessoa.getSenha())){
			System.out.println("Digite o nome da tarefa que deseja concluir");
			String nomeDaTarefa = teclado.next();
			Database.removeTarefa("nomeDaTarefa", pessoa.getRegistro());
		}
	}
}
