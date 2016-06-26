package br.univel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

public class MenuOpcoes extends JFrame {
	public JLabel lblTitulo;
	public JButton btnImportarTXT;
	public JButton bntInserir;
	public JButton btnAlterar;
	public JButton btnExcluir;
	public JButton btnImportarXML;
	public JButton btnExportarXML;
	public JButton btnSair;
	private JScrollPane scrollPane;
	JTable table;

	public MenuOpcoes() {
		setTitle("Teste");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		lblTitulo = new JLabel("AgroMaster");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

		bntInserir = new JButton("Inserir");
		bntInserir.setBackground(UIManager.getColor("ToggleButton.darkShadow"));
		bntInserir.setForeground(new Color(0, 0, 0));
		bntInserir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		bntInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(UIManager.getColor("ToggleButton.darkShadow"));
		btnAlterar.setForeground(new Color(0, 0, 0));
		btnAlterar.setFont(new Font("Times New Roman", Font.BOLD, 12));

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(UIManager.getColor("ToggleButton.darkShadow"));
		btnExcluir.setForeground(new Color(0, 0, 0));
		btnExcluir.setFont(new Font("Times New Roman", Font.BOLD, 12));

		btnImportarXML = new JButton("Importar XML");
		btnImportarXML.setBackground(UIManager.getColor("ToggleButton.darkShadow"));
		btnImportarXML.setForeground(new Color(0, 0, 0));
		btnImportarXML.setFont(new Font("Times New Roman", Font.BOLD, 12));

		btnExportarXML = new JButton("Exportar XML");
		btnExportarXML.setBackground(UIManager.getColor("ToggleButton.darkShadow"));
		btnExportarXML.setForeground(new Color(0, 0, 0));
		btnExportarXML.setFont(new Font("Times New Roman", Font.BOLD, 12));

		btnImportarTXT = new JButton("Importar TXT");
		btnImportarTXT.setBackground(UIManager.getColor("ToggleButton.darkShadow"));
		btnImportarTXT.setForeground(new Color(0, 0, 0));
		btnImportarTXT.setFont(new Font("Times New Roman", Font.BOLD, 12));

		btnSair = new JButton("Voltar");
		btnSair.setBackground(UIManager.getColor("ToggleButton.darkShadow"));
		btnSair.setForeground(new Color(0, 0, 0));
		btnSair.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(571, Short.MAX_VALUE)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(bntInserir, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnImportarXML, GroupLayout.PREFERRED_SIZE, 111, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnExportarXML, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnImportarTXT, GroupLayout.PREFERRED_SIZE, 111, Short.MAX_VALUE)
									.addGap(40))))
						.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(lblTitulo)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bntInserir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnImportarXML)
						.addComponent(btnExportarXML)
						.addComponent(btnImportarTXT))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(btnSair)
					.addContainerGap())
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {btnExcluir, btnImportarXML, btnExportarXML, btnImportarTXT, btnSair});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnExcluir, btnImportarXML, btnExportarXML, btnImportarTXT, btnSair});

		table = new JTable();
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				MenuOpcoes principal = new MenuOpcoes();
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
			}
		});
	}
}