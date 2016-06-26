package br.univel.produto;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class ProdutoNovo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 772046454694497130L;
	public GroupLayout groupLayout;
	public JButton btnSalvar;
	public JButton btnCancelar;
	public JLabel lblTitulo;
	private JTextField txtDescricao;
	private JTextField txtPreco;

	public ProdutoNovo() {
		setBounds(100, 100, 400, 220);
		setTitle("Cadastro de Produto");

		btnSalvar = new JButton("Salvar");

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		lblTitulo = new JLabel("Novo Produto");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lblDescricao = new JLabel("Descricao:");
		lblDescricao.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);

		JLabel lblPreco = new JLabel("Preco Unitario:");
		lblPreco.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblDescricao)
						.addComponent(lblPreco)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(btnCancelar))
						.addComponent(txtDescricao, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
						.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitulo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDescricao)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPreco)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap(169, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				ProdutoNovo principal = new ProdutoNovo();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
			}
		});
	}
}