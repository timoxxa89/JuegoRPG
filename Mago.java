package JuegoRPG;

import java.util.Scanner;

/**
 * Clase Mago, una subclase de Personaje.
 * Tiene atributos y comportamientos específicos como ataque personalizado e inventario inicial propio.
 */

public class Mago extends Personaje{

	private int mana;
	
	public Mago() throws Exception {
		super(null);
		this.vida = 100;
		this.ataque = 40;
		this.defensa = 5;
		this.mana = 100;
		
	}
	
	@Override
	public void getInfo() {
		System.out.println("\n-------------------------------------------------------------\n");
		System.out.println("Nombre: " + nombre + "\n");
	    System.out.println("Clase: Mago");
		System.out.println("Salud: "  + vida);
		System.out.println("Ataque: " + ataque);
		System.out.println("Maná: " + mana);
		System.out.println("Defensa: " + defensa + "%");
		System.out.println("\n-------------------------------------------------------------\n");
	}
	
	@Override
	public void ataque(Enemigo enemigo) {
		int daño;
		if(this.mana > 0) {
			//Ataque mágico
			daño = (int) (ataque * (1 - (enemigo.getDefensa() / 100.0)));
			System.out.println(nombre + " ha realizado un ataque mágico a " + enemigo.getNombre() + " que le ha hecho " + daño + " puntos de daño");
			enemigo.recibirAtaque(daño);
			this.mana -= 20;
			if(mana < 0) {
				mana = 0;
			}
		} else {
			//Si no tiene maná, realiza un ataque cuerpo a cuerpo con menos daño
			System.out.println(nombre + " se ha quedado sin maná, sus ataques harán un 60% menos de daño");
			daño = (int) (ataque * ((1 - (defensa / 100.0))*0.4));
			System.out.println(nombre + " ha realizado un ataque cuerpo a cuerpo a " + enemigo.getNombre() + " que le ha hecho " + daño + " puntos de daño");
			enemigo.recibirAtaque(daño);
		}
	}
	
	@Override
	public void abrirInventario() {
		System.out.println("Inventario de " + nombre + ":");
		for(Bolsa inventario: bolsa) {
			System.out.println("-----------------");
			System.out.println("Nombre del equipo: " + inventario.getNombreEquipamiento() + "\ndescripción: " + inventario.getDescripcionEquipamiento() + "\nCantidad: " + inventario.getCantidad());
		}
	}
	
	@Override
	public void crearInventario() {
		bolsa.add(new Bolsa("Báculo mágico", "Un báculo adornado con runas brillantes que canaliza hechizos con precisión y fuerza.", 1));
        bolsa.add(new Bolsa("Poción de Curación", "Recupera 30 puntos de vida al ser consumida.", 3));
        bolsa.add(new Bolsa("Poción de Maná", "Recupera 30 puntos de maná al ser consumida.", 3));
	}
	
	@Override
	public void recibirAtaque(int daño) {
		vida = vida - daño;
		
		if(vida < 0) {
			vida = 0;
		}
	}
	
	/**
	 * El mago cuenta con pociones de maná. Para poder seguir atacando con magia.
	 */
	
	@Override
	public void curarse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("[1] Curarse");
		System.out.println("[2] Recuperar maná");
		System.out.println("\n-------------------------------------------------------------\n");
		int num = sc.nextInt();

		switch (num) {
			case 1:
				for (Bolsa item : bolsa) {
			        if (item.getNombreEquipamiento().equals("Poción de Curación") && item.getCantidad() > 0) {
			            
			            if(vida < 100) {
			            	System.out.println(nombre + " ha usado una Poción de Curación.");
			            	vida += 30;  
			            	if(vida > 100) {
			            		vida = 100;
			            	}
			            } else {
			            	System.out.println("No has podido usar la poción");
			            	System.out.println("Tienes la salud al máximo");
			            	break;
			            }
			            
			            item.setCantidad(item.getCantidad() - 1);  
			            System.out.println("Recuperas 30 puntos de vida.");
			            break;
			        } else if (item.getNombreEquipamiento().equals("Poción de Curación") && item.getCantidad() == 0) {
			            System.out.println("No tienes pociones de curación disponibles.");
			        }
				}
				break;
			case 2:
				for (Bolsa item : bolsa) {
			        if (item.getNombreEquipamiento().equals("Poción de Maná") && item.getCantidad() > 0) {
			            if(mana < 100) {
			            	System.out.println(nombre + " ha usado una Poción de Maná.");
			            	mana += 30; 
			            	if(mana > 100) {
			            		mana = 100;
			            	}
			            } else {
			            	System.out.println("No has podido usar la poción");
			            	System.out.println("Tienes el maná al máximo");
			            	break;
			            }
			            
			            item.setCantidad(item.getCantidad() - 1);  
			            System.out.println("Recuperas 30 puntos de maná.");
			            break;
			        } else if (item.getNombreEquipamiento().equals("Poción de Maná") && item.getCantidad() == 0) {
			            System.out.println("No tienes pociones de maná disponibles.");
			        }
				}
				break;
		}
	}
	
	@Override
	public int getVida() {
		return vida;
	}
}
