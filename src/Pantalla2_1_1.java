import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;

public class Pantalla2_1_1 {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla2_1_1 window = new Pantalla2_1_1();
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
	public Pantalla2_1_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 314, 182);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNumeroDeMesa = new JLabel("Numero de Mesa");
		lblNumeroDeMesa.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblNumeroDeMesa.setBounds(36, 58, 99, 20);
		frame.getContentPane().add(lblNumeroDeMesa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.BLACK);
		comboBox.setFont(new Font("Haettenschweiler", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox.setBounds(137, 56, 45, 26);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Seleccionar Mesa");
		lblNewLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(84, 11, 124, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setBackground(Color.DARK_GRAY);
		btnAceptar.setBounds(70, 100, 99, 20);
		frame.getContentPane().add(btnAceptar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
			},
			new String[] {
				"MESAS"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(211, 77, 69, 48);
		frame.getContentPane().add(table);
		
		JLabel lblMesas = new JLabel("Mesas");
		lblMesas.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblMesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesas.setBounds(201, 52, 89, 14);
		frame.getContentPane().add(lblMesas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(201, 70, 89, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(201, 48, 87, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(84, 32, 124, 2);
		frame.getContentPane().add(separator_2);
	}
}
