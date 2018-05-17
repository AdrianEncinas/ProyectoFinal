import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Pantalla2_1_1_1 {

	static JFrame frame;
	static String hamburguesas;
	private ConexionBBDD conexion;

	/**
	 * Create the application.
	 */
	public Pantalla2_1_1_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		conexion = new ConexionBBDD();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(200, 200, 1196, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
	    
		JButton BotonBebida = new JButton("");
		BotonBebida.setBackground(Color.BLACK);
		BotonBebida.setForeground(Color.BLACK);
		BotonBebida.setIcon(new ImageIcon(Pantalla2_1_1_1.class.getResource("/img/drink_20623.png")));
		BotonBebida.setBounds(113, 324, 137, 137);
		frame.getContentPane().add(BotonBebida);
		
		JButton BotonCafe = new JButton("");
		BotonCafe.setForeground(Color.BLACK);
		BotonCafe.setBackground(Color.BLACK);
		BotonCafe.setIcon(new ImageIcon(Pantalla2_1_1_1.class.getResource("/img/coffee-bean-icon.png")));
		BotonCafe.setBounds(963, 324, 137, 137);
		frame.getContentPane().add(BotonCafe);
		
		JButton BotonHamburguesa = new JButton("");
		BotonHamburguesa.setBackground(Color.BLACK);
		BotonHamburguesa.setForeground(Color.BLACK);
		BotonHamburguesa.setIcon(new ImageIcon(Pantalla2_1_1_1.class.getResource("/img/burger-icon.png")));
		BotonHamburguesa.setBounds(209, 88, 137, 137);
		frame.getContentPane().add(BotonHamburguesa);
		BotonHamburguesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla2_1_1_1_1 pantallaHamburguesa = new Pantalla2_1_1_1_1();
				pantallaHamburguesa.frame.setVisible(true);
				Pantalla2_1_1_1.frame.setVisible(false);
			}
		});
		
		JButton BotonCervezas = new JButton("");
		BotonCervezas.setForeground(Color.BLACK);
		BotonCervezas.setBackground(Color.BLACK);
		BotonCervezas.setIcon(new ImageIcon(Pantalla2_1_1_1.class.getResource("/img/beer-icon.png")));
		BotonCervezas.setBounds(391, 324, 137, 137);
		frame.getContentPane().add(BotonCervezas);
		
		JButton BotonCopas = new JButton("");
		BotonCopas.setForeground(Color.BLACK);
		BotonCopas.setBackground(Color.BLACK);
		BotonCopas.setIcon(new ImageIcon(Pantalla2_1_1_1.class.getResource("/img/drink-2-icon.png")));
		BotonCopas.setBounds(678, 324, 137, 137);
		frame.getContentPane().add(BotonCopas);
		
		JButton BotonPizza = new JButton("");
		BotonPizza.setBackground(Color.BLACK);
		BotonPizza.setForeground(Color.BLACK);
		BotonPizza.setIcon(new ImageIcon(Pantalla2_1_1_1.class.getResource("/img/pizzaaaaaaaaaaa.png")));
		BotonPizza.setBounds(538, 88, 137, 137);
		frame.getContentPane().add(BotonPizza);
		
		JButton BotonPostres = new JButton("");
		BotonPostres.setBackground(Color.BLACK);
		BotonPostres.setForeground(Color.BLACK);
		BotonPostres.setIcon(new ImageIcon(Pantalla2_1_1_1.class.getResource("/img/icecream-2-icon.png")));
		BotonPostres.setBounds(878, 88, 137, 137);
		frame.getContentPane().add(BotonPostres);
		
		JLabel lblHamburguesas = new JLabel("Hamburguesas");
		lblHamburguesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblHamburguesas.setFont(new Font("Haettenschweiler", Font.PLAIN, 26));
		lblHamburguesas.setBounds(209, 236, 137, 28);
		frame.getContentPane().add(lblHamburguesas);
		
		JLabel lblPizzas = new JLabel("Pizzas");
		lblPizzas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizzas.setFont(new Font("Haettenschweiler", Font.PLAIN, 26));
		lblPizzas.setBounds(525, 236, 161, 28);
		frame.getContentPane().add(lblPizzas);
		
		JLabel lblHelados = new JLabel("Helados");
		lblHelados.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelados.setFont(new Font("Haettenschweiler", Font.PLAIN, 26));
		lblHelados.setBounds(865, 236, 161, 28);
		frame.getContentPane().add(lblHelados);
		
		JLabel lblBebidas = new JLabel("Bebidas");
		lblBebidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBebidas.setFont(new Font("Haettenschweiler", Font.PLAIN, 26));
		lblBebidas.setBounds(100, 472, 161, 28);
		frame.getContentPane().add(lblBebidas);
		
		JLabel lblCervezas = new JLabel("Cervezas");
		lblCervezas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCervezas.setFont(new Font("Haettenschweiler", Font.PLAIN, 26));
		lblCervezas.setBounds(381, 472, 161, 28);
		frame.getContentPane().add(lblCervezas);
		
		JLabel lblCopas = new JLabel("Copas");
		lblCopas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopas.setFont(new Font("Haettenschweiler", Font.PLAIN, 26));
		lblCopas.setBounds(668, 472, 161, 28);
		frame.getContentPane().add(lblCopas);
		
		JLabel lblCafe = new JLabel("Cafe");
		lblCafe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCafe.setFont(new Font("Haettenschweiler", Font.PLAIN, 26));
		lblCafe.setBounds(963, 472, 137, 28);
		frame.getContentPane().add(lblCafe);
		
		JLabel lblCategorias = new JLabel("CATEGORIAS");
		lblCategorias.setFont(new Font("Haettenschweiler", Font.PLAIN, 26));
		lblCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategorias.setBounds(525, 19, 161, 28);
		frame.getContentPane().add(lblCategorias);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 1189, 3);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 285, 1188, 2);
		frame.getContentPane().add(separator_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Pantalla2_1_1_1.class.getResource("/img/arrow_left.png")));
		button.setBounds(22, 3, 56, 50);
		frame.getContentPane().add(button);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Pantalla2_1_1_1.class.getResource("/img/smooth-blaze.jpg")));
		lblNewLabel.setBounds(0, 0, 1180, 548);
		frame.getContentPane().add(lblNewLabel);
	}
}
