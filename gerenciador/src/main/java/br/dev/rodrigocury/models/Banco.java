package br.dev.rodrigocury.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

public class Banco {
	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static Integer chaveSequencial = 1;
	

	static {
		try {
			Banco.add(new Empresa("Google"),new Empresa("Alura"),new Empresa("Caellum"));
		} catch (InvalidAttributesException e) {
			e.printStackTrace();
		}
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

	public static void remove(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa empresa = it.next();
			
			if(empresa.getId() == id) {				
				it.remove();
				break;
			}
		}
	}
	
	public static Empresa getEmpresa(Integer id) {
		for (Empresa empresa : lista) 
			if(empresa.getId() == id)
				return empresa;
		
		return null;
	}
}
