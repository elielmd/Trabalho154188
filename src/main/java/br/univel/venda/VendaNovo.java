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
	private JTextField textCodigoVenda;

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
		textCliente.setFont(new Font("Times New Roman", Font.BOLD, 15));
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
				cliente.setFrameSecundario(getVendaNovo());
				cliente.setVisible(true);
			}
		});

		lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Times New Roman", Font.BOLD, 15));

		textNomeMerc = new JTextField();
		textNomeMerc.setColumns(10);

		JButton btnProcurarProd = new JButton("Buscar");
		btnProcurarProd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnProcurarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ProdutoTela produto = new ProdutoTela();
				produto.setSize(1000, 500);
				produto.setLocationRelativeTo(null);
				produto.btnInserir.setEnabled(false);
				produto.btnAlterar.setEnabled(false);
				produto.btnExcluir.setEnabled(false);
				produto.btnExportarXML.setEnabled(false);
				produto.btnImportarXML.setEnabled(false);
				produto.btnImportarTXT.setEnabled(false);
				produto.btnImportarSER.setEnabled(false);
				produto.btnExportarSER.setEnabled(false);
				produto.setFrameSecundario(getVendaNovo());
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

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Times New Roman", Font.BOLD, 15));

		textCodigoVenda = new JTextField();
		textCodigoVenda.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout.createSequentialGroup().addContainerGap().addComponent(lblTitulo,
										GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(24).addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
										.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
														.createSequentialGroup()
														.addComponent(btnInserirProd, GroupLayout.PREFERRED_SIZE, 85,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 81,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnExcluirMerc).addGap(6))
												.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btnProcurarProd, GroupLayout.PREFERRED_SIZE, 97,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(groupLayout.createSequentialGroup().addGap(10)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(lblQtde)
																.addComponent(textQtde, GroupLayout.PREFERRED_SIZE, 66,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(lblValorVenda)))
												.addGroup(groupLayout.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblTotalVenda, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(textNomeMerc, GroupLayout.DEFAULT_SIZE, 362,
														Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED))
										.addComponent(lblProduto)
										.addComponent(btnProcurarCliente, GroupLayout.PREFERRED_SIZE, 98,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(textCliente, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(lblCodigo)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(
														textCodigoVenda, GroupLayout.PREFERRED_SIZE, 104,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(lblCliente))))
				.addGap(23)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap().addComponent(lblTitulo).addGap(22)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblCodigo).addComponent(
						textCodigoVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblCliente)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(textCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnProcurarCliente)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblProduto)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(textNomeMerc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnProcurarProd)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblQtde)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textQtde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(31).addComponent(lblValorVenda).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblTotalVenda).addGap(11))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnInserirProd)
						.addComponent(btnCancelar).addComponent(btnExcluirMerc).addComponent(btnSalvar))
				.addGap(24)));

		tblProdutos = new JTable();
		scrollPane.setViewportView(tblProdutos);
		getContentPane().setLayout(groupLayout);

		setVendaNovo(this);
		// // $hide>>$
		// montarConsulta();
		// calcularTotal();
		// // $hide<<$
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public VendaNovo getVendaNovo() {
		return vendaNovo;
	}

	public void setVendaNovo(VendaNovo vendaNovo) {
		this.vendaNovo = vendaNovo;
	}

	private void montarConsulta() {
		VendaProdutoModel modelo = new VendaProdutoModel(mercadoria);
		tblProdutos.setModel(modelo);
	}

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
	public Cliente getClienteAtual() {
		return cliente;
	}

	public void setClienteAtual(Cliente clienteAtual) {
		this.cliente = clienteAtual;
	}

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

	public void carregarDados(int codigo){
	
	 VendaDao venCon = new VendaDao();
	 try {
		 venCon.setCon(new ConexaoBD().abrirConexao());
	 } catch (SQLException e1) {
	 // TODO Auto-generated catch block
	 e1.printStackTrace();
	 }
	
	 Venda venda = venCon.buscar(codigo);
	 mercadoria.clear();
	 mercadoria = venda.getMercadoria();
	
	
	 setClienteAtual(venda.getCliente());
	 textCliente.setText(cliente.getNome());
	 setCodigoVenda(venda.getIdVenda());
	 montarConsulta();
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				VendaNovo principal = new VendaNovo();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
				principal.setSize(430, 500);
			}
		});
	}
}
