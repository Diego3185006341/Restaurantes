package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.MenucDAO;
import modelo.MenucDTO;


/**
 * Servlet implementation class servletmenuc
 */
@WebServlet("/servletmenuc")
public class servletmenuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletmenuc() {
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
		String nombre_menu,lista_ingredientes,tm_nombre;
		int tipo_menu,calorias;
		double precio=0;
		String res;
		MenucDTO mdto;
		MenucDAO mdao;
		MenucDTO recdatos;

		if (request.getParameter("btnins") != null) {
			if (request.getParameter("tipo_menu") != "" && request.getParameter("tm_nombre") != ""&& request.getParameter("nombre_menu") != ""
					&& request.getParameter("lista_ingredientes") != "" && request.getParameter("calorias") != ""
					&& request.getParameter("precio") != "") {
				tipo_menu = Integer.parseInt(request.getParameter("tipo_menu"));
				tm_nombre = request.getParameter("tm_nombre");
				nombre_menu =request.getParameter("nombre_menu");
				lista_ingredientes= request.getParameter("lista_ingredientes");
				calorias =Integer.parseInt(request.getParameter("calorias")) ;
				precio = Double.parseDouble(request.getParameter("precio"));
				

				mdto= new MenucDTO(tipo_menu,tm_nombre ,nombre_menu, lista_ingredientes, calorias,
						precio);
				mdao = new MenucDAO();
				res = mdao.insertarmenu(mdto);
				if (res.equals("r")) {
					request.setAttribute("mensaje_success", "menu registrado correctamente!");
					request.getRequestDispatcher("menu_carnes.jsp").forward(request, response);
				} else {
					request.setAttribute("mensaje_error", "menu no registrado");
					request.getRequestDispatcher("menu_carnes.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("mensaje_warning", "Ingrese los valores requeridos");
				request.getRequestDispatcher("menu_carnes.jsp").forward(request, response);
			}

		}

		if (request.getParameter("btncon") != null) {
			// Acciï¿½n para consultar
			int doc;

			if (request.getParameter("tipo_menu") != "") {
				 tipo_menu= Integer.parseInt(request.getParameter("tipo_menu"));
				mdto = new MenucDTO(tipo_menu);
				mdao = new MenucDAO();
				recdatos = mdao.consultarmenu(mdto);

				if (recdatos != null) {

					doc = recdatos.getTipo_menu();
					tm_nombre=recdatos.getTm_nombre();
					nombre_menu= recdatos.getNombre_menu();
					lista_ingredientes=recdatos.getLista_ingredientes();
					calorias = recdatos.getCalorias();
					precio = recdatos.getPrecio();
					

					response.sendRedirect("menu_carnes.jsp?do=" + doc +"&&nm=" + tm_nombre+ "&&rs=" + nombre_menu + "&&nc="
							+ lista_ingredientes + "&&cy=" + calorias + "&&hra=" + precio);

				} else {
					request.setAttribute("mensaje_warning", "No existen datos para el número ingresado.");
					request.getRequestDispatcher("menu_carnes.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("mensaje_warning", "Ingrese un número.");
				request.getRequestDispatcher("menu:carnes.jsp").forward(request, response);
			}

		}

		if (request.getParameter("btnact") != null) {
			// Acciï¿½n para consultar un usuraio
			boolean dat;

			if (request.getParameter("tipo_menu") != "") {
				
				tipo_menu = Integer.parseInt(request.getParameter("tipo_menu"));
				tm_nombre=request.getParameter("tm_nombre");
				nombre_menu=request.getParameter("nombre_menu");
				lista_ingredientes= request.getParameter("lista_ingredientes");
				calorias = Integer.parseInt(request.getParameter("calorias"));
				precio = Double.parseDouble(request.getParameter("precio"));
				
				
				mdto = new MenucDTO(tipo_menu,tm_nombre,nombre_menu, lista_ingredientes,calorias,precio);
				
				mdao = new MenucDAO();
				dat = mdao.actualizar(mdto);
				if (dat == true) {
					request.setAttribute("mensaje_success", "menu actualizado correctamente!");
					request.getRequestDispatcher("menu_carnes.jsp").forward(request, response);
				}

				else {
					request.setAttribute("mensaje_error", "menu no actualizado");
					request.getRequestDispatcher("menu_carnes.jsp").forward(request, response);

				}
			} else {
				request.setAttribute("mensaje_warning", "Ingrese los valores requeridos");
				request.getRequestDispatcher("menu_carnes.jsp").forward(request, response);
			}
 
		}

		if (request.getParameter("btneli") != null) {
			// Acciï¿½n para eliminar
			int y;
			if (request.getParameter("tipo_menu") != "") {
				tipo_menu =Integer.parseInt(request.getParameter("tipo_menu"));
				mdto = new MenucDTO(tipo_menu);
				mdao = new MenucDAO();
				y = mdao.eliminar(mdto);
				if (y > 0) {
					request.setAttribute("mensaje_success", "menu eliminado correctamente!");
					request.getRequestDispatcher("menu_vegetariano.jsp").forward(request, response);

				} else {
					request.setAttribute("mensaje_error", "El menu NO fue eliminado");
					request.getRequestDispatcher("menu_vegetariano.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("mensaje_warning", "Ingrese un número para eliminar.");
				request.getRequestDispatcher("menu_carnes.jsp").forward(request, response);
			}

		}

	}

}
