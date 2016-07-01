package br.univel;

import static org.junit.Assert.*;

import java.io.File;

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
	public void testLerXML() {
		String xml = "listaClientes.xml";
		File arquivo = new File(xml);
		assertFalse("O arquivo esta vazio!", arquivo.length() == 0);
	}
}
