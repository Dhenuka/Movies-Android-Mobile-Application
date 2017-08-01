/*
Assignment -Homework 2 .
File Name -MainActivity Java Class
Group - Dhenuka Bhargavi Rangam(UNCC ID:800963261)
      - Sunisha Chalasani(UNCC ID:800962445)
* */

package com.example.ranga.movies;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CharSequence[] moviesChar ;
     ArrayList movieList = new ArrayList();
    static final int request_code = 100;
    int index = -1;
    static final int request_code_edit = 200;
    static final String movie_key = "myMovie";
    static final String movie_array_key = "AllMyMovies";
    //static final String movie_edit_key = "myEditedMovie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("My Favourite Movies");


    }

    public void addMovie(View view) {
        Intent add = new Intent(MainActivity.this, AddMovie.class);
        startActivityForResult(add,request_code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==request_code && resultCode==RESULT_OK)
        {
           Movie m2 = (Movie) data.getExtras().getSerializable(movie_key);
            movieList.add(m2);
            Log.d("movie",m2+"");
        }else if(requestCode==request_code_edit && resultCode==RESULT_OK)
        {

            Movie m2 = (Movie) data.getExtras().getSerializable(movie_key);
            movieList.remove(index);
            movieList.add(m2);
        }
    }


    public void editMovie(View view) {

        moviesChar=new CharSequence[movieList.size()];

        for(int j =0;j<movieList.size();j++)
        {
            Movie m3 = (Movie) movieList.get(j);
           moviesChar[j] =  m3.getName();

        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick a Movie");
        builder.setItems(moviesChar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

               Movie m3= (Movie) movieList.get(i);
                Intent in = new Intent(MainActivity.this,EditActivity.class);
                in.putExtra(movie_key,m3);
                startActivityForResult(in,request_code_edit);
                index = i;


            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }

    public void deleteMovie(View view) {
        moviesChar=new CharSequence[movieList.size()];

        for(int j =0;j<movieList.size();j++)
        {
            Movie m3 = (Movie) movieList.get(j);
            moviesChar[j] =  m3.getName();

        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick a Movie");
        builder.setItems(moviesChar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Movie m1 = (Movie) movieList.get(i);
                String movieName = m1.getName();
                movieList.remove(i);
                Toast.makeText(MainActivity.this,"Movie with movie name " +movieName + "is deleted",Toast.LENGTH_LONG).show();



            }
        });

        AlertDialog alert = builder.create();
        alert.show();


    }

    public void showByYear(View view) {

        Intent in = new Intent("com.example.ranga.movies.intent.action.VIEW_SY");
        in.addCategory(Intent.CATEGORY_DEFAULT);
        in.putExtra(movie_array_key,movieList);
        startActivity(in);
    }

    public void showByRating(View view) {

        Intent in = new Intent("com.example.ranga.movies.intent.action.VIEW_SR");
        in.addCategory(Intent.CATEGORY_DEFAULT);
        in.putExtra(movie_array_key,movieList);
        startActivity(in);

    }


}
