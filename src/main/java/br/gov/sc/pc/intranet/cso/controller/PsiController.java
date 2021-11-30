package br.gov.sc.pc.intranet.cso.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.gov.sc.pc.intranet.cso.dao.PsiDAO;
import br.gov.sc.pc.intranet.cso.dto.PsiDTO;
import br.gov.sc.pc.intranet.cso.entities.Psi;
import br.gov.sc.pc.intranet.cso.util.Criptografia;

@WebServlet("/usuario")
public class PsiController extends HttpServlet {
	

	private static final long serialVersionUID = 8280435299921719269L;


	public PsiController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
        switch (acao) {
	        case "cadastrar":
				cadastrar(request, response);
				break;
	        case "login":
				login(request, response);
				break;
	        case "logout":
	            logout(request, response);
	            break;
	        case "alterarSenha":
	        	alterarSenha(request, response);
	        	break;
	        default:
	        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}
	

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String lotacao = request.getParameter("lotacao");
		Integer acesso = Integer.parseInt(request.getParameter("acesso"));
		
		Psi psi = new Psi(cpf, nome, null, lotacao, acesso);
		psi.setSenha(senha);
		PsiDAO psiDAO = new PsiDAO();
		psiDAO.cadastrar(psi);
		
		request.setAttribute("sucesso", "Usuário cadastrado com sucesso.<br>Realize seu primeiro login!");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
	
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		PsiDAO psiDAO = new PsiDAO();
		Psi psi = psiDAO.getOneByCpf(cpf);
		
		String senha_cripto = "";
		try {
			senha_cripto = Criptografia.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (psi == null || !psi.getSenha().equals(senha_cripto)) {
			request.setAttribute("erro", "CPF e/ou senha inválido.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			
			PsiDTO psiDTO = new PsiDTO(psi.getCpf(), psi.getNome(), psi.getLotacao(), psi.getAcesso() );
			session.setAttribute("user", psiDTO);
			System.out.println("Login: " + session.getAttribute("user"));
			
			request.getRequestDispatcher("caso?acao=getAllByPsi").forward(request, response);	
		}
				
	}
	
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("Logout: " + session.getAttribute("user"));
		session.invalidate();
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	
	private void alterarSenha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		PsiDTO psiDTO = (PsiDTO) session.getAttribute("user");

		PsiDAO psiDAO = new PsiDAO();
		Psi psi = psiDAO.getOneByCpf(psiDTO.getCpf());
		
		String senha = request.getParameter("senha");
		String senha_cripto = "";
		try {
			senha_cripto = Criptografia.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (psi == null || !psi.getSenha().equals(senha_cripto)) {
			request.setAttribute("senhaErrada", "Senha incorreta.");
			request.getRequestDispatcher("alterarSenha.jsp").forward(request, response);
		} else {
			String senhaNova1 = request.getParameter("senhaNova1");
			String senhaNova2 = request.getParameter("senhaNova2");
			
			if (senhaNova1.equals(senhaNova2)) {
				psi.setSenha(senhaNova1);
				psiDAO.updateOne(psi);
				request.setAttribute("sucesso", "Senha atualizada com sucesso!");
				request.getRequestDispatcher("alterarSenha.jsp").forward(request, response);			
			} else {
				request.setAttribute("senhaNovaErrada", "Senhas novas diferentes.");
				request.getRequestDispatcher("alterarSenha.jsp").forward(request, response);				
			}
		}
	}
}
