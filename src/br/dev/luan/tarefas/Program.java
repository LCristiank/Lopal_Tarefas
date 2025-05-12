package br.dev.luan.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
	// Determinando o caminho do arquivo que será lido
	private static String path = "C:\\Users\\25132588\\Tasks\\tarefas.txt";
	
	 public static void main(String[] args) {
		 
		 gravarArquivo();
		 lerAquivo();
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
