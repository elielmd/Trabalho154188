package br.univel;

import java.io.File;

import br.univel.cliente.TelaCliente;

public class TesteClinte {

	@Test
	public void testPreencheTabela() {
		TelaCliente tCliente = new TelaCliente();
		File arquivo = new File("C:\\Users\\Eliel\\workspace\\Trabalho154188\\listaCliente.xml");

	}

	/*@Test
	public void testGravaXML() {
		TelaCliente tCliente = new TelaCliente();
		String xml = "C:\\Users\\Eliel\\workspace\\Trabalho154188\\listaCliente.xml";
		File arquivo = new File(xml);
		tCliente.GravaXML(arquivo);
		//assertFalse("D");
	}*/

	@Test
	public void testLerXML() {
		TelaCliente tCliente = new TelaCliente();
		String xml = "C:\\Users\\Eliel\\workspace\\Trabalho154188\\listaCliente.xml";
		File arquivo = new File(xml);
		assertFalse("O arquivo esta vazio!", xml.length() == 0);
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
