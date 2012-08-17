package com.ingeniousafrica.supperparckvoiture.activities;

import com.ingeniousafrica.supperparckvoiture.R;
import com.ingeniousafrica.supperparckvoiture.metier.Client;
import com.ingeniousafrica.supperparckvoiture.metier.ParckVehicule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ClientActivity extends Activity implements OnClickListener, OnItemSelectedListener {
    /** Called when the activity is first created. */
	
	Spinner spCarro;
	
	EditText name;
	
	EditText prenom;
	
	EditText model;
	
	EditText description;
	
	String carrosserie;
	
	String[] carrosseries = {
    		   "Berlines",
    		   "4 roues motrices",
    		   "Autobus",
    		   "Camions",
    		   "Machines et tracteurs"
       };;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        
       findViewById(R.id.activity_client_button_continuer).setOnClickListener(this);
       
       
       
       ArrayAdapter<String> adapterCarro = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, carrosseries);
       
       spCarro = (Spinner)findViewById(R.id.activity_client_carrosserie_spin);
       
       spCarro.setAdapter(adapterCarro);
       
       spCarro.setOnItemSelectedListener(this);
       
      
       
       name = (EditText)findViewById(R.id.activity_client_name_edit);
       
       prenom = (EditText)findViewById(R.id.activity_client_prenom_edit);
       
       model = (EditText)findViewById(R.id.activity_client_model_edit);
       
       description = (EditText)findViewById(R.id.activity_client_description_voiture_edit);
       
       
    
    }
    
    
    public void onClick(View v) {
    	switch(v.getId()){

    	case R.id.activity_client_button_continuer:
    		//Toast.makeText(this, carrosserie, 3000).show();
    		//je crée un objet Bundle pour y stocker les infos vers l'autre activité
    		Bundle objetbunble = new Bundle();
    		
    		//un objet vehicule pour les infos de la nouvelle voiture
    		ParckVehicule vehicule = new ParckVehicule();
    		
    		//un objet client pour infos du client
    		Client client = new Client();
    		
    		client.setNom(name.getText().toString());
    		client.setPrenom(prenom.getText().toString());
    		
    		vehicule.setCarrosserie(carrosserie);
    		vehicule.setModel(model.getText().toString());
    		vehicule.setDescription(description.getText().toString());
    		 
    		//je met l'objet client dans l'objet bundle afin de pouvoir le recuperer dans l'autre activity
			objetbunble.putSerializable("client", client);
			
			//je met l'objet vehicule dans l'objet bundle afin de pouvoir le recuperer dans l'autre activity
			objetbunble.putSerializable("vehicule", vehicule);
			
    		Intent intent = new Intent(this, Fabrication.class );
    		
    		//j'introduit l'objet bundle dans l'intention
    		intent.putExtras(objetbunble);
    		
    		startActivity(intent);
    		
    		break;

    	

    	}

    }


	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		 int item = spCarro.getSelectedItemPosition();
	     carrosserie = carrosseries[item];
		
	}


	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}