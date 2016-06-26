package br.univel;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.Font;
import java.awt.SystemColor;

public class Main extends JFrame {

	public static ConexaoBD conexao;

	private static final long serialVersionUID = -2638554920016934872L;

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
				System.out.println("TESTE - TELA CLIENTE");

				TelaCliente OpCliente = new TelaCliente();
				OpCliente.setSize(910, 500);
				//OpCliente.setSize(1100, 800);
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
			}
		});

		mntmCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("TESTE - TELA CLIENTE");

				TelaCliente OpCliente = new TelaCliente();
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
