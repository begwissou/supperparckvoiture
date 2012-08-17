package com.ingeniousafrica.supperparckvoiture.metier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


import android.content.Context;



public final class SerialisationClientVehicule {
	
	public static void saveData(Context context, String key, final Object data, boolean temp){
		synchronized (data) {
			//Log.i("Serialization","Enregistre l'objet dans le cache");
			if(data==null)return;
			final File file;
			if(temp){
				file = getCacheFile(context,key);
			}else{
				file = getDataFile(context,key);
			}
			save(file, data);
		}
	}
	
	private static File getCacheFile(Context context, String key){
		try {
			return new File(context.getCacheDir().getAbsolutePath()+"/"+key);
		} catch (Exception e) {
			//Log.e("Serialization","ERREUR (getCacheFile) lors de l'ouverture du fichier pour la clé : " + key);
			//Log.e("Serialization",e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	private static File getDataFile(Context context, String key){
		try {
			return new File(context.getFilesDir().getAbsolutePath()+"/"+key);
		} catch (Exception e) {
			//Log.e("Serialization","ERREUR (getDataFile) lors de l'ouverture du fichier pour la clé : " + key);
			//Log.e("Serialization",e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	private static void save(File file, final Object data)
	{
		try {
			FileOutputStream	fos = new FileOutputStream(file);
			ObjectOutputStream	oos = new ObjectOutputStream(fos);			
			oos.writeObject(data);			
			oos.close();
			fos.close();
			//Log.i("Serialization","Cache enregistré : " + file.getAbsolutePath());

		} catch (Exception e) {
			//Log.e("Serialization","ERREUR, Cache NON ENREGISTRE : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static Object readData(Context context, String key){
		//Log.i("Serialization","Chargement du cache de la clé : "+key);
		File file = getCacheFile(context,key);
		// Si le fichier n'éxiste pas dans le dossier du cache
		// On regarde s'il existe dans le dossier data
		if(!file.exists()){
			file = getDataFile(context,key);
			// S'il n'éxiste pas non plus dans le dossier data alors on retourne null
			if(!file.exists()) return null;
		}
		try {
			FileInputStream		fis = new FileInputStream(file);
			ObjectInputStream	ois = new ObjectInputStream(fis);
			Object o = ois.readObject();		
			ois.close();
			fis.close();
			//Log.i("Serialization","Fichier cache chargé");
			return o;

		} catch (Exception e) {
			//Log.e("Serialization","ERREUR lors du chargement du cache : " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
