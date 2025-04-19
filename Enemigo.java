package JuegoRPG;

import java.util.Random;

/**
 * Clase base para todos los enemigos del juego.
 * Contiene atributos comunes como nombre, vida, ataque y defensa.
 */

public class Enemigo {
	
	//Atributos del enemigo
	protected static String nombre;
	protected int vida;
	protected int ataque;
	protected int defensa;
	
	/**
     * Constructor para crear un enemigo personalizado.
     * 
     * @param nombre Nombre del enemigo
     * @param vida Puntos de vida
     * @param ataque Valor de ataque base
     * @param defensa Porcentaje de defensa (0-100)
     */
	
	public Enemigo(String nombre, int vida, int ataque, int defensa){
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
	}

	/**
     * Calcula el daño infligido al jugador según su defensa.
     * 
     * @param defensa Defensa del jugador (0-100)
     * @return Daño final tras aplicar defensa
     */
	
	public int ataque(int defensa) {
		int daño;
		daño = (int) (ataque * (1 - (defensa / 100.0)));
		return daño;
	}
	
	/**
	 * Aplica el daño recibido y reduce la vida del enemigo.
	 * 
	 * @param daño
	 */
	
	public void recibirAtaque(int daño) {
		vida = vida - daño;
		if(vida < 0) {
			vida = 0;
		}
	}

	/**
	 * Muestra la información actual del enemigo por consola.
	 */
	
	public void getInfo() {
		System.out.println("\nNombre: " + nombre + "\n");
		System.out.println("Salud: "  + vida);
		System.out.println("Ataque: " + ataque);
		System.out.println("Defensa: " + defensa + "%");
	}
	
	/**
	 * Introducción narrativa de los enemigos
	 */
	
	public void introduccion() {
		System.out.println("Aparece un enemigo");
	}

	//Getters
	
	public int getDefensa() {
		return defensa;
	}

	public String getNombre() {
		return nombre;
	}

	public int getVida() {
		return vida;
	}
}
