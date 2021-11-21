package modelo;

public class RestaurantesDTO {

	int tipoRestaurante;
	 String razonSocial;
	 String nombreComercial;
	 String Ciudad;
	 String hora_Apertura;
	 String hora_Cierre;
	 String lista_Menu;
	
	
	public RestaurantesDTO(int tipoRestaurante,String razonSocial, String nombreComercial,  String ciudad,
			String hora_Apertura, String hora_Cierre, String lista_Menu) {
		
		this.tipoRestaurante = tipoRestaurante;
		this.razonSocial = razonSocial;
		this.nombreComercial = nombreComercial;
		this.Ciudad = ciudad;
		this.hora_Apertura = hora_Apertura;
		this.hora_Cierre = hora_Cierre;
		this.lista_Menu = lista_Menu;
	}


	public RestaurantesDTO(int tipoRestaurante) {
		this.tipoRestaurante = tipoRestaurante;
	}


	


	public int getTipoRestaurante() {
		return tipoRestaurante;
	}


	public void setTipoRestaurante(int tipoRestaurante) {
		this.tipoRestaurante = tipoRestaurante;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getNombreComercial() {
		return nombreComercial;
	}


	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}


	public String getCiudad() {
		return Ciudad;
	}


	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}


	public String getHora_Apertura() {
		return hora_Apertura;
	}


	public void setHora_Apertura(String hora_Apertura) {
		this.hora_Apertura = hora_Apertura;
	}


	public String getHora_Cierre() {
		return hora_Cierre;
	}


	public void setHora_Cierre(String hora_Cierre) {
		this.hora_Cierre = hora_Cierre;
	}


	public String getLista_Menu() {
		return lista_Menu;
	}


	public void setLista_Menu(String lista_Menu) {
		this.lista_Menu = lista_Menu;
	}

	
	

	
}