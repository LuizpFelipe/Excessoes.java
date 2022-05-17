package apricacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data do Check-in:");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Data do Check-Out:");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Erro! Check-in excedeu o valor do Check-Out, Por Favor tente novamente.");
		} else {
			Reserva reservado = new Reserva(numero, checkin, checkout);
			System.out.println("Reservado" + reservado);

			System.out.println("Atualizar Reserva:");
			System.out.println("Entre com uma nova Data:");
			System.out.print("Data do Check-in:");
			checkin = sdf.parse(sc.next());
			System.out.print("Data do Check-Out:");
			checkout = sdf.parse(sc.next());

			
			String error = 	reservado.updateDatas(checkin, checkout);
			if(error != null) {
				System.out.println("Erro na Reserva" + error);
			}else {
				System.out.println("Reserva: " + reservado);
			}
		}

		sc.close();

	}

}
