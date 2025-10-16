package Tarea1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		ArrayList<alumno> lista = new ArrayList();
		ArrayList<alumno> listaO = new ArrayList();
		int veces = 1;
		int menu = 1;
		boolean generoC=false;
		char genero = 'M';
		Scanner sc = new Scanner(System.in);
		while (menu != 0) {
			System.out.println("0 salir \n1 añadir 5 alumnos \n2 mostrar ordenado");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				for (int i = 0; i < veces; i++) {
					try {
						generoC=false;
						System.out.println("dime el nia");
						int nia = sc.nextInt();
						System.out.println("dime el nombre");
						String nombre = sc.next();
						System.out.println("dime el apellido");
						String apellido = sc.next();
						while(!generoC) {
						System.out.println("dime el genero F o M");
						genero = ((sc.next()).toCharArray())[0];
						if(genero=='f'||genero=='F' ||genero=='m'||genero=='M' ) {generoC=true;}
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
				}
				sc.nextLine();
				break;

			case 2:
				System.out.println(
						"1 nia \n2 nombre \n3 apellido \n4 genero  \n5 fecha de nacimiento \n6 ciclo \n7 curso \n8 grupo  ");
				switch (sc.nextInt()) {
				case 1:
					lista.sort(Comparator.comparingInt(alumno::getDniani));
					for (alumno pos : lista) {
						System.out.println(pos);
					}
					break;
				case 2:
					lista.sort(Comparator.comparing(alumno::getNombre));
					for (alumno pos : lista) {
						System.out.println(pos);
					}
					break;
				case 3:
					lista.sort(Comparator.comparing(alumno::getApellidos));
					for (alumno pos : lista) {
						System.out.println(pos);
					}
					break;
				case 4:
					lista.sort(Comparator.comparing(alumno::getGenero));
					for (alumno pos : lista) {
						System.out.println(pos);
					}
					break;
				case 5:
					lista.sort(Comparator.comparing(alumno::getFechaNacimiento));
					for (alumno pos : lista) {
						System.out.println(pos);
					}
					break;
				case 6:
					lista.sort(Comparator.comparing(alumno::getCiclo));
					for (alumno pos : lista) {
						System.out.println(pos);
					}
					break;
				case 7:
					lista.sort(Comparator.comparing(alumno::getCurso));
					for (alumno pos : lista) {
						System.out.println(pos);
					}
					break;
				case 8:
					lista.sort(Comparator.comparing(alumno::getGrupo));
					for (alumno pos : lista) {
						System.out.println(pos);
					}
					break;
				}
			}

		}

	}

}
