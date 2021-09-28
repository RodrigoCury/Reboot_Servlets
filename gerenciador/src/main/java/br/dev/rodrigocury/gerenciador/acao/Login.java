package br.dev.rodrigocury.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.gerenciador.models.Banco;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getMethod()) {
		case "GET":
			return get(request, response);
		case "POST":
			return post(request, response);
		default:
			return "error:405";
		}
	}

	private String post(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		boolean autenticado = Banco.autentica(login, senha);
		
		if (!autenticado) {
			request.setAttribute("error", "Login ou Senha Incorretos");
			return get(request, response);
		}
		
		return "redirect:entrada?acao=ListaEmpresas";
	}

	private String get(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "forward:/WEB-INF/view/login.jsp";
	}

}
