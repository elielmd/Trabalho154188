package br.univel.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClienteParser {

	public List<Cliente> getCliente(List<String> listaStr) {
		List<Cliente> listaPrdCliente = new ArrayList<>();

		Pattern p = Pattern.compile("[0-9]+.*");
		listaStr.forEach(e -> {

			if (!e.startsWith("----")) {
				Matcher m = p.matcher(e);
				if (m.matches()) {
					listaPrdCliente.add(getCliente(e));
				}
			}
		});
		return listaPrdCliente;
	}

	private Cliente getCliente(String str) {

		String[] itens 		= str.split(",");
		int id 				= Integer.parseInt(itens[0]);
		String nome 		= itens[1].trim();
		String endereco 	= itens[2].trim();
		String complemento  = itens[3].trim();
		String bairro 		= itens[4].trim();
		String cidade 		= itens[5].trim();
		String estado 		= itens[6].trim();
		String cep 			= itens[7];
		String telefone 	= itens[8].trim();
		String celular 		= itens[9].trim();

		Cliente cliente = new Cliente(id, nome, endereco, complemento, bairro, cidade, estado, cep, telefone, celular);

		return cliente;
	}
}
