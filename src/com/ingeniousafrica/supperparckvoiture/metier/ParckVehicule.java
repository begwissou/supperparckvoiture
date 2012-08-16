package com.ingeniousafrica.supperparckvoiture.metier;

public class ParckVehicule {
	private int img;
	private String marque;
	private String model;
	private String carrosserie;
	private String annee;
	private String moteur;
	private String description;
	
	
	
	public ParckVehicule() {
	}
	
	
	public ParckVehicule(String marque, String model, String carrosserie,
			String annee, String moteur, String description) {
		this.marque = marque;
		this.model = model;
		this.carrosserie = carrosserie;
		this.annee = annee;
		this.moteur = moteur;
		this.description = description;
	}
	
	

	public ParckVehicule(int img, String marque, String model,
			String carrosserie, String annee, String moteur, String description) {
		super();
		this.img = img;
		this.marque = marque;
		this.model = model;
		this.carrosserie = carrosserie;
		this.annee = annee;
		this.moteur = moteur;
		this.description = description;
	}


	public int getImg() {
		return img;
	}
	public void setImg(int img) {
		this.img = img;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCarrosserie() {
		return carrosserie;
	}
	public void setCarrosserie(String carrosserie) {
		this.carrosserie = carrosserie;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public String getMoteur() {
		return moteur;
	}
	public void setMoteur(String moteur) {
		this.moteur = moteur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
