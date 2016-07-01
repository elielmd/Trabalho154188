package br.univel.cliente;

import java.sql.SQLException;
import java.util.List;

import br.univel.ConexaoBD;
import net.sf.jasperreports.engine.JRDataSource;

public class ClienteDsFactory {
	public static JRDataSource criar(){
		
		ClienteDao dao = new ClienteDao();
		try {
			dao.setCon(new ConexaoBD().abrirConexao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Cliente> lista = dao.listarTodos();
		ClienteJRDataSource ds = new ClienteJRDataSource(lista);
		
		return  ds;
	}
}
