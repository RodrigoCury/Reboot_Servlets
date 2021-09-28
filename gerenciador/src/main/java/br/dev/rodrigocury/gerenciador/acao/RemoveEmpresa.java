package br.dev.rodrigocury.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.gerenciador.models.Banco;

public class RemoveEmpresa {
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
		response.sendRedirect("removeEmpresa.jsp");
		
	}

	private static void post(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = (String) request.getParameter("id");
		Integer idInt = Integer.valueOf(id);
		
		Banco.remove(idInt);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
		
	}
}
