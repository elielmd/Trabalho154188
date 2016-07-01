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
	public JButton btnAlterar;
	public JButton btnCancelar;
	public JLabel lblTitulo;
	private static JTextField textnome;
	private static JTextField textendereco;
	private static JTextField textnumero;
	private static JTextField textcomplemento;
	private static JTextField textbairro;
	private static JTextField textcep;
	private static JTextField texttelefone;
	private static JTextField textcelular;
	private static JTextField textCidade;
	private static JTextField textEstado;
	private static JTextField textCodigo;
	private boolean opcao = false;
	
	public boolean opcaoCrud() {
		return opcao;
	}

	public void setOpcaoCrud(boolean opcao) {
		this.opcao = opcao;
	}

	public ClienteNovo() {
		setBounds(100, 100, 445, 370);
		setTitle("Cadastro de Cliente");
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Cliente cli = new Cliente();

				cli.setId(Integer.parseInt(textCodigo.getText()));
				cli.setNome(textnome.getText());
				cli.setEndereco(textendereco.getText());
				cli.setNumero(textnumero.getText());
				cli.setComplemento(textcomplemento.getText());
				cli.setBairro(textbairro.getText());
				cli.setCidade(textCidade.getText());
				cli.setEstado(textEstado.getText());
				cli.setCep(textcep.getText());
				cli.setCelular(textcelular.getText());
				cli.setTelefone(texttelefone.getText());
				

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

				ClienteDao conCli = new ClienteDao();
				try {
					conCli.setCon(new ConexaoBD().abrirConexao());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

//				conCli.atualizar(cli);
//				conCli.salvar(cli);					
				
				if(opcaoCrud()){
					conCli.atualizar(cli);
				}else{
					conCli.salvar(cli);					
				}
				
				JOptionPane.showMessageDialog(null, "Concluido com sucesso!");

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

		textnome = new JTextField();
		textnome.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Times New Roman", Font.BOLD, 14));

		textendereco = new JTextField();
		textendereco.setColumns(10);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Times New Roman", Font.BOLD, 14));

		textnumero = new JTextField();
		textnumero.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Times New Roman", Font.BOLD, 14));

		textcomplemento = new JTextField();
		textcomplemento.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Times New Roman", Font.BOLD, 14));

		textbairro = new JTextField();
		textbairro.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Times New Roman", Font.BOLD, 14));

		textcep = new JTextField();
		textcep.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Times New Roman", Font.BOLD, 14));

		texttelefone = new JTextField();
		texttelefone.setColumns(10);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Times New Roman", Font.BOLD, 14));

		textcelular = new JTextField();
		textcelular.setColumns(10);

		textCidade = new JTextField();
		textCidade.setColumns(10);

		textEstado = new JTextField();
		textEstado.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Times New Roman", Font.BOLD, 14));

		textCodigo = new JTextField();
		textCodigo.setColumns(10);

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
																.addComponent(textcep, GroupLayout.PREFERRED_SIZE, 104,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(lblCep))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblTelefone).addComponent(texttelefone,
																		GroupLayout.PREFERRED_SIZE, 136,
																		GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lblCelular).addPreferredGap(
																				ComponentPlacement.RELATED, 90,
																				Short.MAX_VALUE))
																.addComponent(textcelular,
																		GroupLayout.DEFAULT_SIZE, 141,
																		Short.MAX_VALUE)))
												.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
														.addComponent(textbairro, GroupLayout.PREFERRED_SIZE, 217,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lblBairro)
																		.addPreferredGap(ComponentPlacement.RELATED,
																				130, Short.MAX_VALUE))
																.addComponent(textcomplemento, GroupLayout.DEFAULT_SIZE,
																		174, Short.MAX_VALUE)))
												.addComponent(lblComplemento, Alignment.LEADING)
												.addGroup(Alignment.LEADING,
														groupLayout.createSequentialGroup().addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING, false)
																.addComponent(textendereco, GroupLayout.DEFAULT_SIZE,
																		277, Short.MAX_VALUE)
																.addComponent(lblEndereco))
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addGroup(groupLayout
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(textnumero,
																				GroupLayout.DEFAULT_SIZE, 114,
																				Short.MAX_VALUE)
																		.addComponent(lblNumero)))
												.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblCidade).addComponent(textCidade,
																		GroupLayout.PREFERRED_SIZE, 217,
																		GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(groupLayout
																.createParallelGroup(Alignment.LEADING, false)
																.addGroup(groupLayout.createSequentialGroup()
																		.addComponent(lblEstado).addGap(129))
																.addComponent(textEstado)))
												.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(lblCodigo))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblNome).addComponent(textnome,
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
								.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textnome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblEndereco)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textendereco,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblNumero)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textnumero,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblComplemento)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textbairro,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblBairro)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textcomplemento,
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
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textcep,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTelefone).addComponent(lblCelular))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(texttelefone, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textcelular, GroupLayout.PREFERRED_SIZE,
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

		textCodigo.setText(Integer.toString(cli.getId()));
		textnome.setText(cli.getNome());
		textendereco.setText(cli.getEndereco());
		textnumero.setText(cli.getNumero());
		textcomplemento.setText(cli.getComplemento());
		textbairro.setText(cli.getBairro());
		textCidade.setText(cli.getCidade());
		textEstado.setText(cli.getEstado());
		textcep.setText(cli.getCep());
		texttelefone.setText(cli.getTelefone());
		textcelular.setText(cli.getCelular());

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