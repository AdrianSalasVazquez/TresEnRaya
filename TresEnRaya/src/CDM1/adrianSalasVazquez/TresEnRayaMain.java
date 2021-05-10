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
		String nombre = scn.nextLine();
		Jugador jugador1 = new Jugador(nombre,tablero);
		System.out.println();
		System.out.println("El jugador 1 es " + nombre);
		
		
		System.out.println();
		System.out.println("Nombre del jugador 2:");
		nombre = scn.nextLine();
		Jugador jugador2 = new Jugador(nombre,tablero);
		System.out.println();
		System.out.println("El jugador 2 es " + nombre);
		
		
		System.out.println();
		System.out.println("Vamos a tirar los dados:");
		boolean repetirDado = false;
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
				repetirDado = true;
			}
			if (dado1 > dado2) {
				System.out.println("Empieza tirando " + jugador1.getNombre());
			}
			if (dado1 < dado2) {
				System.out.println("Empieza tirando " + jugador2.getNombre());
			}
		}while(repetirDado);
		
		System.out.println();
		tablero.mostrarTablero();
		
	}

}
