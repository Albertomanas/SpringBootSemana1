package org.formacio.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServeiAlumnat {

	@Autowired
	private RepositoriAlumnes repositori;
	
	/**
	 * ha de donar d'alta a la base de dades d'alumnes l'alumne indicat amb 
	 * el corresponent codi.
	 * Si el nom de l'alumne es null, no l'ha de donar d'alta
	 * Retorna true si l'alumne s'ha inserit, false si no.
	 */
	public boolean matricula (int id, String alumne) {
		if (alumne != null) {
			repositori.altaAlumne(id, alumne);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Añadir un init para que al inicializar cree 2 alumnos (@PostConstruct)
	 */
	
	@PostConstruct
	public void init() {
		this.iniciarRepo();
	}
	
	public void iniciarRepo() {
		String[] alumnes = { "Antonia", "Joan" };
		final int id = 1;
		
		int asignarId = id;
		for (String alumne : alumnes) {
			repositori.altaAlumne(asignarId, alumne);
			asignarId = 2;
		}
		
	}
	
	public int nomAlumne() {
		return repositori.llistaAlumnes().size();
	}
	

}
