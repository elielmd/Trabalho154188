package br.univel.venda;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import br.univel.anotacoes.Coluna;
import br.univel.anotacoes.Tabela;
import br.univel.produto.Produto;

@SuppressWarnings("serial")
@Tabela("venda_produto")
@XmlRootElement
public class VendaProduto implements Serializable{

	@Coluna(nome="idVenda", pk=true)
	private int idVenda;

	@Coluna(nome="idProduto", pk=true)
	private Produto produto;
	
	@Coluna(nome="vpQtd")
	private float vpQtd;
	
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto mercadoria) {
		this.produto = mercadoria;
	}
	public float getVpQtd() {
		return vpQtd;
	}
	public void setVpQtd(float vpQtd) {
		this.vpQtd = vpQtd;
	}
}
