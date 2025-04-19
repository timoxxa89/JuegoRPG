package JuegoRPG;

/**
 * Clase Abominación, una subclase de Enemigo.
 * Tiene atributos y comportamientos específicos como ataque personalizado.
 */

public class Abominacion extends Enemigo{
	public Abominacion(String nombre, int vida, int ataque, int defensa) {
		super(nombre, vida, ataque, defensa);
	}
	
	@Override
	public int ataque(int defensa) {
		int daño;
		daño = (int) (ataque * (1 - (defensa / 100.0)));
		return daño;
	}

	@Override
	public void recibirAtaque(int daño) {
		vida = vida - daño;
		if(vida < 0) {
			vida = 0;
		}
	}
	
	@Override
	public void getInfo() {
		System.out.println("\nNombre: " + nombre + "\n");
		System.out.println("Salud: "  + vida);
		System.out.println("Ataque: " + ataque);
		System.out.println("Defensa: " + defensa + "%");
	}
	
	@Override
	public void introduccion() {
		System.out.println("Un hedor insoportable llena el aire.");
		System.out.println("Sus ojos vacíos pero hambrientos se clavan en ti con una intención macabra.");
		System.out.println("Aparece una abominación frente a ti");
		System.out.println("\n-------------------------------------------------------------\n");
	}
}
