package br.univel;

import java.util.ArrayList;
import java.util.List;

import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteParser;
import br.univel.produto.Produto;

public class Main {
	
	private static List<Produto> listaProduto = new ArrayList<Produto>();
	private static List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	public static void lerCliente(){
		//ArquivoReader arquivo = new ArquivoReader();
		//arquivo.lerArquivo(null).forEach(System.out::println);
	
		ArquivoReader reader = new ArquivoReader();
		List<String> lista = reader.lerArquivo("listaCliente.txt");

		/*ProdutoParser parserProduto = new ProdutoParser();
		java.util.List<Produto> listaPrd = parserProduto.getProduto(lista);*/

		ClienteParser parserCliente = new ClienteParser();
		listaCliente = parserCliente.getCliente(lista);

	/*	listaPrd.forEach(e -> {
			System.out.println("id.......: " + e.getId());
			System.out.println("Descricao: " + e.getDescricao());
			System.out.println("Preco....: " + e.getPreco());
		}); */
		
		listaCliente.forEach(e -> {
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
	
	public static void main(String[] args) {		
		lerCliente();
	}
}
