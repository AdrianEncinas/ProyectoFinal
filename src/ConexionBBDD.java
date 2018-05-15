import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ConexionBBDD {

	private String bd;
	private String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private String usr = "LORCA";
	private String pwd = "lorca";
	private Connection cn;
	private Statement st;
	

	public ConexionBBDD()  {
		
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
		String query = "SELECT * FROM LORCA.CATEGORIA order by ID_CATEGORIA asc";
		 
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
	public DefaultTableModel ConsultaTablaProductos() {
		String [] columnas={"ID","ID_CATEGORIA","NOMBRE","PRECIO"};
		String [] registro=new String[5];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT * FROM LORCA.PRODUCTO order by ID_PRODUCTO asc";
		 
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
	
	public int InsertarProducto(){
		
		int resultado=0;
		String query = "INSERT INTO LORCA.PRODUCTO VALUES("+Pantalla1_1_2.IdProducto+" , "+Pantalla1_1_2.IdCategoria+" , '"+Pantalla1_1_2.Nombre+"' , "+Pantalla1_1_2.precio+" )";
		 
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
		String query = "INSERT INTO LORCA.CATEGORIA VALUES("+Pantalla1_1_1.Id+" , '"+Pantalla1_1_1.Nombre+"')";
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
		String query = "UPDATE LORCA.CATEGORIA set ID_CATEGORIA="+Pantalla1_1_1.Id+", NOMBRE='"+Pantalla1_1_1.Nombre+"' where ID_CATEGORIA="+Pantalla1_1_1.Id+"";
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
		String query = "UPDATE LORCA.producto set ID_PRODUCTO="+Pantalla1_1_2.IdProducto+" , ID_CATEGORIA="+Pantalla1_1_2.IdCategoria+" , NOMBRE='"+Pantalla1_1_2.Nombre+"' , PRECIO="+Pantalla1_1_2.precio+" where id_producto="+Pantalla1_1_2.IdProducto+"";
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
		String query = "DELETE FROM LORCA.CATEGORIA WHERE ID_CATEGORIA="+Pantalla1_1_1.Id+" AND NOMBRE='"+Pantalla1_1_1.Nombre+"'";
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
		String query = "DELETE FROM LORCA.PRODUCTO WHERE ID_PRODUCTO="+Pantalla1_1_2.IdProducto+" and ID_CATEGORIA="+Pantalla1_1_2.IdCategoria+" AND NOMBRE='"+Pantalla1_1_2.Nombre+"' and PRECIO="+Pantalla1_1_2.precio+"";
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
} 