package tech.ada.monitoria.controller;

import java.util.Map;

import tech.ada.monitoria.model.Aluno;
import tech.ada.monitoria.view.AlunoView;

public class AlunoController {

	private AlunoView view;
	
	public void menu() {
		view = new AlunoView();
		Boolean continuar = true;
		
		while(continuar) {
			String opcao = view.pegarOpcaoMenu();
			switch(opcao) {
				case "1" -> criarAluno();
				case "2" -> editarAluno();
				case "3" -> listarAlunos();
				case "4" -> excluirAluno();
				case "5" -> mediaAlunos();
				case "0" -> continuar = false;
				default -> System.out.println("Opção Inválida.");
			}
		}
	}
	
	public void criarAluno() {
		Map<String,Object> aluno = view.pegarInformacoesAluno();
		Aluno.listaAlunos.add(aluno);
	}
	
	public void editarAluno() {
		view.listarAlunos();
		String id = view.pegarIdentificadorAluno();
		Map<String,Object> alunoModificacao = view.pegarInformacoesAluno();
		Map<String,Object> alunoAtual = Aluno.listaAlunos.get(Integer.valueOf(id));
		alunoAtual.put("nome", alunoModificacao.get("nome"));
		alunoAtual.put("turma", alunoModificacao.get("turma"));
		alunoAtual.put("nota", alunoModificacao.get("nota"));
	}
	
	public void listarAlunos() {
		view.listarAlunos();
	}
	
	public void excluirAluno() {
		view.listarAlunos();
		String id = view.pegarIdentificadorAluno();
		int idInt = Integer.valueOf(id);
		Aluno.listaAlunos.remove(idInt);
	}
	
	public void mediaAlunos() {
		view.listarAlunos();
		Double media = 0.0;
		for(Map<String,Object> aluno : Aluno.listaAlunos) {
			media += (Double) aluno.get("nota");
		}
		media = media/Aluno.listaAlunos.size();
		view.mostrarMediaAlunos(media);
	}
}
