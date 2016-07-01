package br.univel.venda;

import java.awt.EventQueue;
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
import br.univel.MenuOpcoes;

public class VendaTela extends MenuOpcoes {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1788178573385856435L;
	private List<Venda> lista = new ArrayList<Venda>();
	private ExportaArqXML<VendaListWrapper> venXml = new ExportaArqXML<VendaListWrapper>();
	private ExportaSerializador<List<Venda>> serDat = new ExportaSerializador<List<Venda>>();
	private VendaDao venCon = new VendaDao();

	public VendaTela() {

		setAutoRequestFocus(false);

		ConexaoBD conectaBanco = new ConexaoBD();

		try {
			venCon.setCon(conectaBanco.abrirConexao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.getModel().getValueAt(table.getSelectedRow(), 1);
				int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
				venCon.buscar(id);
			}
		});
		
		//venCon.criarTabela(new Venda());
		
//		DaoVendaProduto vp = new DaoVendaProduto();
//
//		try {
//			vp.setCon(conectaBanco.abrirConexao());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}			
//
//		vp.criarTabela(new VendaProduto());
		
		btnImportarTXT.setVisible(false);
		btnAtualizaTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista = venCon.listarTodos();
				VendaModel modelo = new VendaModel(lista);
				table.setModel(modelo);
			}
		});

		btnExportarXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VendaListWrapper ven = new VendaListWrapper();
				ven.setListaVenda(lista);
				venXml.ExportarXml(ven, new File("listaVendas.xml"));
				JOptionPane.showMessageDialog(null, "Arquivo exportado!");
			}
		});

		btnImportarXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendaListWrapper ven = new VendaListWrapper();
				ven = venXml.ImportarXml(ven, new File("listaVendas.xml"));
				lista.clear();
				lista = ven.getListaVenda();
				for (Venda cli : lista) {
					if (venCon.buscar(cli.getIdVenda()).getIdVenda() > 0) {
						venCon.atualizar(cli);
					} else {
						venCon.salvar(cli);
					}
				}
				VendaModel modelo = new VendaModel(lista);
				table.setModel(modelo);
				JOptionPane.showMessageDialog(null, "Arquivo importado!");
			}
		});

		btnExportarSER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					serDat.ExportaSerializable(lista, new File("listaVendas.dat"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Arquivo listaVendas.dat exportado!");

			}
		});

		btnImportarSER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lista.clear();
				try {
					lista = serDat.ImportaSerializable(new File("listaVendas.dat"));
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
				VendaModel modelo = new VendaModel(lista);
				table.setModel(modelo);
				JOptionPane.showMessageDialog(null, "Arquivo importado!");

			}
		});

		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhuma venda para ser alterada.");
				} else {
					if (table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Selecione um Venda.");
					} else {
						VendaNovo AltVenda = new VendaNovo();
						AltVenda.setSize(430, 500);
						AltVenda.setLocationRelativeTo(null);
						AltVenda.lblTitulo.setText("Alterar Venda");
						AltVenda.setVisible(true);
						//VendaNovo.buscaDados((int) table.getModel().getValueAt(table.getSelectedRow(), 0));
					}
				}

			}
		});

		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendaNovo NewVenda = new VendaNovo();
				NewVenda.setSize(430, 500);
				NewVenda.setLocationRelativeTo(null);
				NewVenda.lblTitulo.setText("Nova Venda");
				NewVenda.setVisible(true);
				lista = venCon.listarTodos();
				VendaModel modelo = new VendaModel(lista);
				table.setModel(modelo);
			}
		});

		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhuma venda selecionado!");
				} else {
					if (table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Selecione uma venda!");
					} else {
						int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o Venda ?");
						if (resposta == 0) {
							int codigo = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
							venCon.excluir(codigo);
							VendaModel modelo = new VendaModel(lista);
							table.setModel(modelo);
						}
					}
				}
			}
		});

	}
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				VendaTela principal = new VendaTela();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
				principal.setSize(910, 510);
			}
		});
	}
}
