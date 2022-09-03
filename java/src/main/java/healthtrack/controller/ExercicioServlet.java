package healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.Exercicio;
import healthtrack.dao.ExercicioDAO;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class ExercicioServlet
 */
@WebServlet("/ExercicioServlet")
public class ExercicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExercicioDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getExercicioDAO();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Exercicio> lista = dao.getAll();
		request.setAttribute("exercicios", lista);
		request.getRequestDispatcher("exercicio.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
