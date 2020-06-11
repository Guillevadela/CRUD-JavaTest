package com.ecodeup.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecodeup.dao.SerieDAO;

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
		SerieDAO serieDAO = new SerieDAO();

		ArrayList arraySeries = new ArrayList();

		arraySeries = serieDAO.getAll(); // casrteamos la lista a un tipo ArrayList

		request.setAttribute("series", arraySeries);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
