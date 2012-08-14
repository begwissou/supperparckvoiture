package com.ingeniousafrica.supperparckvoiture.activities;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.ingeniousafrica.supperparckvoiture.R;




public class Fabrication extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fabrication);
		
		findViewById(R.id.activity_fabrication_button_fabriquer).setOnClickListener(this);
	}

	public void onClick(View v) {
		switch(v.getId()){

    	case R.id.activity_fabrication_button_fabriquer:
    		Intent intent = new Intent(this, ParckVoiture.class );
    		
    		startActivity(intent);
    		break;

    	

    	}
	}
	
	

}
