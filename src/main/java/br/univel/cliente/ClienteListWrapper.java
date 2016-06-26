package br.univel.cliente;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="clientes")
public class ClienteListWrapper {
	private List<Cliente> listaCliente;

	@XmlElement(name="cliente")
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
}
