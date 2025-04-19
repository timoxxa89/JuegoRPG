package JuegoRPG;

/**
 * Clase Arquero, una subclase de Personaje.
 * Tiene atributos y comportamientos específicos como ataque personalizado e inventario inicial propio.
 */

public class Arquero extends Personaje{
	
	private int flechas;
	
	public Arquero() throws Exception {
		super(null);
		this.vida = 100;
		this.ataque = 30;
		this.defensa = 10;
		this.flechas = 15;
	}
	
	@Override
	public void getInfo() {
		System.out.println("\n-------------------------------------------------------------\n");
		System.out.println("Nombre: " + nombre + "\n");
	    System.out.println("Clase: Arquero");
		System.out.println("Salud: "  + vida);
		System.out.println("Ataque: " + ataque);
		System.out.println("Número de flechas: " + flechas);
		System.out.println("Defensa: " + defensa + "%");
		System.out.println("\n-------------------------------------------------------------\n");
	}
	
	@Override
	public void ataque(Enemigo enemigo) {
		int daño;
		//Verifica si tiene flechas en su inventario.
		if(this.flechas > 0) {
			//Calcula el daño de ataque
			daño = (int) (ataque * (1 - (enemigo.getDefensa() / 100.0)));
			System.out.println(nombre + " ha realizado un ataque con el arco a " + enemigo.getNombre() + " que le ha hecho " + daño + " puntos de daño");
			enemigo.recibirAtaque(daño);
			this.flechas--; //Disminuye el número de flechas al atacar.
			
			//Verifica si hay "Flechas de cazador" en el inventario y actualiza su cantidad
			for(Bolsa item : bolsa) {
	            if(item.getNombreEquipamiento().equals("Flechas de cazador") && item.getCantidad() > 0) {
	                item.setCantidad(item.getCantidad() - 1);
	            }
	        }
			
		} else {
			// Si no tiene flechas, realiza un ataque cuerpo a cuerpo
			System.out.println(nombre + " se ha quedado sin flechas, utilizará los puños");
			daño = (int) (ataque * ((1 - (defensa / 100.0))*0.2));
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
		bolsa.add(new Bolsa("Arco grande", "Un arco robusto y potente, ideal para disparos de larga distancia con gran precisión.", 1));
        bolsa.add(new Bolsa("Flechas de cazador", "Flechas afiladas y resistentes, perfectas para cazar presas rápidas y furiosas.", 15));
		bolsa.add(new Bolsa("Poción de Curación", "Recupera 30 puntos de vida al ser consumida.", 3));
	}
	
	@Override
	public void recibirAtaque(int daño) {
		vida = vida - daño;
		
		if(vida < 0) {
			vida = 0;
		}
	}
	
	@Override
	public void curarse() {
		for (Bolsa item : bolsa) {
	        if (item.getNombreEquipamiento().equals("Poción de Curación") && item.getCantidad() > 0) {
	            if(vida < 100) {
	            	System.out.println(nombre + " ha usado una Poción de Curación.");
	            	vida += 30; 
	            	if(vida > 100) {
	            		vida = 100;
	            	}
	            }	else {
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
	}
	
	@Override
	public int getVida() {
		return vida;
	}
}
