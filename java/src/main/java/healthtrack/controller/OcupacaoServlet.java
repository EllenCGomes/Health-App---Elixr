package healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.Ocupacao;
import healthtrack.dao.OcupacaoDAO;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class OcupacaoServlet
 */
@WebServlet("/OcupacaoServlet")
public class OcupacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OcupacaoDAO dao;   
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getOcupacaoDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ocupacao> lista = dao.getAll();
		request.setAttribute("ocupacoes", lista);
		request.getRequestDispatcher("ocupacao.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
