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

	private List<VendaProduto> mercadoria;

	@Coluna(nome = "idVenda", pk = true)
	private int idVenda;

	@Coluna(nome = "idCliente")
	private Cliente cliente;

	public List<VendaProduto> getMercadoria() {
		return mercadoria;
	}

	public void setMercadoria(List<VendaProduto> mercadoria) {
		this.mercadoria = mercadoria;
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
