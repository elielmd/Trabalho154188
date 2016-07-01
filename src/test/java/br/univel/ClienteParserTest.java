package br.univel;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.univel.cliente.ClienteParser;

public class ClienteParserTest {
	
	ClienteParser cp;

	@Before
	public void setUp() throws Exception {
		cp = new ClienteParser();
	}

	@Test
	public void testGetCliente() {
		assertNotNull(cp.getCliente(new LerArquivoTXT().lerArquivo("listaClientes.txt")));
	}

}
