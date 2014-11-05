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
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Activity1 extends Activity{
	private static int SELECT_PICTURE = 1;
	int but_act;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.foto);
		
		Button btIma1 = (Button) findViewById(R.id.button1);
		Button btIma2 = (Button) findViewById(R.id.button2);
		Button btIma3 = (Button) findViewById(R.id.button3);
		
		//Metodo onclick listener para cargar las imagenes desde la galeria
		OnClickListener cargarImagenes = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				but_act = v.getId();
				String hola = Integer.toString(but_act);
				Toast toast1 = Toast.makeText(getApplicationContext(), hola , Toast.LENGTH_SHORT);
				toast1.show();
				/*
				Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
				int code = SELECT_PICTURE;
				intent.putExtra("id", "hola");
				startActivityForResult(intent, code);
				*/
			}
		};
		//Asignacion de metodo onlick listener "cargarImagenes"
		btIma1.setOnClickListener(cargarImagenes);
		btIma2.setOnClickListener(cargarImagenes);
		btIma3.setOnClickListener(cargarImagenes);
	}
	
	
	@Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		 if (data != null) {
			   if (requestCode == SELECT_PICTURE) {  
						Uri selectedImage = data.getData();
						//String datos = data.getStringExtra("ID");
						// Toast toast1 =Toast.makeText(getApplicationContext(),
	                   // "Toast por defecto", Toast.LENGTH_SHORT);
	                    //toast1.show();
					//	Toast toast1 = Toast.makeText(getApplicationContext(), datos, Toast.LENGTH_SHORT);
						//toast1.show();
						InputStream is;
						try {
						is = getContentResolver().openInputStream(selectedImage);
				    	BufferedInputStream bis = new BufferedInputStream(is);
				    	Bitmap bitmap = BitmapFactory.decodeStream(bis);  
				
				   		/*
				   		switch (idBoton){
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
				    	*/
				    	ImageView ima = (ImageView) findViewById(R.id.imageView1);
				    	ima.setImageBitmap(bitmap);						
					} catch (FileNotFoundException e) {}
			   }
		 }
	}
}
