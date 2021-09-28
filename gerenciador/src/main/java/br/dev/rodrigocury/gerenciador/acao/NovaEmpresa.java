package br.dev.rodrigocury.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.gerenciador.models.Banco;
import br.dev.rodrigocury.gerenciador.models.Empresa;

public class NovaEmpresa {
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

	private static void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("novaEmpresa.jsp");
		
	}

	private static void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try{	
			Empresa novaEmpresa = new Empresa(request.getParameter("nome"));

			Banco.add(novaEmpresa);
			
			request.setAttribute("empresa", novaEmpresa);
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("error", true);
			
		} finally {
			response.sendRedirect("entrada?acao=ListaEmpresas");
		}
		
	}
}
