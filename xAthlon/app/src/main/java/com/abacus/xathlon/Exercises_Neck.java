package com.abacus.xathlon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.abacus.xathlon.R;

public class Exercises_Neck extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter_Neck adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises__neck);
        viewPager = (ViewPager) findViewById(R.id.pager_neck);
        adapter = new ViewPagerAdapter_Neck(getSupportFragmentManager());
        adapter.AddFragment(new Fragment_Neck_ex1(),"ΑΣΚΗΣΗ 1");
        adapter.AddFragment(new Fragment_Neck_ex2(),"ΑΣΚΗΣΗ 2");
        viewPager.setAdapter(adapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
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
                Toast.makeText(Exercises_Neck.this, "Αρχική Οθόνη",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.help:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Exercises_Neck.this, "Επιλέξατε 'Βοήθεια'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Help.class));
                return true;
            case R.id.feedback:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Exercises_Neck.this, "Επιλέξατε 'Αξιολογήστε μας'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Feedback.class));
                return true;
            case R.id.aboutus:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Exercises_Neck.this, "Επιλέξατε 'Σχετικά με...'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, About_us.class));
                return true;
            case R.id.share:
                if(item.isChecked())item.setChecked(false);
                else item.setChecked(true);
                Toast.makeText(Exercises_Neck.this, "Επιλέξατε 'Κοινή χρήση'",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Share.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
