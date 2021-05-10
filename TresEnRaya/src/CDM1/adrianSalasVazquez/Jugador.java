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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFicha() {
		return ficha;
	}

	public void setFicha(String ficha) {
		this.ficha = ficha;
	}

	public int tirarDado() {
		return dado.nextInt(5)+1;
	}
	
	public void hacerMovimiento() {
		
	}
}
