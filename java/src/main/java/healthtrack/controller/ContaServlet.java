package healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.Conta;
import healthtrack.dao.ContaDAO;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class ContaServlet
 */
@WebServlet("/ContaServlet")
public class ContaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContaDAO dao;
       
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getContaDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Conta> lista = dao.getAll();
		request.setAttribute("contas", lista);
		request.getRequestDispatcher("conta.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
