import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla2_1 {

	static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla2_1 window = new Pantalla2_1();
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
	public Pantalla2_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 407, 248);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnIniciarNuevoPedido = new JButton("Iniciar Nuevo Pedido");
		btnIniciarNuevoPedido.setBounds(72, 57, 237, 47);
		frame.getContentPane().add(btnIniciarNuevoPedido);
		
		JButton btnAadirComandasA = new JButton("A\u00F1adir Comandas a un pedido existente");
		btnAadirComandasA.setBounds(72, 126, 237, 47);
		frame.getContentPane().add(btnAadirComandasA);
		
		JLabel lblBar = new JLabel("BAR");
		lblBar.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		lblBar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBar.setBounds(155, 11, 59, 23);
		frame.getContentPane().add(lblBar);
		
		JButton botonAtras = new JButton("");
		botonAtras.setBounds(10, 11, 50, 44);
		frame.getContentPane().add(botonAtras);
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla1 pantallaPrincipal = new Pantalla1();
				pantallaPrincipal.frame.setVisible(true);
				Pantalla2_1.frame.setVisible(false);
			}
		});
	}
}
