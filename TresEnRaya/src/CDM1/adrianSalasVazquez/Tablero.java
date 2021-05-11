package CDM1.adrianSalasVazquez;

public class Tablero {

	private String[][] cuadricula;
	
	private int filas;
	private int columnas;
	
	public Tablero() {
		cuadricula = new String[3][3];
		filas = cuadricula.length;
		columnas = cuadricula[0].length;
		crearTablero();
	}
	
	private void crearTablero() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++){
				cuadricula[i][j] = "| _ |";
			}
		}
	}
	
	public void mostrarTablero() {
		System.out.println("    A     B     C");
		for (int i = 0; i < filas; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < columnas; j++){
				System.out.print(cuadricula[i][j] + " ");
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public void introducirFicha(String ficha, int fila, int columna) {
		if (comprobarCasilla(fila,columna)) {
			cuadricula[fila][columna] = "| " + ficha + " |";
		}
	}
	
	public boolean comprobarCasilla(int fila, int columna) {
		boolean libre = false;
		if (cuadricula[fila][columna].equals("| _ |")) {
			libre = true;
		}
		return libre;
	}
	
	public boolean comprobarPartidaAcabada() {
		
		
		
		return false;
	}
	
}
