package br.univel.venda;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.univel.anotacoes.Coluna;
import br.univel.anotacoes.Tabela;
import br.univel.cliente.Cliente;

@SuppressWarnings("serial")
@Tabela("cad_venda")
@XmlRootElement
public class Venda implements Serializable {

	private List<VendaProduto> mercadorias;

	@Coluna(nome = "idVenda", pk = true)
	private int idVenda;

	@Coluna(nome = "idCliente")
	private Cliente cliente;

	public List<VendaProduto> getMercadorias() {
		return mercadorias;
	}

	public void setMercadorias(List<VendaProduto> mercadorias) {
		this.mercadorias = mercadorias;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
