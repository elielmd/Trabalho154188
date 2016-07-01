package br.univel.venda;

import java.util.List;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class VendaModel extends AbstractTableModel {

	private List<Venda> lista;
	
	public VendaModel(List<Venda> lista) {
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int column) {
		switch( column) {
			case 0:
				return "C�digo";
			case 1:
				return "Cliente";
			default:
				return super.getColumnName(column);
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Venda v = lista.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return v.getIdVenda();
		case 1:
			return v.getCliente().getNome();
		default:
			return "erro";
		}
	}
}
