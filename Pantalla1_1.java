import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Pantalla1_1 {

	static JFrame frame;

	/**
	 * Create the application.
	 */
	public Pantalla1_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 473, 274);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Administraci\u00F3n");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(99, 35, 245, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JButton botonProducto = new JButton("Productos");
		botonProducto.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		botonProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla1_1_2 pantallaProducto = new Pantalla1_1_2();
				pantallaProducto.frame.setVisible(true);
				Pantalla1_1.frame.setVisible(false);
			}
		});
		botonProducto.setBounds(259, 99, 175, 91);
		frame.getContentPane().add(botonProducto);
		
		JButton botonCategoria = new JButton("Categorias");
		botonCategoria.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		botonCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla1_1_1 pantallaCategoria = new Pantalla1_1_1();
				pantallaCategoria.frame.setVisible(true);
				Pantalla1_1.frame.setVisible(false);
			}
		});
		botonCategoria.setBounds(20, 99, 175, 91);
		frame.getContentPane().add(botonCategoria);
		
		JButton botonAtras = new JButton("");
		botonAtras.setIcon(new ImageIcon(Pantalla1_1.class.getResource("/img/arrow_left.png")));
		botonAtras.setBounds(10, 11, 50, 44);
		frame.getContentPane().add(botonAtras);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Pantalla1_1.class.getResource("/img/macanimated_by_zeeleck.png")));
		lblNewLabel_1.setBounds(0, 0, 464, 242);
		frame.getContentPane().add(lblNewLabel_1);
		
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla1 pantallaPrincipal = new Pantalla1();
				pantallaPrincipal.frame.setVisible(true);
				Pantalla1_1.frame.setVisible(false);
			}
		});
	}
}
