package br.univel.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.ConexaoBD;
import br.univel.ExportaArqXML;
import br.univel.ExportaSerializador;
import br.univel.LerArquivoTXT;
import br.univel.MenuOpcoes;
import br.univel.venda.VendaNovo;

public class ProdutoTela extends MenuOpcoes {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1788178573385856435L;
	private List<Produto> lista = new ArrayList<Produto>();
	private ExportaArqXML<ProdutoListWrapper> proXml = new ExportaArqXML<ProdutoListWrapper>();
	private ExportaSerializador<List<Produto>> serDat = new ExportaSerializador<List<Produto>>();
	private ProdutoDao proCon = new ProdutoDao();
	private VendaNovo frameSecundario;

	public ProdutoTela() {
		setAutoRequestFocus(false);

		ConexaoBD conectaBanco = new ConexaoBD();

		try {
			proCon.setCon(conectaBanco.abrirConexao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		btnImportarTXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LerArquivoTXT arqTxt = new LerArquivoTXT();
				ProdutoParser parserProduto = new ProdutoParser();

				lista = parserProduto.getProduto(arqTxt.lerArquivo("listaProdutos.txt"));
				for (Produto cli : lista) {
					if (proCon.buscar(cli.getId()).getId() > 0) {
						proCon.atualizar(cli);
					} else {
						proCon.salvar(cli);
					}
				}
				ProdutoModel modelo = new ProdutoModel(lista);
				table.setModel(modelo);
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (frameSecundario != null) {
					frameSecundario.textCliente
							.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 1));
					table.getModel().getValueAt(table.getSelectedRow(), 1);
					int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
					frameSecundario.setProduto(proCon.buscar(id));
					dispose();
				}
			}
		});

		// proCon.criarTabela(new Produto());

		btnAtualizaTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista = proCon.listarTodos();
				ProdutoModel modelo = new ProdutoModel(lista);
				table.setModel(modelo);
			}
		});

		btnExportarXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ProdutoListWrapper pro = new ProdutoListWrapper();
				pro.setListaProduto(lista);
				proXml.ExportarXml(pro, new File("listaProdutos.xml"));
				JOptionPane.showMessageDialog(null, "Arquivo exportado!");
			}
		});

		btnImportarXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoListWrapper pro = new ProdutoListWrapper();
				pro = proXml.ImportarXml(pro, new File("listaProdutos.xml"));
				lista.clear();
				lista = pro.getListaProduto();
				for (Produto cli : lista) {
					if (proCon.buscar(cli.getId()).getId() > 0) {
						proCon.atualizar(cli);
					} else {
						proCon.salvar(cli);
					}
				}
				ProdutoModel modelo = new ProdutoModel(lista);
				table.setModel(modelo);
				JOptionPane.showMessageDialog(null, "Arquivo importado!");
			}
		});

		btnExportarSER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					serDat.ExportaSerializable(lista, new File("listaProdutos.dat"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Arquivo listaProdutos.dat exportado!");

			}
		});

		btnImportarSER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lista.clear();
				try {
					lista = serDat.ImportaSerializable(new File("listaProdutos.dat"));
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
				ProdutoModel modelo = new ProdutoModel(lista);
				table.setModel(modelo);
				JOptionPane.showMessageDialog(null, "Arquivo importado!");

			}
		});

		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum produto para ser alterado.");
				} else {
					if (table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Selecione um produto.");
					} else {
						ProdutoNovo AltProduto = new ProdutoNovo();
						AltProduto.setSize(445, 380);
						AltProduto.setLocationRelativeTo(null);
						AltProduto.lblTitulo.setText("Alterar Produto");
						AltProduto.setOpcaoCrud(true);
						AltProduto.setVisible(true);
						ProdutoNovo.buscaDados((int) table.getModel().getValueAt(table.getSelectedRow(), 0));
					}
				}

			}
		});

		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoNovo NewProduto = new ProdutoNovo();
				NewProduto.setSize(445, 380);
				NewProduto.setLocationRelativeTo(null);
				NewProduto.lblTitulo.setText("Novo Produto");
				NewProduto.setVisible(true);
				lista = proCon.listarTodos();
				ProdutoModel modelo = new ProdutoModel(lista);
				table.setModel(modelo);
			}
		});

		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum cliente selecionado!");
				} else {
					if (table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Selecione um cliente!");
					} else {
						int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o produto ?", "excluir",
								JOptionPane.YES_NO_OPTION);
						if (resposta == 0) {
							int codigo = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
							proCon.excluir(codigo);
							ProdutoModel modelo = new ProdutoModel(lista);
							table.setModel(modelo);
						}
					}
				}
			}
		});

	}
	
	public VendaNovo getFrameSecundario() {
		return frameSecundario;
	}

	public void setFrameSecundario(VendaNovo frameSecundario) {
		this.frameSecundario = frameSecundario;
	} 
}
