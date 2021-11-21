package modelo;

public class MenuvDTO {
	
	 int tipo_menu;
	 String tm_nombre;
	 String nombre_menu;
	 String lista_ingredientes;
	 int calorias;
	 double precio;
	public MenuvDTO(int tipo_menu,String tm_nombre, String nombre_menu, String lista_ingredientes, int calorias, double precio) {
		super();
		this.tm_nombre=tm_nombre;
		this.tipo_menu = tipo_menu;
		this.nombre_menu = nombre_menu;
		this.lista_ingredientes = lista_ingredientes;
		this.calorias = calorias;
		this.precio = precio;
	}
	public MenuvDTO(int tipo_menu) {
		this.tipo_menu = tipo_menu;
	}
	
	public int getTipo_menu() {
		return tipo_menu;
	}
	
	public void setTipo_menu(int tipo_menu) {
		this.tipo_menu = tipo_menu;
	}
	public String getNombre_menu() {
		return nombre_menu;
	}
	public void setNombre_menu(String nombre_menu) {
		this.nombre_menu = nombre_menu;
	}
	public String getLista_ingredientes() {
		return lista_ingredientes;
	}
	public void setLista_ingredientes(String lista_ingredientes) {
		this.lista_ingredientes = lista_ingredientes;
	}
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getTm_nombre() {
		return tm_nombre;
	}
	public void setTm_nombre(String tm_nombre) {
		this.tm_nombre = tm_nombre;
	}
	 

}
