package healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.Pa;
import healthtrack.dao.PaDAO;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class PaServlet
 */
@WebServlet("/PaServlet")
public class PaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getPaDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pa> lista = dao.getAll();
		request.setAttribute("pressoes", lista);
		request.getRequestDispatcher("pa.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
