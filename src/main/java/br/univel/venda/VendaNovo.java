package br.univel.venda;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import br.univel.ConexaoBD;
import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteTela;
import br.univel.produto.Produto;
import br.univel.produto.ProdutoTela;

@SuppressWarnings("serial")
public class VendaNovo extends JFrame {
	public JButton btnSalvar;
	public JButton btnCancelar;
	public JLabel lblTitulo;
	public JTextField textCliente;
	private JLabel lblCliente;
	private JTable tblProdutos;
	public JTextField textNomeMerc;
	private JTextField textQtde;
	private Produto produto;
	private Cliente cliente;
	private VendaNovo vendaNovo;
	private List<VendaProduto> mercadoria = new ArrayList<VendaProduto>();
	private JLabel lblTotalVenda;
	private boolean editando = false;
	private int codigoVenda;

	public VendaNovo() {
		setTitle("Venda");

		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (mercadoria.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe pelo um produto.");
				} else {
					Venda venda = new Venda();

					venda.setIdVenda(getCodigoVenda());
					venda.setCliente(cliente);
					venda.setMercadoria(mercadoria);

					VendaDao venCon = new VendaDao();
					try {
						venCon.setCon(new ConexaoBD().abrirConexao());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if (isEditando()) {
						venCon.atualizar(venda);
						dispose();

					} else {
						venCon.salvar(venda);
						dispose();
					}
				}
			}
		});

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		lblTitulo = new JLabel("Cadastrar Pedido");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));

		JLabel lblValorVenda = new JLabel("Total:");
		lblValorVenda.setFont(new Font("Times New Roman", Font.BOLD, 15));

		lblTotalVenda = new JLabel("0,00");
		lblTotalVenda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalVenda.setFont(new Font("Times New Roman", Font.BOLD, 15));

		textCliente = new JTextField();
		textCliente.setEditable(false);
		textCliente.setColumns(10);

		JButton btnProcurarCliente = new JButton("Buscar");
		btnProcurarCliente.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnProcurarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ClienteTela cliente = new ClienteTela();
				cliente.setSize(1000, 500);
				cliente.setLocationRelativeTo(null);
				cliente.btnInserir.setEnabled(false);
				cliente.btnAlterar.setEnabled(false);
				cliente.btnExcluir.setEnabled(false);
				cliente.btnExportarXML.setEnabled(false);
				cliente.btnImportarXML.setEnabled(false);
				cliente.btnImportarTXT.setEnabled(false);
				cliente.btnImportarSER.setEnabled(false);
				cliente.btnExportarSER.setEnabled(false);
				cliente.setVisible(true);
			}
		});

		lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Times New Roman", Font.BOLD, 15));

		textNomeMerc = new JTextField();
		textNomeMerc.setEditable(false);
		textNomeMerc.setColumns(10);

		JButton btnProcurarProd = new JButton("Buscar");
		btnProcurarProd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnProcurarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ProdutoTela produto = new ProdutoTela();
				produto.setSize(740, 460);
				produto.setLocationRelativeTo(null);
				produto.btnInserir.setEnabled(false);
				produto.btnAlterar.setEnabled(false);
				produto.btnExcluir.setEnabled(false);
				produto.btnExportarXML.setEnabled(false);
				produto.btnImportarXML.setEnabled(false);
				produto.btnImportarTXT.setEnabled(false);
				produto.btnImportarSER.setEnabled(false);
				produto.btnExportarSER.setEnabled(false);
				produto.setVisible(true);
			}
		});

		textQtde = new JTextField();
		textQtde.setText("1");
		textQtde.setColumns(10);

		JLabel lblQtde = new JLabel("Quantidade");
		lblQtde.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JButton btnInserirProd = new JButton("Inserir");
		btnInserirProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (getProduto() != null) {
					if (textQtde.getText().isEmpty() || textQtde.getText().trim() == "0") {
						JOptionPane.showMessageDialog(null, "Informe a quantidade.", "Aviso",
								JOptionPane.WARNING_MESSAGE);
					} else {

						VendaProduto merc = new VendaProduto();
						merc.setProduto(produto);
						merc.setVpQtd(Integer.parseInt(textQtde.getText()));
						merc.setIdVenda(codigoVenda);
						mercadoria.add(merc);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Escolha um produto para lançamento.", "Aviso",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnInserirProd.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JButton btnExcluirMerc = new JButton("Excluir");
		btnExcluirMerc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mercadoria.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum registro a ser excluído.", "Informação",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (tblProdutos.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Selecione um registro.", "Informação",
								JOptionPane.INFORMATION_MESSAGE);
					} else {

						int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Exclusão",
								JOptionPane.YES_NO_OPTION);

						if (opcao == 0) {
							mercadoria.remove(tblProdutos.getSelectedRow());
						}
					}
				}

			}
		});
		btnExcluirMerc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(textNomeMerc, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textCliente, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
										.addComponent(lblCliente)
										.addComponent(lblProduto)
										.addComponent(btnProcurarCliente, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnProcurarProd, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnInserirProd, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnExcluirMerc)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblQtde)
										.addComponent(lblValorVenda)
										.addComponent(textQtde, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTotalVenda, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnCancelar))
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitulo)
					.addGap(6)
					.addComponent(lblCliente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnProcurarCliente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblProduto)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textNomeMerc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(btnProcurarProd)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblQtde)
							.addGap(1)
							.addComponent(textQtde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addComponent(lblValorVenda)
							.addGap(3)
							.addComponent(lblTotalVenda)
							.addGap(21)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInserirProd)
						.addComponent(btnSalvar)
						.addComponent(btnExcluirMerc)
						.addComponent(btnCancelar))
					.addGap(24))
		);
		
		tblProdutos = new JTable();
		scrollPane.setViewportView(tblProdutos);
		getContentPane().setLayout(groupLayout);
		
//		setFormAtual(this);
//		// $hide>>$
//		montarConsulta();
//		calcularTotal();
//		// $hide<<$			
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	// public LanVendas getFormAtual() {
	// return formAtual;
	// }
	//
	// public void setFormAtual(LanVendas formAtual) {
	// this.formAtual = formAtual;
	// }
	//
	// private void montarConsulta(){
	// ModeloItemVenda modelo = new ModeloItemVenda(itens);//instancia um modelo
	// de tabela
	// tblProdutos.setModel(modelo);//seta a tabela
	// }
	//
	// private void limparProduto(){
	// setProdutoAtual(null);
	// txetQtde.setText("1");
	// txetNomeMerc.setText("");
	// }
	//
	// private void calcularTotal(){
	// BigDecimal total = new BigDecimal("0");
	//
	// for(ItemVenda iv : itens){
	// total = iv.getP().getPreco().multiply(iv.getQtde()).add(total);
	// }
	//
	// lblTotal.setText(total.toString());
	// }
	//
	// public Cliente getClienteAtual() {
	// return clienteAtual;
	// }
	//
	// public void setClienteAtual(Cliente clienteAtual) {
	// this.clienteAtual = clienteAtual;
	// }
	//
	public boolean isEditando() {
		return editando;
	}

	public void setEditando(boolean editando) {
		this.editando = editando;
	}

	//
	public int getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(int codigoVenda) {
		this.codigoVenda = codigoVenda;
	}
	//
	// public void carregarDados(int codigo){
	//
	// DaoVenda dv = new DaoVenda();
	// try {
	// dv.setCon(new Conexao().abrirConexao());
	// } catch (SQLException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	//
	// Venda v = dv.buscar(codigo);
	// itens.clear();
	// itens = v.getItens();
	//
	//
	// setClienteAtual(v.getCliente());
	// txtCliente.setText(clienteAtual.getNome());
	// setId_venda(v.getId());
	// montarConsulta();
	// calcularTotal();
	// }

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				VendaNovo principal = new VendaNovo();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
				principal.setSize(430, 480);
			}
		});
	}
}
