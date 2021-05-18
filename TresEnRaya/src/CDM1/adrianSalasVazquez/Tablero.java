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
	
	/**
	* Este método privado crea las cuadrículas vacias del tablero.
	*/
	private void crearTablero() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++){
				cuadricula[i][j] = "| _ |";
			}
		}
	}
	
	/**
	* Este método imprime por pantalla el estado del tablero celda a celda.
	*/
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
	
	/**
	* Este método recoge la ficha introducida por parametro y la introduce en la posicion indicada por los parametros
	* fila y columna.
	* @param 
	* @return boolean devuelve (true) si la insercion fue realizada, y (false) si no fue realizada.
	*/
	public boolean introducirFicha(String ficha, int fila, int columna) {
		boolean puede = false;
		
		if (cuadricula[fila][columna].equals("| _ |")) {
			cuadricula[fila][columna] = "| " + ficha + " |";
			puede = true;
		}
		return puede;
	}
	
	/**
	* Este método recoge todas las posibilidades de acabar una partida (Comprueba si esta el tablero lleno y
	* si hay tres en raya, ya sea en: filas, columnas o diagonales).
	* @return devuelve un string en funcion del resultado: No se ha acabado la partida(N), Ha ganado la ficha X(X),
	* Ha ganado la ficha O(O) y si la partida ha quedado en tablas(T).
	*/
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
