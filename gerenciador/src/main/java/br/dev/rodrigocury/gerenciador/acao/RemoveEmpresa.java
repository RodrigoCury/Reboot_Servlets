package br.dev.rodrigocury.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.gerenciador.models.Banco;

public class RemoveEmpresa  implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getParameter("id");
		Integer idInt = Integer.valueOf(id);
		
		boolean removed = Banco.remove(idInt);
		
		if(removed) {
			return "redirect:entrada?acao=ListaEmpresas";			
		}
		
		return "error:404";
				
	}
}
