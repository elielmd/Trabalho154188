package br.univel.venda;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class VendaProdutoModel extends AbstractTableModel{

	private List<VendaProduto> lista;
	
	public VendaProdutoModel(List<VendaProduto> lista) {
		this.lista = lista;
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}
	
	@Override
	public String getColumnName(int column) {
		switch( column) {
			case 0:
				return "Produto";
			case 1:
				return "Qtde";
			case 2:
				return "Preço";
			case 3:
				return "Total";				
			default:
				return super.getColumnName(column);
		}
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		VendaProduto venda = lista.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return venda.getProduto().getDescricao();
		case 1:
			return venda.getVpQtd();
		case 2:
			return venda.getProduto().getPreco();
		case 3:
			BigDecimal valor = new BigDecimal(venda.getProduto().getPreco().toString());
			return venda.getVpQtd();
		default:
			return "erro";
		}
	}

}
