package br.univel;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.univel.cliente.Cliente;

@XmlRootElement(name = "Clientes")
public class ClienteListWrapper {
	private List<Cliente> cliente;

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}
}
