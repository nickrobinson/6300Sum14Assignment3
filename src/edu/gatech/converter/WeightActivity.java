package edu.gatech.converter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class WeightActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_view);
    }

    public void handleClick(View view){
    	boolean checked = ((RadioButton) view).isChecked();
    	
    	EditText txt = (EditText) findViewById(R.id.editText1);
    	double distance = Double.parseDouble(txt.getText().toString());
    	
    	switch(view.getId()) {
    	case R.id.milesBtn:
    		if(checked)
    			txt.setText(kmToMiles(distance));
    		break;
    	case R.id.kmBtn:
    		if(checked)
    			txt.setText(milesToKm(distance));
    		break;
    	}
    }
    
    public String milesToKm(double miles){
    	double km = miles * 1.609;
    	return String.valueOf(km);
    }
    
    public String kmToMiles(double km){
    	double miles = km / 1.609;
    	return String.valueOf(miles);
    }

}
