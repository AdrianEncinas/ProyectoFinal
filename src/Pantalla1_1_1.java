import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.Point;
import java.sql.*;


public class Pantalla1_1_1 {

	static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private ConexionBBDD conexion;
	static String Nombre;
	static String Id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla1_1_1 window = new Pantalla1_1_1();
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
	public Pantalla1_1_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		conexion = new ConexionBBDD();
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 426, 307);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
		JLabel lblAadirCategoria = new JLabel("A\u00F1adir Categoria");
		lblAadirCategoria.setFont(new Font("Haettenschweiler", Font.PLAIN, 20));
		lblAadirCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirCategoria.setBounds(73, 4, 107, 24);
		frame.getContentPane().add(lblAadirCategoria);
		
		textField = new JTextField();
		textField.setBounds(120, 78, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblCategoria.setBounds(49, 78, 67, 17);
		frame.getContentPane().add(lblCategoria);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBackground(new Color(128, 128, 128));
		btnAadir.setForeground(Color.BLACK);
		btnAadir.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		btnAadir.setBounds(49, 109, 157, 38);
		frame.getContentPane().add(btnAadir);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nombre = textField.getText();
				Id = textField_1.getText();
				
				if(Nombre!="" && Id!="") {
					
					DefaultTableModel data = (DefaultTableModel) table.getModel();
					String[] fila = {Id, Nombre};
					data.addRow(fila);
					conexion.InsertarCategoria();
					
				}
			}
		});
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(240, 11, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBackground(Color.LIGHT_GRAY);
		lblNombre.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(311, 11, 60, 14);
		frame.getContentPane().add(lblNombre);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setBackground(new Color(128, 128, 128));
		btnEliminar.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		btnEliminar.setBounds(49, 206, 157, 38);
		frame.getContentPane().add(btnEliminar);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nombre = textField.getText();
				Id = textField_1.getText();
				int numero = 0;
				
				
				if(Nombre!="" && Id!="") {
					
					DefaultTableModel data = (DefaultTableModel) table.getModel();
					String[] fila = {Id, Nombre};
					conexion.borrarCategoria();
					//((DefaultTableModel)table.getModel()).removeRow(rowToRemove);
				}
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 47, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId_1 = new JLabel("Id:");
		lblId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblId_1.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		lblId_1.setBounds(49, 47, 46, 14);
		frame.getContentPane().add(lblId_1);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setBackground(new Color(128, 128, 128));
		btnEditar.setFont(new Font("Haettenschweiler", Font.PLAIN, 16));
		btnEditar.setBounds(49, 158, 157, 38);
		frame.getContentPane().add(btnEditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 36, 150, 223);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"3", "Bebidas"},
				{"1", "pescado"},
				{"2", "carne"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"ID_CATEGORIA", "NOMBRE"
			}
		));
		table.setModel(conexion.ConsultaTablaCategoria());
		scrollPane.setViewportView(table);
		
		
		JButton botonAtras = new JButton("");
		botonAtras.setBounds(10, 4, 50, 44);
		frame.getContentPane().add(botonAtras);
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla1_1 pantalla1_1 = new Pantalla1_1();
				pantalla1_1.frame.setVisible(true);
				Pantalla1_1_1.frame.setVisible(false);
			}
		});
		}
	}

