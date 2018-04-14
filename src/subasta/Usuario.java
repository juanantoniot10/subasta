package subasta;

public class Usuario {
	private String nombre;
	private int credito;
	
	
	
	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
		this.credito = 0;
	}
	public Usuario(String nombre, int credito) {
		super();
		this.nombre = nombre;
		this.credito = credito;
	}
	
	public void incrementarCredito(int cantidad) {
		this.credito += cantidad;
	}
	public void decrementarCredito(int cantidad) {
		this.credito -= cantidad;
	}
	
	
	public void setCredito(int credito) {
		this.credito = credito;
	}
	public String getNombre() {
		return nombre;
	}
	public int getCredito() {
		return credito;
	}
	
	
}
