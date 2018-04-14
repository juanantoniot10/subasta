package subasta;

import java.util.ArrayList;
import java.util.Iterator;

public class Principal {

	public static void main(String[] args) {
		Usuario juan = new Usuario("juan",100);
		Usuario pedro = new Usuario("Pedro", 150);
		Usuario Enrique = new Usuario("Enrique", 300);
		Subasta subastaJuan = new Subasta("Telefono movil", juan);
		subastaJuan.pujar(pedro, 100);
		System.out.println("En las subasta de juan la puja mayor es "+subastaJuan.getPujaMayor().getCantidadPuja());
		System.out.println(subastaJuan.pujar(Enrique,50));
		System.out.println("En las subasta de juan la puja mayor es "+subastaJuan.getPujaMayor().getCantidadPuja());
		System.out.println(subastaJuan.ejecutar());
		System.out.println("Enrique intenta pujar en subasta cerrada:");
		System.out.println(subastaJuan.pujar(Enrique, 200));
		Subasta subastaEnrique = new Subasta("Impresora", Enrique);
		System.out.println("Enrique intenta pujar en su propia subasta:");
		System.out.println(subastaEnrique.pujar(Enrique));
		System.out.println("intento de cerrar una subasta sin pujas:");
		System.out.println(subastaEnrique.ejecutar());
		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.add(juan);
		usuarios.add(pedro);
		usuarios.add(Enrique);
		System.out.println("Creditos actualizados: ");
		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
			Usuario usuario = (Usuario) iterator.next();
			System.out.println(usuario.getNombre() + "  " + usuario.getCredito());
		}
		System.out.println("SUBASTAS");
		System.out.println("propietario----producto");
		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
			Usuario usuario = (Usuario) iterator.next();
			for (Iterator iterator2 = usuario.getSubastas().iterator(); iterator2.hasNext();) {
				Subasta subasta = (Subasta) iterator2.next();
				System.out.println(subasta.getPropietario().getNombre() + "  " + subasta.getProducto());
			}
		}
	}

}
