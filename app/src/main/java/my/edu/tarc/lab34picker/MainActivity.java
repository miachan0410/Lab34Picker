package my.edu.tarc.lab34picker;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    float minBasicSaving;
    int Age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string + "/" + day_string + "/" + year_string);
        Age = Calendar.getInstance().get(Calendar.YEAR)-year;
        Toast.makeText(this, "Date: " + dateMessage, Toast.LENGTH_SHORT).show();
        TextView textViewMsg = findViewById(R.id.buttonDOB);
        textViewMsg.setText(dateMessage);

        TextView AgeView = findViewById(R.id.textViewAge);
        AgeView.setText(String.valueOf(Age));


        if(Age>=16&&Age<=20){
            minBasicSaving=5000;
        }
        else if(Age>=21&&Age<=25){
            minBasicSaving=14000;
        }
        else if(Age>=26&&Age<=30){
            minBasicSaving=29000;
        }
        else if(Age>=31&&Age<=35){
            minBasicSaving=50000;
        }
        else if(Age>=36&&Age<=40){
            minBasicSaving=78000;
        }
        else if(Age>=41&&Age<=45){
            minBasicSaving=116000;
        }
        else if(Age>=46&&Age<=50){
            minBasicSaving=165000;
        }
        else if(Age>=51&&Age<=55){
            minBasicSaving=228000;
        }
    }

    public void setEligibleAmount(View view){
        TextView textViewBalance = findViewById(R.id.editTextAccountBalance);
        int CurrentBalance = Integer.parseInt(textViewBalance.getText().toString());

        TextView textViewEligible = findViewById(R.id.textViewEligibleAmount);
        if(CurrentBalance >= minBasicSaving && (Age>=16 && Age<=55)){
            float amountAvailable = (CurrentBalance - minBasicSaving);
            amountAvailable = amountAvailable * 0.3f;
            textViewEligible.setText(String.valueOf(amountAvailable));
        }
        else{
            textViewEligible.setText("Not Eligible");
        }
    }

    public void Reset(View view){
        TextView textViewBalance = findViewById(R.id.editTextAccountBalance);
        textViewBalance.setText("");
        TextView textViewEligible = findViewById(R.id.textViewEligibleAmount);
        textViewEligible.setText("-");
        TextView textViewAge = findViewById(R.id.textViewAge);
        textViewAge.setText("-");
        TextView textViewMsg = findViewById(R.id.buttonDOB);
        textViewMsg.setText("Select date of birth");
    }

}
