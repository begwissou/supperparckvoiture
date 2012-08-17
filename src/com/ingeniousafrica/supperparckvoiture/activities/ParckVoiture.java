package com.ingeniousafrica.supperparckvoiture.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;


import com.ingeniousafrica.supperparckvoiture.R;
import com.ingeniousafrica.supperparckvoiture.metier.Client;
import com.ingeniousafrica.supperparckvoiture.metier.DataClientVehicule;
import com.ingeniousafrica.supperparckvoiture.metier.ParckVehicule;
import com.ingeniousafrica.supperparckvoiture.metier.SerialisationClientVehicule;
import com.ingeniousafrica.supperparckvoiture.metier.VehiculeAdapter;

public class ParckVoiture extends Activity implements OnClickListener {
	ListView listNewVehicule;
	
	ListView listVehicule;
	
	TextView name;
	
	TextView prenom;
	
	DataClientVehicule donnes;
	
	
	
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_parck);
	        
	        Bundle objetbunble  = this.getIntent().getExtras();
	        //je recupère le client qui crée
	        Client client = (Client)objetbunble.getSerializable("client");
	        
	        name = (TextView)findViewById(R.id.activity_fabrication_new_voiture_client_name);
	        
	        prenom = (TextView)findViewById(R.id.activity_fabrication_new_voiture_client_prenom);
	        
	        name.setText(client.getNom());
	        
	        prenom.setText(client.getPrenom());
	        
	        //je recupère la voiture crée
	        ParckVehicule vehicule = (ParckVehicule)objetbunble.getSerializable("vehicule");
	        ArrayList<ParckVehicule> itemNouveauVoiture = new ArrayList<ParckVehicule>();
	        
	        itemNouveauVoiture.add(vehicule);
	        
	        VehiculeAdapter nAdapter = new VehiculeAdapter(this,R.layout.item_nouveau_voiture,itemNouveauVoiture);
	        
	        listNewVehicule = (ListView)findViewById(R.id.activity_parck_listview_new_voiture);
	        
	        listNewVehicule.setAdapter(nAdapter);
	        
	        findViewById(R.id.activity_parck_button_retour_id).setOnClickListener(this);
	        
	        donnes = (DataClientVehicule) SerialisationClientVehicule.readData(this, "donnees");
	        
	        if(donnes != null){
	        	
	        	VehiculeAdapter adapter = new VehiculeAdapter(this,R.layout.item_nouveau_voiture,donnes.getVehicule());
	        	
	        	listVehicule = (ListView)findViewById(R.id.activity_parck_listview_listvoiture);
	        	
	        	listVehicule.setAdapter(adapter);
//	        	for(int i=0; donnes.getClients().l ){
//	        		
//	        	}
	        	
	        	//donnes.getClients().add(client);
		        donnes.getVehicule().add(vehicule);
		        
		        SerialisationClientVehicule.saveData(this, "donnees", donnes, false);
	        }else{
	        	donnes = new DataClientVehicule();
	        	//donnes.getClients().add(client);
		        donnes.setVehicule(itemNouveauVoiture);
		        
		        SerialisationClientVehicule.saveData(this, "donnees", donnes, false);
	        }
	        //DataClientVehicule donnes = new DataClientVehicule();
	        
	        
	        
	    }



	


	public void onClick(View v) {
		switch(v.getId()){
		case R.id.activity_parck_button_retour_id:
			Intent intent = new Intent(this, ClientActivity.class );
    		startActivity(intent);
			finish();
			break;
		}

    	
		
	}

}
