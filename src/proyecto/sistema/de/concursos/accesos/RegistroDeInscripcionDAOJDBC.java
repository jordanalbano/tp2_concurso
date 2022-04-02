package proyecto.sistema.de.concursos.accesos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import proyecto.sistema.de.concursos.exceptions.AppException;

public class RegistroDeInscripcionDAOJDBC implements RegistroDeInscripcionDao {

	@Override
	public void create(String registro) throws AppException {
		Connection conn;
		try {

			conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement("INSERT INTO registro(fecha_y_monto ) " + "VALUES (?)");
			statement.setString(1, registro);
			int cantidad = statement.executeUpdate();
			if (cantidad > 0) {
				System.out.println("Modificando " + cantidad + " registros");
			} else {
				System.out.println("Error al actualizar");
				// TODO: disparar Exception propia
			}
		} catch (SQLException e) {
			throw new AppException("Error al crear el canje: " + e.getMessage());
		} finally {
			ConnectionManager.disconnect();
		}

	}

	@Override
	public void update(String registro) {
		// TODO Esbozo de método generado automáticamente

	}

	@Override
	public String find(String registro) {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

	@Override
	public List<String> findAll() {
		// TODO Esbozo de método generado automáticamente
		return null;
	}

}
