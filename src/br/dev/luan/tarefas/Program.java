package br.dev.luan.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.luan.tarefas.dao.FuncionarioDAO;
import br.dev.luan.tarefas.model.Funcionario;

public class Program {
	// Determinando o caminho do arquivo que será lido
	private static String path = "C:\\Users\\25132588\\Tasks\\tarefas.txt";
	
	 public static void main(String[] args) {
		 List<String> frutas = new ArrayList<String>();
		 List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		 List<Double> numeros = new ArrayList<Double>();
		 

		 Funcionario funcionario = new Funcionario();
		 funcionario.setCodigo(4);
		 funcionario.setNome("Yasmin");
		 funcionario.setMatricula("25454644");
		 funcionario.setEmail("emai.mail.yasmin@egg.com");
		 
		 Funcionario funcionario2 = new Funcionario();
		 funcionario2.setCodigo(5);
		 funcionario2.setNome("Fabiano");
		 funcionario2.setMatricula("25354644");
		 funcionario2.setEmail("emai.mail.fabiano@egg.com");
		 FuncionarioDAO dao = new FuncionarioDAO(funcionario2);
		 dao.gravar();
//		 System.out.println(funcionario2.toString());
	
	 }

	private static void gravarArquivo() {
		 FileWriter file = null;
		 BufferedWriter escritor = null;
		 try {
			file = new FileWriter(path, true);
			escritor = new BufferedWriter(file);
			escritor.flush();
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	}
	 
	private static void lerAquivo() {
		//Abrir o Arquivo para leitura
		FileReader file = null;
		BufferedReader buffer = null;
		
			try {
				file = new FileReader(path);
				buffer = new BufferedReader(file);
				String linha = "";
				
				while (linha != null) {
					linha = buffer.readLine();
					if (linha != null) {
						System.out.println(linha);
					}
				}
				
			} catch (FileNotFoundException error) {
				System.out.println(error.getMessage());
			} catch (IOException error) {
				System.out.println(error.getMessage());
			} catch (Exception error) {
				System.out.println(error.getMessage());
			}
	}
}
