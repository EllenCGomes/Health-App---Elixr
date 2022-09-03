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
import healthtrack.factory.DAOFactory;
import healthtrack.bean.Ingrediente;
import healthtrack.bean.Refeicao;
import healthtrack.dao.IngredienteDAO;
import healthtrack.dao.RefeicaoDAO;
import healthtrack.exception.DBException;

/**
 * Servlet implementation class InfoMealServlet
 */
@WebServlet("/listaRefeicoes")
public class InfoRefeicaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RefeicaoDAO daoRefeicao;   
	private IngredienteDAO daoIngrediente;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoRefeicaoServlet() {
        super();
        daoRefeicao = DAOFactory.getRefeicaoDAO();
        daoIngrediente = DAOFactory.getIngredienteDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action == null)
		{
			action = "listar";
		}
		
		switch(action) {
		case "edit":
			formEditarRefeicao(request, response);
			break;
		case "delete":
			break;
		case "listar":
			listar(request, response);
			break;
		}
		
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<Refeicao> listaRefeicoes = daoRefeicao.getAll();
		request.setAttribute("refeicoes", listaRefeicoes);
		
		request.getRequestDispatcher("InfoRefeicao.jsp").forward(request, response);
	}
	
	private void formEditarRefeicao(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Refeicao refeicao = daoRefeicao.getById(id);
		request.setAttribute("refeicao", refeicao);
		
		List<Ingrediente> listaIngrediente = daoIngrediente.getAll();
		request.setAttribute("ingredientes", listaIngrediente);
		
		request.getRequestDispatcher("formEditarRefeicao.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		editar(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			
			int codigo = Integer.parseInt(request.getParameter("codigo"));
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar dtDate = Calendar.getInstance();
            dtDate.setTime(format.parse(request.getParameter("dtRef")));
            //String tipoRef = request.getParameter("tipoRef");
            String tipoRef = "Dinner";
            int qtProt = Integer.parseInt(request.getParameter("proteina"));
            int qtCarb = Integer.parseInt(request.getParameter("carboidrato"));
            int qtAcu = Integer.parseInt(request.getParameter("acucar"));
            int qtGord = Integer.parseInt(request.getParameter("gordura"));
            double pesoRef = Double.parseDouble(request.getParameter("pesoRef"));
            String unMedida = request.getParameter("unMed");
            int ingrediente = Integer.parseInt(request.getParameter("ingrediente"));
            

            Refeicao ref = new Refeicao(codigo, dtDate, tipoRef, qtProt, qtCarb, qtAcu, qtGord, pesoRef, unMedida, 8, ingrediente);
            daoRefeicao.update(ref);

            request.setAttribute("msg", "Produto cadastrado!");
        }catch(DBException db){
            db.printStackTrace();
            request.setAttribute("erro", "Erro ao cadastrar");
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("erro", "Por favor, valide os dados");
        }
		listar(request, response);
	}

}
