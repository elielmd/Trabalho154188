package br.univel.venda;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="vendas")
public class VendaListWrapper {
	
	private List<Venda> listaVenda;

	@XmlElement(name="venda")
	public List<Venda> getListaVenda() {
		return listaVenda;
	}

	public void setListaVenda(List<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}
}
