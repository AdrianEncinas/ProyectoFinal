import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Pantalla2_1_1_1_4 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla2_1_1_1_4 window = new Pantalla2_1_1_1_4();
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
	public Pantalla2_1_1_1_4() {
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
		
		JLabel lblNewLabel = new JLabel("Bebidas");
		lblNewLabel.setBounds(191, 22, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCocacola = new JButton("Coca-Cola");
		btnCocacola.setBounds(49, 93, 113, 75);
		frame.getContentPane().add(btnCocacola);
		
		JButton btnFanta = new JButton("Fanta");
		btnFanta.setBounds(254, 93, 113, 75);
		frame.getContentPane().add(btnFanta);
	}

}
