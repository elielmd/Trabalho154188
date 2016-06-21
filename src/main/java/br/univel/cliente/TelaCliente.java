package br.univel.cliente;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.univel.ClienteListWrapper;
import br.univel.LerArquivoTXT;

/* corrigindo erro do git */
public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private List<Cliente> listaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton btnNewButton = new JButton("Listar Clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheTabela();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		JButton btnGravaXMLButton = new JButton("Exportar XML");
		btnGravaXMLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(listaCliente);
				String xml = "C:\\Users\\Eliel\\workspace\\Trabalho154188\\listaCliente.xml";
				File arquivo = new File(xml);
				GravaXML(arquivo);
			}
		});

		GridBagConstraints gbc_btnGravaXMLButton = new GridBagConstraints();
		gbc_btnGravaXMLButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnGravaXMLButton.gridx = 1;
		gbc_btnGravaXMLButton.gridy = 0;
		contentPane.add(btnGravaXMLButton, gbc_btnGravaXMLButton);

		JButton btnImportaXMLButton = new JButton("Importar XML");
		btnImportaXMLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(listaCliente);
				String xml = "C:\\Users\\Eliel\\workspace\\Trabalho154188\\listaCliente.xml";
				File arquivo = new File(xml);
				LerXML(arquivo);
			}
		});

		GridBagConstraints gbc_btnImportaXMLButton = new GridBagConstraints();
		gbc_btnImportaXMLButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnImportaXMLButton.gridx = 2;
		gbc_btnImportaXMLButton.gridy = 0;
		contentPane.add(btnImportaXMLButton, gbc_btnImportaXMLButton);

		JButton btnGSerializableButton = new JButton("G_Serializable");
		btnGSerializableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(listaCliente);
				String xml = "C:\\Users\\Eliel\\workspace\\Trabalho154188\\listaCliente.dat";
				File arquivo = new File(xml);
				GravarSerializacao(arquivo);
			}
		});

		GridBagConstraints gbc_btnGSerializableButton = new GridBagConstraints();
		gbc_btnGSerializableButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnGSerializableButton.gridx = 1;
		gbc_btnGSerializableButton.gridy = 3;
		contentPane.add(btnGSerializableButton, gbc_btnGSerializableButton);

		JButton btnISerializableButton = new JButton("I_Serializable");
		btnISerializableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(listaCliente);
				String xml = "C:\\Users\\Eliel\\workspace\\Trabalho154188\\listaCliente.dat";
				File arquivo = new File(xml);
				LerSerializacao(arquivo);
			}
		});

		GridBagConstraints gbc_btnISerializableButton = new GridBagConstraints();
		gbc_btnISerializableButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnISerializableButton.gridx = 2;
		gbc_btnISerializableButton.gridy = 3;
		contentPane.add(btnISerializableButton, gbc_btnISerializableButton);

		/*
		 * JButton btnRemove = new JButton("Remove Cliente");
		 * btnRemove.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { removerSelecionado(); } });
		 * 
		 * GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		 * gbc_btnRemove.insets = new Insets(0, 0, 5, 0); gbc_btnRemove.gridx =
		 * 0; gbc_btnRemove.gridy = 3; contentPane.add(btnRemove,
		 * gbc_btnRemove);
		 */

		// JButton btnAdiciona = new JButton("Adiciona");
		// btnAdiciona.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// adicionarDoAlem();
		// }
		// });
		// GridBagConstraints gbc_btnAdiciona = new GridBagConstraints();
		// gbc_btnAdiciona.insets = new Insets(0, 0, 5, 0);
		// gbc_btnAdiciona.gridx = 0;
		// gbc_btnAdiciona.gridy = 2;
		// contentPane.add(btnAdiciona, gbc_btnAdiciona);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable() {

			@Override
			public String getToolTipText(MouseEvent e) {

				String tip = null;

				Point p = e.getPoint();

				int rowIndex = rowAtPoint(p);
				int colIndex = columnAtPoint(p);

				if (rowIndex == -1 || colIndex == -1) {
					return null;
				}

				try {
					tip = getValueAt(rowIndex, colIndex).toString();
				} catch (RuntimeException e1) {

				}

				return tip;

			}

		};

		scrollPane.setViewportView(table);

		// final
		configuraTabela();
	}

	// protected void adicionarDoAlem() {
	//
	// Cliente c = new Cliente(123, "Do além!");
	//
	//
	// ((ClienteModel)table.getModel()).adicionarCliente(c);
	//
	// }

	protected void removerSelecionado() {
		Cliente c = getClienteSelecionadoNaTabela();
		if (c != null) {
			((ClienteModel) table.getModel()).removerCliente(c);
		}

	}

	private void configuraTabela() {
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					Cliente c = getClienteSelecionadoNaTabela();
					if (c != null) {
						JOptionPane.showMessageDialog(null, "Cliente: " + c.toString());
					}

				}
			}

		});

	}

	protected void preencheTabela() {

		LerArquivoTXT reader = new LerArquivoTXT();
		List<String> lista = reader.lerArquivo("C:\\Users\\Eliel\\workspace\\Trabalho154188\\listaCliente.txt");
		ClienteParser parserCliente = new ClienteParser();
		listaCliente = parserCliente.getCliente(lista);
		// System.out.println(lista);

		ClienteModel model = new ClienteModel(listaCliente);
		table.setModel(model);
		// System.out.println(listaCliente);

	}

	private Cliente getClienteSelecionadoNaTabela() {
		Cliente c = null;
		int index = table.getSelectedRow();
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
		} else {
			c = ((ClienteModel) table.getModel()).getClienteNaLinha(index);
		}
		return c;
	}

	public void GravaXML(File arq) {

		try {

			JAXBContext context = JAXBContext.newInstance(ClienteListWrapper.class);
			// System.out.println(listaCliente);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// System.out.println(listaCliente);
			ClienteListWrapper clienteList = new ClienteListWrapper();
			clienteList.setCliente(listaCliente);
			System.out.println((clienteList));
			m.marshal(clienteList, arq);
			// System.out.println((listaCliente));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void LerXML(File arq) {
		try {
			JAXBContext context = JAXBContext.newInstance(ClienteListWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			ClienteListWrapper clienteList = (ClienteListWrapper) um.unmarshal(arq);

			listaCliente = new ArrayList<>();

			listaCliente.addAll(clienteList.getCliente());
			System.out.println(clienteList);
			ClienteModel model = new ClienteModel(listaCliente);
			table.setModel(model);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void GravarSerializacao(File arq) {
		try {

			FileOutputStream fos = new FileOutputStream(arq);

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(listaCliente);

			oos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void LerSerializacao(File arq) {
		try {

			FileInputStream fis = new FileInputStream(arq);

			ObjectInputStream ois = new ObjectInputStream(fis);

			// List<Cliente>(listaCliente).clear();

			listaCliente = (List<Cliente>) ois.readObject();
			System.out.println(listaCliente);

			ois.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
