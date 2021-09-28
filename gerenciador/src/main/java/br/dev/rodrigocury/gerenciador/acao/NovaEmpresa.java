package br.dev.rodrigocury.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.gerenciador.models.Banco;
import br.dev.rodrigocury.gerenciador.models.Empresa;

public class NovaEmpresa {
	public static String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getMethod()) {
			case "POST":
				return post(request, response);
			case "GET":
				return get(request, response);
			default:
				return "error:405";
		}
	}

	private static String get(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return "redirect:WEB-INF/view/novaEmpresa.jsp";	
	}

	private static String post(HttpServletRequest request, HttpServletResponse response) {
		try{	
			Empresa novaEmpresa = new Empresa(request.getParameter("nome"));

			Banco.add(novaEmpresa);
			
			request.setAttribute("empresa", novaEmpresa);
		} catch (Exception e) {
			return "error:400";
		}
	
		return "forward:/entrada?acao=ListaEmpresas";
	}
}
