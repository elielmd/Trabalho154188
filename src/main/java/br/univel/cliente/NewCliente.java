package br.univel.cliente;

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

public class NewCliente extends JFrame {
	public GroupLayout groupLayout;
	public JButton btnSalvar;
	public JButton btnCancelar;
	public JLabel lblTitulo;
	private JTextField txtnome;
	private JTextField txtendereco;
	private JTextField txtnumero;
	private JTextField txtcomplemento;
	private JTextField txtbairro;
	private JTextField txtcep;
	private JTextField txttelefone;
	private JTextField txtcelular;
	private JTextField textCidade;
	private JTextField textEstado;

	public NewCliente() {
		setBounds(100, 100, 445, 380);
		setTitle("Cadastro de Cliente");

		btnSalvar = new JButton("Salvar");

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		lblTitulo = new JLabel("Novo Cliente");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtnome = new JTextField();
		txtnome.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtendereco = new JTextField();
		txtendereco.setColumns(10);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtnumero = new JTextField();
		txtnumero.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtcomplemento = new JTextField();
		txtcomplemento.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtbairro = new JTextField();
		txtbairro.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtcep = new JTextField();
		txtcep.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txttelefone = new JTextField();
		txttelefone.setColumns(10);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtcelular = new JTextField();
		txtcelular.setColumns(10);

		textCidade = new JTextField();
		textCidade.setColumns(10);

		textEstado = new JTextField();
		textEstado.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Times New Roman", Font.BOLD, 14));
		groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 93,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnCancelar))
										.addComponent(lblTitulo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401,
												Short.MAX_VALUE)
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(txtcep, GroupLayout.PREFERRED_SIZE, 104,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblCep))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblTelefone).addComponent(txttelefone,
																GroupLayout.PREFERRED_SIZE, 136,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(lblCelular)
																.addPreferredGap(ComponentPlacement.RELATED, 90,
																		Short.MAX_VALUE))
														.addComponent(txtcelular, GroupLayout.DEFAULT_SIZE, 141,
																Short.MAX_VALUE)))
										.addGroup(Alignment.LEADING,
												groupLayout.createSequentialGroup()
														.addComponent(txtbairro, GroupLayout.PREFERRED_SIZE, 217,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lblBairro).addPreferredGap(
																				ComponentPlacement.RELATED, 130,
																				Short.MAX_VALUE))
																.addComponent(txtcomplemento, GroupLayout.DEFAULT_SIZE,
																		174, Short.MAX_VALUE)))
										.addComponent(lblComplemento, Alignment.LEADING)
										.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(txtendereco, GroupLayout.DEFAULT_SIZE, 277,
																Short.MAX_VALUE)
														.addComponent(lblEndereco).addComponent(lblNome))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(txtnumero, GroupLayout.DEFAULT_SIZE, 114,
																Short.MAX_VALUE)
														.addComponent(lblNumero)))
										.addGroup(Alignment.LEADING,
												groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblCidade)
																.addComponent(textCidade, GroupLayout.PREFERRED_SIZE,
																		217, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING, false)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lblEstado).addGap(129))
																.addComponent(textEstado)))
										.addComponent(txtnome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 401,
												Short.MAX_VALUE))
								.addGap(166)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblTitulo)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNome)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtnome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblEndereco)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtendereco,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNumero).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtnumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblComplemento)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(
												txtbairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblBairro)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtcomplemento,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblCidade)
								.addComponent(lblEstado))
						.addGap(7)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblCep)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtcep,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTelefone).addComponent(lblCelular))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(txttelefone, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtcelular, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancelar).addComponent(btnSalvar))
						.addGap(60)));
		getContentPane().setLayout(groupLayout);

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				NewCliente principal = new NewCliente();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
			}
		});
	}
}