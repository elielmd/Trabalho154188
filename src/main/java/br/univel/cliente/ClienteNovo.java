package br.univel.cliente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.univel.ConexaoBD;

public class ClienteNovo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 772046454694497130L;
	public GroupLayout groupLayout;
	public JButton btnSalvar;
	public JButton btnCancelar;
	public JLabel lblTitulo;
	private static JTextField txtnome;
	private static JTextField txtendereco;
	private static JTextField txtnumero;
	private static JTextField txtcomplemento;
	private static JTextField txtbairro;
	private static JTextField txtcep;
	private static JTextField txttelefone;
	private static JTextField txtcelular;
	private static JTextField txtCidade;
	private static JTextField txtEstado;
	private static JTextField txtCodigo;

	public ClienteNovo() {
		setBounds(100, 100, 445, 370);
		setTitle("Cadastro de Cliente");

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cli = new Cliente();

				ClienteDao conCli = new ClienteDao();
				try {
					conCli.setCon(new ConexaoBD().abrirConexao());
					System.err.println(conCli);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				cli.setId(Integer.parseInt(txtCodigo.getText()));
				cli.setNome(txtnome.getText());
				cli.setEndereco(txtendereco.getText());
				cli.setNumero(txtnumero.getText());
				cli.setComplemento(txtcomplemento.getText());
				cli.setBairro(txtbairro.getText());
				cli.setCidade(txtCidade.getText());
				cli.setEstado(txtEstado.getText());
				cli.setCep(txtcep.getText());
				cli.setCelular(txtcelular.getText());
				cli.setTelefone(txttelefone.getText());

				/*
				 * cli.setId(1); cli.setNome("BATATA");
				 * cli.setEndereco("BATATA"); cli.setNumero("BATATA");
				 * cli.setComplemento("BATATA"); cli.setBairro("BATATA");
				 * cli.setCidade("BATATA"); cli.setEstado("BATATA");
				 * cli.setCelular("BATATA"); cli.setCep("BATATA");
				 * cli.setTelefone("BATATA"); cli.setCelular("BATATA");
				 * 
				 * System.out.println(cli.getId());
				 * System.out.println(cli.getNome());
				 */
				conCli.salvar(cli);
				JOptionPane.showMessageDialog(null, "Cliente Cadastrado");

				dispose();
			}
		});

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

		txtCidade = new JTextField();
		txtCidade.setColumns(10);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
								groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
												.createSequentialGroup().addGroup(groupLayout
														.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(lblTitulo, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
																.addGap(227)
																.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 93,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(btnCancelar)))
												.addContainerGap(162, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.TRAILING)
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
																		.addComponent(lblCelular).addPreferredGap(
																				ComponentPlacement.RELATED, 90,
																				Short.MAX_VALUE))
																.addComponent(txtcelular,
																		GroupLayout.DEFAULT_SIZE, 141,
																		Short.MAX_VALUE)))
												.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
														.addComponent(txtbairro, GroupLayout.PREFERRED_SIZE, 217,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lblBairro)
																		.addPreferredGap(ComponentPlacement.RELATED,
																				130, Short.MAX_VALUE))
																.addComponent(txtcomplemento, GroupLayout.DEFAULT_SIZE,
																		174, Short.MAX_VALUE)))
												.addComponent(lblComplemento, Alignment.LEADING)
												.addGroup(Alignment.LEADING,
														groupLayout.createSequentialGroup().addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(txtendereco, GroupLayout.DEFAULT_SIZE,
																		277, Short.MAX_VALUE)
																.addComponent(lblEndereco))
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(txtnumero,
																				GroupLayout.DEFAULT_SIZE, 114,
																				Short.MAX_VALUE)
																		.addComponent(lblNumero)))
												.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblCidade).addComponent(txtCidade,
																		GroupLayout.PREFERRED_SIZE, 217,
																		GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING, false)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lblEstado).addGap(129))
																.addComponent(txtEstado)))
												.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(lblCodigo))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblNome).addComponent(txtnome,
																		GroupLayout.DEFAULT_SIZE, 305,
																		Short.MAX_VALUE))))
												.addGap(166)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblTitulo)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblCodigo)
								.addComponent(lblNome))
						.addGap(6)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtnome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblEndereco)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtendereco,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblNumero)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtnumero,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblComplemento)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtbairro,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
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
								.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
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
						.addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnSalvar)
								.addComponent(btnCancelar))
						.addGap(67)));
		getContentPane().setLayout(groupLayout);

	}

	public static void buscaDados(int id) {

		ClienteDao cliCon = new ClienteDao();
		try {
			cliCon.setCon(new ConexaoBD().abrirConexao());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Cliente cli = cliCon.buscar(id);

		txtCodigo.setText(Integer.toString(cli.getId()));
		txtnome.setText(cli.getNome());
		txtendereco.setText(cli.getEndereco());
		txtnumero.setText(cli.getNumero());
		txtcomplemento.setText(cli.getComplemento());
		txtbairro.setText(cli.getBairro());
		txtCidade.setText(cli.getCidade());
		txtEstado.setText(cli.getEstado());
		txtcep.setText(cli.getCep());
		txttelefone.setText(cli.getTelefone());
		txtcelular.setText(cli.getCelular());
		

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				ClienteNovo principal = new ClienteNovo();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
			}
		});
	}
}