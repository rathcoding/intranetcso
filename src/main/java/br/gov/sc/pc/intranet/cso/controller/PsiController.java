package br.gov.sc.pc.intranet.cso.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.gov.sc.pc.intranet.cso.entities.Psi;
import br.gov.sc.pc.intranet.cso.util.Criptografia;
import br.gov.sc.pc.intranet.dao.PsiDAO;

@WebServlet("/psi")
public class PsiController extends HttpServlet {
	
	private static final long serialVersionUID = -1899660119224193680L;

	public PsiController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
        switch (acao) {
	        case "criar":
				criar(request, response);
				break;
	        case "login":
				login(request, response);
				break;
	        case "logout":
	             logout(request, response);
	             break;
	        default:
	        	request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}
	
	protected void criar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		String lotacao = request.getParameter("lotacao");
		Integer acesso = 0;
		acesso = Integer.parseInt(request.getParameter("acesso"));
		
		Psi psi = new Psi(cpf, senha, lotacao, acesso);
		PsiDAO psiDAO = new PsiDAO();
		psiDAO.cadastrar(psi);
		
		request.setAttribute("sucesso", "Usuário cadastrado com sucesso.<br>Realize seu primeiro login!");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}
	
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		PsiDAO psiDAO = new PsiDAO();
		Psi psi = psiDAO.getOneByCPF(cpf);
		
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
			session.setAttribute("user", cpf);
			System.out.println("Login: " + session.getAttribute("user"));
			request.getRequestDispatcher("home").forward(request, response);	
		}
				
	}
	
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		System.out.println("Logout: " + session.getAttribute("user"));
		session.invalidate();
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
