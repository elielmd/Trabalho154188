package br.univel.venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univel.ConexaoBD;
import br.univel.SqlGenImpl;
import br.univel.cliente.Cliente;
import br.univel.interfaces.Dao;
import br.univel.produto.ProdutoDao;

public class DaoVendaProduto implements Dao<VendaProduto, Integer> {

	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public void salvar(VendaProduto t) {
		SqlGenImpl sql = new SqlGenImpl();

		try {

			PreparedStatement ps = sql.getSqlInsert(con, t);
			ps.setInt(1, t.getIdVenda());
			ps.setInt(2, t.getProduto().getId());
			ps.setFloat(3, t.getVpQtd());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public VendaProduto buscar(Integer k) {
		SqlGenImpl sql = new SqlGenImpl();
		VendaProduto merc = new VendaProduto();
		ProdutoDao proCon = new ProdutoDao();
		try {
			proCon.setCon(new ConexaoBD().abrirConexao());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			PreparedStatement ps = sql.getSqlSelectById(con, new Cliente());
			ps.setInt(1, k);
			ResultSet resultados = ps.executeQuery();

			while (resultados.next()) {
				merc.setIdVenda(resultados.getInt("idVenda"));
				merc.setProduto(proCon.buscar(resultados.getInt("idProduto")));
				merc.setVpQtd(resultados.getInt("vpQtd"));
			}

			ps.close();
			resultados.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return merc;
	}

	@Override
	public void atualizar(VendaProduto t) {
		SqlGenImpl sql = new SqlGenImpl();

		try {

			PreparedStatement ps = sql.getSqlUpdateById(con, t);
			ps.setFloat(1, t.getVpQtd());
			ps.setInt(2, t.getIdVenda());
			ps.setInt(3, t.getProduto().getId());

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

			PreparedStatement ps = con.prepareStatement("DELETE FROM vendas_produtos WHERE id_venda = ?");
			ps.setInt(1, pk);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public List<VendaProduto> listarTodos() {
		SqlGenImpl sql = new SqlGenImpl();
		List<VendaProduto> listaVendaProduto = new ArrayList<VendaProduto>();
		ProdutoDao proCon = new ProdutoDao();
		try {
			proCon.setCon(new ConexaoBD().abrirConexao());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			PreparedStatement ps = sql.getSqlSelectAll(con, new VendaProduto());
			ResultSet resultados = ps.executeQuery();

			while (resultados.next()) {
				VendaProduto i = new VendaProduto();

				i.setIdVenda(resultados.getInt("idVenda"));
				i.setProduto(proCon.buscar(resultados.getInt("idProduto")));
				i.setVpQtd(resultados.getInt("vpQtd"));

				listaVendaProduto.add(i);
			}

			ps.close();
			resultados.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaVendaProduto;
	}

	public void criarTabela(VendaProduto t) {
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

	public List<VendaProduto> listarItensVenda(int idVenda) {
		List<VendaProduto> listaVendaProduto = new ArrayList<VendaProduto>();
		ProdutoDao proCon = new ProdutoDao();
		proCon.setCon(con);

		try {

			PreparedStatement ps = con.prepareStatement("SELECT * FROM vendas_produtos WHERE id_venda = ?");
			ps.setInt(1, idVenda);
			ResultSet resultados = ps.executeQuery();

			while (resultados.next()) {
				VendaProduto i = new VendaProduto();

				i.setIdVenda(resultados.getInt("idVenda"));
				i.setProduto(proCon.buscar(resultados.getInt("idProduto")));
				i.setVpQtd(resultados.getInt("qtd"));

				listaVendaProduto.add(i);
			}

			ps.close();
			resultados.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaVendaProduto;
	}

}
