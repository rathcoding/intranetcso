package br.gov.sc.pc.intranet.tests;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import br.gov.sc.pc.intranet.cso.entities.Caso;
import br.gov.sc.pc.intranet.cso.entities.Intervencao;
import br.gov.sc.pc.intranet.cso.entities.Psi;
import br.gov.sc.pc.intranet.cso.entities.Servidor;
import br.gov.sc.pc.intranet.dao.CasoDAO;
import br.gov.sc.pc.intranet.dao.IntervencaoDAO;
import br.gov.sc.pc.intranet.dao.PsiDAO;
import br.gov.sc.pc.intranet.dao.ServidorDAO;

public class Testes {

	public static void main(String[] args) {
		
// TESTES PsiDAO ==================================================
//		cadastrarPsi();
		consultarPsi();
		getAllPsi();

// TESTES ServidorDAO =============================================
//		cadastrarServidor();
		consultarServidor();
		getAllServidor();
		
// TESTES CasoDAO =================================================
//		cadastrarCaso();
		getCasoById();
		getAllCasosByPsi();
//		updateOneCaso();
//		deleteOneCaso();
		
// TESTES IntervencaoDAO ==========================================
//		cadastrarIntervencao();
		getIntervencaoById();
		getAllIntervencoesByCaso();
//		updateOneIntervencao();
//		deleteOneIntervencao();


	}
	
// TESTES PsiDAO ==================================================
	public static void cadastrarPsi() {
		
		PsiDAO psiDAO = new PsiDAO();
		
		String cpf = "02925522971";
		String senha = "senha";
		String lotacao = "DIFRON";
		Integer acesso = 1;
		
		Psi psi = new Psi(cpf, senha, lotacao, acesso);
		psiDAO.cadastrar(psi);
		
		return;
	}
	
	public static void consultarPsi() {
		
		PsiDAO psiDAO = new PsiDAO();
		Psi psi = psiDAO.getOneByCPF("02925522971");
		System.out.println(psi.toString());		
		return;
	}
	
	public static void getAllPsi() {
		
		PsiDAO psiDAO = new PsiDAO();
		List<Psi> list = psiDAO.getAll(); 
		
		for (Psi psi : list) {
			System.out.println(psi.toString());
		}
				
		return;
	}

// TESTES ServidorDAO =============================================
	public static void cadastrarServidor() {
		
		ServidorDAO servidorDAO = new ServidorDAO();
		
		String cpf = "02925522971";
		String nome = "RAFAEL RATH";
		String cargo = "PSICOLOGO POLICIAL CIVIL CLASSE VIII";
		Date data_nascimento = Date.valueOf("1980-01-09");
		String matricula = "0953630-2-01";
		Date data_ingresso = Date.valueOf("2012-03-12");
		Date data_cargo = Date.valueOf("2012-03-12");
		String email = "rath@pc.sc.gov.br";
		String telefone = "(48) 3234-4810";
		String celular = "(48) 3234-4810";
		String unidade = null;
		
		Servidor servidor = new Servidor(cpf, nome, cargo, data_nascimento, matricula, data_ingresso,
										 data_cargo, email, telefone, celular, unidade);
		
		servidorDAO.cadastrar(servidor);
		
		return;
	}
	
	public static void consultarServidor() {
		
		ServidorDAO servidorDAO = new ServidorDAO();
		Servidor servidor = servidorDAO.getOneByCPF("02925522971");
		System.out.println(servidor.toString());		
		return;
	}
	
	public static void getAllServidor() {
		
		ServidorDAO servidorDAO = new ServidorDAO();
		List<Servidor> list = servidorDAO.getAll(); 
		
		for (Servidor servidor : list) {
			System.out.println(servidor.toString());
		}
				
		return;
	}
	
// TESTES CasoDAO =================================================
	private static void cadastrarCaso() {
		
		String sgpe = "PCSC 123456/2021";
	    String tipo = "LTS";
	    String cid = "F32.2";
	    Date data_inicio = Date.valueOf("2021-07-01");
	    Date data_fim_prev = Date.valueOf("2021-07-30");
		Date data_fim = null;
		String psi = "02925522971";
	    String servidor = "02925522971";
		Caso caso = new Caso(sgpe, tipo, cid, data_inicio, data_fim_prev, data_fim, servidor, psi);
		
		CasoDAO casoDAO = new CasoDAO();
		casoDAO.cadastrar(caso);
		return;
		
	}

	private static void getCasoById() {
		
		CasoDAO casoDAO = new CasoDAO();
		Caso caso = casoDAO.getOneById(1);
		System.out.println(caso.toString());
		return;
		
	}

	private static void getAllCasosByPsi() {
		
		CasoDAO casoDAO = new CasoDAO();
		List<Caso> list = casoDAO.getAllByPsi("02925522971"); 
		
		for (Caso caso : list) {
			System.out.println(caso.toString());
		}
		
		return;
		
	}
	
	private static void updateOneCaso() {
		CasoDAO casoDAO = new CasoDAO();
		Caso caso = casoDAO.getOneById(2);
		caso.setData_fim(Date.valueOf("2021-07-30"));
		casoDAO.updateOne(caso);
		System.out.println("Updated:");
		getCasoById();
		return;
		
	}

	private static void deleteOneCaso() {
		CasoDAO casoDAO = new CasoDAO();
		casoDAO.deleteOne(1);
		System.out.println("Deleted.");
		return;
		
	}

// TESTES IntervencaoDAO ==========================================
	private static void cadastrarIntervencao() {

	    IntervencaoDAO intervencaoDAO = new IntervencaoDAO();

		String tipo = "Atendimento individual";
		Date data = Date.valueOf("2021-07-12");
	    Time hora = Time.valueOf("00:56:00");
	    String notas = "O primeiro atendimento foi individual....... blablabla";
	    String psi = "02925522971";
		Integer caso = 1;
		Intervencao int1 = new Intervencao(tipo, data, hora, notas, psi, caso);
	    intervencaoDAO.cadastrar(int1);
	    
		tipo = "Avaliação de Porte de Arma de Fogo";
		data = Date.valueOf("2021-08-01");
	    hora = Time.valueOf("03:30:00");
	    notas = "Considerado APTO para o porte.";
	    psi = "02925522971";
		caso = 1;
		Intervencao int2 = new Intervencao(tipo, data, hora, notas, psi, caso);
	    intervencaoDAO.cadastrar(int2);
	    
	    tipo = "Acompanhamento";
		data = Date.valueOf("2021-07-20");
	    hora = Time.valueOf("00:22:00");
	    notas = "Contato via Whastapp. Tratamento indo bem... blablabla";
	    psi = "02925522971";
		caso = 1;
		Intervencao int3 = new Intervencao(tipo, data, hora, notas, psi, caso);
	    intervencaoDAO.cadastrar(int3);
	    
	    return;
	    
	}
	
	private static void getIntervencaoById() {
		IntervencaoDAO intervencaoDAO = new IntervencaoDAO();
		Intervencao intervencao = intervencaoDAO.getOneById(1);
		System.out.println(intervencao.toString());
		
	}

	private static void getAllIntervencoesByCaso() {
		
		IntervencaoDAO intervencaoDAO = new IntervencaoDAO();
		List<Intervencao> list = intervencaoDAO.getAllByCaso(1); 
		
		for (Intervencao intervencao : list) {
			System.out.println(intervencao.toString());
		}
		
		return;
		
	}
	
	private static void updateOneIntervencao() {
		IntervencaoDAO intervencaoDAO = new IntervencaoDAO();
		Intervencao intervencao = intervencaoDAO.getOneById(1);
		intervencao.setNotas("O primeiro atendimento foi individual....... updated!");
		intervencaoDAO.updateOne(intervencao);
		System.out.println("Updated: " + intervencao.toString());
		return;
	}

	private static void deleteOneIntervencao() {
		IntervencaoDAO intervencaoDAO = new IntervencaoDAO();
		intervencaoDAO.deleteOne(3);
		System.out.println("Deleted Intervencao id=3");
		return;
		
	}
}


