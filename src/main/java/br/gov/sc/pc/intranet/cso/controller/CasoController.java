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
import br.gov.sc.pc.intranet.dao.CasoDAO;


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
		System.out.println("CasoController.acao: " + acao); // DEBUGGER
		
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
    	request.setAttribute("casos", casos);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

	private void getOneById(HttpServletRequest request, HttpServletResponse response) {
		
		
	}


}
