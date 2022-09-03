package healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.Peso;
import healthtrack.dao.PesoDAO;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class PesoServlet
 */
@WebServlet("/PesoServlet")
public class PesoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PesoDAO dao;      
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getPesoDAO();
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Peso> lista = dao.getAll();
		request.setAttribute("pesos", lista);
		request.getRequestDispatcher("peso.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
