package CDM1.adrianSalasVazquez;

import java.util.Scanner;

public class TresEnRayaMain {

	public static void main(String[] args) throws InterruptedException {
		
		Tablero tablero = new Tablero();
		Scanner scn = new Scanner(System.in);
		
		System.out.println("====================");
		System.out.println("    TRES EN RAYA    ");
		System.out.println("====================");
		System.out.println();
		
		
		System.out.println("Nombre del jugador 1:");
		String nombre = scn.nextLine().toUpperCase();
		Jugador jugador1 = new Jugador(nombre,tablero);
		System.out.println();
		System.out.println("El jugador 1 es " + nombre);
		
		
		System.out.println();
		System.out.println("Nombre del jugador 2:");
		nombre = scn.nextLine().toUpperCase();
		Jugador jugador2 = new Jugador(nombre,tablero);
		System.out.println();
		System.out.println("El jugador 2 es " + nombre);
		
		
		System.out.println();
		System.out.println("Vamos a tirar los dados:");
		boolean repetirDado = false;
		Jugador jugadorPrimero = null;
		Jugador jugadorSegundo = null;
		
		do {
			System.out.print("Tirando dado de " + jugador1.getNombre());
			int dado1 = jugador1.tirarDado();
			Thread.sleep(5*500);
			System.out.print("  -->  " + dado1);
			System.out.println();
			System.out.println();
			
			System.out.print("Tirando dado de " + jugador2.getNombre());
			int dado2 = jugador2.tirarDado();
			Thread.sleep(5*500);
			System.out.print("  -->  " + dado2);
			System.out.println();
			System.out.println();
			
		
			if (dado1 == dado2) {
				System.out.println("Se repitieron los dados, se va a volver a tirar");
				System.out.println();
				repetirDado = true;
			}
			if (dado1 > dado2) {
				System.out.println("Empieza tirando " + jugador1.getNombre());
				jugador1.setFicha("X");
				jugador2.setFicha("O");
				repetirDado = false;
				jugadorPrimero = jugador1;
				jugadorSegundo = jugador2;
			}
			if (dado1 < dado2) {
				System.out.println("Empieza tirando " + jugador2.getNombre());
				jugador2.setFicha("X");
				jugador1.setFicha("O");
				repetirDado = false;
				jugadorPrimero = jugador2;
				jugadorSegundo = jugador1;
			}
		}while(repetirDado);
		
		System.out.println();
		tablero.mostrarTablero();
		
		do {
			
			String coords = null;
			
			do {
				System.out.println();
				System.out.println(jugadorPrimero.getNombre() + ", introduce las coordenadas de tu movimiento: \n(ej: C1, B2, A3...)");
				coords = scn.nextLine().replaceAll(" ", "").toUpperCase();
			}while(!jugadorPrimero.hacerMovimiento(coords));
			
			System.out.println();
			tablero.mostrarTablero();
			
			if (tablero.comprobarPartidaAcabada() == "N") {
				
				do {
					System.out.println();
					System.out.println(jugadorSegundo.getNombre() + ", introduce las coordenadas de tu movimiento: \n(ej: C1, B2, A3...)");
					coords = scn.nextLine().replaceAll(" ", "").toUpperCase();
				}while(!jugadorSegundo.hacerMovimiento(coords));
				
				System.out.println();
				tablero.mostrarTablero();
				
			}
			
		}while (tablero.comprobarPartidaAcabada() == "N");
		
		
		
		String fin = tablero.comprobarPartidaAcabada();
		
		switch (fin) {
			case "X" : {
				if (jugador1.getFicha().equals("X")) {
					System.out.println("Ha ganado " + jugador1.getNombre());
				}
				else {
					System.out.println("Ha ganado " + jugador2.getNombre());
				}
				break;
			}
			case "O" : {
				if (jugador1.getFicha().equals("O")) {
					System.out.println("Ha ganado " + jugador1.getNombre());
				}
				else {
					System.out.println("Ha ganado " + jugador2.getNombre());
				}
				break;
			}
			case "T" : {
				System.out.println("La partida a acabado se ha quedado en tablas");
				break;
			}
		}
		
		
		
		
	}

}
