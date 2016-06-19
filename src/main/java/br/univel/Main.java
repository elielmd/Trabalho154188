package br.univel;

import java.awt.List;

import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteParser;
import br.univel.produto.Produto;
import br.univel.produto.ProdutoParser;

public class Main {

	public static void main(String[] args) throws Exception {

		ArquivoReader reader = new ArquivoReader();
		java.util.List<String> lista = reader.lerArquivo(null);

		/*ProdutoParser parserProduto = new ProdutoParser();
		java.util.List<Produto> listaPrd = parserProduto.getProduto(lista);*/

		ClienteParser parserCliente = new ClienteParser();
		java.util.List<Cliente> listaPrdCliente = parserCliente.getCliente(lista);

	/*	listaPrd.forEach(e -> {
			System.out.println("id.......: " + e.getId());
			System.out.println("Descricao: " + e.getDescricao());
			System.out.println("Preco....: " + e.getPreco());
		}); */
		
		listaPrdCliente.forEach(e -> {
			System.out.println("id.........: " + e.getId());
			System.out.println("Nome.......: " + e.getNome());
			System.out.println("Endereco...: " + e.getEndereco());
			System.out.println("Complemento: " + e.getComplemento());
			System.out.println("Bairro.....: " + e.getBairro());
			System.out.println("Cidade.....: " + e.getCidade());
			System.out.println("Estado.....: " + e.getEstado());
			System.out.println("Cep........: " + e.getCep());
			System.out.println("Telefone...: " + e.getTelefone());
			System.out.println("Celular....: " + e.getCelular());
			System.out.println("");
		});
		
	}
}
