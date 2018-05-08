import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Pantalla2_1_1_2 {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla2_1_1_2 window = new Pantalla2_1_1_2();
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
	public Pantalla2_1_1_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 451, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBounds(200, 58, 225, 320);
		frame.getContentPane().add(table);
		
		JLabel label = new JLabel("Articulo");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(254, 41, 102, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Cantidad");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(200, 41, 56, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Total");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(356, 41, 56, 14);
		frame.getContentPane().add(label_2);
		
		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Haettenschweiler", Font.PLAIN, 24));
		lblTotal.setBounds(10, 76, 114, 47);
		frame.getContentPane().add(lblTotal);
		
		textField = new JTextField();
		textField.setBounds(92, 84, 86, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNMesa = new JLabel("N\u00BA MESA:");
		lblNMesa.setFont(new Font("Haettenschweiler", Font.PLAIN, 23));
		lblNMesa.setBounds(10, 134, 65, 26);
		frame.getContentPane().add(lblNMesa);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 134, 86, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnPagar = new JButton("PAGAR");
		btnPagar.setBackground(Color.BLACK);
		btnPagar.setBounds(27, 201, 137, 48);
		frame.getContentPane().add(btnPagar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBackground(Color.BLACK);
		btnCancelar.setBounds(27, 260, 137, 47);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblComanda = new JLabel("COMANDA");
		lblComanda.setHorizontalAlignment(SwingConstants.CENTER);
		lblComanda.setFont(new Font("Haettenschweiler", Font.PLAIN, 23));
		lblComanda.setBounds(159, 11, 114, 19);
		frame.getContentPane().add(lblComanda);
	}
}
