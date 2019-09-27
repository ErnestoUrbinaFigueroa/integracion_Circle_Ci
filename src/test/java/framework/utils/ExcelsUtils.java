package framework.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelsUtils {

	/**
	 * <p>
	 * Lee un excel y obtiene una referencia a la hoja especificada por parametro.
	 * <ul>
	 * <li>{@link #obtenerPaginaExcel(String rutaExcel, String hoja)}</li>
	 * </ul>
	 *
	 * @param rutaExcel ruta en la cual se encuentra el excel a abrir.
	 * @param sheet     hoja del excel a manipular.
	 * @author Ernesto Urbina Figueroa
	 */
	public static XSSFSheet obtenerPaginaExcel(String rutaExcel, String sheet) {
		FileInputStream fis;
		XSSFWorkbook wb;
		XSSFSheet st = null;

		try {
			fis = new FileInputStream(rutaExcel);
			wb = new XSSFWorkbook(fis);
			st = wb.getSheet(sheet);
			fis.close();
		} catch (IOException e) {
			System.out.println("ERROR LEYENDO EL EXCEL!!");
			e.printStackTrace();
		}

		return st;
	}

	/**
	 * <p>
	 * Extrae el dato de una hoja excel segun su fila - columna.
	 * <ul>
	 * <li>{@link #obtenerCelda(String rutaExcel, String hoja)}</li>
	 * </ul>
	 *
	 * @param sheet  hoja del excel de la cual se extraeran los datos.
	 * @param row    fila de hoja excel.
	 * @param column columna de la hoja excel.
	 * @author Ernesto Urbina Figueroa
	 */
	public static XSSFCell obtenerCelda(XSSFSheet sheet, int row, String column) {
		XSSFRow rw = sheet.getRow(row - 1);
		XSSFCell cell = rw.getCell(columLetter(column));

		return cell;
	}

	/**
	 * <p>
	 * Convierte la columna indicada en letras a numero. Se consideran las columnas
	 * de la A - Z.
	 * <ul>
	 * <li>{@link #columLetter(String column)}</li>
	 * </ul>
	 *
	 * @param column columna de la hoja excel (A - Z).
	 * @author Ernesto Urbina Figueroa
	 */
	private static int columLetter(String column) {
		String[] columnas = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		int encontrado = -1;

		for (int i = 0; i <= columnas.length; i++) {
			if (columnas[i].equalsIgnoreCase(column)) {
				encontrado = i;
				break;
			}
		}

		try {
			if (encontrado == -1) {
				throw new Exception("ERROR : Columna invalida!!");
			}

		} catch (Exception e) {
			// Impresion de exception
			e.printStackTrace();
		}

		return encontrado;

	}

}
