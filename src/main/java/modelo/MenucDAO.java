package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import controlador.Conexion;


public class MenucDAO {
	static Conexion con=new Conexion();
	static Connection cnn=con.conexiondb();
	static PreparedStatement ps;
	static ResultSet rs;
	static MenucDTO medto;
	
public String insertarmenu(MenucDTO mdo) {
		
		int x;
		String dat="";
		try {
			medto=consultarmenu(mdo);
			if(medto==null) {
				ps=cnn.prepareStatement("INSERT INTO menu_carnes VALUES(?,?,?,?,?,?)");
				ps.setInt(1, mdo.getTipo_menu());
				ps.setString(2, mdo.getTm_nombre());
				ps.setString(3, mdo.getNombre_menu());
				ps.setString(4, mdo.getLista_ingredientes());
				ps.setInt(5, mdo.getCalorias());
				ps.setDouble(6, mdo.getPrecio());
				
				
				
				
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


	public  MenucDTO consultarmenu(MenucDTO mdo) {
		
		MenucDTO mdto = null;
		
	try {
		ps=cnn.prepareStatement("SELECT * FROM menu_carnes WHERE tipo_menu=?");
		ps.setInt(1, mdo.getTipo_menu());
		rs=ps.executeQuery();
		if(rs.next()) {
		   mdto=new MenucDTO(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5), rs.getDouble(6));
					
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	
		
	return mdto;
	}



	public int eliminar(MenucDTO mdo) {
		
		int x=0;
	  try {
		ps=cnn.prepareStatement("DELETE FROM menu_carnes WHERE tipo_menu=? ");
		ps.setInt(1, mdo.getTipo_menu());
		x=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	 return x; 	
	}
		

	public boolean actualizar(MenucDTO mdo) {
		boolean dat=false;
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE menu_carnes SET tm_nombre=?,nombre_menu=?,lista_ingredientes=?,Calorias=?,precio=? WHERE tipo_menu=?");
			ps.setInt(6,mdo.getTipo_menu());
			ps.setString(1, mdo.getTm_nombre());
			ps.setString(2, mdo.getNombre_menu());
			ps.setString(3, mdo.getLista_ingredientes());
		    ps.setInt(4, mdo.getCalorias());
		    ps.setDouble(5, mdo.getPrecio());
		   
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
	public static ArrayList<MenucDTO> consultar(){
		ArrayList<MenucDTO> lista=new  ArrayList<MenucDTO>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM menu_carnes");
			rs=ps.executeQuery();
			while(rs.next()) {
				medto= new MenucDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6));
			   lista.add(medto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	

}