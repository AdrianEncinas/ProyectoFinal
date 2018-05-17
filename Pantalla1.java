import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Pantalla1 {

	static JFrame frame;

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
		frame.setBounds(100, 100, 290, 217);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	     frame.setLocationRelativeTo(null);
	     frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	     frame.setVisible(true);
		
		JLabel lblAfter = new JLabel("Afternoon");
		lblAfter.setFont(new Font("Segoe Script", Font.BOLD, 25));
		lblAfter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAfter.setBounds(0, 11, 264, 40);
		frame.getContentPane().add(lblAfter);
		
		JButton btnAdministracin = new JButton("Administraci\u00F3n");
		btnAdministracin.setFont(new Font("Segoe Script", Font.PLAIN, 15));
		btnAdministracin.setBounds(45, 133, 185, 26);
		frame.getContentPane().add(btnAdministracin);
		
		btnAdministracin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla1_1 pantallaAdministracion = new Pantalla1_1();
				pantallaAdministracion.frame.setVisible(true);
				Pantalla1.frame.setVisible(false);
			}
		});
		
		JButton btnBar = new JButton("BAR");
		btnBar.setFont(new Font("Segoe Script", Font.PLAIN, 15));
		btnBar.setBounds(45, 62, 185, 60);
		frame.getContentPane().add(btnBar);
		
		JLabel lblA = new JLabel("a");
		lblA.setIcon(new ImageIcon(Pantalla1.class.getResource("/img/fondo-de-malla-degradado-abstracto-borrosa_1159-3174.jpg")));
		lblA.setBounds(0, 0, 274, 178);
		frame.getContentPane().add(lblA);
		
		btnBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla2_1 pantallaBar = new Pantalla2_1();
				pantallaBar.frame.setVisible(true);
				Pantalla1.frame.setVisible(false);
			}
		});
	}
}
