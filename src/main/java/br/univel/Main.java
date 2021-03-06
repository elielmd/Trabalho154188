package br.univel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import br.univel.cliente.ClienteDao;
import br.univel.cliente.ClienteJRDataSource;
import br.univel.cliente.ClienteTela;
import br.univel.produto.ProdutoTela;
import br.univel.venda.VendaTela;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 640393652128333579L;
	public static ConexaoBD conectaBanco;

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 140);
		setTitle("AgroMaster");

		JMenuBar menuBar = new JMenuBar();
		menuBar.setEnabled(false);
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);

		JMenu mnCadastrar = new JMenu("Menu");
		menuBar.add(mnCadastrar);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mnCadastrar.add(mntmCliente);

		JMenuItem mntmProduto = new JMenuItem("Produto");
		mnCadastrar.add(mntmProduto);

		JMenuItem mntmVenda = new JMenuItem("Venda");
		mnCadastrar.add(mntmVenda);

		Panel panel = new Panel();
		getContentPane().add(panel, BorderLayout.CENTER);

		JButton btnOpCliente = new JButton("CLIENTES");
		btnOpCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ClienteTela OpCliente = new ClienteTela();
				OpCliente.setSize(910, 500);
				OpCliente.setLocationRelativeTo(null);
				OpCliente.setVisible(true);
			}
		});
		btnOpCliente.setBackground(SystemColor.activeCaption);
		btnOpCliente.setForeground(SystemColor.menuText);
		btnOpCliente.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnOpCliente.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(btnOpCliente);

		JButton btnOpProduto = new JButton("PRODUTOS");
		btnOpProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoTela OpProduto = new ProdutoTela();
				OpProduto.setSize(910, 500);
				// OpCliente.setSize(1100, 800);
				OpProduto.setLocationRelativeTo(null);
				OpProduto.setVisible(true);
			}
		});
		btnOpProduto.setBackground(SystemColor.activeCaption);
		btnOpProduto.setForeground(SystemColor.menuText);
		btnOpProduto.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnOpProduto.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(btnOpProduto);

		JButton btnOpVenda = new JButton("VENDAS");
		btnOpVenda.setVerticalAlignment(SwingConstants.BOTTOM);
		btnOpVenda.setHorizontalAlignment(SwingConstants.RIGHT);
		btnOpVenda.setBackground(SystemColor.activeCaption);
		btnOpVenda.setForeground(SystemColor.menuText);
		btnOpVenda.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(btnOpVenda);
		btnOpVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendaTela OpVenda = new VendaTela();
				OpVenda.setSize(910, 500);
				OpVenda.setLocationRelativeTo(null);
				OpVenda.setVisible(true);
			}
		});

		mntmCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClienteTela OpCliente = new ClienteTela();
				OpCliente.setSize(900, 500);
				OpCliente.setLocationRelativeTo(null);
				OpCliente.setVisible(true);
			}
		});

		/*
		 * contentPane = new JPanel(); contentPane.setBackground(new Color(153,
		 * 255, 153)); contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 * contentPane.setLayout(new BorderLayout(0, 0));
		 * setContentPane(contentPane);
		 */
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				conectaBanco = new ConexaoBD();
				try {
					conectaBanco.abrirConexao();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(conectaBanco);
				Main principal = new Main();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
				try {
					conectaBanco.fecharConexao();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

//	private void executarRelatorio(String arquivo) {
//
//		JasperPrint jp = null;
//		try {
//			jp = JasperFillManager.fillReport(arquivo, null, new ConexaoBD().abrirConexao());
//		} catch (SQLException | JRException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		JasperViewer jasperViewer = new JasperViewer(jp);
//
//		jasperViewer.setBounds(50, 50, 320, 240);
//		jasperViewer.setLocationRelativeTo(null);
//		jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
//
//		jasperViewer.setVisible(true);
//	}

}
