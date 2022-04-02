package proyecto.sistema.de.concursos.persistencia;

import proyecto.sistema.de.concursos.accesos.RegistroDeInscripcionDAOJDBC;
import proyecto.sistema.de.concursos.accesos.RegistroDeInscripcionDao;
import proyecto.sistema.de.concursos.exceptions.AppException;
import proyecto.sistema.de.concursos.modelo.RegistroDeInscripcion;

public class EnBaseDeDatosRegistroDeInscripcion implements RegistroDeInscripcion {
	private RegistroDeInscripcionDao registro;

	public EnBaseDeDatosRegistroDeInscripcion() {
		registro = new RegistroDeInscripcionDAOJDBC();
	}

	@Override
	public void registrar(String registro) throws AppException {
		this.registro.create(registro);
	}

}
