package br.univel.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.univel.ConexaoBD;
import br.univel.ExportaArqXML;
import br.univel.ExportaSerializador;
import br.univel.LerArquivoTXT;
import br.univel.MenuOpcoes;
import br.univel.venda.VendaNovo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ClienteTela extends MenuOpcoes {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1788178573385856435L;
	private List<Cliente> lista = new ArrayList<Cliente>();
	private ExportaArqXML<ClienteListWrapper> cliXml = new ExportaArqXML<ClienteListWrapper>();
	private ExportaSerializador<List<Cliente>> serDat = new ExportaSerializador<List<Cliente>>();
	private ClienteDao cliCon = new ClienteDao();
	private VendaNovo frameSecundario;

	public ClienteTela() {
		ConexaoBD conectaBanco = new ConexaoBD();

		try {
			cliCon.setCon(conectaBanco.abrirConexao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		btnAtualizaTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista = cliCon.listarTodos();
				ClienteModel modelo = new ClienteModel(lista);
				table.setModel(modelo);
			}
		});

		btnRelatorioCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					relatorioCliente();
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frameSecundario != null){
					frameSecundario.textCliente.setText((String) table.getModel().getValueAt(table.getSelectedRow(), 1));
				table.getModel().getValueAt(table.getSelectedRow(), 1);
				int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
				frameSecundario.setClienteAtual(cliCon.buscar(id));
				dispose();
				}			
			}
		});

		// cliCon.criarTabela(new Cliente());

		setAutoRequestFocus(false);

		btnImportarTXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LerArquivoTXT arqTxt = new LerArquivoTXT();
				ClienteParser parserCliente = new ClienteParser();

				lista = parserCliente.getCliente(arqTxt.lerArquivo("listaClientes.txt"));
				for (Cliente cli : lista) {
					if (cliCon.buscar(cli.getId()).getId() > 0) {
						cliCon.atualizar(cli);
					} else {
						cliCon.salvar(cli);
					}
				}
				ClienteModel modelo = new ClienteModel(lista);
				table.setModel(modelo);
			}
		});

		btnExportarXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ClienteListWrapper cli = new ClienteListWrapper();
				cli.setListaCliente(lista);
				cliXml.ExportarXml(cli, new File("listaClientes.xml"));
				JOptionPane.showMessageDialog(null, "Arquivo exportado!");
			}
		});

		btnImportarXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteListWrapper cli = new ClienteListWrapper();
				cli = cliXml.ImportarXml(cli, new File("listaClientes.xml"));
				lista.clear();
				lista = cli.getListaCliente();
				for (Cliente cliente : lista) {
					if (cliCon.buscar(cliente.getId()).getId() > 0) {
						cliCon.atualizar(cliente);
					} else {
						cliCon.salvar(cliente);
					}
				}
				ClienteModel modelo = new ClienteModel(lista);
				table.setModel(modelo);
				JOptionPane.showMessageDialog(null, "Arquivo importado!");
			}
		});

		btnExportarSER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					serDat.ExportaSerializable(lista, new File("listaClientes.dat"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Arquivo listaClientes.dat exportado!");

			}
		});

		btnImportarSER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lista.clear();
				try {
					lista = serDat.ImportaSerializable(new File("listaClientes.dat"));
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
				ClienteModel modelo = new ClienteModel(lista);
				table.setModel(modelo);
				JOptionPane.showMessageDialog(null, "Arquivo importado!");

			}
		});

		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhum cliente para ser alterado.");
				} else {
					if (table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Selecione um cliente.");
					} else {
						ClienteNovo AltCliente = new ClienteNovo();
						AltCliente.setSize(445, 380);
						AltCliente.setLocationRelativeTo(null);
						AltCliente.lblTitulo.setText("Alterar Cliente");
						AltCliente.setOpcaoCrud(true);
						AltCliente.setVisible(true);
						ClienteNovo.buscaDados((int) table.getModel().getValueAt(table.getSelectedRow(), 0));
					}
				}
			}
		});

		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteNovo NewCliente = new ClienteNovo();
				NewCliente.setSize(445, 380);
				NewCliente.setLocationRelativeTo(null);
				NewCliente.lblTitulo.setText("Novo Cliente");
				NewCliente.setVisible(true);
				lista = cliCon.listarTodos();
				ClienteModel modelo = new ClienteModel(lista);
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
						int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente ?", "excluir",
								JOptionPane.YES_NO_OPTION);
						if (resposta == 0) {
							int codigo = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
							cliCon.excluir(codigo);
							ClienteModel modelo = new ClienteModel(lista);
							table.setModel(modelo);
						}
					}
				}
			}
		});
	}

	protected void relatorioCliente() throws JRException {
		String arq = "RelaCli_A4.jrxml";

		ClienteDao cliCon = new ClienteDao();
		try {
			cliCon.setCon(new ConexaoBD().abrirConexao());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ClienteJRDataSource cRelatorio = new ClienteJRDataSource(cliCon.listarTodos());
		System.out.println(cRelatorio);
		HashMap treta = new HashMap();
		JasperPrint jp;
		jp = JasperFillManager.fillReport(arq, treta, cRelatorio);

		JasperViewer jasperViewer = new JasperViewer(jp);
		jasperViewer.setBounds(50, 50, 320, 240);
		jasperViewer.setLocationRelativeTo(null);
		jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jasperViewer.setVisible(true);

	}
	
	public VendaNovo getFrameSecundario() {
		return frameSecundario;
	}

	public void setFrameSecundario(VendaNovo frameSecundario) {
		this.frameSecundario = frameSecundario;
	} 
}
