package com.abacus.xathlon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.abacus.xathlon.R;

public class Exercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
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
                Toast.makeText(Exercises.this, "Αρχική Οθόνη",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.help:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Exercises.this, "Επιλέξατε 'Βοήθεια'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Help.class));
                return true;
            case R.id.feedback:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Exercises.this, "Επιλέξατε 'Αξιολογήστε μας'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Feedback.class));
                return true;
            case R.id.aboutus:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Exercises.this, "Επιλέξατε 'Σχετικά με...'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, About_us.class));
                return true;
            case R.id.share:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Exercises.this, "Επιλέξατε 'Κοινή χρήση'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Share.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void startExercises_Neck(View view){ startActivity(new Intent(this, Exercises_Neck.class)); }
    public void startExercises_Arms(View view){ startActivity(new Intent(this, Exercises_Arms.class)); }
    public void startExercises_Back(View view){ startActivity(new Intent(this, Exercises_Back.class)); }
    public void startExercises_Legs(View view){ startActivity(new Intent(this, Exercises_Legs.class)); }
}
