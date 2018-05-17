import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Pantalla2_1_1_1_1 {

	static JFrame frame;
	private ConexionBBDD conexion;
	private JFormattedTextField textoCarne;
	private JTextField textoPOLLO;
	static int texto;
	int sumaCantCarne = 0;
	int restaCantCarne = 0;
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
		conexion = new ConexionBBDD();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 687, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(258, 32, 146, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblHamburguesas = new JLabel("HAMBURGUESAS");
		lblHamburguesas.setFont(new Font("Haettenschweiler", Font.PLAIN, 26));
		lblHamburguesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblHamburguesas.setBounds(233, 0, 195, 43);
		frame.getContentPane().add(lblHamburguesas);
		
		JButton btnCarne = new JButton("");
		btnCarne.setIcon(new ImageIcon(Pantalla2_1_1_1_1.class.getResource("/img/3603b4_055b8a0a66694adba9f2247b9a5a4d3a_mv2.jpg")));
		btnCarne.setBounds(36, 70, 265, 265);
		frame.getContentPane().add(btnCarne);
		
		
		JButton btnPollo = new JButton("");
		btnPollo.setIcon(new ImageIcon(Pantalla2_1_1_1_1.class.getResource("/img/cadd20_f69727e71b14433a9719f86af48ad234.jpg")));
		btnPollo.setBounds(369, 70, 265, 265);
		frame.getContentPane().add(btnPollo);
		
		JLabel lblNewLabel = new JLabel("Carne");
		lblNewLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 39, 265, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPollo = new JLabel("Pollo");
		lblPollo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPollo.setFont(new Font("Haettenschweiler", Font.PLAIN, 24));
		lblPollo.setBounds(369, 45, 265, 20);
		frame.getContentPane().add(lblPollo);
		
		JButton atras = new JButton("");
		atras.setIcon(new ImageIcon(Pantalla2_1_1_1_1.class.getResource("/img/arrow_left.png")));
		atras.setBounds(10, 9, 56, 50);
		frame.getContentPane().add(atras);
		
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla2_1_1_1 pantalla2_1_1_1 = new Pantalla2_1_1_1();
				pantalla2_1_1_1.frame.setVisible(true);
				Pantalla2_1_1_1_1.frame.setVisible(false);
			}
		});
		
		textoCarne = new JFormattedTextField(new Integer(0));
		textoCarne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textoCarne.setBounds(149, 346, 36, 29);
		frame.getContentPane().add(textoCarne);
		textoCarne.setColumns(10);
		textoCarne.setColumns(1);
		
		JButton BotonCarneMAS = new JButton("+");
		BotonCarneMAS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sumaCantCarne = (int) textoCarne.getValue();
				sumaCantCarne++;
				textoCarne.setValue(sumaCantCarne);
				
			}
		});
		BotonCarneMAS.setBounds(195, 346, 46, 29);
		frame.getContentPane().add(BotonCarneMAS);
		
		JButton menosCarne = new JButton("-");
		menosCarne.setBounds(94, 346, 45, 29);
		frame.getContentPane().add(menosCarne);
		menosCarne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((int) textoCarne.getValue() > 0) {
					restaCantCarne = (int) textoCarne.getValue();
					restaCantCarne--;
					textoCarne.setValue(restaCantCarne);	
				}else {
					JOptionPane.showMessageDialog(menosCarne, "Cantidad incorrecta");
				}
			}
		});
		
		JButton añadirCarne = new JButton("A\u00F1adir");
		añadirCarne.setBounds(94, 386, 147, 33);
		frame.getContentPane().add(añadirCarne);
		
		añadirCarne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				texto=(int) textoCarne.getValue();
				conexion.añadirCarne();
				Pantalla2_1_1_2 pantalla = new Pantalla2_1_1_2();
				pantalla.table.setModel(conexion.ConsultaTablaComanda());
			}
		});
		
		JButton buttonpolloMAS = new JButton("+");
		buttonpolloMAS.setBounds(532, 346, 46, 29);
		frame.getContentPane().add(buttonpolloMAS);
		
		textoPOLLO = new JTextField();
		textoPOLLO.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textoPOLLO.setColumns(10);
		textoPOLLO.setBounds(486, 346, 36, 29);
		frame.getContentPane().add(textoPOLLO);
		
		JButton añadirPollo = new JButton("A\u00F1adir");
		añadirPollo.setBounds(430, 386, 147, 33);
		frame.getContentPane().add(añadirPollo);
		
		JButton botonpolloMENOS = new JButton("-");
		botonpolloMENOS.setBounds(430, 346, 45, 29);
		frame.getContentPane().add(botonpolloMENOS);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Pantalla2_1_1_1_1.class.getResource("/img/fondo1.jpg")));
		lblNewLabel_1.setBounds(0, 0, 671, 430);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
