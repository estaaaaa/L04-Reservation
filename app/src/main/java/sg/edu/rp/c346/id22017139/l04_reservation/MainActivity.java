package sg.edu.rp.c346.id22017139.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    // Faster way to initialize from the same group of functions is to just use a comma!
    EditText editTextName, editTextMobileNumber, editTextGroupSize;
    DatePicker datePicker;
    TimePicker timePicker;
    RadioGroup radioGroupSmoke;
    Button buttonConfirm, buttonReset;
    Spinner spinnerPrefix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        editTextName = findViewById(R.id.editTextName);
        editTextMobileNumber = findViewById(R.id.editTextMobileNumber);
        editTextGroupSize = findViewById(R.id.editTextGroupSize);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        radioGroupSmoke = findViewById(R.id.radioGroupArea);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        buttonReset = findViewById(R.id.buttonReset);
        spinnerPrefix = findViewById(R.id.spinnerPrefix);

        // Set default date and time
        Calendar defaultDateTime = Calendar.getInstance();
        defaultDateTime.set(2023, Calendar.JUNE, 1, 19, 30);
        datePicker.updateDate(2023, Calendar.JUNE, 1);
        timePicker.setCurrentHour(19);
        timePicker.setCurrentMinute(30);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected date and time
                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int day = datePicker.getDayOfMonth();
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                // Get the selected area
                String area;
                int checkedRadioButtonId = radioGroupSmoke.getCheckedRadioButtonId();
                if (checkedRadioButtonId == R.id.radioButtonSmoking) {
                    area = "Smoking";
                } else if (checkedRadioButtonId == R.id.radioButtonNonSmoking) {
                    area = "Non-Smoking";
                } else {
                    area = "";
                }

                String prefix = spinnerPrefix.getSelectedItem().toString();

                // Get the entered reservation details
                String name = editTextName.getText().toString();
                String mobileNumber = editTextMobileNumber.getText().toString();
                String groupSize = editTextGroupSize.getText().toString();

                // Display reservation information in a message for a short while
                String reservationInfo = "Prefix: " + prefix + "\n"
                        + "Name: " + name + "\n"
                        + "Mobile Number: " + mobileNumber + "\n"
                        + "Group Size: " + groupSize + "\n"
                        + "Date: " + year + "-" + (month + 1) + "-" + day + "\n"
                        + "Time: " + hour + ":" + minute + "\n"
                        + "Area: " + area;
                Toast.makeText(MainActivity.this, reservationInfo, Toast.LENGTH_SHORT).show();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset inputs to default values
                editTextName.setText("");
                editTextMobileNumber.setText("");
                editTextGroupSize.setText("");
                datePicker.updateDate(2020, Calendar.JUNE, 1);
                timePicker.setCurrentHour(19);
                timePicker.setCurrentMinute(30);
                radioGroupSmoke.clearCheck();
                spinnerPrefix.setSelection(0);
            }
        });
    }
}