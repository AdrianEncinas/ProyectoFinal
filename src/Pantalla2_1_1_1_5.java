import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Pantalla2_1_1_1_5 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla2_1_1_1_5 window = new Pantalla2_1_1_1_5();
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
	public Pantalla2_1_1_1_5() {
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
		
		JLabel lblCarvezas = new JLabel("Cervezas");
		lblCarvezas.setBounds(170, 11, 46, 14);
		frame.getContentPane().add(lblCarvezas);
		
		JButton btnConAlcohol = new JButton("Con alcohol");
		btnConAlcohol.setBounds(39, 84, 117, 91);
		frame.getContentPane().add(btnConAlcohol);
		
		JButton btnSinAlcohol = new JButton("Sin alcohol");
		btnSinAlcohol.setBounds(247, 84, 117, 91);
		frame.getContentPane().add(btnSinAlcohol);
	}

}
