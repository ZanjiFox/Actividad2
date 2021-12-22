package com.example.trabajo2.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.trabajo2.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonDataSource {

    SQLiteOpenHelper dbhelper;
    SQLiteDatabase db;
    String TAG = "db";


    public PokemonDataSource(Context context){

        dbhelper = new PokemonDb(context);


    }

    public void openDB(){
        db = dbhelper.getWritableDatabase();
        Log.i(TAG,"openDB");

    }

    public void closeDB(){
        dbhelper.close();
        Log.i(TAG,"closeDB");

    }


    public List<Pokemon> obtenerPokemons(){

        List<Pokemon> pokemons = new ArrayList<>();

        String query = "SELECT * FROM pokemon";

        Cursor cursor = db.rawQuery(query,null);

        Log.i(TAG,"Filas retornadas "+ cursor.getCount());

        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){

                Pokemon pokemon = new Pokemon();
                pokemon.setId(cursor.getLong(0));
                pokemon.setNombre(cursor.getString(1));
                pokemon.setNumero(cursor.getString(2));
                pokemon.setRdescripcion(cursor.getString(3));
                pokemon.setTipo(cursor.getString(4));
                pokemon.setAltura(cursor.getString(5));
                pokemon.setPeso(cursor.getString(6));
                pokemon.setDescripcion(cursor.getString(7));
                //nombre, numero, rdesc, tipo, altura, peso, descr

                pokemons.add(pokemon);


            }
        }

        return pokemons;

    }
    //nombre TEXT, numero TEXT, rdesc TEXT, tipo TEXT, altura TEXT, peso TEXT, descr TEXT
    public Pokemon InsertarPokemons(Pokemon pokemon){
        ContentValues campos = new ContentValues();
        campos.put("nombre",pokemon.getNombre());
        campos.put("numero",pokemon.getNumero());
        campos.put("rdesc",pokemon.getRdescripcion());
        campos.put("tipo",pokemon.getTipo());
        campos.put("altura",pokemon.getAltura());
        campos.put("peso",pokemon.getPeso());
        campos.put("descr",pokemon.getDescripcion());

        long insertid = db.insert("pokemon",null,campos);
        pokemon.setId(insertid);

        return pokemon;
    }
}
