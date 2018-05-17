import java.sql.Connection;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;

public class ConexionBBDD {

	private String bd;
	private String url;
	private String usr;
	private String pwd;
	private String esquema;
	private Connection cn;
	private Statement st;
	

	public ConexionBBDD()  {
		ficheroini();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection(url, usr, pwd);
			
			if(!cn.isClosed()) {
				System.out.println("Conexión establecida");
			}
			else
				System.out.println("Fallo en Conexión");	
			

		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");	
			e.printStackTrace();
		}
		
	}
	
	public DefaultTableModel ConsultaTablaCategoria() {
		String [] columnas={"ID_CATEGORIA","NOMBRE"};
		String [] registro=new String[9];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT * FROM "+esquema+".CATEGORIA order by ID_CATEGORIA asc";
		 
		try {
			Statement stmt = cn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("ID_CATEGORIA");
		         registro[1]=rset.getString("NOMBRE");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	
	public DefaultTableModel ConsultaTablaComanda() {
		String [] columnas={"CANTIDAD","ARTICULO"};
		String [] registro=new String[9];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT Id_Producto,cantidad FROM "+esquema+".COMANDAS WHERE ID_COMANDA=(SELECT MAX( id_comanda ) FROM "+esquema+".comandas)";
		 
		try {
			Statement stmt = cn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("ID_PRODUCTO");
		         registro[1]=rset.getString("CANTIDAD");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	public DefaultTableModel ConsultaTablaProductos() {
		String [] columnas={"ID","ID_CATEGORIA","NOMBRE","PRECIO"};
		String [] registro=new String[5];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT * FROM "+esquema+".PRODUCTO order by ID_PRODUCTO asc";
		 
		try {
			Statement stmt = cn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("ID_PRODUCTO");
		         registro[1]=rset.getString("ID_CATEGORIA");
		         registro[2]=rset.getString("NOMBRE");
		         registro[3]=rset.getString("PRECIO");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	public DefaultTableModel ConsultaMesa() {
		String [] columnas={"Id_Mesa"};
		String [] registro=new String[9];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT id_mesa FROM "+esquema+".MESA where ocupada=1 order by ID_MESA asc";
		 
		try {
			Statement stmt = cn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("ID_MESA");
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	
	public int InsertarProducto(){
		
		int resultado=0;
		String query = "INSERT INTO "+esquema+".PRODUCTO VALUES("+Pantalla1_1_2.IdProducto+" , "+Pantalla1_1_2.IdCategoria+" , '"+Pantalla1_1_2.Nombre+"' , "+Pantalla1_1_2.precio+" )";
		 
		try {
			Statement stmt = cn.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return resultado;	
	}
	
	public int InsertarCategoria(){
		
		int resultado=0;
		String query = "INSERT INTO "+esquema+".CATEGORIA VALUES("+Pantalla1_1_1.Id+" , '"+Pantalla1_1_1.Nombre+"')";
		System.out.println(query);
		
		try {
			Statement stmt = cn.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return resultado;	
	}
	
	public int ModificarCategoria() {
		
		int resultado = 0;
		String query = "UPDATE "+esquema+".CATEGORIA set ID_CATEGORIA="+Pantalla1_1_1.Id+", NOMBRE='"+Pantalla1_1_1.Nombre+"' where ID_CATEGORIA="+Pantalla1_1_1.Id+"";
		System.out.println(query);
		
		try {
			Statement stmt = cn.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return resultado;
	}
	
public int ModificarProducto() {
		
		int resultado = 0;
		String query = "UPDATE "+esquema+".producto set ID_PRODUCTO="+Pantalla1_1_2.IdProducto+" , ID_CATEGORIA="+Pantalla1_1_2.IdCategoria+" , NOMBRE='"+Pantalla1_1_2.Nombre+"' , PRECIO="+Pantalla1_1_2.precio+" where id_producto="+Pantalla1_1_2.IdProducto+"";
		System.out.println(query);
		
		try {
			Statement stmt = cn.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return resultado;
	}

	public int borrarCategoria() {
		int resultado=0;
		String query = "DELETE FROM "+esquema+".CATEGORIA WHERE ID_CATEGORIA="+Pantalla1_1_1.Id+" AND NOMBRE='"+Pantalla1_1_1.Nombre+"'";
		try {
			Statement stmt = cn.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return resultado;
	}
	
	public int borrarProducto() {
		int resultado=0;
		String query = "DELETE FROM "+esquema+".PRODUCTO WHERE ID_PRODUCTO="+Pantalla1_1_2.IdProducto+" and ID_CATEGORIA="+Pantalla1_1_2.IdCategoria+" AND NOMBRE='"+Pantalla1_1_2.Nombre+"' and PRECIO="+Pantalla1_1_2.precio+"";
		System.out.println(query);
		try {
			Statement stmt = cn.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return resultado;
	}
	public int crearComanda() {
		int resultado=0;
		String query = "INSERT INTO "+esquema+".comandas( id_comanda, cantidad, id_mesa,id_producto )VALUES ((SELECT MAX( id_comanda ) FROM "+esquema+".comandas) +1,null,"+Pantalla2_1_1.num_mesa+",null)";
		System.out.println(query);
		try {
			Statement stmt = cn.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return resultado;
	}
	public int MesaOcupada() {
		int resultado = 0;
		String query = "UPDATE "+esquema+".MESA set OCUPADA=2 where id_MESA="+Pantalla2_1_1.num_mesa+"";
		System.out.println(query);
		
		try {
			Statement stmt = cn.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return resultado;
	}
	
	public int añadirCarne() {
		int resultado=0;
		String query = "UPDATE "+esquema+".COMANDAS set id_producto=1, cantidad="+Pantalla2_1_1_1_1.texto+" where id_comanda=(SELECT MAX( id_comanda ) FROM "+esquema+".comandas)";
		System.out.println(query);
		try {
			Statement stmt = cn.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return resultado;
	}
	
	public void ficheroini() {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try{
			File miFichero = new File("src/Esquema.ini");
			if(miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url=propiedades.getProperty("Basededatos");
				usr=propiedades.getProperty("usuario");
				pwd=propiedades.getProperty("contraseña");
				esquema=propiedades.getProperty("esquema");
			}else {
				System.out.println("Fichero no encontrado");
			}
		}catch(IOException ex) {
			ex.printStackTrace();	
		}finally{
			if(entrada!=null) {
				try {
					entrada.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		};
	}
} 