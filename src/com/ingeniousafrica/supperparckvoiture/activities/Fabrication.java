package com.ingeniousafrica.supperparckvoiture.activities;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ingeniousafrica.supperparckvoiture.R;




public class Fabrication extends Activity implements OnClickListener {

	Spinner spMark;
	Spinner spMoteur;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fabrication);
		
		findViewById(R.id.activity_fabrication_button_fabriquer).setOnClickListener(this);
		//remplissage du spinner de type de marque
		 String[] marques = {
	    		   "TOYOTA",
	    		   "DACIA",
	    		   "VOLSKWAGEN",
	    		   "BENZ"
	       };
	       
	       ArrayAdapter<String> adapterMark = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, marques);
	       
	       spMark = (Spinner)findViewById(R.id.activity_fabrication_marque_spin);
	       
	       spMark.setAdapter(adapterMark);
	       
	       //remplissage du spinner de type de moteur
	       String[] moteurs = {
	    		   "Diesel",
	    		   "Carburent",
	    		   "Eau"
	       };
	       
	       ArrayAdapter<String> adapterMoteur = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, moteurs);
	       
	       spMoteur = (Spinner)findViewById(R.id.activity_fabrication_moteur_spin);
	       
	       spMoteur.setAdapter(adapterMoteur);
	}

	public void onClick(View v) {
		switch(v.getId()){

    	case R.id.activity_fabrication_button_fabriquer:
    		Intent intent = new Intent(this, ParckVoiture.class );
    		
    		startActivity(intent);
    		break;

    	

    	}
	}
	
	

}
