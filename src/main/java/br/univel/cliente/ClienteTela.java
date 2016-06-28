package br.univel.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class ClienteTela extends MenuOpcoes {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1788178573385856435L;
	private List<Cliente> lista = new ArrayList<Cliente>();
	private ExportaArqXML<ClienteListWrapper> cliXml = new ExportaArqXML<ClienteListWrapper>();
	private ExportaSerializador<List<Cliente>> serDat = new ExportaSerializador<List<Cliente>>();
	private ClienteDao cliCon = new ClienteDao();

	public ClienteTela() {
		ConexaoBD conectaBanco = new ConexaoBD();

		try {
			cliCon.setCon(conectaBanco.abrirConexao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//cliCon.criarTabela(new Cliente());

		setAutoRequestFocus(false);

		btnImportarTXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LerArquivoTXT arqTxt = new LerArquivoTXT();
				ClienteParser parserCliente = new ClienteParser();

				lista = parserCliente.getCliente(arqTxt.lerArquivo("listaCliente.txt"));

				ClienteModel modelo = new ClienteModel(lista);
				table.setModel(modelo);
			}
		});

		btnExportarXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ClienteListWrapper cli = new ClienteListWrapper();
				cli.setListaCliente(lista);
				cliXml.ExportarXml(cli, new File("listaCliente.xml"));
				JOptionPane.showMessageDialog(null, "Arquivo exportado!");
			}
		});

		btnImportarXML.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteListWrapper cli = new ClienteListWrapper();
				cli = cliXml.ImportarXml(cli, new File("listaCliente.xml"));
				lista.clear();
				lista = cli.getListaCliente();
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
				ClienteNovo AltCliente = new ClienteNovo();
				AltCliente.setSize(445, 380);
				AltCliente.setLocationRelativeTo(null);
				AltCliente.lblTitulo.setText("Alterar Cliente");
				AltCliente.setVisible(true);

			}
		});

		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteNovo NewCliente = new ClienteNovo();
				NewCliente.setSize(445, 380);
				NewCliente.setLocationRelativeTo(null);
				NewCliente.lblTitulo.setText("Novo Cliente");
				NewCliente.setVisible(true);
			}
		});

	}
}
