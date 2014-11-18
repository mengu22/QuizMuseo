package com.example.quizmuseo;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.Buffer;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Activity1 extends Activity{
	private static int SELECT_PICTURE = 1;
	int but_act;
	EditText preg;
	EditText resa;
	EditText resb;
	EditText resc;
	EditText resco;
	EditText tem;
	EditText tipo;
	DataBaseManager db;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foto);
		db = new DataBaseManager(this);
		
		tem = (EditText) findViewById(R.id.editText1);
		tipo = (EditText) findViewById(R.id.editText2);
		preg = (EditText) findViewById(R.id.editText3);
		resa = (EditText) findViewById(R.id.editText4);
		resb = (EditText) findViewById(R.id.editText5);
		resc = (EditText) findViewById(R.id.editText6);
		resco = (EditText) findViewById(R.id.editText7);
		
		Button btIma1 = (Button) findViewById(R.id.button1);
		Button btIma2 = (Button) findViewById(R.id.button2);
		Button btIma3 = (Button) findViewById(R.id.button3);
		Button btSave = (Button) findViewById(R.id.button4);
		Button btVolver = (Button) findViewById(R.id.button5);
		
		//Metodo onclick listener para cargar las imagenes desde la galeria
		OnClickListener cargarImagenes = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				but_act = v.getId();
				
				Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
				int code = SELECT_PICTURE;
				startActivityForResult(intent, code);
				
			}
		};
		//Asignacion de metodo onclick listener "cargarImagenes"
		btIma1.setOnClickListener(cargarImagenes);
		btIma2.setOnClickListener(cargarImagenes);
		btIma3.setOnClickListener(cargarImagenes);
		
		// Boton volver al menu principal
		btVolver.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	//finish para cerrar esta actividad 
            	finish();
               Intent intent = new Intent(Activity1.this, MainActivity.class);
               startActivity(intent);
            }});
		
		btSave.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	//finish para cerrar esta actividad 
            	
            	String pregunta = preg.getText().toString(); 
            	String respuesta = resa.getText().toString(); 
            	String respuestab = resb.getText().toString(); 
            	String respuestac = resc.getText().toString(); 
            	String respuestacor = resco.getText().toString(); 
            	String tema = tem.getText().toString(); 
            	int tip = Integer.valueOf(tipo.getText().toString());
            	
            	Pregunta nueva = new Pregunta(tip, tema, pregunta, respuesta, respuestab, respuestac, respuestacor);
            	db.insertarPregunta(nueva);
            }});
	}
	
	
	@Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		 if (data != null) {
			   if (requestCode == SELECT_PICTURE) {  
						Uri selectedImage = data.getData();
						
						InputStream is;
						try {
						is = getContentResolver().openInputStream(selectedImage);
				    	BufferedInputStream bis = new BufferedInputStream(is);
				    	Bitmap bitmap = BitmapFactory.decodeStream(bis);  
				    	int codigoImagen = 0;
				   		// segun el id del boton seleciona un imageview para mostrar la imagen
				   		switch (but_act){
				   		case R.id.button1:
				   			codigoImagen=R.id.imageView1;
				   			break;
				   		case R.id.button2:
				   			codigoImagen=R.id.imageView2;
				   			break;
				   		case R.id.button3:
				   			codigoImagen=R.id.imageView3;
				   			break;
				   		}
				    	
				    	ImageView ima = (ImageView) findViewById(codigoImagen);
				    	ima.setImageBitmap(bitmap);						
					} catch (FileNotFoundException e) {}
			   }
		 }
	}
}
