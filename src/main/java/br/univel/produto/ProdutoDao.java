package br.univel.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.SqlGenImpl;
import br.univel.interfaces.Dao;

public class ProdutoDao implements Dao<Produto, Integer> {

	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public void salvar(Produto t) {
		SqlGenImpl sql = new SqlGenImpl();

		try {

			PreparedStatement ps = sql.getSqlInsert(con, t);
			ps.setInt(1, t.getId());
			ps.setString(2, t.getDescricao());
			ps.setBigDecimal(3, t.getPreco());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public Produto buscar(Integer pk) {
		SqlGenImpl sql = new SqlGenImpl();
		Produto p = new Produto();

		try {

			PreparedStatement ps = sql.getSqlSelectById(con, new Produto());
			ps.setInt(1, pk);
			ResultSet resulSet = ps.executeQuery();

			while (resulSet.next()) {
				p.setId(resulSet.getInt("pdId"));
				p.setDescricao(resulSet.getString("pdDescricao"));
				p.setPreco(resulSet.getBigDecimal("pdPreco"));
			}

			ps.close();
			resulSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public void atualizar(Produto t) {
		SqlGenImpl sql = new SqlGenImpl();

		try {

			PreparedStatement ps = sql.getSqlUpdateById(con, t);
			ps.setString(1, t.getDescricao());
			ps.setBigDecimal(2, t.getPreco());
			ps.setInt(3, t.getId());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public void excluir(Integer pk) {
		SqlGenImpl sql = new SqlGenImpl();

		try {

			PreparedStatement ps = sql.getSqlDeleteById(con, new Produto());
			ps.setInt(1, pk);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public List<Produto> listarTodos() {
		SqlGenImpl sql = new SqlGenImpl();
		List<Produto> listaProduto = new ArrayList<Produto>();

		try {

			PreparedStatement ps = sql.getSqlSelectAll(con, new Produto());
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				Produto p = new Produto();
				p.setId(resultSet.getInt("pdId"));
				p.setDescricao(resultSet.getString("pdDescricao"));
				p.setPreco(resultSet.getBigDecimal("pdPreco"));

				listaProduto.add(p);
			}

			ps.close();
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaProduto;
	}

	public void criarTabela(Produto t) {
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