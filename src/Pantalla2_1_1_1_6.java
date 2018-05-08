import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Pantalla2_1_1_1_6 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla2_1_1_1_6 window = new Pantalla2_1_1_1_6();
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
	public Pantalla2_1_1_1_6() {
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
		
		JLabel lblCopas = new JLabel("Copas");
		lblCopas.setBounds(188, 11, 46, 14);
		frame.getContentPane().add(lblCopas);
		
		JButton btnRon = new JButton("Ron barcelo");
		btnRon.setBounds(22, 118, 89, 23);
		frame.getContentPane().add(btnRon);
		
		JButton btnBombay = new JButton("Bombay");
		btnBombay.setBounds(247, 118, 89, 23);
		frame.getContentPane().add(btnBombay);
	}

}
