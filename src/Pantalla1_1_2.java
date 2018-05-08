import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Pantalla1_1_2 {

	static JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla1_1_2 window = new Pantalla1_1_2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new JFrame();
		frame.setBounds(100, 100, 558, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
		JLabel lblAadirProducto = new JLabel("A\u00F1adir Producto ");
		lblAadirProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirProducto.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		lblAadirProducto.setBounds(70, 29, 107, 24);
		frame.getContentPane().add(lblAadirProducto);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(117, 72, 86, 20);
		frame.getContentPane().add(textField);
		
		JLabel lblIdProducto = new JLabel("Id Producto:");
		lblIdProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdProducto.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblIdProducto.setBounds(22, 72, 70, 14);
		frame.getContentPane().add(lblIdProducto);
		
		JLabel lblProducto = new JLabel("Categoria");
		lblProducto.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblProducto.setBounds(32, 103, 67, 17);
		frame.getContentPane().add(lblProducto);
		
		JButton button = new JButton("A\u00F1adir");
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		button.setBackground(Color.BLACK);
		button.setBounds(48, 220, 157, 38);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Editar");
		button_1.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		button_1.setBackground(Color.BLACK);
		button_1.setBounds(48, 269, 157, 38);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Eliminar");
		button_2.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		button_2.setBackground(Color.BLACK);
		button_2.setBounds(48, 317, 157, 38);
		frame.getContentPane().add(button_2);
		
		table = new JTable();
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
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(232, 58, 285, 226);
		frame.getContentPane().add(table);
		
		JLabel label_3 = new JLabel("Id");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		label_3.setBounds(237, 36, 46, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("NOMBRE");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		label_4.setBackground(Color.LIGHT_GRAY);
		label_4.setBounds(383, 36, 60, 14);
		frame.getContentPane().add(label_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Hamburguesas", "Pizzas", "Helados", "Bebidas", "Cervezas", "Copas", "Cafe"}));
		comboBox.setBounds(117, 103, 105, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblIdCategoria = new JLabel("Id Categoria");
		lblIdCategoria.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblIdCategoria.setBounds(307, 36, 86, 14);
		frame.getContentPane().add(lblIdCategoria);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblPrecio.setBounds(453, 36, 46, 14);
		frame.getContentPane().add(lblPrecio);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblNombre.setBounds(34, 140, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblPrecio_1.setBounds(34, 177, 46, 14);
		frame.getContentPane().add(lblPrecio_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 139, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(117, 174, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton botonAtras = new JButton("");
		botonAtras.setBounds(10, 4, 50, 44);
		frame.getContentPane().add(botonAtras);
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla1_1 pantalla1_1 = new Pantalla1_1();
				pantalla1_1.frame.setVisible(true);
				Pantalla1_1_2.frame.setVisible(false);
			}
		});
	}
}
