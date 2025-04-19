package JuegoRPG;

/**
 * Clase Esqueleto, una subclase de Enemigo.
 * Tiene atributos y comportamientos específicos como ataque personalizado.
 */

public class Esqueleto extends Enemigo{
	
	public Esqueleto(String nombre, int vida, int ataque, int defensa) {
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
		System.out.println("Un crujido rompe el silencio. Un esqueleto emerge de las sombras.");
		System.out.println("Su espada oxidada arrastra el suelo mientras avanza hacia ti, sediento de batalla");
		System.out.println("Aparece un esqueleto frente a ti");
		System.out.println("\n-------------------------------------------------------------\n");
	}
}
