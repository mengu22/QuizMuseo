package com.example.quizmuseo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseManager {
	public static final String TABLE_NAME = "preguntas";
	
	public static final String CN_ID = "id";
	public static final String CN_TEMA = "tema";
	public static final String CN_TIPO = "tipo"; // tipo de pregunta 1,2 o 3
	public static final String CN_PREGUNTA = "pregunta";
	public static final String CN_RESPA = "respa";
	public static final String CN_RESPB = "respb";
	public static final String CN_RESPC = "respc";
	public static final String CN_RESPCORR = "respcorr";
	public static final String CN_IMA1 = "imagen1";
	public static final String CN_IMA2 = "imagen2";
	public static final String CN_IMA3 = "imagen3";
	
	//crear la tabla sql
	
	public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
			+CN_ID+ " integer primary key autoincrement,"
			+CN_TEMA+ " text,"
			+CN_TIPO+ " integer not null,"
			+CN_PREGUNTA+ " text not null,"
			+CN_RESPA+ " text,"
			+CN_RESPB+ " text,"
			+CN_RESPC+ " text,"
			+CN_RESPCORR+ " text not null,"
			+CN_IMA1+ " blob,"
			+CN_IMA2+ " blob,"
			+CN_IMA3+ " blob)";
	
	
	private DataBaseHelper helper;
	private SQLiteDatabase db;
	
	public DataBaseManager(Context context) {
		
		 helper = new DataBaseHelper(context);
	     db = helper.getWritableDatabase();
	
	}
	
	public void insertarPregunta(Pregunta pregunta){
		ContentValues cv = new ContentValues();
		cv.put(CN_TEMA, pregunta.getTema());
		cv.put(CN_TIPO, pregunta.getTipo());
		cv.put(CN_PREGUNTA, pregunta.getPregunta());
		cv.put(CN_RESPA, pregunta.getRespa());
		cv.put(CN_RESPB, pregunta.getRespb());
		cv.put(CN_RESPC, pregunta.getRespc());
		cv.put(CN_RESPCORR, pregunta.getRespcorr());
		//cv.put(CN_IMA1,Utility.getBytes(pregunta.getIma1()));
		//cv.put(CN_IMA2,Utility.getBytes(pregunta.getIma1()));
		//cv.put(CN_IMA3,Utility.getBytes(pregunta.getIma1()));
		db.insert(TABLE_NAME, null, cv);


	}
		
		{
	}
	
			

}
