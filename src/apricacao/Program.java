package apricacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Hotel.entidades.Reserva;
import hhotel.excessoes.DominioExcessoes;

public class Program {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Quarto: ");
			int numero = sc.nextInt();
			System.out.print("Data do Check-in:");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Data do Check-Out:");
			Date checkout = sdf.parse(sc.next());
			Reserva reservado = new Reserva(numero, checkin, checkout);
			System.out.println("Reservado" + reservado);
	
			System.out.println("Atualizar Reserva:");
			System.out.println("Entre com uma nova Data:");
			System.out.print("Data do Check-in:");
			checkin = sdf.parse(sc.next());
			System.out.print("Data do Check-Out:");
			checkout = sdf.parse(sc.next());
	
			reservado.updateDatas(checkin, checkout);
			System.out.println("Reserva: " + reservado);
		} catch(ParseException e) {
			System.out.println("Data Inavalida!!");
		} catch(DominioExcessoes e) {
			System.out.println("Erro na reserva:  " + e.getMessage());
		} catch(RuntimeException e) {
			System.out.println("Erro inesperado!!");
		}
		sc.close();
	}

}
