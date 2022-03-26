package proyecto.sistema.de.concursos.modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import proyecto.sistema.de.concursos.exceptions.ExcepcionPorNoEstarEnRango;
import proyecto.sistema.de.concursos.exceptions.ExcepcionPorParticipanteInscripto;

public class Concurso {
	private Integer codigoDeConcurso;
	private String descripcion;
	private String nombre;
	private LocalDate fechaInicioInscripcion = null;
	private LocalDate fechaFinDeInscripcion = null;
	private ArrayList<Participante> participantesInscriptos = new ArrayList<Participante>();
	public Concurso(Integer codigoDeConcurso, String descripcion, String nombre, LocalDate fechaInicioDeInscripcion,int duracion) {
		
		this.codigoDeConcurso = codigoDeConcurso;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.fechaInicioInscripcion = fechaInicioDeInscripcion;
		this.fechaFinDeInscripcion = fechaInicioDeInscripcion.plusDays(duracion);
	}

	public Concurso(Integer codigoDeConcurso, String descripcion, String nombre, int dia, int mes, int anio,int duracion) {
		this.codigoDeConcurso = codigoDeConcurso;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.fechaInicioInscripcion = LocalDate.of(anio, mes, dia);
		this.fechaFinDeInscripcion = this.fechaInicioInscripcion.plusDays(duracion);

	}

	private Integer codigoDeConcurso() {
		return this.codigoDeConcurso;
	}

	private String descripcion() {
		return this.descripcion;
	}

	private String nombre() {
		return this.nombre;
	}

	public boolean equals(Concurso otroConcurso) {
		return this.codigoDeConcurso.equals(otroConcurso.codigoDeConcurso());

	}

	public String toString() {
		return "Nombre: " + this.nombre() + "Descripcion: " + this.descripcion() + "Codigo De Concurso: "
				+ this.codigoDeConcurso;
	}

	public void inscribirse(Participante participante)
			throws ExcepcionPorParticipanteInscripto, ExcepcionPorNoEstarEnRango {
			if (this.participantesInscriptos.size() != 0) {
			if (estaInscripto(participante)) {
				throw new ExcepcionPorParticipanteInscripto("El Participante Ya Esta Inscripto");
			}
			if (!estaEnRangoDeInscripcion()) {
				throw new ExcepcionPorNoEstarEnRango("No Esta En El Rango De Inscripcion");
			}
			
		}
		if (inscribioElPrimerDia()) {
				participante.agregarPuntos(10);
		}
		
		this.participantesInscriptos.add(participante);

	}

	public boolean inscribioElPrimerDia() {
		LocalDate ld = LocalDate.now();
		return fechaInicioInscripcion.equals(ld);
	}

	public boolean estaEnRangoDeInscripcion() {
		LocalDate fechaActual = LocalDate.now();
		return this.fechaInicioInscripcion.isBefore(fechaActual) && this.fechaFinDeInscripcion.isAfter(fechaActual);
	}

	public boolean estaInscripto(Participante participante) {
		return this.participantesInscriptos.stream().anyMatch(p -> participante.equals(participante));
	}
}
