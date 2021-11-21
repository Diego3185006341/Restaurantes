package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.RestaurantesDAO;
import modelo.RestaurantesDTO;

/**
 * Servlet implementation class servletrestaurantes
 */
@WebServlet("/servletrestaurantes")
public class servletrestaurantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletrestaurantes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		String razon_social, nombre_comercial, ciudad,hora_apertura,hora_cierre,lista_menu;
		int tipo_restaurante;
		String res;
		RestaurantesDTO rdto;
		RestaurantesDAO rdao;
		RestaurantesDTO recdatos;

		if (request.getParameter("btnins") != null) {
			if (request.getParameter("tipo_restaurante") != "" && request.getParameter("razon_social") != ""
					&& request.getParameter("nombre_comercial") != "" && request.getParameter("ciudad") != ""
					&& request.getParameter("hora_apertura") != ""&&request.getParameter("hora_cierre")
					!= ""&&request.getParameter("lista_menu") != "") {
				tipo_restaurante = Integer.parseInt(request.getParameter("tipo_restaurante"));
				razon_social =request.getParameter("razon_social");
				nombre_comercial= request.getParameter("nombre_comercial");
				ciudad = request.getParameter("ciudad");
				hora_apertura = request.getParameter("hora_apertura");
				hora_cierre = request.getParameter("hora_cierre");
				lista_menu=request.getParameter("lista_menu");
				

				rdto = new RestaurantesDTO(tipo_restaurante, nombre_comercial, razon_social, ciudad,
						hora_apertura,hora_cierre,lista_menu);
				rdao = new RestaurantesDAO();
				res = rdao.insertarRestaurante(rdto);
				if (res.equals("r")) {
					request.setAttribute("mensaje_success", "Cliente registrado correctamente!");
					request.getRequestDispatcher("restaurantes.jsp").forward(request, response);
				} else {
					request.setAttribute("mensaje_error", "Cliente no registrado");
					request.getRequestDispatcher("restaurantes.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("mensaje_warning", "Ingrese los valores requeridos");
				request.getRequestDispatcher("restaurantes.jsp").forward(request, response);
			}

		}

		if (request.getParameter("btncon") != null) {
			// Acciï¿½n para consultar
			int doc;

			if (request.getParameter("tipo_restaurante") != "") {
				 tipo_restaurante= Integer.parseInt(request.getParameter("tipo_restaurante"));
				rdto = new RestaurantesDTO(tipo_restaurante);
				rdao = new RestaurantesDAO();
				recdatos = rdao.consultarusuario(rdto);

				if (recdatos != null) {

					doc = recdatos.getTipoRestaurante();
					razon_social= recdatos.getRazonSocial();
					nombre_comercial=recdatos.getNombreComercial();
					ciudad = recdatos.getCiudad();
					hora_apertura = recdatos.getHora_Apertura();
					hora_cierre = recdatos.getHora_Cierre();
					lista_menu = recdatos.getLista_Menu();

					response.sendRedirect("restaurantes.jsp?do=" + doc + "&&rs=" + razon_social + "&&nc="
							+ nombre_comercial + "&&cy=" + ciudad + "&&hra=" + hora_apertura+"&&hrc=" + hora_cierre+"&&lm=" + lista_menu);

				} else {
					request.setAttribute("mensaje_warning", "No existen datos para el número de cédula ingresado.");
					request.getRequestDispatcher("restaurantes.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("mensaje_warning", "Ingrese un número de cédula para consultar.");
				request.getRequestDispatcher("restaurantes.jsp").forward(request, response);
			}

		}

		if (request.getParameter("btnact") != null) {
			// Acciï¿½n para consultar un usuraio
			boolean dat;

			if (request.getParameter("tipo_restaurante") != "") {
				
				tipo_restaurante = Integer.parseInt(request.getParameter("tipo_restaurante"));
				razon_social=request.getParameter("razon_social");
				nombre_comercial = request.getParameter("nombre_comercial");
				ciudad = request.getParameter("ciudad");
				hora_apertura = request.getParameter("hora_apertura");
				hora_cierre=request.getParameter("hora_cierre");
				lista_menu=request.getParameter("lista_menu");
				
				rdto = new RestaurantesDTO(tipo_restaurante,razon_social, nombre_comercial, ciudad,hora_apertura,
						hora_cierre,lista_menu);
				
				rdao = new RestaurantesDAO();
				dat = rdao.actualizar(rdto);
				if (dat == true) {
					request.setAttribute("mensaje_success", "Cliente actualizado correctamente!");
					request.getRequestDispatcher("restaurantes.jsp").forward(request, response);
				}

				else {
					request.setAttribute("mensaje_error", "Cliente no actualizado");
					request.getRequestDispatcher("restaurantes.jsp").forward(request, response);

				}
			} else {
				request.setAttribute("mensaje_warning", "Ingrese los valores requeridos");
				request.getRequestDispatcher("restaurantes.jsp").forward(request, response);
			}
 
		}

		if (request.getParameter("btneli") != null) {
			// Acciï¿½n para eliminar
			int y;
			if (request.getParameter("tipo_restaurante") != "") {
				tipo_restaurante =Integer.parseInt(request.getParameter("tipo_restaurante"));
				rdto = new RestaurantesDTO(tipo_restaurante);
				rdao = new RestaurantesDAO();
				y = rdao.eliminar(rdto);
				if (y > 0) {
					request.setAttribute("mensaje_success", "Cliente eliminado correctamente!");
					request.getRequestDispatcher("Clientes.jsp").forward(request, response);

				} else {
					request.setAttribute("mensaje_error", "El Cliente NO fue eliminado");
					request.getRequestDispatcher("restaurantes.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("mensaje_warning", "Ingrese un número de cédula para eliminar.");
				request.getRequestDispatcher("restaurantes.jsp").forward(request, response);
			}

		}

	

	}

}
