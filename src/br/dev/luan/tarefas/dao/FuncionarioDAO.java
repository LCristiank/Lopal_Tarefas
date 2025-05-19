package br.dev.luan.tarefas.dao;

import java.io.BufferedWriter;
import java.io.IOException;

import br.dev.luan.tarefas.factory.FileFactory;
import br.dev.luan.tarefas.model.Funcionario;

public class FuncionarioDAO {
	private Funcionario funcionario;
	
	//Método Construtor	
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public void gravar() {
		FileFactory ff = new FileFactory();
		try {
			BufferedWriter bw = ff.getBufferedWriter();
			bw.write(funcionario.toString());
			bw.flush();
		} catch (IOException error) {
			System.out.println(error.getMessage());
		}
	}
	public void showEmployees() {
		
	}
}
