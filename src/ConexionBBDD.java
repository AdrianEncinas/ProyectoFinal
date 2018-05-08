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
	
	public int InsertarCategoria(){
		
		int resultado=0;
		String query = "INSERT INTO LORCA.CATEGORIA VALUES("+Pantalla1_1_1.Id+" , '"+Pantalla1_1_1.Nombre+"')";
		 
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
}