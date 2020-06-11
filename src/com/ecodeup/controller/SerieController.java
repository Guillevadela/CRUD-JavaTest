package com.ecodeup.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecodeup.dao.SerieDAO;
import com.ecodeup.model.Serie;

/**
 * Servlet implementation class SerieController
 */
@WebServlet(description = "administra peticiones para la tabla series", urlPatterns = { "/series" })
public class SerieController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SerieController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String opcion = request.getParameter("opcion");

		if (opcion.equals("crear")) {
			System.out.println("Usted a presionado la opcion crear");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
			requestDispatcher.forward(request, response);
		} else if (opcion.equals("listar")) {

			SerieDAO serieDAO = new SerieDAO();
			List<Serie> lista = new ArrayList<>();
			try {
				lista = serieDAO.obtenerSeries();
				for (Serie serie : lista) {
					System.out.println(serie);
				}

				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Usted a presionado la opcion listar");
		} else if (opcion.equals("meditar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("Editar id: " + id);
			SerieDAO serieDAO = new SerieDAO();
			Serie p = new Serie();
			try {
				p = serieDAO.obtenerSerie(id);
				System.out.println(p);
				request.setAttribute("serie", p);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (opcion.equals("eliminar")) {
			SerieDAO serieDAO = new SerieDAO();
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				serieDAO.eliminar(id);
				System.out.println("Registro eliminado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		Date fechaActual = new Date();

		if (opcion.equals("guardar")) {
			SerieDAO serieDAO = new SerieDAO();
			Serie serie = new Serie();
			serie.setNombre(request.getParameter("nombre"));
			serie.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
			serie.setPrecio(Double.parseDouble(request.getParameter("precio")));
			serie.setFechaCrear(new java.sql.Date(fechaActual.getTime()));
			try {
				serieDAO.guardar(serie);
				System.out.println("Registro guardado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (opcion.equals("editar")) {
			Serie serie = new Serie();
			SerieDAO serieDAO = new SerieDAO();

			serie.setId(Integer.parseInt(request.getParameter("id")));
			serie.setNombre(request.getParameter("nombre"));
			serie.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
			serie.setPrecio(Double.parseDouble(request.getParameter("precio")));
			serie.setFechaActualizar(new java.sql.Date(fechaActual.getTime()));
			try {
				serieDAO.editar(serie);
				System.out.println("Registro editado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// doGet(request, response);
	}

}
