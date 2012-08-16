package com.ingeniousafrica.supperparckvoiture.metier;

import java.util.List;

import com.ingeniousafrica.supperparckvoiture.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class VehiculeAdapter extends ArrayAdapter<ParckVehicule>{
	
	int mRessources;
	LayoutInflater inflateur;

	public VehiculeAdapter(Context context, int textViewResourceId,
			List<ParckVehicule> objects) {
		super(context, textViewResourceId, objects);
		inflateur = LayoutInflater.from(context);
		mRessources = textViewResourceId;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){
			convertView = inflateur.inflate(mRessources, null);
			
			
		}
		
		ParckVehicule vehicule = getItem(position);
		
		TextView marque = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_marque_text);
		TextView model = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_model_text);
		TextView carrosserie = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_carrosserie_text);
		TextView moteur = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_moteur_text);
		TextView annee = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_annee_text);
		TextView description = (TextView)convertView.findViewById(R.id.item_nouveau_voiture_description_text);
		
		marque.setText(vehicule.getMarque());
		model.setText(vehicule.getModel());
		carrosserie.setText(vehicule.getCarrosserie());
		moteur.setText(vehicule.getMoteur());
		annee.setText(vehicule.getAnnee());
		description.setText(vehicule.getDescription());

		return convertView;
	}
	
	

}
