import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Pantalla2_1 {

	static JFrame frame;
	private ConexionBBDD conexion;

	/**
	 * Create the application.
	 */
	public Pantalla2_1() {
		
		conexion  = new ConexionBBDD();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 423, 219);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);
	     frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	     frame.setVisible(true);
		
		JButton btnIniciarNuevoPedido = new JButton("Iniciar Nuevo Pedido");
		btnIniciarNuevoPedido.setBounds(72, 64, 269, 58);
		frame.getContentPane().add(btnIniciarNuevoPedido);
		btnIniciarNuevoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla2_1_1 pantallaBar = new Pantalla2_1_1();
				pantallaBar.frame.setVisible(true);
				Pantalla2_1.frame.setVisible(false);
			}
		});
		
		JButton btnAadirComandasA = new JButton("A\u00F1adir Comandas a un pedido existente");
		btnAadirComandasA.setBounds(72, 133, 269, 23);
		frame.getContentPane().add(btnAadirComandasA);
		
		JLabel lblBar = new JLabel("BAR");
		lblBar.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		lblBar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBar.setBounds(171, 11, 59, 34);
		frame.getContentPane().add(lblBar);
		
		JButton botonAtras = new JButton("");
		botonAtras.setIcon(new ImageIcon(Pantalla2_1.class.getResource("/img/arrow_left.png")));
		botonAtras.setBounds(10, 11, 50, 44);
		frame.getContentPane().add(botonAtras);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Pantalla2_1.class.getResource("/img/fondo-de-malla-degradado-abstracto-borrosa_1159-3174.jpg")));
		lblNewLabel.setBounds(0, 0, 407, 180);
		frame.getContentPane().add(lblNewLabel);
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla1 pantallaPrincipal = new Pantalla1();
				pantallaPrincipal.frame.setVisible(true);
				Pantalla2_1.frame.setVisible(false);
			}
		});
	}
}
