package br.univel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteListWrapper;
import br.univel.produto.Produto;
import br.univel.produto.ProdutoListWrapper;
import br.univel.venda.Venda;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteImpExpXML {
	static Cliente c1, c2;
	static Produto p1, p2;
	static Venda v1, v2;  
		
	static ExportaArqXML<Cliente> XMLCliente;	
	static ExportaArqXML<Produto> XMLProduto;	
	static ExportaArqXML<ClienteListWrapper> XMLListaCliente;	
	static ExportaArqXML<ProdutoListWrapper> XMLListaProduto;	
	
	static List<Cliente> listaClientes;
	static List<Produto> listaProdutos;	
	
	static ClienteListWrapper lc;
	static ProdutoListWrapper lp;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		c1 = new Cliente();
		c2 = new Cliente();
		
		p1 = new Produto();
		p2 = new Produto();	
		
		XMLCliente      = new ExportaArqXML<Cliente>();
		XMLListaCliente = new ExportaArqXML<ClienteListWrapper>();
		XMLProduto      = new ExportaArqXML<Produto>();
		XMLListaProduto = new ExportaArqXML<ProdutoListWrapper>();

		listaClientes  = new ArrayList<Cliente>();
		listaProdutos  = new ArrayList<Produto>();
		
		lc			   = new ClienteListWrapper();
		lp             = new ProdutoListWrapper();	
		
		c1.setId(1);
		c1.setNome("Eliel");
		c1.setEndereco("Rua Grecia");
		c1.setNumero("1046");
		c1.setBairro("Jardim Italia");
		c1.setCep("85818330");
		c1.setCelular("98298779");
		c1.setTelefone("33282906");
		c1.setCidade("Cascavel");
		c1.setEstado("PR");
		c1.setComplemento("TESTE");
		
		listaClientes.add(c1);
		lc.setListaCliente(listaClientes);		
		
		p1.setId(1);
		p1.setDescricao("Coca Cola");
		p1.setPreco(new BigDecimal(5.5));
		
		listaProdutos.add(p1);
		lp.setListaProduto(listaProdutos);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		c1 		        = null;
		p1              = null;
		
		XMLCliente      = null;
		XMLListaCliente = null;
		XMLProduto      = null;
		XMLListaProduto = null;
		
		listaClientes   = null;
		listaProdutos   = null;
	}

	
	@Test
	public void testExportarXmlCliente() {
		assertEquals(true, XMLCliente.ExportarXml(c1, new File("clientes.xml")));
	}
	
	@Test
	public void testExportarXmlProduto() {
		assertEquals(true, XMLProduto.ExportarXml(p1, new File("produtos.xml")));
	}

	@Test
	public void testExportarXmlListaCliente() {
		assertEquals(true, XMLListaCliente.ExportarXml(lc, new File("clienteslista.xml")));
	}	
	
	@Test
	public void testExportarXmlListaProduto() {
		assertEquals(true, XMLListaProduto.ExportarXml(lp, new File("produtoslista.xml")));
	}
	
	@Test
	public void testImportarXmlCliente() {
		assertNotNull(XMLCliente.ImportarXml(c1,  new File("clientes.xml")));
	}
	
	@Test
	public void testImportarXmlProduto() {
		assertNotNull(XMLProduto.ImportarXml(p1,  new File("produtos.xml")));
	}	
	
	@Test
	public void testImportarXmlListaCliente() {
		assertNotNull(XMLListaCliente.ImportarXml(lc,  new File("clienteslista.xml")));
	}
	
	@Test
	public void testImportarXmlListaProduto() {
		assertNotNull(XMLListaProduto.ImportarXml(lp,  new File("produtoslista.xml")));
	}	

}
