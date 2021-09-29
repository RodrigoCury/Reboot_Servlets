package br.dev.rodrigocury.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.dev.rodrigocury.gerenciador.models.Banco;
import br.dev.rodrigocury.gerenciador.models.Usuario;

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
		Usuario autenticado = Banco.autentica(login, senha);
		
		if (autenticado == null) {
			request.setAttribute("error", "Login ou Senha Incorretos");
			return get(request, response);
		}
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("usuarioLogado", autenticado);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}

	private String get(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "forward:/WEB-INF/view/login.jsp";
	}

}
