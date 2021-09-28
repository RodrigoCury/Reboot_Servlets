package br.dev.rodrigocury.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.gerenciador.models.Banco;

public class RemoveEmpresa {
	public static void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id = (String) request.getParameter("id");
		Integer idInt = Integer.valueOf(id);
		
		Banco.remove(idInt);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
