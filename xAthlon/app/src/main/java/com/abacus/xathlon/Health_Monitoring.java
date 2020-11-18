package com.abacus.xathlon;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.abacus.xathlon.R;


public class Health_Monitoring extends AppCompatActivity implements SensorEventListener  {
    TextView steps;
    TextView profile_warning;
    TextView bmi;
    static TextView calories;
    SensorManager sensorManager;
    Sensor mysensor;
    ProgressBar step_ProgressBar;
    int step_progress=0;
    int equalizer=0;
    boolean running = false;
    Button step_zero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_health__monitoring );
        steps = (TextView) findViewById (R.id.steps);
        calories = (TextView) findViewById (R.id.calories);
        profile_warning = (TextView) findViewById (R.id.profile_warning);
        bmi = (TextView) findViewById (R.id.bmi);
        sensorManager = (SensorManager) getSystemService ( Context.SENSOR_SERVICE);
        step_ProgressBar = (ProgressBar) findViewById(R.id.step_ProgressBar);
        step_zero = (Button) findViewById(R.id.step_zero);
        step_zero.setOnClickListener(handler_zero);
        bmi.setText(String.format ("%.3f", Profile.weight/((Profile.height*0.01)*(Profile.height*0.01))));
        if(Profile.weight<=0){
            profile_warning.setText("Ενημερώστε το προφίλ σας!");
        }
    }

    @Override
    protected void onResume() {
        super.onResume ();
        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor ( mysensor.TYPE_STEP_COUNTER );
        if(countSensor!= null){
            sensorManager.registerListener(this,countSensor,SensorManager.SENSOR_DELAY_UI);
        }
        else {
            Toast.makeText ( this,"SENSOR NOT FOUND",Toast.LENGTH_SHORT ).show ();
        }
    }

    @Override
    protected void onPause() {
        super.onPause ();
        running = false;
        //if you unregister the hardware will stop detecting steps
    }

    View.OnClickListener handler_zero = new View.OnClickListener() {
        public void onClick(View v) {
            String buttonText = step_zero.getText().toString();
            step_progress = 0;
            equalizer=0;
            calories.setText((String.valueOf(0)));
            step_ProgressBar.setProgress(step_progress);
            steps.setText(String.valueOf(0));
            Toast.makeText(Health_Monitoring.this, "Τα στοιχεία μηδενίστηκαν!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onSensorChanged(SensorEvent event) {
        calories.setText (String.format ("%.3f",(0.57*2.204*step_progress* Profile.weight)/2200));
        if (equalizer < 1){
            steps.setText ( String.valueOf ((int) event.values[0]) );
            step_progress = (int) event.values[0];
            equalizer = (int)event.values [0];
            step_ProgressBar.setProgress(step_progress);
        }
       else if (running){
            steps.setText ( String.valueOf ((int) event.values[0]-equalizer) );
            step_progress = (int) event.values[0]-equalizer;
            step_ProgressBar.setProgress(step_progress);
        }

        if(Profile.age > 0 && Profile.age <= 40){
            step_ProgressBar.setMax(10000);
            if(step_ProgressBar.getProgress()<=2500){
                step_ProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));}
            else if(step_ProgressBar.getProgress()>2500 && step_ProgressBar.getProgress()<=7000){
                step_ProgressBar.setProgressTintList(ColorStateList.valueOf(-150));}
            else if(step_ProgressBar.getProgress()>7000){
                step_ProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));}
        }
        else if(Profile.age > 40 && Profile.age <= 55){
            step_ProgressBar.setMax(8000);
            if(step_ProgressBar.getProgress()<=2000){
                step_ProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));}
            else if(step_ProgressBar.getProgress()>2000 && step_ProgressBar.getProgress()<=6000){
                step_ProgressBar.setProgressTintList(ColorStateList.valueOf(-150));}
            else if(step_ProgressBar.getProgress()>6000){
                step_ProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));}
        }
        else if(Profile.age > 55 && Profile.age <= 70){
            step_ProgressBar.setMax(5000);
            if(step_ProgressBar.getProgress()<=1000){
                step_ProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));}
            else if(step_ProgressBar.getProgress()>1000 && step_ProgressBar.getProgress()<=3000){
                step_ProgressBar.setProgressTintList(ColorStateList.valueOf(-150));}
            else if(step_ProgressBar.getProgress()>3000){
                step_ProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));}
        }
        else if(Profile.age > 70){
            step_ProgressBar.setMax(40);
            if(step_ProgressBar.getProgress()<=15){
                step_ProgressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));}
            else if(step_ProgressBar.getProgress()>15 && step_ProgressBar.getProgress()<=25){
                step_ProgressBar.setProgressTintList(ColorStateList.valueOf(-150));}
            else if(step_ProgressBar.getProgress()>25){
                step_ProgressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));}
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){}


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
                Toast.makeText(Health_Monitoring.this, "Αρχική Οθόνη",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.help:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Health_Monitoring.this, "Επιλέξατε 'Βοήθεια'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Help.class));
                return true;
            case R.id.feedback:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Health_Monitoring.this, "Επιλέξατε 'Αξιολογήστε μας'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Feedback.class));
                return true;
            case R.id.aboutus:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Health_Monitoring.this, "Επιλέξατε 'Σχετικά με...'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, About_us.class));
                return true;
            case R.id.share:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Health_Monitoring.this, "Επιλέξατε 'Κοινή χρήση'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Share.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
