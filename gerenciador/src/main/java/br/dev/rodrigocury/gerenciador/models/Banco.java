package br.dev.rodrigocury.gerenciador.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

public class Banco {
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static Integer chaveSequencial = 1;
	

	static {
		try {
			Banco.add(new Empresa("Google"),new Empresa("Alura"),new Empresa("Caellum"));
			Banco.add(new Usuario("RodrigoCury", "1234"), new Usuario("Luigi", "1234"));
		} catch (InvalidAttributesException e) {
			e.printStackTrace();
		}
	}
	
	public static void add(Usuario usuario) {
		listaUsuarios.add(usuario);
	}
	
	public static void add(Usuario ...usuario) {
		List.of(usuario).forEach(Banco::add);
	}
	
	public static Usuario autentica(String login, String senha) {
		for (Usuario usuario: listaUsuarios) {
			if(usuario.autentica(login, senha))
				return usuario;
		}
		return null;
		
	}
	
	
	public static void add(Empresa empresa) {
		lista.add(empresa);
		empresa.setId(chaveSequencial++);
	}
	
	public static void add(Empresa ...empresas) {
		List.of(empresas).forEach(Banco::add);
	}
	
	public static List<Empresa> getEmpresas(){
		return Collections.unmodifiableList(lista);
	}
	
	public static int getSize() {
		return lista.size();
	}

	public static boolean remove(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa empresa = it.next();
			
			if(empresa.getId() == id) {				
				it.remove();
				return true;
			}
		}
		
		return false;
	}
	
	public static Empresa getEmpresa(Integer id) {
		for (Empresa empresa : lista) 
			if(empresa.getId() == id)
				return empresa;
		
		return null;
	}
}
