package br.dev.rodrigocury.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.gerenciador.models.Banco;
import br.dev.rodrigocury.gerenciador.models.Empresa;

public class MostraEmpresa {
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
	
	private static String get(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = (String) request.getParameter("id");
		Integer idInt = Integer.valueOf(id);
		
		Empresa empresa = Banco.getEmpresa(idInt);
		if (empresa == null) {
			return "error:404";			
		}
		
		request.setAttribute("empresa", empresa);
		
		return "forward:/WEB-INF/view/alteraEmpresa.jsp";
		
	}
	
	private static String post(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String nomeAlterado = request.getParameter("nome");
		String id = (String) request.getParameter("id");
		Integer idInt = Integer.valueOf(id);
		
		Empresa empresa = Banco.getEmpresa(idInt);
		if (empresa == null | nomeAlterado == "") {
			return "error:400";
		}
		
		empresa.setNome(nomeAlterado);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
