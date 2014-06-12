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
    	double weight = Double.parseDouble(txt.getText().toString());
    	
    	switch(view.getId()) {
    	case R.id.poundsBtn:
    		if(checked)
    			txt.setText(kilosToPounds(weight));
    		break;
    	case R.id.kiloBtn:
    		if(checked)
    			txt.setText(poundsToKilos(weight));
    		break;
    	}
    }
    
    public String poundsToKilos(double weight){
    	double kilos = weight / 2.2046;
    	return String.valueOf(kilos);
    }
    
    public String kilosToPounds(double weight){
    	double pounds = weight * 2.2046;
    	return String.valueOf(pounds);
    }

}
