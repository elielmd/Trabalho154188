package br.univel.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.SqlGenImpl;
import br.univel.interfaces.Dao;

public class ClienteDao implements Dao<Cliente, Integer> {

	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public void salvar(Cliente t) {
		SqlGenImpl sql = new SqlGenImpl();

		try {

			PreparedStatement ps = sql.getSqlInsert(con, t);
			ps.setInt(1, t.getId());
			ps.setString(2, t.getNome());
			ps.setString(3, t.getEndereco());
			ps.setString(4, t.getNumero());
			ps.setString(5, t.getComplemento());
			ps.setString(6, t.getBairro());
			ps.setString(7, t.getCidade());
			ps.setString(8, t.getEstado());
			ps.setString(9, t.getCep());
			ps.setString(10, t.getTelefone());
			ps.setString(11, t.getCelular());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public Cliente buscar(Integer pk) {
		SqlGenImpl sql = new SqlGenImpl();
		Cliente cli = new Cliente();
		cli.setId(0);

		try {

			PreparedStatement ps = sql.getSqlSelectById(con, new Cliente());
			ps.setInt(1, pk);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				cli.setId(result.getInt("clId"));
				cli.setNome(result.getString("clNome"));
				cli.setEndereco(result.getString("clEndereco"));
				cli.setNumero(result.getString("clNumero"));
				cli.setComplemento(result.getString("clComplemento"));
				cli.setBairro(result.getString("clBairro"));
				cli.setCidade(result.getString("clCidade"));
				cli.setEstado(result.getString("clEstado"));
				cli.setCep(result.getString("clCep"));
				cli.setTelefone(result.getString("telefone"));
				cli.setCelular(result.getString("celular"));

			}

			ps.close();
			result.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cli;
	}

	@Override
	public void atualizar(Cliente t) {
		SqlGenImpl sql = new SqlGenImpl();

		try {

			PreparedStatement ps = sql.getSqlUpdateById(con, t);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getEndereco());
			ps.setString(3, t.getNumero());
			ps.setString(4, t.getComplemento());
			ps.setString(5, t.getBairro());
			ps.setString(6, t.getCidade());
			ps.setString(7, t.getEstado());
			ps.setString(8, t.getCep());
			ps.setString(9, t.getTelefone());
			ps.setString(10, t.getCelular());
			ps.setInt(11, t.getId());

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

			PreparedStatement ps = sql.getSqlDeleteById(con, new Cliente());
			ps.setInt(1, pk);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public List<Cliente> listarTodos() {
		SqlGenImpl gerador = new SqlGenImpl();
		List<Cliente> listaCliente = new ArrayList<Cliente>();

		try {

			PreparedStatement ps = gerador.getSqlSelectAll(con, new Cliente());
			ResultSet result = ps.executeQuery();

			while (result.next()) {

				Cliente c = new Cliente();
				c.setId(result.getInt("clId"));
				c.setNome(result.getString("clNome"));
				c.setEndereco(result.getString("clEndereco"));
				c.setNumero(result.getString("clNumero"));
				c.setComplemento(result.getString("clComplemento"));
				c.setBairro(result.getString("clBairro"));
				c.setCidade(result.getString("clCidade"));
				c.setEstado(result.getString("clEstado"));
				c.setCep(result.getString("clCep"));
				c.setTelefone(result.getString("clTelefone"));
				c.setCelular(result.getString("celular"));

				listaCliente.add(c);
			}

			ps.close();
			result.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaCliente;
	}

	public void criarTabela(Cliente t) {
		SqlGenImpl gerador = new SqlGenImpl();
		System.out.println(gerador);
		try {
			String sql = gerador.getCreateTable(con, t);
			System.out.println(t);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println(ps);
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
}
