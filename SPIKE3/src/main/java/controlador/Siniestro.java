package controlador;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Siniestro {

	@Id
	private String id;

	private String matricula;
	private String numeroPoliza;
	private String numeroBastidor;
	private String marca;
	private String modelo;
	private String fechaAccidente;
	private String lugarAccidente;
	private String tipo;

	public Siniestro() {
	}

	public Siniestro(String matricula, String numeroPoliza,
			String numeroBastidor, String marca, String modelo,
			String fechaAccidente, String lugarAccidente, String tipo) {

		this.matricula = matricula;
		this.numeroPoliza = numeroPoliza;
		this.numeroBastidor = numeroBastidor;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaAccidente = fechaAccidente;
		this.lugarAccidente = lugarAccidente;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return String
				.format("Siniestro:\n id=%s \n matricula ='%s'\n número de Poliza='%s'\n número de bastidor='%s'\n marca = '%s'\n",
						id, matricula, numeroPoliza, numeroBastidor, marca);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getNumeroBastidor() {
		return numeroBastidor;
	}

	public void setNumeroBastidor(String numeroBastidor) {
		this.numeroBastidor = numeroBastidor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFechaAccidente() {
		return fechaAccidente;
	}

	public void setFechaAccidente(String fechaAccidente) {
		this.fechaAccidente = fechaAccidente;
	}

	public String getLugarAccidente() {
		return lugarAccidente;
	}

	public void setLugarAccidente(String lugarAccidente) {
		this.lugarAccidente = lugarAccidente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
