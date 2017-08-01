/*
Assignment -Homework 2 .
File Name -EditActivity Java Class
Group - Dhenuka Bhargavi Rangam(UNCC ID:800963261)
      - Sunisha Chalasani(UNCC ID:800962445)
* */
package com.example.ranga.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    EditText name,description,year,imdb;
    Spinner genre;
    SeekBar rating;
    TextView ratingValue;
    int rate;
    String rateStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Movie m3 = (Movie) getIntent().getExtras().getSerializable("myMovie");
        Log.d("demo",m3.toString());
        Log.d("demo","Oncreateedit");
        name = (EditText) findViewById(R.id.addNameID);
        description = (EditText) findViewById(R.id.addDescID);
        year = (EditText) findViewById(R.id.addYearID);
        imdb = (EditText) findViewById(R.id.addIMDBID);
        genre = (Spinner) findViewById(R.id.spinner);
        rating = (SeekBar) findViewById(R.id.seekBar);
        name.setText(m3.getName());
        description.setText(m3.getDescription());
        year.setText(m3.getYear());
        imdb.setText(m3.getImdb());
        ratingValue = (TextView) findViewById(R.id.seekbarValue);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.genre,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        int i = adapter.getPosition(m3.getGenre());
        genre.setAdapter(adapter);
        genre.setSelection(i);
        rating.setProgress(Integer.parseInt(m3.getRating()));
        ratingValue.setText(m3.getRating());
        rateStr = ratingValue.getText().toString();


        rating.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                rate = i+0;
                rateStr = String.valueOf(rate);
                ratingValue.setText(rateStr);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        saveMovie(findViewById(R.id.activity_edit));
        super.onBackPressed();
    }

    public void saveMovie(View view) {


        if(name.getText().toString().length()==0 || description.getText().toString().length()==0 ||
                genre.getSelectedItem().toString().equals("Select") || year.getText().toString().length()==0
                || imdb.getText().toString().length()==0 || ratingValue.length()==0 || year.length()<4 || rate==0){
            if(name.getText().toString().length()==0)
            {
                Toast.makeText(this,"Please enter appropriate name",Toast.LENGTH_LONG).show();
            }else if(description.getText().toString().length()==0)
            {
                Toast.makeText(this,"Please enter appropriate description",Toast.LENGTH_LONG).show();
            }else if(genre.getSelectedItem().toString().equals("Select"))
            {
                Toast.makeText(this,"Please enter appropriate genre",Toast.LENGTH_LONG).show();
            }else if(year.getText().toString().length()==0)
            {
                Toast.makeText(this,"Please enter appropriate year",Toast.LENGTH_LONG).show();
            }else if(imdb.getText().toString().length()==0)
            {
                Toast.makeText(this,"Please select imdb value",Toast.LENGTH_LONG).show();
            }else if(year.length()<4)
            {
                Toast.makeText(this,"Please enter appropriate year value",Toast.LENGTH_LONG).show();
            }else if(rate == 0)
            {
                Toast.makeText(this,"Please enter appropriate rating value",Toast.LENGTH_LONG).show();
            }
            Toast.makeText(this,"Please enter appropriate value",Toast.LENGTH_LONG).show();


        }else {

            String name1 = name.getText().toString();

            String description1 = description.getText().toString();

            String genre1 = genre.getSelectedItem().toString();

            String year1 = year.getText().toString();

            String imdb1 = imdb.getText().toString();


           rateStr = (String) ratingValue.getText();

            Movie m1 = new Movie(name1, description1, genre1, rateStr, year1, imdb1);
            Intent in = new Intent();
            in.putExtra(MainActivity.movie_key, m1);
            setResult(RESULT_OK, in);
            finish();

        }


    }
}
