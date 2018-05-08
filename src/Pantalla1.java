import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;

public class Pantalla1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla1 window = new Pantalla1();
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
	public Pantalla1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 306, 248);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAfter = new JLabel("Afternoon");
		lblAfter.setFont(new Font("Haettenschweiler", Font.PLAIN, 18));
		lblAfter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAfter.setBounds(85, 11, 99, 14);
		frame.getContentPane().add(lblAfter);
		
		JButton btnAdministracin = new JButton("Administraci\u00F3n");
		btnAdministracin.setBounds(45, 48, 174, 51);
		frame.getContentPane().add(btnAdministracin);
		
		JButton btnBar = new JButton("BAR");
		btnBar.setBounds(45, 122, 174, 51);
		frame.getContentPane().add(btnBar);
	}
}
