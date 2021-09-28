package br.dev.rodrigocury.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.gerenciador.models.Banco;
import br.dev.rodrigocury.gerenciador.models.Empresa;

public class MostraEmpresa {
	public static void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getMethod()) {
			case "POST":
				post(request, response);
				break;
			case "GET":
				get(request, response);
				break;
			default:
				response.sendError(405);
		}
	}
	
	private static void get(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = (String) request.getParameter("id");
		Integer idInt = Integer.valueOf(id);
		
		Empresa empresa = Banco.getEmpresa(idInt);
		if (empresa == null) {
			response.sendRedirect("listaEmpresas");
			return;
		}
		
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher rd = request.getRequestDispatcher("/alteraEmpresa.jsp");
		
		rd.forward(request, response);
	}
	
	private static void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nomeAlterado = request.getParameter("nome");
		String id = (String) request.getParameter("id");
		Integer idInt = Integer.valueOf(id);
		
		Empresa empresa = Banco.getEmpresa(idInt);
		if (empresa == null | nomeAlterado == "") {
			response.sendRedirect("listaEmpresas");
			return;
		}
		empresa.setNome(nomeAlterado);
		
		response.sendRedirect("listaEmpresas");
	}
}
