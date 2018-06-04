package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class Partidos_TD {
	
	private int cod_partido;
	private String eq_local;
	private String eq_visit;
	private int gol_local;
	private int gol_visit;
	private Calendar fecha;
	private String liga;
	
	
	public Partidos_TD (int cod_partido, String eq_local, String eq_visit, int gol_local, int gol_visit, /*Calendar cal,*/ String liga) {
		
		this.cod_partido=cod_partido;
		this.eq_local=eq_local;
		this.eq_visit=eq_visit;
		this.gol_local=gol_local;
		this.gol_visit=gol_visit;
		/*this.fecha=cal;*/
		this.liga=liga;
		
	}


	public int getCod_partido() {
		return cod_partido;
	}


	public void setCod_partido(int cod_partido) {
		this.cod_partido = cod_partido;
	}


	public String getEq_local() {
		return eq_local;
	}


	public void setEq_local(String eq_local) {
		this.eq_local = eq_local;
	}


	public String getEq_visit() {
		return eq_visit;
	}


	public void setEq_visit(String eq_visit) {
		this.eq_visit = eq_visit;
	}


	public int getGol_local() {
		return gol_local;
	}


	public void setGol_local(int gol_local) {
		this.gol_local = gol_local;
	}


	public int getGol_visit() {
		return gol_visit;
	}


	public void setGol_visit(int gol_visit) {
		this.gol_visit = gol_visit;
	}


	public Calendar getFecha() {
		return fecha;
	}


	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}


	public String getLiga() {
		return liga;
	}


	public void setLiga(String liga) {
		this.liga = liga;
	}

}
