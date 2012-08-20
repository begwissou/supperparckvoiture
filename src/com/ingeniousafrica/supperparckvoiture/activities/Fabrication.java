package com.ingeniousafrica.supperparckvoiture.activities;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ingeniousafrica.supperparckvoiture.R;
import com.ingeniousafrica.supperparckvoiture.metier.ParckVehicule;




public class Fabrication extends Activity implements OnClickListener, OnItemSelectedListener {

	Spinner spMark;
	Spinner spMoteur;
	
	Bundle objetbunble;
	
	//remplissage du spinner de type de moteur
    String[] moteurs = {
 		   "Diesel",
 		   "Carburent",
 		   "Eau"
    };
    
  //remplissage du spinner de type de marque
	 String[] marques = {
   		   "TOYOTA",
   		   "DACIA",
   		   "VOLSKWAGEN",
   		   "BENZ"
      };
	 
	 String marque;
	 
	 String moteur;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fabrication);

		objetbunble  = this.getIntent().getExtras();

		findViewById(R.id.activity_fabrication_button_fabriquer).setOnClickListener(this);
		findViewById(R.id.activity_fabrication_button_annuler).setOnClickListener(this);

		//Chargons les données de marque de voiture
		ArrayAdapter<String> adapterMark = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, marques);

		spMark = (Spinner)findViewById(R.id.activity_fabrication_marque_spin);

		spMark.setAdapter(adapterMark);

		spMark.setOnItemSelectedListener(this);


		//Chargons les données de type de moteur
		ArrayAdapter<String> adapterMoteur = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, moteurs);

		spMoteur = (Spinner)findViewById(R.id.activity_fabrication_moteur_spin);

		spMoteur.setAdapter(adapterMoteur);

		spMoteur.setOnItemSelectedListener(this);
	}

	public void onClick(View v) {
		switch(v.getId()){

    	case R.id.activity_fabrication_button_fabriquer:
    		//Client client = (Client)objetbunble.getSerializable("client");
    		//je recupère mon objet vehicule qui se trouve dans l'objet bundle puis je remet les informations à jour
    		ParckVehicule vehicule = (ParckVehicule)objetbunble.getSerializable("vehicule");
    		vehicule.setMarque(marque);
    		vehicule.setMoteur(moteur);
    		vehicule.setAnnee(new Date().toString());
    		
    		objetbunble.putSerializable("vehicule", vehicule);
    		
    		Intent intent = new Intent(this, ParckVoiture.class );
    		intent.putExtras(objetbunble);
    		startActivity(intent);
    		
    		// je termine l'activité
    		finish();
    		break;

    	case R.id.activity_fabrication_button_annuler:
    		// je termine l'activité puis je me retrouve automatiquement sur la première page
    		finish();

    	}
	}

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		switch(arg0.getId()){

    	case R.id.activity_fabrication_marque_spin:
    		int pMark = spMark.getSelectedItemPosition();
   	     	marque = marques[pMark];
    		break;
    		
    	case R.id.activity_fabrication_moteur_spin:
    		int pMoteur = spMoteur.getSelectedItemPosition();
   	     	moteur = moteurs[pMoteur];
    		break;

    	

    	}
		
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		
		
	}
	
	

}
