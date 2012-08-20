package com.ingeniousafrica.supperparckvoiture.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



import com.ingeniousafrica.supperparckvoiture.R;
import com.ingeniousafrica.supperparckvoiture.metier.Client;
import com.ingeniousafrica.supperparckvoiture.metier.DataClientVehicule;
import com.ingeniousafrica.supperparckvoiture.metier.ParckVehicule;
import com.ingeniousafrica.supperparckvoiture.metier.SerialisationClientVehicule;
import com.ingeniousafrica.supperparckvoiture.metier.VehiculeAdapter;

public class ParckVoiture extends Activity implements OnClickListener, OnItemClickListener {
	ListView listNewVehicule;
	
	ListView listVehicule;
	
	TextView name;
	
	TextView prenom;
	
	DataClientVehicule donnes;
	
	public static final int SUPPRIMER_VEHICULE = 1;
	
	ParckVehicule itemVehicule;
	
	VehiculeAdapter adapter;
	
	ArrayList<ParckVehicule> listObjVehicule;
	
	
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
	        
	        //je déserialise puis recupère les données sur le lient et les vehicules
	        donnes = (DataClientVehicule) SerialisationClientVehicule.readData(this, "donnees");
	        
	        if(donnes != null){
	        	//recupère la liste des vehicules de l'objet DataClientVehicule
	        	listObjVehicule = donnes.getVehicule();
	        	
	        	adapter = new VehiculeAdapter(this,R.layout.item_nouveau_voiture, listObjVehicule);
	        	
	        	listVehicule = (ListView)findViewById(R.id.activity_parck_listview_listvoiture);
	        	
	        	listVehicule.setOnItemClickListener(this);
	        	
	        	listVehicule.setAdapter(adapter);
	        	
	        	//j'ajoute à liste de vehicule la voiture nouvellement créee
	        	listObjVehicule.add(vehicule);
	        	
	        	donnes.setVehicule(listObjVehicule);
		        
	        	//je sauvegarde les donnés en les sérialisant
		        SerialisationClientVehicule.saveData(this, "donnees", donnes, false);
	        }else{
	        	donnes = new DataClientVehicule();
	        	//donnes.getClients().add(client);
		        donnes.setVehicule(itemNouveauVoiture);
		        
		        SerialisationClientVehicule.saveData(this, "donnees", donnes, false);
	        }
	      
	        
	    }

	public void onClick(View v) {
		switch(v.getId()){
		case R.id.activity_parck_button_retour_id:
			/*Intent intent = new Intent(this, ClientActivity.class );
    		startActivity(intent);*/
			finish();
			break;
		}

		
	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		itemVehicule = (ParckVehicule) listVehicule.getItemAtPosition(arg2);
		//j'affiche le dialogue avec son id en paramettre, puis la methode onCreateDialog() sera appeller
		showDialog(SUPPRIMER_VEHICULE);
		
		
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.titre_boite_dialogue);
		builder.setMessage("Voulez-vous supprimer cette voiture? \n\n");
		builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface arg0, int arg1) {
				//je supprime l'objet vehicule clicqué
				listObjVehicule.remove(itemVehicule);
				
				//je modifi la liste des voitures
				donnes.setVehicule(listObjVehicule);
				
				//je sauvegarde les données
				SerialisationClientVehicule.saveData(ParckVoiture.this, "donnees", donnes, false);
				
				//j'affiche un message pour rassurrer l'utilisateur
				Toast.makeText(ParckVoiture.this,"La voiture "+itemVehicule.getMarque()+" "+itemVehicule.getModel()+" à été supprimée", 5000).show();
				
				//je reaffiche les infos dans la listview
				listVehicule.setAdapter(adapter);
				
				
			}
		});
		
		builder.setNegativeButton("Non", null);
		return builder.create();
		
	}
	
	

}
