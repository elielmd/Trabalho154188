package br.univel.relatorios;

import java.util.Iterator;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import br.univel.cliente.Cliente;

public class ClienteJRDataSource implements JRDataSource {
	@SuppressWarnings("unused")
	private List<Cliente> lista;
	private Cliente selecionado;
	private Iterator<Cliente> iterator;
	
	
	public ClienteJRDataSource(List<Cliente> lista) {
		this.lista = lista;
		this.iterator = lista.iterator();
	}


	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		if("id".equals(arg0.getName())){
			return selecionado.getId();			
		}else if("nome".equals(arg0.getName())){		
			return selecionado.getNome();
		}else if("telefone".equals(arg0.getName())){
			return selecionado.getTelefone();			
		}
		return "Undeifined";
	}

	@Override
	public boolean next() throws JRException {
		if(iterator.hasNext()){
			selecionado = iterator.next();
			return true;			
		}
		
		return false;
	}	
}
