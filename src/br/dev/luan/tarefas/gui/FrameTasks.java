package br.dev.luan.tarefas.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.luan.tarefas.dao.EmployeeDAO;
import br.dev.luan.tarefas.dao.TaskDAO;
import br.dev.luan.tarefas.model.Funcionario;
import br.dev.luan.tarefas.model.Tarefa;
import br.dev.luan.tarefas.utils.Utils;

public class FrameTasks {
	private JLabel labelCodigo;
	private JLabel labelTitulo;
	
	private JTextField txtCodigo;
	private JTextField txtTitulo;
	
	private JButton btnSalvar;
	private JButton btnSair;
	
	public FrameTasks(JFrame telaLista) {
		criarTela(telaLista);
	}
	private void criarTela(JFrame telaLista) {
		JDialog tela = new JDialog(telaLista, "", true);
		tela.setLayout(null);
		tela.setSize(400, 400);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLocationRelativeTo(telaLista);

		labelCodigo = new JLabel("Código");
		labelCodigo.setBounds(20, 20, 200, 30);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(20, 50, 200, 30);
		txtCodigo.setEnabled(false);
		
		labelTitulo = new JLabel("Titulo");
		labelTitulo.setBounds(20, 85, 200, 30);
		txtTitulo = new JTextField();
		txtTitulo.setBounds(20, 115, 200, 30);
		
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(20, 290, 100, 40);
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tarefa tarefa = new Tarefa();
				tarefa.setCodigo(Utils.genUUID());
				tarefa.setTitulo(txtTitulo.getText());
		
				TaskDAO dao = new TaskDAO(tarefa);
				dao.gravar();
				JOptionPane.showMessageDialog(
						tela, 
						txtTitulo.getText() + "Gravado com Sucesso",
						"REGISTRO BEM-SUCEDIDO",
						JOptionPane.INFORMATION_MESSAGE
						);

			}
		});
		btnSair = new JButton("Sair");
		btnSair.setBounds(130, 290, 100, 40);
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(
						tela,
						"Tem certeza que quer sair?",
						"Sair do Sistema",
						JOptionPane.YES_NO_OPTION
						);
				if (resposta == 0) {
					System.exit(0);
				}
			}
		});
		tela.add(labelCodigo);
		tela.add(txtCodigo);
		tela.add(labelTitulo);
		tela.add(txtTitulo);
		
		tela.add(btnSalvar);
		tela.add(btnSair);
		tela.setVisible(true);
	}
}
