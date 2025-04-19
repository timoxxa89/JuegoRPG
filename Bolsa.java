package JuegoRPG;

/**
 * Clase que representa un objeto dentro del inventario del personaje.
 */

public class Bolsa {
	  
	private String nombreEquipamiento;
	private String descripcionEquipamiento;
	private int cantidad;
	
	/**
	 * Constructor para crear un nuevo objeto de inventario.
	 * 
	 * @param nombreEquipamiento Nombre del objeto (ej: Poción de Curación)
     * @param descripcionEquipamiento Descripción de lo que hace el objeto
     * @param cantidad Cantidad inicial de ese objeto
	 */
	
	public Bolsa(String nombreEquipamiento, String descripcionEquipamiento, int cantidad) {
		this.nombreEquipamiento = nombreEquipamiento;
		this.descripcionEquipamiento = descripcionEquipamiento;
		this.cantidad = cantidad;
	}

	//Getters
	public String getNombreEquipamiento() {
		return nombreEquipamiento;
	}

	public String getDescripcionEquipamiento() {
		return descripcionEquipamiento;
	}

	
	public int getCantidad() {
		return cantidad;
	}

	//Setters
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
