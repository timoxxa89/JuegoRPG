package JuegoRPG;

import java.util.Random;

/**
 * Clase Molinete, una subclase de Enemigo.
 * Tiene atributos y comportamientos específicos como ataque personalizado.
 */

public class Molinete extends Enemigo{
		
	public Molinete(String nombre, int vida, int ataque, int defensa) {
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
		System.out.println("Molinete se alza entre las sombras.");
		System.out.println("Sus ojos vacíos te perforan, su aliento apesta a carne podrida. No hay humanidad en su rostro, solo una mueca retorcida entre el dolor y la locura.");
		System.out.println("Aparece un mago elemental frente a ti");
		System.out.println("\n-------------------------------------------------------------\n");
	}
}
