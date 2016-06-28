package br.univel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;


// gridBagiLayout
public class TesteCliente {

	// TelaCliente tCliente = new TelaCliente();

	@Test
	public void testLerXML() {
		String xml = "listaClientes.xml";
		File arquivo = new File(xml);
		assertFalse("O arquivo esta vazio!", arquivo.length() == 0);
	}

	/*
	 * @Test public void testLista() { TelaCliente tCliente = new
	 * TelaCliente(); String xml = "listaCliente.xml"; assertFalse(
	 * "A lista esta vazio!", xml.length() == 0); }
	 */

	@Test
	public void testLerArquivoSerializable() {
		String dat = "listaClientes.dat";
		assertTrue("O arquivo esta vazio!", dat.length() == 0);
	}

	@Test
	public void testValidaLista() {
		fail("Not yet implemented");
	}
}
