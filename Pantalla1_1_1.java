
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.awt.Point;
import java.sql.*;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.MouseEvent;



public class Pantalla1_1_1 {

	static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private ConexionBBDD conexion;
	static String Nombre;
	static String Id;


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
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 610, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = table.rowAtPoint(e.getPoint());
				
				textField_1.setText((String)table.getValueAt(select, 0));
				textField.setText((String)table.getValueAt(select, 1));
				
				Nombre=textField.getText();
				Id=textField_1.getText();
			}
		});
		
		JLabel lblAadirCategoria = new JLabel("A\u00F1adir Categoria");
		lblAadirCategoria.setForeground(Color.BLACK);
		lblAadirCategoria.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAadirCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirCategoria.setBounds(70, 11, 192, 37);
		frame.getContentPane().add(lblAadirCategoria);
		
		textField = new JTextField();
		textField.setBounds(125, 113, 118, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(Color.BLACK);
		lblCategoria.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblCategoria.setBounds(25, 112, 101, 21);
		frame.getContentPane().add(lblCategoria);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBackground(new Color(204, 204, 204));
		btnAadir.setForeground(Color.BLACK);
		btnAadir.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnAadir.setBounds(35, 154, 195, 38);
		frame.getContentPane().add(btnAadir);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nombre = textField.getText();
				Id = textField_1.getText();
				
				if(!Nombre.isEmpty() && !Id.isEmpty()) {
					
					DefaultTableModel data = (DefaultTableModel) table.getModel();
					String[] fila = {Id, Nombre};
					data.addRow(fila);
					conexion.InsertarCategoria();
					
				}else {
					JOptionPane.showMessageDialog(btnAadir, "Datos no introducidos");
				}
			}
		});
		
		JLabel lblId = new JLabel("Id");
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(272, 13, 146, 23);
		frame.getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setBackground(Color.LIGHT_GRAY);
		lblNombre.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(419, 11, 146, 25);
		frame.getContentPane().add(lblNombre);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setBackground(new Color(204, 204, 204));
		btnEliminar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnEliminar.setBounds(34, 276, 196, 38);
		frame.getContentPane().add(btnEliminar);
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int FilaSeleccionada = table.getSelectedRow();
				
				if(FilaSeleccionada >=0) {
				int filaa;
				filaa= (Integer)table.getSelectedRow();
				Object id=table.getValueAt(filaa, 0);
				((DefaultTableModel)table.getModel()).removeRow(filaa);
				DefaultTableModel data = new DefaultTableModel();
				conexion.borrarCategoria();
				}else {
					JOptionPane.showMessageDialog(btnEliminar, "Fila NO Seleccionada");
				}
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 81, 118, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId_1 = new JLabel("Id:");
		lblId_1.setForeground(Color.BLACK);
		lblId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblId_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblId_1.setBounds(25, 81, 101, 21);
		frame.getContentPane().add(lblId_1);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setBackground(new Color(204, 204, 204));
		btnEditar.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnEditar.setBounds(35, 214, 195, 38);
		frame.getContentPane().add(btnEditar);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nombre = textField.getText();
				Id = textField_1.getText();
				conexion.ModificarCategoria();
				table.setModel(conexion.ConsultaTablaCategoria());
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(282, 36, 283, 290);
		frame.getContentPane().add(scrollPane);
		
		
		table.setFont(new Font("Century Gothic", Font.PLAIN, 11));
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
		botonAtras.setIcon(new ImageIcon(Pantalla1_1_1.class.getResource("/img/arrow_left.png")));
		botonAtras.setForeground(new Color(0, 0, 0));
		botonAtras.setBackground(new Color(204, 204, 204));
		botonAtras.setBounds(10, 4, 50, 44);
		frame.getContentPane().add(botonAtras);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Pantalla1_1_1.class.getResource("/img/macanimated_by_zeeleck.png")));
		lblNewLabel.setBounds(0, 0, 594, 350);
		frame.getContentPane().add(lblNewLabel);
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pantalla1_1 pantalla1_1 = new Pantalla1_1();
				pantalla1_1.frame.setVisible(true);
				Pantalla1_1_1.frame.setVisible(false);
			}
		});
		}
	}

