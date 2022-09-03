package healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import healthtrack.bean.Ingrediente;
import healthtrack.bean.Refeicao;
import healthtrack.dao.IngredienteDAO;
import healthtrack.dao.RefeicaoDAO;
import healthtrack.exception.DBException;
import healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class RefeicaoServlet
 */
@WebServlet("/refeicao")
public class RefeicaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RefeicaoDAO daoRefeicao;   
	private IngredienteDAO daoIngrediente;
	
	@Override
	public void init() throws ServletException {
		super.init();
		daoRefeicao = DAOFactory.getRefeicaoDAO();
		daoIngrediente = DAOFactory.getIngredienteDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String action = request.getParameter("action");
		
		listar(request, response);
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<Ingrediente> listaIngrediente = daoIngrediente.getAll();
		request.setAttribute("ingredientes", listaIngrediente);
		
		request.getRequestDispatcher("Refeicao.jsp").forward(request, response);
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar dtDate = Calendar.getInstance();
            dtDate.setTime(format.parse(request.getParameter("dtRef")));
            String tipoRef = request.getParameter("tipoRef");
            int qtProt = Integer.parseInt(request.getParameter("proteina"));
            int qtCarb = Integer.parseInt(request.getParameter("carboidrato"));
            int qtAcu = Integer.parseInt(request.getParameter("acucar"));
            int qtGord = Integer.parseInt(request.getParameter("gordura"));
            double pesoRef = Double.parseDouble(request.getParameter("pesoRef"));
            String unMedida = request.getParameter("unMed");
            int ingrediente = Integer.parseInt(request.getParameter("ingrediente"));
            

            Refeicao ref = new Refeicao(0, dtDate, tipoRef, qtProt, qtCarb, qtAcu, qtGord, pesoRef, unMedida, 8, ingrediente);
            daoRefeicao.insert(ref);

            request.setAttribute("msg", "Produto cadastrado!");
        }catch(DBException db){
            db.printStackTrace();
            request.setAttribute("erro", "Erro ao cadastrar");
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("erro", "Por favor, valide os dados");
        }
        request.getRequestDispatcher("Refeicao.jsp").forward(request, response);
	}

}
