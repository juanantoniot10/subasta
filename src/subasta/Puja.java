package subasta;

public class Puja {
	private Usuario usuario;
	private int cantidadPuja;
	
	public Puja(Usuario usuario, int cantidadPuja) {
		super();
		this.usuario = usuario;
		this.cantidadPuja = cantidadPuja;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public int getCantidadPuja() {
		return cantidadPuja;
	}
	
	
	
}
