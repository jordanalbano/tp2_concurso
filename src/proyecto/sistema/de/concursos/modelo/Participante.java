package proyecto.sistema.de.concursos.modelo;

public class Participante {
	private Integer codigoDeParticipante;
	private String nombre;
	private String apellido;
	private Integer dni;
	private Integer edad;
	private Integer cantPuntos;

	public Participante(Integer codigoDeParticipante, String nombre, String apellido, Integer dni, Integer edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.cantPuntos = 0;
		this.codigoDeParticipante = codigoDeParticipante;
		
	}

	public Integer cantidadDePuntos() {
		return this.cantPuntos;
	}

	public void agregarPuntos(Integer puntosParaAgregar) {
		this.cantPuntos += puntosParaAgregar;
	}

	public Integer codigoDeParticipante() {
		return this.codigoDeParticipante;
	}

	public String apellido() {
		return this.apellido;
	}

	public String nombre() {
		return this.nombre;
	}

	public Integer dni() {

		return dni;
	}

	public Integer edad() {
		return this.edad;
	}

	public boolean equals(Participante participanteAIgualar) {
		return this.codigoDeParticipante.equals(participanteAIgualar.codigoDeParticipante());
	}

	public String toString() {
		return "\nnombre: " + this.nombre + "\nApellido: " + this.apellido + "\nEdad: " + this.edad + "\nDni: "
				+ this.dni;
	}

}
