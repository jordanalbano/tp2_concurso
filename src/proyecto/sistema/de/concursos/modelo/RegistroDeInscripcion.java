package proyecto.sistema.de.concursos.modelo;

import proyecto.sistema.de.concursos.exceptions.AppException;

public interface RegistroDeInscripcion {
	void registrar(String registro) throws AppException;

}
