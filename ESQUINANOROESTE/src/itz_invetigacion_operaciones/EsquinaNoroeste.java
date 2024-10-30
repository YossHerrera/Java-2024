package itz_invetigacion_operaciones;

import javax.swing.JOptionPane;

public class EsquinaNoroeste {

	public static void main(String[] args) {
			// Obtener las dimensiones de la matriz de oferta y demanda
			int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas (ofertas):"));
			int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas (demandas):"));

			// Crear las matrices de oferta, demanda, costos y asignaciones
			int[][] oferta = new int[filas][1];
			int[][] demanda = new int[1][columnas];
			int[][] costo = new int[filas][columnas];
			int[][] asignaciones = new int[filas][columnas];

			// Llenar las matrices de oferta, demanda y costos
			for (int i = 0; i < filas; i++) {
				oferta[i][0] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la oferta para la fila " + (i + 1) + ":"));
			}
			for (int j = 0; j < columnas; j++) {
				demanda[0][j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la demanda para la columna " + (j + 1) + ":"));
			}
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					costo[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el costo para la celda (" + (i + 1) + "," + (j + 1) + "):"));
				}
			}

			// Aplicar el método de la esquina noroeste
			int i = 0, j = 0;
			while (i < filas && j < columnas) {
				int asignacion = Math.min(oferta[i][0], demanda[0][j]);
				asignaciones[i][j] = asignacion;
				oferta[i][0] -= asignacion;
				demanda[0][j] -= asignacion;
				if (oferta[i][0] == 0) {
					i++;
				} else {
					j++;
				}
			}

			// Calcular el costo total
			int costoTotal = 0;
			for (int x = 0; x < filas; x++) {
				for (int y = 0; y < columnas; y++) {
					costoTotal += asignaciones[x][y] * costo[x][y];
				}
			}

			// Mostrar la solución y el costo total
			String resultado = "La matriz de asignaciones es:\n";
			for (int x = 0; x < filas; x++) {
				for (int y = 0; y < columnas; y++) {
					resultado += "{"+asignaciones[x][y]+"}" + "\t";
				}
				resultado += "\n";
			}
			resultado += "El costo total es: " + costoTotal;
			JOptionPane.showMessageDialog(null, resultado);
	}
}
