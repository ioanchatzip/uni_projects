package com.abacus.xathlon;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.abacus.xathlon.R;

public class Profile extends AppCompatActivity implements View.OnClickListener {

    CheckBox male, female;
    static int age=0;
    static int weight=0;
    static int height=0;
    static int flag=0;

    EditText ageInput;
    EditText weightInput;
    EditText heightInput;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        male = (CheckBox) findViewById(R.id.male);
        male.setOnClickListener(this);
        female = (CheckBox) findViewById(R.id.female);
        female.setOnClickListener(this);

        ageInput = (EditText) findViewById(R.id.ageInput);
        weightInput = (EditText) findViewById(R.id.weightInput);
        heightInput = (EditText) findViewById(R.id.heightInput);

        if(age!=0){
            ageInput.setHint(String.valueOf(age));
        }
        if(weight!=0){
            weightInput.setHint(String.valueOf(weight));
        }
        if(height!=0){
            heightInput.setHint(String.valueOf(height));
        }

        if(flag==1){
            male.setChecked(true);
        }
        else if (flag==2){
            female.setChecked(true);
        }

        submitButton= (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age= Integer.valueOf(ageInput.getText().toString());
                weight= Integer.valueOf(weightInput.getText().toString());
                height= Integer.valueOf(heightInput.getText().toString());

            }
        });

    }

    private void showToast (String text){
        Toast.makeText(Profile.this, text, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Toast.makeText(Profile.this, "Αρχική Οθόνη",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.help:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Profile.this, "Επιλέξατε 'Βοήθεια'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Help.class));
                return true;
            case R.id.feedback:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Profile.this, "Επιλέξατε 'Αξιολογήστε μας'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Feedback.class));
                return true;
            case R.id.aboutus:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Profile.this, "Επιλέξατε 'Σχετικά με...'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, About_us.class));
                return true;
            case R.id.share:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Profile.this, "Επιλέξατε 'Κοινή χρήση'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Share.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.male:
                if (male.isChecked()){
                    Toast.makeText(getApplicationContext(), "Επιλέξατε 'Άνδρας'", Toast.LENGTH_SHORT).show();
                    female.setChecked(false);
                    flag=1;
                    break;}
            case R.id.female:
                if (female.isChecked()){
                    Toast.makeText(getApplicationContext(), "Επιλέξατε 'Γυναίκα'", Toast.LENGTH_SHORT).show();
                    male.setChecked(false);
                    flag=2;
                    break;}
        }
    }

}