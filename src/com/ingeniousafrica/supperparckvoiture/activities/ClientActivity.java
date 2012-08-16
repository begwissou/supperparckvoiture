package com.ingeniousafrica.supperparckvoiture.activities;

import com.ingeniousafrica.supperparckvoiture.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ClientActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	Spinner spCarro;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        
       findViewById(R.id.activity_client_button_continuer).setOnClickListener(this);
       
       String[] carrosseries = {
    		   "Berlines",
    		   "4 roues motrices",
    		   "Autobus",
    		   "Camions",
    		   "Machines et tracteurs"
       };
       
       ArrayAdapter<String> adapterCarro = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, carrosseries);
       
       spCarro = (Spinner)findViewById(R.id.activity_client_carrosserie_spin);
       
       spCarro.setAdapter(adapterCarro);
       
    
    }
    
    
    public void onClick(View v) {
    	switch(v.getId()){

    	case R.id.activity_client_button_continuer:
    		Intent intent = new Intent(this, Fabrication.class );
    		
    		startActivity(intent);
    		break;

    	

    	}

    }
}