package tarea4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {
		FileOutputStream salida;
		FileInputStream entrada;
		ArrayList<alumno> lista = new ArrayList();
		int veces = 1;
		boolean generoComprovacion = false;
		char genero = 'm';
		Scanner sc = new Scanner(System.in);
		System.out.println("Pasame la ruta del fichero a usar");
		File fichero = new File(sc.nextLine());
		try {
			 salida =new FileOutputStream(fichero,true);
			 entrada =new FileInputStream(fichero);
		} catch (FileNotFoundException e) {
			//mete aqui un mensaje para que no s eha encontrado el archivo y que se creara
		}
		for (int i = 0; i < veces; i++) {
			try {
				generoComprovacion = false;
				System.out.println("dime el nia");
				int nia = sc.nextInt();
				System.out.println("dime el nombre");
				String nombre = sc.next();
				System.out.println("dime el apellido");
				String apellido = sc.next();
				while (!generoComprovacion) {
					System.out.println("dime el genero F o M");
					genero = ((sc.next().toLowerCase()).toCharArray())[0];
					if (genero == 'f' || genero == 'm') {
						generoComprovacion = true;
					}
				}
				System.out.println("dime la fecha (formato yyyy-mm-dd)");
				String dateS = sc.next();
				int anio = Integer.parseInt((dateS.split("-")[0]));
				int mes = Integer.parseInt((dateS.split("-")[1]));
				int dia = Integer.parseInt((dateS.split("-")[2]));
				Date fecha = new Date(anio, mes, dia);
				System.out.println("dime el ciclo");
				String ciclo = sc.next();
				System.out.println("dime el curso");
				String curso = sc.next();
				System.out.println("dime el grupo");
				String grupo = sc.next();
				lista.add(new alumno(nia, nombre, apellido, genero, fecha, ciclo, curso, grupo));
			} catch (InputMismatchException e) {
				System.out.println("tipo de dato incorecto");
				veces++;
				sc.nextLine();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("el formato para la fecha deveria ser yyyy-mm-dd");
				veces++;
				sc.nextLine();
			} catch (java.lang.NumberFormatException e) {
				System.out.println("el formato para la fecha deveria ser yyyy-mm-dd y no incluir letras");
				veces++;
				sc.nextLine();
			}
			//hacer que escriva
			//salida.write(1);
			//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
			//DavidOrtiz-dot
		}
		sc.nextLine();
	}
}

