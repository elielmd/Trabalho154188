package br.univel.produto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.univel.anotacoes.Coluna;
import br.univel.anotacoes.Tabela;

@SuppressWarnings("serial")
@XmlRootElement(name = "produto")
@XmlAccessorType(XmlAccessType.FIELD)
@Tabela("cad_produto")
public class Produto implements Serializable{

	@XmlElement(name = "id")
	@Coluna(pk = true, nome = "pdId", tamanho = -1)
	private int id;
	
	@XmlElement(name = "descricao")
	@Coluna(nome = "pdDescricao", tamanho = 100)
	private String descricao;
	
	@XmlElement(name = "preco")
	@Coluna(nome="pdPreco")
	private BigDecimal preco;

	public Produto(int id, String descricao, BigDecimal preco) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public Produto() {
		this(0, null, null);
	}

}
