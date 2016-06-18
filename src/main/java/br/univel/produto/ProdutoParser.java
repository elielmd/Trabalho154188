package br.univel.produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProdutoParser {

	public List<Produto> getProduto(List<String> listaStr) {

		List<Produto> listaPrd = new ArrayList<>();

		Pattern p = Pattern.compile("[0-9]+.*");

		listaStr.forEach(e -> {
			if (!e.startsWith("-----")) {
				Matcher m = p.matcher(e);
				if (m.matches()) {
					listaPrd.add(getProduto(e));
				}
			}
		});
		return listaPrd;

	}

	private Produto getProduto(String str) {
		// importar de arquivo CSV
//		String[] itens = str.split(" ");
//		int id = Integer.parseInt(itens[0]);                                 
//		String descricao = itens[1];
//		BigDecimal preco = new BigDecimal(itens[2].replaceAll(",", ","));
		
		int id = Integer.parseInt(str.substring(0,str.indexOf(' ')));
		String descricao = null;
		BigDecimal preco = null;
		Produto p = new Produto(id, descricao, preco);
		return p;
	}
}