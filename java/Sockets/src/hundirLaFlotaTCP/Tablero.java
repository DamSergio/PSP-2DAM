package hundirLaFlotaTCP;

import java.util.Arrays;

public class Tablero {
	private int board[][];
	private int barcos;
	private int barcosEncontrados;
	private int intentos;
	private String pos[];
	
	public Tablero() {
		this.board = new int[10][10];
		this.pos = new String[10];
		this.barcos = 10;
		this.barcosEncontrados = 0;
		this.intentos = 10;
		
		rellenarTablero();
		colocarBarcosAleatorio();
	}
	
	public int getIntentos() {
		return intentos;
	}
	
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public int getBarcos() {
		return barcos;
	}

	public void setBarcos(int barcos) {
		this.barcos = barcos;
	}

	public int getBarcosEncontrados() {
		return barcosEncontrados;
	}

	public void setBarcosEncontrados(int barcosEncontrados) {
		this.barcosEncontrados = barcosEncontrados;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}
	
	private void rellenarTablero() {
		for (int row = 0; row < barcos; row++) {
			for (int col = 0; col < barcos; col++) {
				board[row][col] = 0;
			}
		}
	}

	private void colocarBarcosAleatorio() {
		int barcosColocados = 0;
		while (barcosColocados < barcos) {
			int row = (int) (Math.random()*10);
			int col = (int) (Math.random()*10);
			
			if (board[row][col] == 1) {
				continue;
			}
			
			board[row][col] = 1;
			pos[barcosColocados] = "(" + row + ", " + col + ")";
			barcosColocados++;
		}
	}
	
	public String buscarCasilla(int row, int col) {
		if (board[row][col] == 1) {
			this.barcosEncontrados++;
			return "Barco encontrado en: " + row + ", " + col + ". HUNDIDO";
		} 
		
		this.intentos--;
		return "Agua";
	}

	@Override
	public String toString() {
		return "Tablero [pos=" + Arrays.toString(pos) + "]";
	}
	
	
}
