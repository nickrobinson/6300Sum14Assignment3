package edu.gatech.converter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class TemperatureActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature_view);
    }

    public void handleClick(View view){
    	boolean checked = ((RadioButton) view).isChecked();
    	
    	EditText txt = (EditText) findViewById(R.id.editText1);
 	
    	//We need to check if the text field is empty and if so set the value to 0
    	double temp;
    	if(!txt.getText().toString().matches(""))
    	{
    		temp = Double.parseDouble(txt.getText().toString());
    	}
    	else
    	{
    		temp = 0;
    	}
    	
    	switch(view.getId()) {
    	case R.id.farenheitBtn:
    		if(checked)
    			txt.setText(celciusToFarenheit(temp));
    		break;
    	case R.id.celciusBtn:
    		if(checked)
    			txt.setText(farenheitToCelcius(temp));
    		break;
    	}
    }
    
    public String farenheitToCelcius(double temp){
    	double celcius = ((temp - 32) * 5)/9;
    	return String.valueOf(celcius);
    }
    
    public String celciusToFarenheit(double temp){
    	double farenheit = ((temp * 9)/5) + 32;
    	return String.valueOf(farenheit);
    }

}
