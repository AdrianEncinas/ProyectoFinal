import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ticket {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the application.
	 */
	public ticket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTicket = new JLabel("TICKET ");
		lblTicket.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTicket.setBounds(151, 22, 110, 34);
		frame.getContentPane().add(lblTicket);
		
		JButton btnEfectivo = new JButton("EFECTIVO");
		btnEfectivo.setBounds(35, 81, 100, 34);
		frame.getContentPane().add(btnEfectivo);
		
		JButton btnTarjeta = new JButton("TARJETA");
		btnTarjeta.setBounds(35, 143, 100, 34);
		frame.getContentPane().add(btnTarjeta);
		
		JLabel lblEntregado = new JLabel("Entregado");
		lblEntregado.setBounds(191, 81, 70, 14);
		frame.getContentPane().add(lblEntregado);
		
		JLabel lblCambiado = new JLabel("Cambiado");
		lblCambiado.setBounds(191, 106, 70, 14);
		frame.getContentPane().add(lblCambiado);
		
		textField = new JTextField();
		textField.setBounds(263, 78, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(263, 106, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}

}
