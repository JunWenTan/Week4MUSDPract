package com.example.a153907n_mysuperhero.mysuperhero;


import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spLocations;
    ArrayAdapter<CharSequence> adapter;
    TextView superHeroTV;
    String[] strArray;
    String[] superHeros = {"1. Batman\n2. SpiderMan", "1.Peter Pan\n2. SuperMan", "1. IronMan\n2. Peter Pan","1. SnowWhite\n2. Gingerbreadman"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        superHeroTV = (TextView) findViewById(R.id.superHerosTV);
        spLocations = (Spinner) findViewById(R.id.spLocations);

        Resources myRes = this.getResources();
        strArray = myRes.getStringArray(R.array.locationArea);

        adapter = ArrayAdapter.createFromResource(this, R.array.locationArea, android.R.layout.simple_spinner_dropdown_item);
        spLocations.setAdapter(adapter);

        spLocations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0,
                                       View arg1, int arg2, long arg3)
            {
                String text = superHeros[arg2];
                superHeroTV.setText(text);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {
                superHeroTV.setText("There is no super Heroes for this area.");
            }
        });

    }
}
