package com.ingeniousafrica.supperparckvoiture.metier;

import java.io.Serializable;
import java.util.ArrayList;

public class DataClientVehicule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Client> clients;
	
	private ArrayList<ParckVehicule> vehicule;

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ArrayList<ParckVehicule> getVehicule() {
		return vehicule;
	}

	public void setVehicule(ArrayList<ParckVehicule> vehicule) {
		this.vehicule = vehicule;
	}

	
	
	

}
