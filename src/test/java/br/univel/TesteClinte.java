package br.univel;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import br.univel.cliente.TelaCliente;

// gridBagiLayout
public class TesteClinte {

	// TelaCliente tCliente = new TelaCliente();

	@Test
	public void testLerXML() {
		TelaCliente tCliente = new TelaCliente();
		String xml = "listaCliente.xml";
		File arquivo = new File(xml);
		assertFalse("O arquivo esta vazio!", arquivo.length() == 0);
	}

	/*
	 * @Test public void testGravaXML() { TelaCliente tCliente = new
	 * TelaCliente(); String xml = "listaCliente.xml"; assertFalse(
	 * "O arquivo esta vazio!", xml.length() == 0); }
	 */

	@Test
	public void testLerArquivoSerializable() {
		String dat = "listaCliente.dat";
		assertFalse("O arquivo esta vazio!", dat.length() == 0);
	}

	@Test
	public void testGravarSerializacao() {
		fail("Not yet implemented");
	}

	@Test
	public void testLerSerializacao() {
		fail("Not yet implemented");
	}

}
