package JuegoRPG;

/**
 * Clase Guerrero, una subclase de Personaje.
 * Tiene atributos y comportamientos específicos como ataque personalizado e inventario inicial propio.
 */

public class Guerrero extends Personaje {


    public Guerrero() {
        super("Guerrero");
        this.vida = 100;
        this.ataque = 30;
        this.defensa = 20;
    }

    @Override
    public void getInfo() {
        System.out.println("\n-------------------------------------------------------------\n");
        System.out.println("Nombre: " + nombre);
        System.out.println("Clase: Guerrero");
        System.out.println("Salud: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa + "%");
        System.out.println("-------------------------------------------------------------");
    }

    @Override
    public void ataque(Enemigo enemigo) {
        int daño = (int) (ataque * (1 - (enemigo.getDefensa() / 100.0)));
        System.out.println(nombre + " ha realizado un ataque a " + enemigo.getNombre() + " que le ha hecho " + daño + " puntos de daño.");
        enemigo.recibirAtaque(daño);
    }

    @Override
    public void abrirInventario() {
        System.out.println("Inventario de " + nombre + ":");
        for (Bolsa inventario : bolsa) {
            System.out.println("-----------------");
            System.out.println("Nombre del equipo: " + inventario.getNombreEquipamiento());
            System.out.println("Descripción: " + inventario.getDescripcionEquipamiento());
            System.out.println("Cantidad: " + inventario.getCantidad());
        }
    }

    @Override
    public void crearInventario() {
        bolsa.add(new Bolsa("Espada de Hierro", "Una espada afilada que puedes usar para atacar.", 1));
        bolsa.add(new Bolsa("Poción de Curación", "Recupera 30 puntos de vida al ser consumida.", 3));
    }

    @Override
    public void recibirAtaque(int daño) {
        vida -= daño;
        if (vida < 0) {
            vida = 0;
        }
    }

    @Override
    public void curarse() {
        for (Bolsa item : bolsa) {
            if (item.getNombreEquipamiento().equals("Poción de Curación")) {
                if (item.getCantidad() > 0) {
                    if (vida < 100) {
                        System.out.println(nombre + " ha usado una Poción de Curación.");
                        vida += 30;
                        if (vida > 100) vida = 100;
                        item.setCantidad(item.getCantidad() - 1);
                        System.out.println("Recuperas 30 puntos de vida.");
                    } else {
                        System.out.println("No has podido usar la poción.");
                        System.out.println("Tienes la salud al máximo.");
                    }
                } else {
                    System.out.println("No tienes pociones de curación disponibles.");
                }
                break;
            }
        }
    }

    @Override
    public int getVida() {
        return vida;
    }
}
