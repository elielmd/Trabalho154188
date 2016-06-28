package br.univel.produto;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.univel.ConexaoBD;

public class ProdutoNovo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 772046454694497130L;
	public GroupLayout groupLayout;
	public JButton btnSalvar;
	public JButton btnCancelar;
	public JLabel lblTitulo;
	private static JTextField textDescricao;
	private static JTextField textPreco;
	private static JTextField textId;

	public ProdutoNovo() {
		setBounds(100, 100, 400, 280);
		setTitle("Cadastro de Produto");

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto pro = new Produto();
				pro.setId(Integer.parseInt(textId.getText()));
				pro.setDescricao(textDescricao.getText());
				pro.setPreco(new BigDecimal(textPreco.getText()));

				ProdutoDao conPro = new ProdutoDao();
				try {
					conPro.setCon(new ConexaoBD().abrirConexao());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				conPro.atualizar(pro);
				dispose();
			}
		});

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

		textDescricao = new JTextField();
		textDescricao.setColumns(10);

		JLabel lblPreco = new JLabel("Preco Unitario:");
		lblPreco.setFont(new Font("Times New Roman", Font.BOLD, 14));

		textPreco = new JTextField();
		textPreco.setColumns(10);

		textId = new JTextField();
		textId.setColumns(10);

		JLabel lblID = new JLabel("C\u00F3digo:");
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 14));
		groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 364,
																Short.MAX_VALUE)
														.addContainerGap())
												.addGroup(Alignment.TRAILING,
														groupLayout.createSequentialGroup()
																.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 93,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnCancelar).addGap(8))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(textPreco, GroupLayout.PREFERRED_SIZE, 184,
																GroupLayout.PREFERRED_SIZE)
														.addContainerGap(190, Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup().addComponent(lblPreco)
														.addContainerGap(281, Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(textDescricao, GroupLayout.DEFAULT_SIZE, 365,
																Short.MAX_VALUE)
														.addContainerGap())
												.addGroup(groupLayout.createSequentialGroup().addComponent(lblDescricao)
														.addContainerGap(310, Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(textId, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addContainerGap(288, Short.MAX_VALUE))
												.addGroup(groupLayout.createSequentialGroup().addComponent(lblID)
														.addContainerGap(328, Short.MAX_VALUE)))));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addContainerGap().addComponent(lblTitulo)
												.addGap(18).addComponent(lblID).addGap(5)
												.addComponent(textId, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblDescricao)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textDescricao, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblPreco)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textPreco, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnSalvar).addComponent(btnCancelar))
												.addContainerGap()));
		getContentPane().setLayout(groupLayout);

	}
	
	public static void buscaDados(int id) {

		ProdutoDao cliPro = new ProdutoDao();
		try {
			cliPro.setCon(new ConexaoBD().abrirConexao());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Produto pro = cliPro.buscar(id);

		textId.setText(Integer.toString(pro.getId()));
		textDescricao.setText(pro.getDescricao());
		textPreco.setText(pro.getPreco().toString());


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