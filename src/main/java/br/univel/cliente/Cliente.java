package br.univel.cliente;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.univel.anotacoes.Coluna;
import br.univel.anotacoes.Tabela;

//
@XmlRootElement(name = "cliente")
@XmlAccessorType(XmlAccessType.FIELD)
@Tabela("cad_cliente")
public class Cliente implements Serializable {

	@XmlElement(name = "id")
	@Coluna(pk = true, nome = "clId", tamanho = -1)
	private int id;

	@XmlElement(name = "nome")
	@Coluna(nome = "clNome", tamanho = 100)
	private String nome;

	@XmlElement(name = "endereco")
	@Coluna(nome = "clEndereco", tamanho = 255)
	private String endereco;

	@XmlElement(name = "complemento")
	@Coluna(nome = "clComplemento", tamanho = 255)
	private String complemento;

	@XmlElement(name = "bairro")
	@Coluna(nome = "clBairro", tamanho = 100)
	private String bairro;

	@XmlElement(name = "cidade")
	@Coluna(nome = "clCidade", tamanho = 100)
	private String cidade;

	@XmlElement(name = "estado")
	@Coluna(nome = "clEstado", tamanho = 100)
	private String estado;

	@XmlElement(name = "cep")
	@Coluna(nome = "clCep", tamanho = 15)
	private String cep;

	@XmlElement(name = "telefone")
	@Coluna(nome = "clTelefone", tamanho = 15)
	private String telefone;

	@XmlElement(name = "celular")
	@Coluna(nome = "clCelular", tamanho = 15)
	private String celular;

	public Cliente(int id, String nome, String endereco, String complemento, String bairro, String cidade,
			String estado, String cep, String telefone, String celular) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.telefone = telefone;
		this.celular = celular;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Cliente() {
		this(0, null, null, null, null, null, null, null, null, null);
	}

}
