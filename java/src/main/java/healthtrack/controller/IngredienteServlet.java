package healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.Ingrediente;
import healthtrack.dao.IngredienteDAO;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class IngredienteServlet
 */
@WebServlet("/IngredienteServlet")
public class IngredienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IngredienteDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getIngredienteDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ingrediente> lista = dao.getAll();
		request.setAttribute("ingredientes", lista);
		request.getRequestDispatcher("ingrediente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
