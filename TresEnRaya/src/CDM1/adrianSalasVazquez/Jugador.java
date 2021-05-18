package CDM1.adrianSalasVazquez;

import java.util.Random;

public class Jugador {
	
	private String nombre;
	
	private String ficha;
	
	private Random dado;
	
	private Tablero tablero;
	
	public Jugador(String nombre, Tablero tablero) {
		this.nombre = nombre;
		ficha = null;
		dado = new Random();
		this.tablero = tablero;
	}

	/**
	* Este método devuelve el nombre del jugador
	* @return String nombre del jugador
	*/
	public String getNombre() {
		return nombre;
	}

	/**
	* Este método cambia el nombre del jugador por el introducido por parametro.
	* @param
	*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	* Este método devuelve la ficha del jugador
	* @return String ficha del jugador
	*/
	public String getFicha() {
		return ficha;
	}

	/**
	* Este método cambia la ficha del jugador por la introducida por parametro.
	* @param
	*/
	public void setFicha(String ficha) {
		this.ficha = ficha;
	}

	/**
	* Este método simplemente devuelve un número aleatorio entre 1 y 6.
	* @return int número aleatorio del 1 al 6.
	*/
	public int tirarDado() {
		return (dado.nextInt(6))+1;
	}
	
	/**
	* Este método filtra las coordenadas introducidas por parametro para que sean válidas para realizar el movimiento del jugador.
	* @return boolean devuelve (true) si la operacion se ha realizado correctamente y (false) si no.
	*/
	public boolean hacerMovimiento(String coords) {
		
		int fila = 0, columna = 0;
		boolean correcto = true;
		
		switch (coords) {
			case "1A" :
			case "A1" : 
				fila = 0;
				columna = 0;
				break;

			case "2A" :
			case "A2" : 
				fila = 1;
				columna = 0;
				break;
			
			case "3A" :
			case "A3" : 
				fila = 2;
				columna = 0;
				break;
			
			case "1B" :
			case "B1" : 
				fila = 0;
				columna = 1;
				break;
			
			case "2B" :
			case "B2" : 
				fila = 1;
				columna = 1;
				break;
			
			case "3B" :
			case "B3" : 
				fila = 2;
				columna = 1;
				break;
			
			case "1C" :
			case "C1" : 
				fila = 0;
				columna = 2;
				break;
			
			case "2C" :
			case "C2" : 
				fila = 1;
				columna = 2;
				break;
			
			case "3C" :
			case "C3" : 
				fila = 2;
				columna = 2;
				break;
			
			default : 
				System.out.println();
				System.out.println("Coordenadas erroneas. \nPor favor introduce correctamente las coordenadas (ej: A1, B3, C1...)");
				correcto = false;
				break;
			
		}
		if (correcto) {
			correcto = tablero.introducirFicha(getFicha(), fila, columna);
			if (!correcto) {
				System.out.println();
				System.out.println("Casilla usada, por favor use otra");
			}
		}
		return correcto;
	}
}
