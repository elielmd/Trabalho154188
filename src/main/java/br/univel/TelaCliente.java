package br.univel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteModel;
import br.univel.cliente.ClienteParser;

public class TelaCliente extends MenuOpcoes {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1788178573385856435L;
	private List<Cliente> lista = new ArrayList<Cliente>();

	public TelaCliente() {

		btnImportarTXT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LerArquivoTXT arqTxt = new LerArquivoTXT();
				ClienteParser parserCliente = new ClienteParser();

				lista = parserCliente.getCliente(arqTxt.lerArquivo("listaCliente.txt"));

				ClienteModel modelo = new ClienteModel(lista);
				table.setModel(modelo);
			}
		});

	}
}
