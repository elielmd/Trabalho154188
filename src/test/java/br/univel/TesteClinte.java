package br.univel;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import br.univel.cliente.TelaClienteTeste;

// gridBagiLayout
public class TesteClinte {

	// TelaCliente tCliente = new TelaCliente();

	@Test
	public void testLerXML() {
		TelaClienteTeste tCliente = new TelaClienteTeste();
		String xml = "listaCliente.xml";
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
		String dat = "listaCliente.dat";
		assertTrue("O arquivo esta vazio!", dat.length() == 0);
	}

	@Test
	public void testValidaLista() {
		fail("Not yet implemented");
	}
}
