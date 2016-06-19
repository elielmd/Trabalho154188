package br.univel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.transform.stream.StreamResult;

import br.univel.cliente.Cliente;

public class TesteGravacao {

	public static void main(String[] args) throws IOException {

		Cliente c = new Cliente();
		c.getId();
		c.getNome();

		StringWriter out = new StringWriter();
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(c.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(c, new StreamResult(out));
		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		String xml = out.toString();
		FileWriter fw = new FileWriter("arq.xml");
		fw.write(xml);
		fw.close();

	}

}
