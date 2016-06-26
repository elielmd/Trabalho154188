package br.univel;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import br.univel.cliente.Cliente;

public class ClienteListWrapper {
	private List<Cliente> listaCliente;

	@XmlElement(name="clientes")
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
}
