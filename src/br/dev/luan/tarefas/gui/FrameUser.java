package br.dev.luan.tarefas.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.luan.tarefas.dao.FuncionarioDAO;
import br.dev.luan.tarefas.model.Funcionario;
import br.dev.luan.tarefas.utils.Utils;

public class FrameUser {
	private JLabel labelCodigo;
	private JLabel labelName;
	private JLabel labelTelefone;
	private JLabel labelEmail;
	
	private JTextField txtCodigo;
	private JTextField txtName;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	
	private JButton btnSalvar;
	private JButton btnSair;
	
	public FrameUser() {
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame();
		
		tela.setLayout(null);
		tela.setSize(400, 400);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		labelCodigo = new JLabel("Código");
		labelCodigo.setBounds(20, 20, 200, 30);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(20, 50, 200, 30);
		txtCodigo.setEnabled(false);
		
		labelName = new JLabel("Nome");
		labelName.setBounds(20, 85, 200, 30);
		txtName = new JTextField();
		txtName.setBounds(20, 115, 200, 30);
		
		labelTelefone = new JLabel("Telefone");
		labelTelefone.setBounds(20, 150, 200, 30);
		txtTelefone = new JTextField();
		txtTelefone.setBounds(20, 180, 200, 30);
		
		labelEmail = new JLabel("Email");
		labelEmail.setBounds(20, 215, 300, 30);
		txtEmail = new JTextField();
		txtEmail.setBounds(20, 245, 300, 30);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(20, 290, 100, 40);
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				funcionario.setCodigo(Utils.genUUID());
				funcionario.setNome(txtName.getText());
				funcionario.setEmail(txtEmail.getText());
				funcionario.setTelefone(txtTelefone.getText());
				
				FuncionarioDAO dao = new FuncionarioDAO(funcionario);
				dao.gravar();
				JOptionPane.showMessageDialog(
						tela, 
						txtName.getText() + "Gravado com Sucesso",
						"REGISTRO BEM-SUCEDIDO",
						JOptionPane.INFORMATION_MESSAGE
						);

				limparFormulario();
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
		tela.add(labelName);
		tela.add(txtName);
		tela.add(labelTelefone);
		tela.add(txtTelefone);	
		tela.add(txtTelefone);	
		tela.add(labelEmail);	
		tela.add(txtEmail);	
		tela.add(btnSalvar);
		tela.add(btnSair);
		tela.setVisible(true);
	}

	private void limparFormulario() {
		txtName.setText(null);
		txtTelefone.setText(null);
		txtEmail.setText(null);
		txtName.requestFocus();
	}
}
