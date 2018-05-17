import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Pantalla2_1_1 {

	static JFrame frame;
	private JTable table;
	private JTextField textField;
	private ConexionBBDD conexion;
	static String num_mesa;

	/**
	 * Create the application.
	 */
	public Pantalla2_1_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		conexion = new ConexionBBDD();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 325, 232);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
		JLabel lblNumeroDeMesa = new JLabel("Numero de Mesa:");
		lblNumeroDeMesa.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblNumeroDeMesa.setBounds(50, 80, 99, 31);
		frame.getContentPane().add(lblNumeroDeMesa);
		
		JLabel lblNewLabel = new JLabel("Seleccionar Mesa");
		lblNewLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 24, 124, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBackground(Color.DARK_GRAY);
		btnAceptar.setBounds(84, 122, 99, 33);
		frame.getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num_mesa = textField.getText();
				if(!num_mesa.isEmpty()) {
					Pantalla2_1_1_1 pantallaBar = new Pantalla2_1_1_1();
					pantallaBar.frame.setVisible(true);
					Pantalla2_1_1_2 pantalla2_1_1_2 = new Pantalla2_1_1_2();
					pantalla2_1_1_2.frame.setVisible(true);
					Pantalla2_1_1.frame.setVisible(false);
					//conexion.MesaOcupada();
					conexion.crearComanda();
				}else {
					JOptionPane.showMessageDialog(btnAceptar, "Mesa no introducida");
				}
			}
		});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"ID_MESA"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setModel(conexion.ConsultaMesa());
		table.setBounds(225, 99, 74, 83);
		frame.getContentPane().add(table);
		
		JLabel lblMesas = new JLabel("Mesas libres");
		lblMesas.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblMesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesas.setBounds(215, 74, 89, 14);
		frame.getContentPane().add(lblMesas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(215, 92, 89, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(215, 70, 87, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(95, 45, 124, 2);
		frame.getContentPane().add(separator_2);
		
		textField = new JTextField();
		textField.setBounds(145, 87, 44, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Pantalla2_1_1.class.getResource("/img/arrow_left.png")));
		button.setBounds(10, 14, 50, 44);
		frame.getContentPane().add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla2_1 pantalla2_1 = new Pantalla2_1();
				Pantalla2_1_1.frame.setVisible(false);
				pantalla2_1.frame.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Pantalla2_1_1.class.getResource("/img/fondo-de-malla-degradado-abstracto-borrosa_1159-3174.jpg")));
		lblNewLabel_1.setBounds(0, 0, 309, 193);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
