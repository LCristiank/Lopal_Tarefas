package br.dev.luan.tarefas.gui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameListFuncionario {
	private JLabel labelTitulo;
	private JTable tableFuncionario;
	private JScrollPane scrollFuncionarios;
	private JButton btnNovo;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnSair;
	
	private Font fontTitulo = new Font("Arial", Font.BOLD, 26);
	
	public FrameListFuncionario() {
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de Funcionarios");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Funcionarios");
		labelTitulo.setBounds(10, 20, 350, 30);
		labelTitulo.setFont(fontTitulo);
		
		String[] colunas = {"Código", "Nome", "E-mail"};
		
		Object[][] dados = {
				{"xxx", "xxx", "xxx"},
				{"yyy", "yyy", "yyy"},
				{"zzz", "zzz", "zzz"}
		};
		tableFuncionario = new JTable(dados, colunas);
	
		scrollFuncionarios = new JScrollPane(tableFuncionario);
		scrollFuncionarios.setBounds(10, 70, 500, 300);
		
		painel.add(labelTitulo);
		painel.add(scrollFuncionarios);
		tela.setVisible(true);
	}
}
