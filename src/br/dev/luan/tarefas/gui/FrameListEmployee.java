package br.dev.luan.tarefas.gui;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.dev.luan.tarefas.dao.EmployeeDAO;
import br.dev.luan.tarefas.model.Funcionario;

public class FrameListEmployee {
	private JLabel labelTitulo;
	private JTable tableFuncionario;
	private JScrollPane scrollFuncionarios;
	private JButton btnCadastrar;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnSair;
	
	private Font fontTitulo = new Font("Arial", Font.BOLD, 26);
	
	public FrameListEmployee() {
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de Funcionarios");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Funcionarios");
		labelTitulo.setBounds(10, 20, 350, 30);
		labelTitulo.setFont(fontTitulo);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 380, 150, 40);
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameUser(tela);
				
			}
		});
		
		String[] colunas = new String[3];
		colunas[0] = "Código";
		colunas[1] = "Nome";
		colunas[2] = "Email";
		
		EmployeeDAO dao = new EmployeeDAO(null);
		
		List<Funcionario> funcionarios = dao.showEmployees();
		Object[][] dados = new Object[funcionarios.size()][3];
		
		int linha = 0;
		for (Funcionario f : funcionarios) {
			dados[linha][0] = f.getCodigo();
			dados[linha][1] = f.getNome();
			dados[linha][2] = f.getEmail();
			
			linha++;
		}
		
		tableFuncionario = new JTable(dados, colunas);
	
		scrollFuncionarios = new JScrollPane(tableFuncionario);
		scrollFuncionarios.setBounds(10, 70, 500, 300);
		
		painel.add(labelTitulo);
		painel.add(btnCadastrar);
		painel.add(scrollFuncionarios);
		tela.setVisible(true);
	}
}