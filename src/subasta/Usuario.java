package subasta;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private int credito;
	private ArrayList<Subasta> subastas;
	
	
	
	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
		this.credito = 0;
		this.subastas= new ArrayList<>();
	}
	public Usuario(String nombre, int credito) {
		super();
		this.nombre = nombre;
		this.credito = credito;
		this.subastas= new ArrayList<>();
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
	public ArrayList<Subasta> getSubastas() {
		return subastas;
	}
	public void setSubastas(ArrayList<Subasta> subastas) {
		this.subastas = subastas;
	}
	
	
}
