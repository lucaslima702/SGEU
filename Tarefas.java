package SistemaDeGestaoEscolarUniversitaria;
import java.util.Scanner;

public class Tarefas {
	static Scanner teclado = new Scanner(System.in);
	
	public static void adicionaTarefa(Pessoa pessoa) {
		if(Database.verificacaoDeLogin(pessoa.getLogin(), pessoa.getSenha(), pessoa)) {
			System.out.println("Digite o nome da tarefa");
			String nomeDaTarefa = teclado.next();
			Database.adicionaTarefa(nomeDaTarefa, pessoa);
			System.out.println("Tarefa: " + nomeDaTarefa + " adicionada com sucesso !");
		}else{
			System.out.println("Autenticação de login falhou, tente novamente.");
		}
	}
	
	public static void concluiTarefa(String nomeDaTarefaParaConcluir, Pessoa pessoa) {
		//if(pessoas.tarefas.contains(nomeDaTarefaParaConcluir){
		//db.apagaTarefa(nomeDaTarefaParaConcluir);
		//else{
		//sysout("Essa tarefa não existe, tente novamente");
	}
	
	public static void mostraTarefas(Pessoa pessoa) {
		
	}
}