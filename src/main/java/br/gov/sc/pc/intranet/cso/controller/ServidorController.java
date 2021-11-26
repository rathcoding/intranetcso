package br.gov.sc.pc.intranet.cso.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.sc.pc.intranet.cso.entities.Caso;
import br.gov.sc.pc.intranet.cso.entities.Servidor;
import br.gov.sc.pc.intranet.dao.CasoDAO;
import br.gov.sc.pc.intranet.dao.ServidorDAO;


@WebServlet("/servidor")
public class ServidorController extends HttpServlet {
       
	private static final long serialVersionUID = 3405673826970854843L;

    public ServidorController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
			case "getOneByCPF":
				getOneByCPF(request, response);
				break;
		}
		
		switch (acao) {
		case "buscarForm":
			buscarForm(request, response);
			break;
	}
	}
	

	private void getOneByCPF(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cpf = request.getParameter("cpf");
		ServidorDAO servidorDAO = new ServidorDAO();
		Servidor servidor = servidorDAO.getOneByCpf(cpf);
		request.setAttribute("servidor", servidor);
		
		CasoDAO casoDAO = new CasoDAO();
		List<Caso> casos = casoDAO.getAllByServidor(cpf);
		request.setAttribute("casos", casos);
		
		request.getRequestDispatcher("servidor.jsp").forward(request, response);
	}

	private void buscarForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServidorDAO servidorDAO = new ServidorDAO();
		List<Servidor> servidores = servidorDAO.getAll();
		request.setAttribute("servidores", servidores);
		
		request.getRequestDispatcher("buscarServidor.jsp").forward(request, response);
	}

}

