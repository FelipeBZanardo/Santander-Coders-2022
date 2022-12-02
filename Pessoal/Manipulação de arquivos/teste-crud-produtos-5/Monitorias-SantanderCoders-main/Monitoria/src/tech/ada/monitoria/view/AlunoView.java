package tech.ada.monitoria.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import tech.ada.monitoria.model.Aluno;

public class AlunoView {
	
	Scanner sc = new Scanner(System.in);

	public String pegarOpcaoMenu() {
		System.out.println("Digite a opção desejada: ");
		System.out.println("1 - Criar Aluno");
		System.out.println("2 - Editar Aluno");
		System.out.println("3 - Listar Alunos");
		System.out.println("4 - Excluir Aluno");
		System.out.println("5 - Mostrar média dos Alunos");
		System.out.println("0 - Sair");
		
		String opcao = sc.next();
		return opcao;
	}
	
	public String pegarIdentificadorAluno() {
		System.out.println("Digite o identificador do Aluno: ");
		return sc.next();
	}
	
	public Map<String,Object> pegarInformacoesAluno() {
		
		Map<String,Object> aluno = new HashMap<>();
	
		System.out.println("Digite o nome do aluno: ");
		aluno.put("nome", sc.next());
		
		System.out.println("Digite o turma do aluno: ");
		aluno.put("turma", sc.next());
		
		System.out.println("Digite o nota do aluno: ");
		aluno.put("nota", sc.nextDouble());
		
		return aluno;
	}
	
	public void listarAlunos() {
		
		System.out.println("\n");
		
		for(int i = 0;i<Aluno.listaAlunos.size();i++){
			
			Map<String,Object> aluno = Aluno.listaAlunos.get(i);
			
			System.out.print("Identificador: "+i+", ");
			System.out.print("Nome: "+aluno.get("nome")+", ");
			System.out.print("Turma: "+aluno.get("turma")+", ");
			System.out.print("Nota: "+aluno.get("nota")+"\n");
			
		}
		
		System.out.println("\n\n");
	}
	
	public void mostrarMediaAlunos(Double media) {
		System.out.printf("A média dos alunos é %.2f\n\n",media);
	}
}
