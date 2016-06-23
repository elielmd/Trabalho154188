/*package br.univel;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import br.univel.cliente.Cliente;

public class ExportaXML {

	public void GravaXML(File arq){
		
		List<Cliente> listaCliente = null;
		
		try {
			JAXBContext context = JAXBContext.newInstance(ClienteListWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			ClienteListWrapper clienteList = new ClienteListWrapper();
			clienteList.setCliente(listaCliente);

			m.marshal(clienteList, arq);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} */
