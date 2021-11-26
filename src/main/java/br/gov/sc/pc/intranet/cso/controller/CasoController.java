package br.gov.sc.pc.intranet.cso.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.gov.sc.pc.intranet.cso.dto.PsiDTO;
import br.gov.sc.pc.intranet.cso.entities.Caso;
import br.gov.sc.pc.intranet.cso.entities.Intervencao;
import br.gov.sc.pc.intranet.cso.entities.Psi;
import br.gov.sc.pc.intranet.cso.entities.Servidor;
import br.gov.sc.pc.intranet.dao.CasoDAO;
import br.gov.sc.pc.intranet.dao.CidDAO;
import br.gov.sc.pc.intranet.dao.IntervencaoDAO;
import br.gov.sc.pc.intranet.dao.PsiDAO;
import br.gov.sc.pc.intranet.dao.ServidorDAO;
import br.gov.sc.pc.intranet.dao.TipoCasoDAO;
import br.gov.sc.pc.intranet.dao.TipoIntervencaoDAO;


@WebServlet("/caso")
public class CasoController extends HttpServlet {
	
	private static final long serialVersionUID = -963299625127904923L;

    public CasoController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		
        switch (acao) {
	        case "cadastrar":
				cadastrar(request, response);
				break;
	        case "deleteOne":
				deleteOne(request, response);
				break;
	        case "getAllByPsi":
				getAllByPsi(request, response);
				break;
	        case "getOneById":
	            getOneById(request, response);
	            break;
	        case "updateForm":
	            updateForm(request, response);
	            break;
	        case "updateOne":
	            updateOne(request, response);
	            break;
	        default:
	        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}


	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sgpe = request.getParameter("sgpe");
		String tipo = request.getParameter("tipo");
		String cid = request.getParameter("cid");
		Date data_inicio = Date.valueOf(request.getParameter("data_inicio"));
		Date data_fim_prev = Date.valueOf(request.getParameter("data_fim_prev"));
		String cpfServidor = request.getParameter("cpfServidor");
		ServidorDAO servidorDAO = new ServidorDAO();
		Servidor servidor = servidorDAO.getOneByCpf(cpfServidor);
		PsiDAO psiDAO = new PsiDAO();
		Psi psi = psiDAO.getOneByCpf(request.getParameter("psi"));
		
		Caso caso = new Caso(sgpe, tipo, cid, data_inicio, data_fim_prev, null, cpfServidor, servidor.getNome(), psi.getCpf(), psi.getNome());
		
		CasoDAO casoDAO = new CasoDAO();
		casoDAO.cadastrar(caso);
		
		this.getAllByPsi(request, response);
	}
	
	private void deleteOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		IntervencaoDAO intervencaoDAO = new IntervencaoDAO();
		List<Intervencao> intervencoes = intervencaoDAO.getAllByCaso(id);
		for (Intervencao intervencao : intervencoes) {
			intervencaoDAO.deleteOne(intervencao.getId());
		}
		
		CasoDAO casoDAO = new CasoDAO();
		casoDAO.deleteOne(id);
		
		this.getAllByPsi(request, response);
	}

	private void getAllByPsi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		PsiDTO user = (PsiDTO) session.getAttribute("user");
		
		CasoDAO casoDAO = new CasoDAO();
		List<Caso> casos = casoDAO.getAllByPsi(user.getCpf());
		
//		for (Caso caso : casos) {
//		    ServidorDAO servidorDAO = new ServidorDAO();
//			Servidor servidor = servidorDAO.getOneByCpf(caso.getCpfServidor());
//			caso.setServidor(servidor);
//		}
		
		// Lista de tipos de Caso
		TipoCasoDAO tipoCasoDAO = new TipoCasoDAO();
		List<String> tipos_caso = tipoCasoDAO.getAll();
		request.setAttribute("tipos_caso", tipos_caso);
		
		// Lista de tipos de CID
		CidDAO cidDAO = new CidDAO();
		List<String> tipos_cid = cidDAO.getAll();
		request.setAttribute("tipos_cid", tipos_cid);

		// Lista de Psis
		PsiDAO psiDAO = new PsiDAO();
		List<Psi> psis = psiDAO.getAll();
		List<PsiDTO> psisDTO = new ArrayList<>();
		for (Psi p : psis ) {
			PsiDTO psi = new PsiDTO(p.getCpf(), p.getNome(), p.getLotacao(), p.getAcesso());
			psisDTO.add(psi);
		}
		request.setAttribute("psis", psisDTO);

		// Lista de Servidores
		ServidorDAO servidorDAO = new ServidorDAO();
		List<Servidor> servidores = servidorDAO.getAll();
		request.setAttribute("servidores", servidores);

    	request.setAttribute("casos", casos);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

	private void getOneById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		CasoDAO casoDAO = new CasoDAO();
		Caso caso = casoDAO.getOneById(id);
		
	    ServidorDAO servidorDAO = new ServidorDAO();
		Servidor servidor = servidorDAO.getOneByCpf(caso.getCpfServidor());
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

	private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		CasoDAO casoDAO = new CasoDAO();
		Caso caso = casoDAO.getOneById(id);
		request.setAttribute("caso", caso);
		
		ServidorDAO servidorDAO = new ServidorDAO();
		Servidor servidor = servidorDAO.getOneByCpf(caso.getCpfServidor());
		caso.setServidor(servidor);
		
		// Lista de tipos de Caso
		TipoCasoDAO tipoCasoDAO = new TipoCasoDAO();
		List<String> tipos_caso = tipoCasoDAO.getAll();
		request.setAttribute("tipos_caso", tipos_caso);
		
		// Lista de tipos de CID
		CidDAO cidDAO = new CidDAO();
		List<String> tipos_cid = cidDAO.getAll();
		request.setAttribute("tipos_cid", tipos_cid);

		// Lista de Psis
		PsiDAO psiDAO = new PsiDAO();
		List<Psi> psis = psiDAO.getAll();
		List<PsiDTO> psisDTO = new ArrayList<>();
		for (Psi p : psis ) {
			PsiDTO psi = new PsiDTO(p.getCpf(), p.getNome(), p.getLotacao(), p.getAcesso());
			psisDTO.add(psi);
		}
		request.setAttribute("psis", psisDTO);

		request.getRequestDispatcher("editCaso.jsp").forward(request, response);
	}
	
	private void updateOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		CasoDAO casoDAO = new CasoDAO();
		Caso caso = casoDAO.getOneById(id);
		
		caso.setSgpe(request.getParameter("sgpe"));
		caso.setTipo(request.getParameter("tipo"));
		caso.setCid(request.getParameter("cid"));
		caso.setData_inicio(Date.valueOf(request.getParameter("data_inicio")));
		caso.setData_fim_prev(Date.valueOf(request.getParameter("data_fim_prev")));
		
		if (!request.getParameter("data_fim").equals("")) {
			caso.setData_fim(Date.valueOf(request.getParameter("data_fim")));
		}
		
		PsiDAO psiDAO = new PsiDAO();
		Psi psi = psiDAO.getOneByCpf(request.getParameter("psi"));
		
		caso.setCpfPsi(psi.getCpf());
		caso.setNomePsi(psi.getNome());
		
		casoDAO.updateOne(caso);
		
		request.getRequestDispatcher("caso?acao=getOneById&id=" + id).forward(request, response);
	}

}
