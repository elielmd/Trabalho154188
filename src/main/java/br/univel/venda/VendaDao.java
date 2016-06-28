package br.univel.venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.ConexaoBD;
import br.univel.SqlGenImpl;
import br.univel.cliente.ClienteDao;
import br.univel.interfaces.Dao;

public class VendaDao implements Dao<Venda, Integer> {

	private DaoVendaProduto vendaDao = new DaoVendaProduto();
	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public void salvar(Venda t) {
		SqlGenImpl sql = new SqlGenImpl();

		try {

			PreparedStatement ps = sql.getSqlInsert(con, t);
			ps.setInt(1, t.getIdV());
			ps.setInt(2, t.getCliente().getId());
			ps.executeUpdate();
			ps.close();

			vendaDao.setCon(con);
			for (VendaProduto iv : t.getMercadorias()) {
				vendaDao.salvar(iv);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public Venda buscar(Integer k) {
		SqlGenImpl sql = new SqlGenImpl();
		Venda v = new Venda();
		ClienteDao dc = new ClienteDao();
		try {
			dc.setCon(new ConexaoBD().abrirConexao());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			PreparedStatement ps = sql.getSqlSelectById(con, new Venda());
			ps.setInt(1, k);
			ResultSet resultados = ps.executeQuery();

			vendaDao.setCon(con);
			while (resultados.next()) {
				v.setIdV(resultados.getInt("id"));
				v.setCliente(dc.buscar(resultados.getInt("id_cliente")));
				v.setMercadorias(vendaDao.listarItensVenda(v.getIdV()));
			}

			vendaDao.setCon(con);

			ps.close();
			resultados.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return v;
	}

	@Override
	public void atualizar(Venda t) {
		SqlGenImpl sql = new SqlGenImpl();

		try {

			PreparedStatement ps = sql.getSqlUpdateById(con, t);
			ps.setInt(1, t.getCliente().getId());
			ps.setInt(2, t.getIdV());
			ps.executeUpdate();
			ps.close();

			vendaDao.setCon(con);
			vendaDao.excluir(t.getIdV());
			for (VendaProduto iv : t.getMercadorias()) {
				vendaDao.salvar(iv);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public void excluir(Integer pk) {
		SqlGenImpl sql = new SqlGenImpl();

		try {

			PreparedStatement ps = sql.getSqlDeleteById(con, new Venda());
			ps.setInt(1, pk);
			ps.executeUpdate();
			ps.close();

			vendaDao.setCon(con);
			vendaDao.excluir(pk);

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public List<Venda> listarTodos() {
		SqlGenImpl sql = new SqlGenImpl();
		List<Venda> listaVenda = new ArrayList<Venda>();

		ClienteDao cliCon = new ClienteDao();
		try {
			cliCon.setCon(new ConexaoBD().abrirConexao());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			PreparedStatement ps = sql.getSqlSelectAll(con, new Venda());
			ResultSet resultados = ps.executeQuery();
			vendaDao.setCon(con);

			while (resultados.next()) {

				Venda venda = new Venda();

				venda.setIdV(resultados.getInt("idV"));
				venda.setCliente(cliCon.buscar(resultados.getInt("idCliente")));
				venda.setMercadorias(vendaDao.listarItensVenda(venda.getIdV()));

				listaVenda.add(venda);
			}

			ps.close();
			resultados.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaVenda;
	}

	public void criarTabela(Venda t) {
		SqlGenImpl gerador = new SqlGenImpl();

		try {
			String sql = gerador.getCreateTable(con, t);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
