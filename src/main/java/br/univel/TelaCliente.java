package br.univel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteModel;
import br.univel.cliente.ClienteParser;

public class TelaCliente extends MenuOpcoes {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1788178573385856435L;
	private List<Cliente> lista = new ArrayList<Cliente>();
	private ExportaArqXML<ClienteListWrapper> cliXml = new ExportaArqXML<ClienteListWrapper>();
	private ExportaSerializador<List<Cliente>> serDat = new ExportaSerializador<List<Cliente>>();

	public TelaCliente() {
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
			}
		});

		btnExportarSER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "BATATA 1!");

				/*try {
					System.out.println("BATATA");
					serDat.ExportaSerializable(lista, new File("listaClientes.dat"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/

			}
		});

		btnImportarSER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "BATATA 2!");
				/*lista.clear();
				try {
					lista = serDat.ImportaSerializable(new File("listaCliente.dat"));
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ClienteModel modelo = new ClienteModel(lista);
				table.setModel(modelo);*/

			}
		});

	}
}
