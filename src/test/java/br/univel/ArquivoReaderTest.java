package br.univel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArquivoReaderTest {

	LerArquivoTXT reader;
	
	@Before
	public void setUp() throws Exception {
		reader = new LerArquivoTXT();		
	}
	
	@Test
	public void testLerArquivoProd() {
		assertNotNull(reader.lerArquivo("listaProdutos.txt"));
	}

	@Test
	public void testLerArquivoCliente() {
		assertNotNull(reader.lerArquivo("listaClientes.csv"));
	}
}
