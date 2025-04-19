package JuegoRPG;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//Introducción narrativa
		introduccion(); 

		//definimos las clases del jugador
		Personaje pj = elegirClase();  
		
		//definimos la clase del enemigo aleatorio
		Enemigo enemigo = elegirEnemigo();
		
		//se inicializa el inventario del jugador
		pj.crearInventario();
		
	
		//mostramos la información inicial
		pj.getInfo(); 
		enemigo.introduccion(); 
		enemigo.getInfo(); 
		
		//variable de control de la batalla
		boolean enBatalla = true;
		boolean curandose = false;
		Scanner sc = new Scanner(System.in);
	
		//bucle inicial del combate	
		while(enBatalla != false) { 
			 
			System.out.println("\n-------------------------------------------------------------\n");
	         System.out.println("Empieza la batalla\n");
	         System.out.println("[1] Atacar");
	         System.out.println("[2] Curarse");
	         System.out.println("[3] Inventario");
	         System.out.println("\n-------------------------------------------------------------\n");
	         
	         int num = sc.nextInt();
	         boolean accionHecha = false;
	         
	         //Validar acciones jugador
	         while(accionHecha != true) {
	        	 switch (num) {
		         	case 1:
		         		pj.ataque(enemigo);  //realiza un ataque al enemigo
		         		accionHecha = true;
		         		break;
		         	case 2:
		         		pj.curarse();  //el personaje se cura sin perder el turno
		         		curandose = true;
		         		accionHecha = true;
		         		break;
		         	case 3: 
		         		pj.abrirInventario(); //abres el inventario perdiendo el turno
		         		accionHecha = true;
		         		break;
		         	default: 
		         		throw new Exception("Número introducido incorrecto");
		        	 }
	         }
	         
	         //comprueba si el enemigo ha sido derrotado
	         if(enemigo.getVida() <= 0) { 
	        	 System.out.println("\n-------------------------------------------------------------\n");
	             System.out.println("Con un último golpe " + enemigo.getNombre() + " cae al suelo derrotado");
	             System.out.println("Has ganado esta batalla");
	             enBatalla = false;
	         
	         } 
	         //si te has curado el enemigo no realiza su ataque
	         else if(curandose == false) { 
	        	 int dañoJefe = enemigo.ataque(pj.getDefensa());
	             System.out.println("\n-------------------------------------------------------------\n");
	        	 System.out.println(enemigo.getNombre() + " se abalanza sobre ti, su golpe resuena como un eco en la oscuridad. Te ha hecho " + dañoJefe + " Puntos de daño");
	             pj.recibirAtaque(dañoJefe);
	         }
	         
	         //comprueba si el jugador ha sido derrotado
	         if(pj.getVida() <= 0) { 
	             System.out.println("\n-------------------------------------------------------------\n");
	        	 System.out.println("El dolor se extiende por tu cuerpo mientras caes al suelo.");
	        	 System.out.println("La oscuridad te envuelve y, antes de perder el conocimiento, sabes que esta batalla ha llegado a su fin...");
	        	 enBatalla = false;
	         }
	         
	         //mostrar estado actual de ambos
	         pj.getInfo();
	         enemigo.getInfo();
	         curandose = false;
		}		
	}
	
	
	/**
	 * Método para que el jugador elija su clase.
	 * @return una instancia de la clase seleccionada
	 */
	
	public static Personaje elegirClase () throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escoja una de las siguientes clases:\n");
		System.out.println("[1] Guerrero");
		System.out.println("[2] Mago");
		System.out.println("[3] Arquero");
		System.out.println("\n-------------------------------------------------------------\n");
		int num = sc.nextInt();
		Personaje personaje;
		
		
        	if(num == 1) {
        		personaje = new Guerrero();
        		
			} else if (num == 2) {
				personaje = new Mago();
			
			} else if (num == 3) {
				personaje = new Arquero();
			
			} else {
				throw new Exception("Número introducido incorrecto");
			}
       
		

		return personaje;

	}
	
	/**
	 * Narrativa inicial de la partida.
	 */
	
	public static void introduccion() { 
		System.out.println("\n-------------------------------------------------------------\n");
		System.out.println("La oscuridad lo envuelve todo...");
		System.out.println("El suelo es frío, el aire denso con el hedor de la muerte. No recuerdas cómo llegaste aquí. Algo se mueve entre las sombras, susurrando tu nombre.");
		System.out.println("\n-------------------------------------------------------------\n");
	}
	
	/**
	 * Elige un enemigo aleatoriamente de entre tres tipos.
	 * @return instancia de Enemigo
	 */
	
	public static Enemigo elegirEnemigo() { 
		Random rd = new Random();
		int enemigoElegido = rd.nextInt(3);
		
		switch (enemigoElegido) {
			case 0:
				return new Esqueleto("Esqueleto", 50, 15, 10);
			case 1: 
				return new Molinete("Molinete", 150, rd.nextInt(20, 40), rd.nextInt(20, 40));
			case 2:
				return new Abominacion("Abominación", 120, rd.nextInt(25, 45), 15);
			default:
				return new Molinete("Molinete", 150, rd.nextInt(20, 40), rd.nextInt(20, 40));
		}
	}
	
	
}
