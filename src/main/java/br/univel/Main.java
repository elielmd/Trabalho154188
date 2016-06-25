package br.univel;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main extends JFrame {

	public static ConexaoBD conexao;

	private static final long serialVersionUID = -2638554920016934872L;

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		setTitle("AgroMaster");

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastrar = new JMenu("Menu");
		menuBar.add(mnCadastrar);

		JMenuItem mntmCadastrar = new JMenuItem("Cliente");
		mnCadastrar.add(mntmCadastrar);

		JMenuItem mntmNewMenuItem = new JMenuItem("Produto");
		mnCadastrar.add(mntmNewMenuItem);

		JMenuItem mntmVenda = new JMenuItem("Venda");
		mnCadastrar.add(mntmVenda);
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
				conexao = new ConexaoBD();
				try {
					conexao.abrirConexao();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Main principal = new Main();
				principal.setLocationRelativeTo(null); 
				principal.setVisible(true); 
			}
		});
	}
}
