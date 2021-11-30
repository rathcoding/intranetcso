package br.gov.sc.pc.intranet.cso.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.gov.sc.pc.intranet.cso.dao.IntervencaoDAO;
import br.gov.sc.pc.intranet.cso.dto.PsiDTO;
import br.gov.sc.pc.intranet.cso.entities.Intervencao;

@WebServlet("/intervencao")
public class IntervencaoController extends HttpServlet {
	
	private static final long serialVersionUID = -1761271792798495402L;

    public IntervencaoController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
        switch (acao) {
	        case "cadastrar":
				cadastrar(request, response);
				break;
	        case "delete":
				delete(request, response);
				break;
	        default:
	        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }
		
	}


	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		PsiDTO user = (PsiDTO) session.getAttribute("user");
		
	    String tipo = request.getParameter("tipo");
	    Date data = Date.valueOf(request.getParameter("data"));
	    Time hora = Time.valueOf(request.getParameter("hora")+":00");
	    String notas = request.getParameter("notas");
	    String psi = user.getCpf();
	    String nomePsi = user.getNome();
	    Integer idCaso = Integer.parseInt(request.getParameter("idCaso"));
	    Intervencao intervencao = new Intervencao(tipo, data, hora, notas, psi, nomePsi, idCaso);
	    
	    IntervencaoDAO intervencaoDAO = new IntervencaoDAO();
	    intervencaoDAO.cadastrar(intervencao);
	    
		request.getRequestDispatcher("caso?acao=getOneById&id="+idCaso).forward(request, response);

	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    Integer id = Integer.parseInt(request.getParameter("id"));
	    IntervencaoDAO intervencaoDAO = new IntervencaoDAO();
	    Intervencao intervencao = intervencaoDAO.getOneById(id);
	    Integer casoid = intervencao.getCaso();
	    intervencaoDAO.deleteOne(id);
System.out.println("DELETE INTERVENCAO: " + intervencao.toString() + " >>> casoid: " + casoid);
	    
		request.getRequestDispatcher("caso?acao=getOneById&id="+casoid).forward(request, response);

	}

}
