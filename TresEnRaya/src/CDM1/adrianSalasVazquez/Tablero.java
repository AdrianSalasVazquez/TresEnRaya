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
	
	public boolean introducirFicha(String ficha, int fila, int columna) {
		boolean puede = false;
		
		if (cuadricula[fila][columna].equals("| _ |")) {
			cuadricula[fila][columna] = "| " + ficha + " |";
			puede = true;
		}
		return puede;
	}
	
	public String comprobarPartidaAcabada() {
		int cont = 0;
		String resul = "N";
		
		
		//Comprobar tablero lleno
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++){
				if (cuadricula[i][j].equals("| X |") || cuadricula[i][j].equals("| O |")) {
					cont++;
				}
			}
		}
		if (cont == 9) {
			 resul = "T";
		}
		
		//Comprobar filas
		for (int i = 0; i < filas; i++) {
			int contX = 0, contO = 0;
			for (int j = 0; j < columnas; j++){
				if (cuadricula[i][j].equals("| X |")) {
					contX++;
				}
				if (cuadricula[i][j].equals("| O |")) {
					contO++;
				}
			}
			if (contO == 3 || contX == 3) {
				 resul = cuadricula[i][0].substring(2, 3);
			}
		}
		
		
		//Comprobar Columnas
		for (int i = 0; i < filas; i++) {
			int contX = 0, contO = 0;
			for (int j = 0; j < columnas; j++){
				if (cuadricula[j][i].equals("| X |")) {
					contX++;
				}
				if (cuadricula[j][i].equals("| O |")) {
					contO++;
				}
			}
			if (contO == 3 || contX == 3) {
				 resul = cuadricula[i][0].substring(2, 3);
			}
		}
		
		
		//Comprobar diagonales
		String prueba = "";
		for (int i = 0; i < filas; i++) {
			prueba += cuadricula[i][i].substring(2, 3);
		}
		if (prueba.equals("XXX") || prueba.equals("OOO")) {
			resul = prueba.substring(0, 1);
		}
		prueba = "";
		int restar = filas;
		for (int i = 0; i < filas; i++) {
			restar--;
			prueba += cuadricula[i][restar].substring(2, 3);
		}
		if (prueba.equals("XXX") || prueba.equals("OOO")) {
			resul = prueba.substring(0, 1);
		}
		
		
		return resul;
	}
	
}
