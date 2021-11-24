package br.gov.sc.pc.intranet.cso.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.gov.sc.pc.intranet.cso.entities.Caso;
import br.gov.sc.pc.intranet.cso.entities.Intervencao;
import br.gov.sc.pc.intranet.cso.entities.Servidor;
import br.gov.sc.pc.intranet.dao.CasoDAO;
import br.gov.sc.pc.intranet.dao.IntervencaoDAO;
import br.gov.sc.pc.intranet.dao.ServidorDAO;
import br.gov.sc.pc.intranet.dao.TipoIntervencaoDAO;


@WebServlet("/caso")
public class CasoController extends HttpServlet {
	
	private static final long serialVersionUID = -963299625127904923L;

    public CasoController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		
        switch (acao) {
//	        case "criar":
//				criar(request, response);
//				break;
	        case "getAllByPsi":
				getAllByPsi(request, response);
				break;
	        case "getOneById":
	            getOneById(request, response);
	            break;
	        default:
	        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}


	private void getAllByPsi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		
		CasoDAO casoDAO = new CasoDAO();
		List<Caso> casos = casoDAO.getAllByPsi(user);
		
		for (Caso caso : casos) {
		    ServidorDAO servidorDAO = new ServidorDAO();
			Servidor servidor = servidorDAO.getOneByCPF(caso.getServidorCPF());
			caso.setServidor(servidor);
		}
		
    	request.setAttribute("casos", casos);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

	private void getOneById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		CasoDAO casoDAO = new CasoDAO();
		Caso caso = casoDAO.getOneById(id);
		
	    ServidorDAO servidorDAO = new ServidorDAO();
		Servidor servidor = servidorDAO.getOneByCPF(caso.getServidorCPF());
		caso.setServidor(servidor);
		
		IntervencaoDAO intervencaoDAO = new IntervencaoDAO();
		List<Intervencao> intervencoes = intervencaoDAO.getAllByCaso(id);
		caso.setIntervencoes(intervencoes);
		
		// Lista de tipos de intervenções
		TipoIntervencaoDAO tipoIntervencaoDAO = new TipoIntervencaoDAO();
		List<String> tipos_intervencao = tipoIntervencaoDAO.getAll();
		request.setAttribute("tipos_intervencao", tipos_intervencao);
		
    	request.setAttribute("caso", caso);
		request.getRequestDispatcher("caso.jsp").forward(request, response);
		
	}


}
