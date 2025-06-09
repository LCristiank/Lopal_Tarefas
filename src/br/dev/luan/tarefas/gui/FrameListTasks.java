package br.dev.luan.tarefas.gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.Taskbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.luan.tarefas.dao.TaskDAO;
import br.dev.luan.tarefas.model.Tarefa;

public class FrameListTasks {
	private JLabel labelTitulo;
	private JTable tableTarefas;
	private JScrollPane scrollTarefas;
	DefaultTableModel modeloTabela;
	private JButton btnCadastrar;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnSair;
	private Font fontTitulo = new Font("Arial", Font.BOLD, 26);
	
	public FrameListTasks(){
		criarTela();
	}
	public void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de Tarefas");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Tarefas");
		labelTitulo.setBounds(10, 20, 350, 30);
		labelTitulo.setFont(fontTitulo);

		btnCadastrar = new JButton("Criar Tarefa");
		btnCadastrar.setBounds(10, 380, 240, 40);
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTasks(tela);
				
			}
		});
		
		String[] colunas = new String[3];
		colunas[0] = "Código";
		colunas[1] = "Titulo";
		colunas[2] = "Responsável";
		
		TaskDAO dao = new TaskDAO(null);

		List<Tarefa> tarefas = dao.showTasks();
		Object[][] dados = new Object[tarefas.size()][3];
		
		int linha = 0;
		for(Tarefa t : tarefas) {
			dados[linha][0] = t.getCodigo();
			dados[linha][1] = t.getTitulo();
			dados[linha][2] = t.getResponsavel();
			linha++;
		}
		
		tableTarefas = new JTable(dados, colunas);
		scrollTarefas = new JScrollPane(tableTarefas);
		scrollTarefas.setBounds(10, 70, 500, 300);

		modeloTabela = new DefaultTableModel();
		
		painel.add(labelTitulo);
		painel.add(btnCadastrar);
		painel.add(scrollTarefas);
		tela.setVisible(true);
	}
}
