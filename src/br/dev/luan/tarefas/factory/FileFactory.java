package br.dev.luan.tarefas.factory;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
	private FileWriter fw;
	private BufferedWriter bw;

	private String pathFuncionarios = "C:\\Users\\25132588\\Tasks\\funcionarios.csv";

	public BufferedWriter getBufferedWriter() throws FileNotFoundException, IOException {

		fw = new FileWriter(pathFuncionarios, true);
		bw = new BufferedWriter(fw);

		return bw;

	}
}
