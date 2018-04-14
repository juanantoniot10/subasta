package subasta;

import java.util.ArrayList;

public class Subasta {
	private String producto;
	private Usuario propietario;
	private boolean abierta;
	private ArrayList<Puja> pujas;
	private Puja pujaMayor;
	
	
	
	
	
	public Subasta(String producto, Usuario propietario) {
		super();
		this.producto = producto;
		this.propietario = propietario;
		this.abierta = true;
		this.pujas = new ArrayList<Puja>();
		this.propietario.getSubastas().add(this);
	}
	
	
	public String ejecutar() {
		String retorno;
		if(pujas.size()>0) {
			if(this.isAbierta()) {
				this.pujas.get(0).getUsuario().decrementarCredito(this.pujas.get(0).getCantidadPuja());
				this.getPropietario().incrementarCredito(this.pujas.get(0).getCantidadPuja());
				retorno = new String("subasta cerrada con exito: objeto "+this.producto+" adjudicado a "+this.pujas.get(0).getUsuario().getNombre()+" por la cantidad de "+this.pujas.get(0).getCantidadPuja());
				this.abierta=false;
			}
			else retorno = new String("la subasta esta cerrada");
		}
		else retorno = new String("no hay ninguna puja");
		return retorno;
	}
	
	public String pujar (Usuario usuario) {
		String retorno;
		int cantidad;
		if(this.getPujas().size()>0) {
			cantidad = this.getPujas().get(0).getCantidadPuja();
		}
		else cantidad =0;
		
		if(this.isAbierta()) {
			if(usuario.getCredito()>cantidad) {
				if(!usuario.equals(propietario)) {
					if(this.getPujaMayor()==null||cantidad > this.getPujaMayor().getCantidadPuja()) {
						pujas.add(0, new Puja(usuario, cantidad));
						retorno="puja realizada " + cantidad + " por " + this.getProducto();
					}
					else retorno = new String("la cantidad no supera la puja mayor de "+this.getPujaMayor().getCantidadPuja()); 
				}
				else retorno = new String("el usuario coincide con el propietario"); 	
			}
			else retorno = new String("el credito del usuario es inferior a la cantidad pujada"); 	
		}
		else retorno = new String("la subasta no esta abierta"); 	
		return retorno;
	}
	
	public String pujar (Usuario usuario,int cantidad) {
		String retorno;
		if(this.isAbierta()) {
			if(usuario.getCredito()>cantidad) {
				if(!usuario.equals(propietario)) {
					if(this.getPujaMayor()==null||cantidad > this.getPujaMayor().getCantidadPuja()) {
						pujas.add(0, new Puja(usuario, cantidad));
						retorno="puja realizada " + cantidad + " por " + this.getProducto();
					}
					else retorno = new String("la cantidad no supera la puja mayor de "+this.getPujaMayor().getCantidadPuja()); 
				}
				else retorno = new String("el usuario coincide con el propietario"); 	
			}
			else retorno = new String("el credito del usuario es inferior a la cantidad pujada"); 	
		}
		else retorno = new String("la subasta no esta abierta"); 	
		return retorno;
	}

	public String getProducto() {
		return producto;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public boolean isAbierta() {
		return abierta;
	}

	public ArrayList<Puja> getPujas() {
		return pujas;
	}

	public Puja getPujaMayor() {
		if(pujas.size()!=0)return pujas.get(0);
		else return new Puja(new Usuario("sin pujas", 0),0);
	}
}
