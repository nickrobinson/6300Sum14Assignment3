package edu.gatech.unitconverter;

import edu.gatech.unitconverter.R;

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
    	
    	//We need to check if the text field is empty and if so set the value to 0
    	double weight;
    	if(!txt.getText().toString().matches(""))
    	{
    		weight = Double.parseDouble(txt.getText().toString());
    	}
    	else
    	{
    		weight = 0;
    	}
    	
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
