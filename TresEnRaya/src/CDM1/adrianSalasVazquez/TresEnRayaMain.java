package CDM1.adrianSalasVazquez;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TresEnRayaMain {

	public static void main(String[] args) throws InterruptedException {
		
		Tablero tablero = new Tablero();
		Scanner scn = new Scanner(System.in);
		boolean repetir = false;
		
		System.out.println("====================");
		System.out.println("    TRES EN RAYA    ");
		System.out.println("====================");
		System.out.println();
		System.out.println("Deseas jugar o cargar partida:");
		
		do {
			
			System.out.println("Introduce: ( Jugar | Cargar )");
			String modo = scn.nextLine().toUpperCase();
			
			switch (modo) {
			case "JUGAR":
				ArrayList<String> logs = new ArrayList<>();
				repetir = false;
				
				System.out.println();
				System.out.println("Ha seleccionado jugar:");
				System.out.println("========================");
				System.out.println();
				
				System.out.println("Nombre del jugador 1:");
				String nombre = scn.nextLine().toUpperCase();
				Jugador jugador1 = new Jugador(nombre,tablero);
				System.out.println();
				System.out.println("El jugador 1 es " + nombre);
				
				//Log nombre del jugador1
				logs.add("El jugador1 se llama " + nombre + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
				
				System.out.println();
				System.out.println("Nombre del jugador 2:");
				nombre = scn.nextLine().toUpperCase();
				Jugador jugador2 = new Jugador(nombre,tablero);
				System.out.println();
				System.out.println("El jugador 2 es " + nombre);
				
				//Log nombre del jugador1
				logs.add("El jugador2 se llama " + nombre + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
				
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
					
					//Log dado del jugador1
					logs.add(jugador1.getNombre() + " saca un " + dado1 + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
					
					
					System.out.print("Tirando dado de " + jugador2.getNombre());
					int dado2 = jugador2.tirarDado();
					Thread.sleep(5*500);
					System.out.print("  -->  " + dado2);
					System.out.println();
					System.out.println();
					
					//Log dado del jugador2
					logs.add(jugador2.getNombre() + " saca un " + dado2 + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
					
					
				
					if (dado1 == dado2) {
						System.out.println("Se repitieron los dados, se va a volver a tirar");
						System.out.println();
						repetirDado = true;
						
						//Log dados iguales
						logs.add("Se repiten los dados" + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
						
					}
					if (dado1 > dado2) {
						System.out.println("Empieza tirando " + jugador1.getNombre());
						jugador1.setFicha("X");
						jugador2.setFicha("O");
						repetirDado = false;
						jugadorPrimero = jugador1;
						jugadorSegundo = jugador2;
						
						//Log jugador1 gana dados
						logs.add(jugador1.getNombre() + " gano a los dados. Tira primero" + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
						
					}
					if (dado1 < dado2) {
						System.out.println("Empieza tirando " + jugador2.getNombre());
						jugador2.setFicha("X");
						jugador1.setFicha("O");
						repetirDado = false;
						jugadorPrimero = jugador2;
						jugadorSegundo = jugador1;
						
						//Log jugador2 gana dados
						logs.add(jugador2.getNombre() + " gano a los dados. Tira primero" + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
						
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
					
					//Log movimiento 1
					logs.add(jugadorPrimero.getNombre() + " introduce las coordenadas " + coords + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
					
					
					System.out.println();
					tablero.mostrarTablero();
					
					if (tablero.comprobarPartidaAcabada() == "N") {
						
						do {
							System.out.println();
							System.out.println(jugadorSegundo.getNombre() + ", introduce las coordenadas de tu movimiento: \n(ej: C1, B2, A3...)");
							coords = scn.nextLine().replaceAll(" ", "").toUpperCase();
						}while(!jugadorSegundo.hacerMovimiento(coords));
						
						//Log movimiento 2
						logs.add(jugadorSegundo.getNombre() + " introduce las coordenadas " + coords + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
						
						
						System.out.println();
						tablero.mostrarTablero();
						
					}
					
				}while (tablero.comprobarPartidaAcabada() == "N");
				
				
				
				String fin = tablero.comprobarPartidaAcabada();
				
				switch (fin) {
					case "X" : 
						if (jugador1.getFicha().equals("X")) {
							System.out.println("Ha ganado " + jugador1.getNombre());
							
							//Log ganador 1
							logs.add(jugador1.getNombre() + " ha ganado la partida" + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
							
						}
						else {
							System.out.println("Ha ganado " + jugador2.getNombre());
							
							//Log ganador 2
							logs.add(jugador2.getNombre() + " ha ganado la partida" + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
						}
						break;
					
					case "O" : 
						if (jugador1.getFicha().equals("O")) {
							System.out.println("Ha ganado " + jugador1.getNombre());
							
							//Log movimiento 1
							logs.add(jugador1.getNombre() + " ha ganado la partida" + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
						}
						else {
							System.out.println("Ha ganado " + jugador2.getNombre());
							
							//Log ganador 2
							logs.add(jugador2.getNombre() + " ha ganado la partida" + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
						}
						break;
					
					case "T" : 
						System.out.println("La partida ha acabado se ha quedado en tablas");
						
						//Log tablas
						logs.add("La partida ha acabado en tablas" + " - " + new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date()));
						
						break;
					
				}
				
				
				//Creacion de fichero log
				String fecha = new SimpleDateFormat("dd-MM-yyyy'_'HH-mm-ss").format(new Date());
				String fileName = fecha.concat("-log.txt");
				File file1 = new File("logs//" + fileName);
				file1.getParentFile().mkdirs();
				try {
					FileWriter fw = new FileWriter(file1);
					PrintWriter pw = new PrintWriter(fw);
					
					for (String log : logs) {
						pw.println(log);
					}
					
					fw.close();
				} catch (IOException e) {
					System.out.println("Ha fallado o se ha interrumpido la conexion de entrada o salida.");
					e.getStackTrace();
				}
				
				break;
				
			case "CARGAR":
				repetir = false;
				boolean repetirFichero = false;
				File file2 = null;
				
				System.out.println();
				System.out.println("Ha seleccionado cargar una partida");
				System.out.println("====================================");
				System.out.println();
				System.out.println("Introduce el nombre del log que desea cargar:");
				
				do {
					
					String filename = ("logs//" + scn.nextLine());
					if (!filename.endsWith(".txt")) {
						filename = (filename + ".txt");
					}
					file2 = new File(filename);
					file2.getParentFile().mkdirs();
					if (file2.exists()) {
						System.out.println();
						System.out.println("Log encontrado");
						repetirFichero = false;
					}
					else {
						System.out.println("No existe ese log vuelve a introducir un nombre:");
						repetirFichero = true;
					}
					
				} while(repetirFichero);
				
				ArrayList<String> logsLeer = new ArrayList<>();
				
				try {
					
					FileReader fr = new FileReader (file2);
					BufferedReader br = new BufferedReader (fr);
					String linea = "";
					while (linea != null) {
						linea = br.readLine();
						if(linea != null) {
							logsLeer.add(linea.substring(0, linea.length()-22));
						}
					}
					fr.close();
					
				} catch (FileNotFoundException e) {
					System.out.println("No ha encontrado el archivo");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Ha fallado o se ha interrumpido la conexion de entrada o salida.");
					e.getStackTrace();
				}
				
				System.out.println("Cargando contenido del log:");
				System.out.println();
				
				Thread.sleep(5*500);
				
				String nombreCargar = logsLeer.get(0).substring(21);
				Jugador jugadorCargar1 = new Jugador(nombreCargar,tablero);
				System.out.println("El jugador 1 es " + jugadorCargar1.getNombre());
				System.out.println();
				
				
				nombreCargar = logsLeer.get(1).substring(21);
				Jugador jugadorCargar2 = new Jugador(nombreCargar,tablero);
				System.out.println("El jugador 2 es " + jugadorCargar2.getNombre());
				System.out.println();
				
				
				System.out.println("Tiran los dados:");
				System.out.println(jugadorCargar1.getNombre() + " --> " + logsLeer.get(2).substring(jugadorCargar1.getNombre().length()+8));
				System.out.println(jugadorCargar2.getNombre() + " --> " + logsLeer.get(3).substring(jugadorCargar2.getNombre().length()+8));
				System.out.println();
				
				if (logsLeer.get(4).substring(0,jugadorCargar1.getNombre().length()).equals(jugadorCargar1.getNombre())) {
					System.out.println("Empieza tirando " + jugadorCargar1.getNombre());
					jugadorCargar1.setFicha("X");
					jugadorCargar2.setFicha("O");
				}
				else {
					System.out.println("Empieza tirando " + jugadorCargar2.getNombre());
					jugadorCargar2.setFicha("X");
					jugadorCargar1.setFicha("O");
				}
				System.out.println();
				
				
				for (String log : logsLeer) {
					if (log.contains(" introduce las coordenadas ")) {
						System.out.println(log);
						if (log.substring(0,jugadorCargar1.getNombre().length()).equals(jugadorCargar1.getNombre())) {
							jugadorCargar1.hacerMovimiento(log.substring(27 + jugadorCargar1.getNombre().length()));
							System.out.println();
							tablero.mostrarTablero();
							System.out.println();
						}
						else {
							jugadorCargar2.hacerMovimiento(log.substring(27 + jugadorCargar1.getNombre().length()));
							System.out.println();
							tablero.mostrarTablero();
							System.out.println();
						}
					}
				}
				
				System.out.println(logsLeer.get(logsLeer.size()-1));
				
				break;
				
				
			default :
				System.out.println();
				repetir = true;
				break;
			}
			
		}while (repetir);
		
	}

}
