package br.dev.rodrigocury.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

public class Banco {
	private static List<Empresa> lista = new ArrayList<Empresa>();
	

	static {
		try {
			Banco.add(new Empresa("Google"),new Empresa("Alura"),new Empresa("Caellum"));
		} catch (InvalidAttributesException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void add(Empresa empresa) {
		lista.add(empresa);
		empresa.setId(getSize());
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
}
