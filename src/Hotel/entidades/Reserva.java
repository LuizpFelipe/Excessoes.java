package Hotel.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import hhotel.excessoes.DominioExcessoes;
import hhotel.excessoes.DominioExcessoes;
public class Reserva {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut){
		if (!checkOut.after(checkIn)) {
			throw new DominioExcessoes("Erro! Check-in excedeu o valor do Check-Out, Por Favor tente novamente.");
		}
		
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDatas(Date checkIn, Date checkOut){
		Date agora = new Date();
		
		if(checkIn.before(agora) || checkOut.before(agora)) {
			throw new DominioExcessoes("Reserva invalida: as datas só podem ser alteradas para uma data Futura da que esta reservada.");
		} 
		if (!checkOut.after(checkIn)) {
			throw new DominioExcessoes("Erro! Check-in excedeu o valor do Check-Out, Por Favor tente novamente.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Quarto " + numeroQuarto + ", Check-in: " + sdf.format(checkIn) + ", Check-Out: " + sdf.format(checkOut)
				+ ", " + duration() + " Nights.";
	}

}