package br.dev.luan.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import br.dev.luan.tarefas.factory.TaskFileFactory;
import br.dev.luan.tarefas.model.Funcionario;
import br.dev.luan.tarefas.model.Tarefa;

public class TaskDAO {
	private Tarefa tarefa;
	private TaskFileFactory ff = new TaskFileFactory();
	private Funcionario funcionario;
	
	public TaskDAO(Tarefa tarefas) {
		this.tarefa = tarefas;
	}
	
	public void gravar() {
		try {
			BufferedWriter bw = ff.getBufferedWriter();
			bw.write(tarefa.toString());
			bw.flush();
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}
	public List<Tarefa> showTasks(){
	
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		try {
			
			BufferedReader br = ff.getBufferedReader();
			String linha = br.readLine();
			do {
				linha = br.readLine();
				String tarefa[] = linha != null ? linha.split(",") : null;
				
				Tarefa t = new Tarefa();
				t.setCodigo(tarefa[0]);
				t.setTitulo(tarefa[1]);
				t.setResponsavel(funcionario);
				
				tarefas.add(t);
			} while(linha != null);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return tarefas;
	}
}
