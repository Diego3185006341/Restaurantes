package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import controlador.Conexion;


public class RestaurantesDAO {
	static Conexion con=new Conexion();
	static Connection cnn=con.conexiondb();
	static PreparedStatement ps;
	static ResultSet rs;
	static RestaurantesDTO rdto;
	
public String insertarRestaurante(RestaurantesDTO rdo) {
		
		int x;
		String dat="";
		try {
			rdto=consultarusuario(rdo);
			if(rdto==null) {
				ps=cnn.prepareStatement("INSERT INTO restaurantes VALUES(?,?,?,?,?,?,?)");
				ps.setInt(1, rdo.getTipoRestaurante());
				ps.setString(2, rdo.getRazonSocial());
				ps.setString(3, rdo.getNombreComercial());
				ps.setString(4, rdo.getCiudad());
				ps.setString(5, rdo.getHora_Apertura());
				ps.setString(6, rdo.getHora_Cierre());
				ps.setString(7, rdo.getLista_Menu());
				
				
				
				x=ps.executeUpdate();
					if(x>0) {
						dat="r";
					}
			}	
			else {
				dat="nr";
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar"+e);
			
		}
		
		
		return dat;
	}


	public  RestaurantesDTO consultarusuario(RestaurantesDTO rdo) {
		
		RestaurantesDTO rdto = null;
		
	try {
		ps=cnn.prepareStatement("SELECT * FROM restaurantes WHERE tipo_restaurante=?");
		ps.setInt(1, rdo.getTipoRestaurante());
		rs=ps.executeQuery();
		if(rs.next()) {
		   rdto=new RestaurantesDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7));
					
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	
		
	return rdto;
	}



	public int eliminar(RestaurantesDTO rdo) {
		
		int x=0;
	  try {
		ps=cnn.prepareStatement("DELETE FROM restaurantes WHERE tipo_restaurante=? ");
		ps.setInt(1, rdo.getTipoRestaurante());
		x=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	 return x; 	
	}
		

	public boolean actualizar(RestaurantesDTO rdo) {
		boolean dat=false;
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE restaurantes SET razon_social=?,nombre_comercial=?,ciudad=?,hora_apertura=?,hora_cierre=?,lista_menu=? WHERE tipo_restaurante=?");
			ps.setInt(7,rdo.getTipoRestaurante());
			ps.setString(1, rdo.getRazonSocial());
		    ps.setString(2, rdo.getNombreComercial());
		    ps.setString(3, rdo.getCiudad());
		    ps.setString(4, rdo.getHora_Apertura());
		    ps.setString(5, rdo.getHora_Cierre());
		    ps.setString(6, rdo.getLista_Menu());
		    x=ps.executeUpdate();
		    if(x>0) {
		    	dat=true;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dat;	
	}
	public static ArrayList<RestaurantesDTO> consultar(){
		ArrayList<RestaurantesDTO> lista=new  ArrayList<RestaurantesDTO>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM restaurantes");
			rs=ps.executeQuery();
			while(rs.next()) {
				rdto=new RestaurantesDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			   lista.add(rdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	

}
