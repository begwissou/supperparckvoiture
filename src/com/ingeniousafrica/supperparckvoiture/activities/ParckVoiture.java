package com.ingeniousafrica.supperparckvoiture.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.ingeniousafrica.supperparckvoiture.R;
import com.ingeniousafrica.supperparckvoiture.metier.ParckVehicule;
import com.ingeniousafrica.supperparckvoiture.metier.VehiculeAdapter;

public class ParckVoiture extends Activity {
	ListView listNewVehicule;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_parck);
	        
	        ArrayList<ParckVehicule> itemNouveauVoiture = new ArrayList<ParckVehicule>();
	        
	        itemNouveauVoiture.add(new ParckVehicule("TOYOTA","Germine","4 roues","2007","diesel","Tres bon pour la course"));
	        
	        VehiculeAdapter nAdapter = new VehiculeAdapter(this,R.layout.item_nouveau_voiture,itemNouveauVoiture);
	        
	        listNewVehicule = (ListView)findViewById(R.id.activity_parck_listview_new_voiture);
	        
	        listNewVehicule.setAdapter(nAdapter);
	        
	        
	    }

}
