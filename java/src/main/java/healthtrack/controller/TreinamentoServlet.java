package healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.Treinamento;
import healthtrack.dao.TreinamentoDAO;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class TreinamentoServlet
 */
@WebServlet("/TreinamentoServlet")
public class TreinamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TreinamentoDAO dao;   
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getTreinamentoDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Treinamento> lista = dao.getAll();
		request.setAttribute("treinamentos", lista);
		request.getRequestDispatcher("treinamento.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
