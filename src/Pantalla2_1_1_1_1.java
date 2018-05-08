import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;

public class Pantalla2_1_1_1_1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla2_1_1_1_1 window = new Pantalla2_1_1_1_1();
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
	public Pantalla2_1_1_1_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 672, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHamburguesas = new JLabel("HAMBURGUESAS");
		lblHamburguesas.setFont(new Font("Haettenschweiler", Font.PLAIN, 26));
		lblHamburguesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblHamburguesas.setBounds(233, 0, 195, 43);
		frame.getContentPane().add(lblHamburguesas);
		
		JButton btnCarne = new JButton("");
		btnCarne.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\3603b4_055b8a0a66694adba9f2247b9a5a4d3a_mv2.jpg"));
		btnCarne.setBounds(36, 70, 265, 265);
		frame.getContentPane().add(btnCarne);
		
		JButton btnPollo = new JButton("");
		btnPollo.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\cadd20_f69727e71b14433a9719f86af48ad234.jpg"));
		btnPollo.setBounds(369, 70, 265, 265);
		frame.getContentPane().add(btnPollo);
		
		JLabel lblNewLabel = new JLabel("Carne");
		lblNewLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 45, 265, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPollo = new JLabel("Pollo");
		lblPollo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPollo.setFont(new Font("Haettenschweiler", Font.PLAIN, 24));
		lblPollo.setBounds(369, 45, 265, 20);
		frame.getContentPane().add(lblPollo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(258, 32, 146, 2);
		frame.getContentPane().add(separator);
	}

}
