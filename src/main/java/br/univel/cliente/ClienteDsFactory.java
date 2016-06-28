package br.univel.cliente;

import java.sql.SQLException;
import java.util.List;

import br.univel.ConexaoBD;
import br.univel.cliente.Cliente;
import br.univel.cliente.ClienteDao;
import net.sf.jasperreports.engine.JRDataSource;

public class ClienteDsFactory {
	public static JRDataSource geraRelaorio(){
		
		ClienteDao cliCon = new ClienteDao();
		try {
			cliCon.setCon(new ConexaoBD().abrirConexao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Cliente> lista = cliCon.listarTodos();
		System.out.println(lista);
		ClienteJRDataSource cRel = new ClienteJRDataSource(lista);
		
		return cRel;
	}
}
