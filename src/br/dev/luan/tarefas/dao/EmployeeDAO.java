package br.dev.luan.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.luan.tarefas.factory.EmployeeFileFactory;
import br.dev.luan.tarefas.model.Funcionario;

public class EmployeeDAO {
	private Funcionario funcionario;
	private EmployeeFileFactory ff = new EmployeeFileFactory();

	// Método Construtor
	public EmployeeDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void gravar() {
		try {
			BufferedWriter bw = ff.getBufferedWriter();
			bw.write(funcionario.toString());
			bw.flush();
		} catch (IOException error) {
			System.out.println(error.getMessage());
		}
	}

	public List<Funcionario> showEmployees() {
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			BufferedReader br = ff.getBufferedReader();
			String linha = br.readLine();
			do {
				linha = br.readLine();
				String funcionario[] = linha != null ? linha.split(",") : null;
						
				Funcionario f = new Funcionario();
				f.setCodigo(funcionario[0]);
				f.setNome(funcionario[1]);
				f.setTelefone(funcionario[2]);
				f.setEmail(funcionario[3]);
	
				funcionarios.add(f);
			} while(linha != null);
				
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
		return funcionarios;
	}
}
