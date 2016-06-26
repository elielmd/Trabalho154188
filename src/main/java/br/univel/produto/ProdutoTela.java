package br.univel.produto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.ExportaArqXML;
import br.univel.ExportaSerializador;
import br.univel.LerArquivoTXT;
import br.univel.MenuOpcoes;

public class ProdutoTela extends MenuOpcoes {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1788178573385856435L;
	private List<Produto> lista = new ArrayList<Produto>();
	private ExportaArqXML<ProdutoListWrapper> proXml = new ExportaArqXML<ProdutoListWrapper>();
	private ExportaSerializador<List<Produto>> serDat = new ExportaSerializador<List<Produto>>();

	public ProdutoTela() {
		setAutoRequestFocus(false);

		btnImportarTXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LerArquivoTXT arqTxt = new LerArquivoTXT();
				ProdutoParser parserProduto = new ProdutoParser();

				lista = parserProduto.getProduto(arqTxt.lerArquivo("listaProdutos.txt"));

				ProdutoModel modelo = new ProdutoModel(lista);
				table.setModel(modelo);
			}
		});

		btnExportarXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ProdutoListWrapper pro = new ProdutoListWrapper();
				pro.setListaProduto(lista);
				proXml.ExportarXml(pro, new File("listaProduto.xml"));
				JOptionPane.showMessageDialog(null, "Arquivo exportado!");
			}
		});

		btnImportarXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoListWrapper pro = new ProdutoListWrapper();
				pro = proXml.ImportarXml(pro, new File("listaProduto.xml"));
				lista.clear();
				lista = pro.getListaProduto();
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
				ProdutoNovo AltProduto = new ProdutoNovo();		
				AltProduto.setSize(445, 380);
				AltProduto.setLocationRelativeTo(null); 
				AltProduto.lblTitulo.setText("Alterar Produto");
				AltProduto.setVisible(true);					
			
			}
		});
		
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoNovo NewProduto = new ProdutoNovo();		
				NewProduto.setSize(445, 380);
				NewProduto.setLocationRelativeTo(null);
				NewProduto.lblTitulo.setText("Novo Produto");
				NewProduto.setVisible(true);					
			}
		});

	}
}
