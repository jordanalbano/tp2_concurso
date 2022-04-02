package proyecto.sistema.de.concursos.casos.de.test;

import java.util.Objects;
import java.util.Optional;

import proyecto.sistema.de.concursos.modelo.RegistroDeInscripcion;

public class EnMemoriaRegistroDeInscripcion implements RegistroDeInscripcion {
	private String registroGuardado = null;// String por defecto es nulo?

	@Override
	public void registrar(String registro) {
		// TODO Esbozo de método generado automáticamente
		this.registroGuardado = registro;
	}

	/*
	 * public String encontrar() {
	 * 
	 * return this.registroGuardado; }
	 */

	public Optional<String> encontrar() {
		return Optional.of(Objects.requireNonNull(this.registroGuardado, "no hay ningun registro guardado"));

	}

}
