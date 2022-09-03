package healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.Fc;
import healthtrack.dao.FcDAO;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class FcServlet
 */
@WebServlet("/FcServlet")
public class FcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FcDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getFcDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Fc> lista = dao.getAll();
		request.setAttribute("frequencias", lista);
		request.getRequestDispatcher("fc.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
