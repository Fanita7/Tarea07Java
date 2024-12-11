package Tarea07Java;

import java.util.Scanner;

public class Tarea07Java {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Crear un programa en Java que realice lo siguiente:
			Debe solicitar al usuario un día de la semana (de lunes a viernes).
			Debe solicitar al usuario una hora (horas y minutos).
			Debe calcular cuantos minutos faltan para el fin de semana. Se considera que el fin de semana comienza el viernes a las 15:00 hrs.
			Debe mostrar el resultado por consola.
			Debe ser capaz de identificar si los datos de entrada son válidos (día de la semana válido, hora válida, minutos válidos), en caso contrario debe mandar un mensaje de error y volver a solicitar los datos.
			Prueba tu programa con las siguientes entradas para asegurarte que funcione correctamente:
			lunes
			14
			30
			Faltan 5730 minutos para el fin de semana.
			Entradas: Lunes, 14:30 hrs
			Salida:*/
		Scanner s = new Scanner (System.in);
		String dia;
		int hora, minutos ;
				
		while (true) {
		System.out.println("escribe un día de la semana (de lunes a viernes)");	
		dia = s.nextLine().trim().toLowerCase();
		if (!validDay(dia)) {
			System.out.println("ese día no es válido");
			continue;
		}
		try {
			System.out.println("escribe una hora (0-23)");
			hora = Integer.parseInt(s.nextLine());
			if (hora < 0 || hora> 23) {
				System.out.println("hora inválida");
				continue;
			}
			
			System.out.println("escribe los miutos (0-59)");
			minutos = Integer.parseInt(s.nextLine());
			if (minutos < 0 || minutos > 23) {
				System.out.println("minutos inválidos");
				continue;
			}
			break;
					
		} catch (NumberFormatException e) {
			System.out.println("inténtalo de nuevo");
		}
		
		}
		
		int minRest = calcMinFinde(dia, hora, minutos);
		if (minRest >0) {
			System.out.println("Faltan" + minRest + " minutos para el finde");
		}else {
			System.out.println("ya es finde");
		}
	}
	
	public static boolean validDay(String dia) {
		return dia.equals("lunes") || dia.equals("martes") || dia.equals("miercoles") || dia.equals("jueves") || dia.equals("viernes");}
	
	public static int calcMinFinde(String dia, int hora, int minutos) {
		int minFinde = (4*20*60) + (15*60);
		int minPasados = 0;
		
		switch (dia) {
		case "lunes":
			minPasados =(0*24*60) + (hora*60) + minutos;break;
		case "martes":
			minPasados =(1*24*60) + (hora*60) + minutos;break;
		case "miercoles":
			minPasados =(2*24*60) + (hora*60) + minutos;break;
		case "jueves":
			minPasados =(3*24*60) + (hora*60) + minutos;break;
		case "viernes":
			minPasados =(4*24*60) + (hora*60) + minutos;break;
		}
		
		return minFinde - minPasados;	
		
	}

}
