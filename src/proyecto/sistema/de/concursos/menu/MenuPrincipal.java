package proyecto.sistema.de.concursos.menu;

import java.time.LocalDate;


import proyecto.sistema.de.concursos.modelo.Concurso;
import proyecto.sistema.de.concursos.modelo.Participante;

public class MenuPrincipal {
	public static void main(String[] args) {
		/*
		 * Concurso c = new
		 * Concurso(5,"concurso 1","concurso de motos",LocalDate.of(2022, 2,
		 * 10),LocalDate.of(2022,3,12)); boolean b = cd.estaEnRangoDeInscripcion();
		 * System.out.println(b);
		 */
		Concurso miConcurso = new Concurso(1, "des", "nombre", LocalDate.of(2022, 1, 1),10);
		Participante participante = new Participante(1, "jo", "as", 123312, 20);

		// testear- invocar para ver si anda o no
		miConcurso.inscribirse(participante);

		// verificar
		boolean esta = miConcurso.estaInscripto(participante);

		// System.out.println(new Date(2022,2,3).after(new Date(2022,3,20)));
		// System.out.println(new Date(2022,2,3).after(new Date(2022,3,20)));
		// System.out.println(b);
	}

}
