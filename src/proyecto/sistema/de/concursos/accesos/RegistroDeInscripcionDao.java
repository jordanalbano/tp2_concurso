package proyecto.sistema.de.concursos.accesos;

import java.util.List;

import proyecto.sistema.de.concursos.exceptions.AppException;

public interface RegistroDeInscripcionDao {
	void create(String registro) throws AppException;

	//
	void update(String registro);

	String find(String registro);

	List<String> findAll();

}
