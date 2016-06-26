package br.univel.produto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProdutoListWrapper {
	
	
	private List<Produto> listaProd;

	@XmlElement(name="produto")
	public List<Produto> getListaProd() {
		return listaProd;
	}

	public void setListaProd(List<Produto> listaProd) {
		this.listaProd = listaProd;
	}

}
