import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;

public class Pantalla1_1_2 {

	static JFrame frame;
	private JTable table;
	private ConexionBBDD conexion;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextField textidCategoria;
	private JTable table_1;
	static String IdProducto;
	static String IdCategoria;
	static String Nombre;
	static String precio;


	/**
	 * Create the application.
	 */
	public Pantalla1_1_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		conexion = new ConexionBBDD();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 871, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    table = new JTable();
		
		
		JLabel lblAadirProducto = new JLabel("A\u00F1adir Producto ");
		lblAadirProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirProducto.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAadirProducto.setBounds(275, 21, 165, 24);
		frame.getContentPane().add(lblAadirProducto);
		
		JLabel lblIdProducto = new JLabel("Id Producto:");
		lblIdProducto.setForeground(Color.BLACK);
		lblIdProducto.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdProducto.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblIdProducto.setBounds(42, 94, 127, 20);
		frame.getContentPane().add(lblIdProducto);
		
		JLabel lblProducto = new JLabel("Id Categoria");
		lblProducto.setForeground(Color.BLACK);
		lblProducto.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblProducto.setBounds(42, 125, 127, 24);
		frame.getContentPane().add(lblProducto);
		
		JButton btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setForeground(Color.BLACK);
		btnAñadir.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnAñadir.setBackground(new Color(220, 220, 220));
		btnAñadir.setBounds(42, 246, 253, 38);
		frame.getContentPane().add(btnAñadir);
		
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdProducto = textId.getText();
				IdCategoria = textidCategoria.getText();
				Nombre = textNombre.getText();
				precio = textPrecio.getText();
				
				if(!IdProducto.isEmpty() && !IdCategoria.isEmpty() && !Nombre.isEmpty() && !precio.isEmpty()) {
					
					DefaultTableModel data = (DefaultTableModel) table.getModel();
					String[] fila = {IdProducto,IdCategoria,Nombre,precio};
					data.addRow(fila);
					conexion.InsertarProducto();
					
				}else {
					JOptionPane.showMessageDialog(btnAñadir, "Datos no introducidos");
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(306, 64, 384, 332);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID_PRODUCTO", "ID_CATEGORIA", "NOMBRE", "PRECIO"
			}
		));
		table.setModel(conexion.ConsultaTablaProductos());
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = table.rowAtPoint(e.getPoint());
				
				textId.setText((String)table.getValueAt(select, 0));
				textidCategoria.setText((String)table.getValueAt(select, 1));
				textNombre.setText((String)table.getValueAt(select, 2));
				textPrecio.setText((String)table.getValueAt(select, 3));
				
				IdProducto = textId.getText();
				IdCategoria = textidCategoria.getText();
				Nombre = textNombre.getText();
				precio = textPrecio.getText();
			}/* */
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnEditar.setBackground(new Color(220, 220, 220));
		btnEditar.setBounds(42, 295, 253, 38);
		frame.getContentPane().add(btnEditar);
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int FilaSeleccionada = table.getSelectedRow();
				if(FilaSeleccionada >=0) {
				IdProducto = textId.getText();
				IdCategoria = textidCategoria.getText();
				Nombre = textNombre.getText();
				precio = textPrecio.getText();
				conexion.ModificarProducto();
				table.setModel(conexion.ConsultaTablaProductos());}
				else {
					JOptionPane.showMessageDialog(btnEditar, "Fila NO Seleccionada");
				}
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnEliminar.setBackground(new Color(220, 220, 220));
		btnEliminar.setBounds(42, 344, 253, 38);
		frame.getContentPane().add(btnEliminar);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int FilaSeleccionada = table.getSelectedRow();
				
				if(FilaSeleccionada >=0) {
				int filaa;
				filaa= (Integer)table.getSelectedRow();
				Object id=table.getValueAt(filaa, 0);
				((DefaultTableModel)table.getModel()).removeRow(filaa);
				DefaultTableModel data = new DefaultTableModel();
				conexion.borrarProducto();
				}else {
					JOptionPane.showMessageDialog(btnEliminar, "Fila NO Seleccionada");
				}
			}
		});
		
		JLabel label_3 = new JLabel("Id");
		label_3.setForeground(Color.BLACK);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		label_3.setBounds(317, 61, 97, 21);
		frame.getContentPane().add(label_3);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setForeground(Color.BLACK);
		lblNombre_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNombre_1.setBackground(Color.LIGHT_GRAY);
		lblNombre_1.setBounds(504, 61, 97, 21);
		frame.getContentPane().add(lblNombre_1);
		
		JLabel lblIdCategoria = new JLabel("Id Categoria");
		lblIdCategoria.setForeground(Color.BLACK);
		lblIdCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdCategoria.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblIdCategoria.setBounds(417, 61, 89, 21);
		frame.getContentPane().add(lblIdCategoria);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblPrecio.setBounds(593, 61, 97, 21);
		frame.getContentPane().add(lblPrecio);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNombre.setBounds(44, 153, 125, 31);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setForeground(Color.BLACK);
		lblPrecio_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblPrecio_1.setBounds(42, 187, 125, 26);
		frame.getContentPane().add(lblPrecio_1);
		
		textId = new JTextField();
		textId.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		textId.setColumns(10);
		textId.setBounds(168, 93, 127, 20);
		frame.getContentPane().add(textId);
		
		textidCategoria = new JTextField();
		textidCategoria.setBounds(168, 124, 127, 20);
		frame.getContentPane().add(textidCategoria);
		textidCategoria.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		textNombre.setBounds(168, 155, 127, 22);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		textPrecio.setBounds(168, 187, 127, 26);
		frame.getContentPane().add(textPrecio);
		textPrecio.setColumns(10);
		
		JButton botonAtras = new JButton("");
		botonAtras.setIcon(new ImageIcon(Pantalla1_1_2.class.getResource("/img/arrow_left.png")));
		botonAtras.setBounds(10, 11, 50, 44);
		frame.getContentPane().add(botonAtras);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			
			new String[] {
				"New column", "New column"
			}
		));
		table_1.setModel(conexion.ConsultaTablaCategoria());
		table_1.setBounds(705, 93, 140, 240);
		frame.getContentPane().add(table_1);
		
		JLabel lblIdcategoria = new JLabel("Id_categoria");
		lblIdcategoria.setBounds(703, 66, 71, 14);
		frame.getContentPane().add(lblIdcategoria);
		
		JLabel lblNombre_2 = new JLabel("Nombre.Cat");
		lblNombre_2.setBounds(784, 66, 61, 14);
		frame.getContentPane().add(lblNombre_2);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon(Pantalla1_1_2.class.getResource("/img/macanimated_by_zeeleck.png")));
		label_1.setBounds(0, 0, 855, 413);
		frame.getContentPane().add(label_1);
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla1_1 pantalla1_1 = new Pantalla1_1();
				pantalla1_1.frame.setVisible(true);
				Pantalla1_1_2.frame.setVisible(false);
			}
		});
	}
}
