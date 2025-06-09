package br.dev.luan.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;

import br.dev.luan.tarefas.dao.EmployeeDAO;
import br.dev.luan.tarefas.gui.FrameListEmployee;
import br.dev.luan.tarefas.gui.FrameListTasks;
import br.dev.luan.tarefas.gui.FrameUser;
import br.dev.luan.tarefas.model.Funcionario;
import br.dev.luan.tarefas.model.Tarefa;
import br.dev.luan.tarefas.utils.Utils;

public class Program {
	
	// duas barras para não dar erro no encontro do arquivo (\ é chamada de scape)
	private static String path = "C:\\Users\\25132656\\tarefa\\tarefa.txt";

	public static void main(String[] args) {
//		new FrameListEmployee();
		new FrameListTasks();
//		new FrameUser();

	}

}