package healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.Altura;
import healthtrack.dao.AlturaDAO;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class AlturaServlet
 */
@WebServlet("/AlturaServlet")
public class AlturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlturaDAO dao;
	
    @Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getAlturaDAO();
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Altura> lista = dao.getAll();
		request.setAttribute("alturas", lista);
		request.getRequestDispatcher("altura.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
