package com.example.quizmuseo;
import android.graphics.Bitmap;

public class Pregunta {
	private int tipo;
	private String tema;
	private String pregunta;
	private String respa;
	private String respb;
	private String respc;
	private String respcorr;
	private Bitmap ima1;
	private Bitmap ima2;
	private Bitmap ima3;
	
	
	public Pregunta(int tipo, String tema, String pregunta, String respa,
			String respb, String respc, String respcorr, Bitmap ima1,
			Bitmap ima2, Bitmap ima3) {
		super();
		this.tipo = tipo;
		this.tema = tema;
		this.pregunta = pregunta;
		this.respa = respa;
		this.respb = respb;
		this.respc = respc;
		this.respcorr = respcorr;
		this.ima1 = ima1;
		this.ima2 = ima2;
		this.ima3 = ima3;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public String getTema() {
		return tema;
	}


	public void setTema(String tema) {
		this.tema = tema;
	}


	public String getPregunta() {
		return pregunta;
	}


	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}


	public String getRespa() {
		return respa;
	}


	public void setRespa(String respa) {
		this.respa = respa;
	}


	public String getRespb() {
		return respb;
	}


	public void setRespb(String respb) {
		this.respb = respb;
	}


	public String getRespc() {
		return respc;
	}


	public void setRespc(String respc) {
		this.respc = respc;
	}


	public String getRespcorr() {
		return respcorr;
	}


	public void setRespcorr(String respcorr) {
		this.respcorr = respcorr;
	}


	public Bitmap getIma1() {
		return ima1;
	}


	public void setIma1(Bitmap ima1) {
		this.ima1 = ima1;
	}


	public Bitmap getIma2() {
		return ima2;
	}


	public void setIma2(Bitmap ima2) {
		this.ima2 = ima2;
	}


	public Bitmap getIma3() {
		return ima3;
	}


	public void setIma3(Bitmap ima3) {
		this.ima3 = ima3;
	}
	
	

	
	
	
	
	

}
