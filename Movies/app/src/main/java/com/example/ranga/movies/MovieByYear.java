/*
Assignment -Homework 2 .
File Name -MovieByYear Java Class
Group - Dhenuka Bhargavi Rangam(UNCC ID:800963261)
      - Sunisha Chalasani(UNCC ID:800962445)
* */

package com.example.ranga.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MovieByYear extends AppCompatActivity {

    TextView title, description, genre, rating, year, imdb;
    Button finish ;
    ImageView first,last,previous,next;
    static ArrayList<Movie> myAllMovies ;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_by_year);
        myAllMovies = (ArrayList<Movie>) getIntent().getExtras().getSerializable(MainActivity.movie_array_key);
        Collections.sort(myAllMovies,Movie.sortByYear);
        title = (TextView) findViewById(R.id.Title_ID_SR);
        description = (TextView) findViewById(R.id.Desc_ID_SR);
        genre = (TextView) findViewById(R.id.Genre_ID_SR);
        rating = (TextView) findViewById(R.id.Rating_ID_SR);
        year = (TextView) findViewById(R.id.Year_ID_SY);
        imdb = (TextView) findViewById(R.id.IMDB_ID_SR);
        finish = (Button) findViewById(R.id.finish_id_sr);
        Movie m2 = myAllMovies.get(0);
        title.setText(m2.getName());
        description.setText(m2.getDescription());
        genre.setText(m2.getGenre());
        rating.setText(m2.getRating());
        year.setText(m2.getYear());
        imdb.setText(m2.getImdb());
        last = (ImageView) findViewById(R.id.last_sr); first = (ImageView) findViewById(R.id.first);
        previous = (ImageView) findViewById(R.id.previous_sr);
        next = (ImageView) findViewById(R.id.next_sr);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if(index>0){
                    index = index-1;
                    title.setText(myAllMovies.get(index).getName());
                    description.setText(myAllMovies.get(index).getDescription());
                    genre.setText(myAllMovies.get(index).getGenre());
                    rating.setText(myAllMovies.get(index).getRating());
                    year.setText(myAllMovies.get(index).getYear());
                    imdb.setText(myAllMovies.get(index).getImdb());
                }
                else
                {
                    //Log.d("demo","InPreviousElse");
                    Toast.makeText(MovieByYear.this,"This is the first Movie",Toast.LENGTH_LONG).show();
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(index<(myAllMovies.size()-1)) {
                  index = index+1;
                    title.setText(myAllMovies.get(index).getName());
                    description.setText(myAllMovies.get(index).getDescription());
                    genre.setText(myAllMovies.get(index).getGenre());
                    rating.setText(myAllMovies.get(index).getRating());
                    year.setText(myAllMovies.get(index).getYear());
                    imdb.setText(myAllMovies.get(index).getImdb());
                }else
                {

                    Toast.makeText(MovieByYear.this,"This is the last Movie",Toast.LENGTH_LONG).show();

                }


            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(index==0)
                {
                    Toast.makeText(MovieByYear.this,"This is the first Movie",Toast.LENGTH_LONG).show();
                }else
                {
                    index = 0;
                    title.setText(myAllMovies.get(0).getName());
                    description.setText(myAllMovies.get(0).getDescription());
                    genre.setText(myAllMovies.get(0).getGenre());
                    rating.setText(myAllMovies.get(0).getRating());
                    year.setText(myAllMovies.get(0).getYear());
                    imdb.setText(myAllMovies.get(0).getImdb());

                }


            }
        });
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(index==myAllMovies.size()-1)
                {
                    Toast.makeText(MovieByYear.this,"This is the Last Movie",Toast.LENGTH_LONG).show();
                }else
                {
                    index = myAllMovies.size()-1;
                    title.setText(myAllMovies.get(index).getName());
                    description.setText(myAllMovies.get(index).getDescription());
                    genre.setText(myAllMovies.get(index).getGenre());
                    rating.setText(myAllMovies.get(index).getRating());
                    year.setText(myAllMovies.get(index).getYear());
                    imdb.setText(myAllMovies.get(index).getImdb());

                }

            }
        });


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
