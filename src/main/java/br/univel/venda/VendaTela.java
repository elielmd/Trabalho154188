//package br.univel.venda;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.File;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.PatternSyntaxException;
//
//import javax.swing.JOptionPane;
//import javax.swing.RowFilter;
//import javax.swing.table.TableModel;
//import javax.swing.table.TableRowSorter;
//
//import br.univel.ConexaoBD;
//import br.univel.ExportaArqXML;
//import br.univel.MenuOpcoes;
//import br.univel.SqlGenImpl;
//import br.univel.produto.ProdutoModel;
//
//@SuppressWarnings("serial")
//public class VendaTela extends MenuOpcoes {
//	
//	private ConexaoBD conexao;	
//	private List<Venda> lista = new ArrayList<Venda>();
//	private SqlGenImpl serializador = new SqlGenImpl();
//	private ExportaArqXML<VendaListWrapper> vendaXML = new ExportaArqXML<VendaListWrapper>();	
//	private VendaDao venCon = new VendaDao();
//	
//	public VendaTela(){
//		
//		ConexaoBD conectaBanco = new ConexaoBD();
//		
//		try {
//			venCon.setCon(conectaBanco.abrirConexao());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		btnExcluir.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(lista.isEmpty()){
//					JOptionPane.showMessageDialog(null, "Nenhuma venda a ser excluido.");
//				}else{	
//					if(table.getSelectedRow() == -1){
//						JOptionPane.showMessageDialog(null, "Selecione um venda.");
//					}else{
//					
//						int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir uma venda?");
//						
//						if(opcao == 0){
//							int codigo = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
//							venCon.excluir(codigo);
//						}
//					}
//				}				
//			}
//		});
//		
//		btnAtualizaTabela.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				lista = venCon.listarTodos();
//				VendaModel modelo = new VendaModel(lista);
//				table.setModel(modelo);
//			}
//		});
//			
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				table.getModel().getValueAt(table.getSelectedRow(), 1);
//				int id = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
//				venCon.buscar(id);
//			}
//		});
//		
//		btnSerializar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				try {
//					serializador.gravar(lista, new File("listaVendas.dat"));
//				} catch (SerializadorException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}	
//				JOptionPane.showMessageDialog(null, "Serialização finalizada com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
//				
//			}
//		});
//		
//		
//		
//		btnImportarXML.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				ListaVendas lv = new ListaVendas();
//				lv = exportadorXML.ImportarXml(lv, new File("listavendas.xml"));		
//				
//				
//				List<Venda> listaTemp = new ArrayList<Venda>();					
//				listaTemp = lv.getListaVenda();
//				
//				for(Venda v : listaTemp){
//					if(dv.buscar(v.getId()).getId() > 0){
//						dv.atualizar(v);
//					}else{
//						dv.salvar(v);
//					}
//				}
//				JOptionPane.showMessageDialog(null, "Importação de XML finalizado com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
//				montarConsulta();					
//				
//			}
//		});
//		
//		btnExportarXML.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				ListaVendas lv = new ListaVendas();
//				lv.setListaVenda(lista);
//				exportadorXML.ExportarXml(lv, new File("listavendas.xml"));			
//				JOptionPane.showMessageDialog(null, "Exportação de XML finalizada com sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
//			
//			}
//		});
//		
//		btnAlterar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//tela
//				if(lista.isEmpty()){
//					JOptionPane.showMessageDialog(null, "Nenhum registro a ser alterado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
//				}else{					
//					if(tblResultados.getSelectedRow() == -1){
//						JOptionPane.showMessageDialog(null, "Selecione um registro.", "Informação", JOptionPane.INFORMATION_MESSAGE);
//					}else{					
//						//tela
//						LanVendas LanVendas = new LanVendas();		
//						LanVendas.setSize(615, 466);
//						LanVendas.setLocationRelativeTo(null); //centraliza na tela
//						LanVendas.lblTitulo.setText("Alteração de Venda");
//						LanVendas.setEditando(true);
//						LanVendas.carregarDados((int) tblResultados.getModel().getValueAt(tblResultados.getSelectedRow(), 0));
//						LanVendas.setVisible(true);//mostra na tela				
//					}
//				}				
//			}
//		});
//		
//		btnInserir.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//tela
//				LanVendas LanVendas = new LanVendas();		
//				LanVendas.setSize(615, 466);
//				LanVendas.setLocationRelativeTo(null); //centraliza na tela
//				LanVendas.lblTitulo.setText("Lançamento de Venda");
//				LanVendas.setEditando(false);
//				LanVendas.setId_venda(dv.proximoID());		
//				LanVendas.setVisible(true);//mostra na tela				
//			}
//		});
//		
//		setTitle("Vendas");
//		lblTitulo.setText("Vendas");
//		btnImportarTXT.setVisible(false);			
//	}
//		di.criarTabela(new ItemVenda());
//		
//	}	
//	
//	private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt){                                         
//		VendaModelo  =  (VendaModelo) tblResultados.getModel();
//        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
//        tblResultados.setRowSorter(sorter);
//        String text = txtPesquisa.getText().toUpperCase();
//        if (text.length() == 0){
//             sorter.setRowFilter(null);
//        } else{
//             try{
//                sorter.setRowFilter(
//                RowFilter.regexFilter(text));
//             } catch (PatternSyntaxException pse) {
//                System.err.println("Erro");
//             }
//        }
//	}	
//}
