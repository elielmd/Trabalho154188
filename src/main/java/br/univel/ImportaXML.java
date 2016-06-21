package br.univel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.univel.cliente.Cliente;

public class ImportaXML {

	public static void main(String[] args) throws IOException {

		String xml = null;
		try {
			FileReader fr = new FileReader("arq.xml");
			BufferedReader br = new BufferedReader(fr);

			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}

			xml = sb.toString();
			br.close();
			fr.close();

			StringReader in = new StringReader(xml);
			JAXBContext context = JAXBContext.newInstance(Cliente.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Cliente cli = (Cliente) unmarshaller.unmarshal(in);
			System.out.println(cli.getId());
			System.err.println(cli.getEndereco());
			System.out.println(cli.getComplemento());

		} catch (JAXBException e1) {
			e1.printStackTrace();
			// TODO: handle exception
		}
	}
}
