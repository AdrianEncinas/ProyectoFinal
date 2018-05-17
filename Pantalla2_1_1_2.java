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
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class Pantalla2_1_1_2 {

	JFrame frame;
	JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private ConexionBBDD conexion;

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
		conexion = new ConexionBBDD();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(1400, 200, 451, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Articulo");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(206, 41, 107, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Cantidad");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(304, 41, 108, 14);
		frame.getContentPane().add(label_1);
		
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
		Pantalla2_1_1 pantallaMesa = new Pantalla2_1_1();
		//textField_1 = pantallaMesa.num_mesa.toString();
		//Nombre=textField.getText();
		textField_1.setText((String)pantallaMesa.num_mesa.toString());
		
		JButton btnPagar = new JButton("PAGAR");
		btnPagar.setBackground(Color.LIGHT_GRAY);
		btnPagar.setBounds(27, 201, 137, 48);
		frame.getContentPane().add(btnPagar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(27, 260, 137, 47);
		frame.getContentPane().add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(222, 66, 203, 309);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
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
			},
			new String[] {
				"ARTICULO", "CANTIDAD"
			}
		));
		table.setModel(conexion.ConsultaTablaComanda());
		
		JLabel lblComanda = new JLabel("COMANDA");
		lblComanda.setHorizontalAlignment(SwingConstants.CENTER);
		lblComanda.setFont(new Font("Haettenschweiler", Font.PLAIN, 23));
		lblComanda.setBounds(159, 11, 114, 19);
		frame.getContentPane().add(lblComanda);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Pantalla2_1_1_2.class.getResource("/img/fondo1.jpg")));
		lblNewLabel.setBounds(0, 0, 435, 386);
		frame.getContentPane().add(lblNewLabel);
	}
}
