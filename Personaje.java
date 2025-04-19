package JuegoRPG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	/**
	 * Clase base para representar a un personaje del jugador.
	 */

	public class Personaje {

	    protected int vida;
	    protected int ataque;
	    protected int defensa;
	    protected String nombre;
	    protected List<Bolsa> bolsa;  // Inventario
	    
	    private static Scanner sc = new Scanner(System.in);

    /**
     * Constructor del personaje. Se pide al usuario ingresar un nombre.
     *
     * @param nombre Nombre del personaje
     */
    
    public Personaje(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            this.nombre = definirNombre();
        } else {
            this.nombre = nombre;
        }

        this.bolsa = new ArrayList<>();
    }

    /**
     * Solicita al usuario que introduzca un nombre para el personaje.
     * 
     * @return nombre elegido
     */
    
    public String definirNombre() {
        System.out.println("\n-------------------------------------------------------------\n");
        System.out.println("Elige un nombre para tu personaje:");
        System.out.println("\n-------------------------------------------------------------\n");
        return sc.next();
    }

    /**
     * Método que representa un ataque básico (sobreescribir en subclases).
     * 
     * @param enemigo objetivo del ataque
     */
    
    public void ataque(Enemigo enemigo) {
        System.out.println(nombre + " realiza un ataque básico.");
    }

    /**
     * Muestra la información del personaje.
     */
    
    public void getInfo() {
        System.out.println("\nNombre: " + nombre);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa + "%");
    }

    /**
     * Aplica daño recibido al personaje.
     * 
     * @param daño cantidad de daño recibido
     */
    
    public void recibirAtaque(int daño) {
        vida -= daño;
        if (vida < 0) vida = 0;
    }

    /**
     * Muestra el inventario actual del personaje.
     */
    
    public void abrirInventario() {
        System.out.println("\nInventario de " + nombre + ":");
        if (bolsa.isEmpty()) {
            System.out.println("No tienes objetos en tu inventario.");
        }
        for (Bolsa item : bolsa) {
            System.out.println("Equipo: " + item.getNombreEquipamiento() +
                               " | Descripción: " + item.getDescripcionEquipamiento() +
                               " | Cantidad: " + item.getCantidad());
        }
    }

    /**
     * Inicializa el inventario del personaje con objetos por defecto.
     */
    
    public void crearInventario() {
        // Aquí puedes añadir ítems iniciales (ejemplo)
        bolsa.add(new Bolsa("Poción de Curación", "Restaura 30 de vida.", 2));
        bolsa.add(new Bolsa("Bomba de Humo", "Escapas del combate.", 1));
        System.out.println("Se ha creado el inventario inicial.");
    }

    /**
     * Usa una poción de curación si está disponible.
     */
    
    public void curarse() {
        boolean encontrada = false;
        for (Bolsa item : bolsa) {
            if (item.getNombreEquipamiento().equals("Poción de Curación")) {
                encontrada = true;
                if (item.getCantidad() > 0) {
                    System.out.println(nombre + " ha usado una Poción de Curación.");
                    vida = Math.min(vida + 30, 100);  // Vida máxima = 100
                    item.setCantidad(item.getCantidad() - 1);
                    System.out.println("Recuperas 30 puntos de vida.");
                } else {
                    System.out.println("No tienes pociones de curación disponibles.");
                }
                break;
            }
        }

        if (!encontrada) {
            System.out.println("No tienes ninguna poción de curación.");
        }
    }

    // Getters

    public int getDefensa() {
        return defensa;
    }

    public int getVida() {
        return vida;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Bolsa> getBolsa() {
        return bolsa;
    }
}
