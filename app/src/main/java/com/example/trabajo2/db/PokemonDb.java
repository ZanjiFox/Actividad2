package com.example.trabajo2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class PokemonDb extends SQLiteOpenHelper {
    //pokemons
    public static String DATABASE_NAME = "pokemons.db";
    public static int VERSION = 1;

    String CREATE_TABLE_POKEMON = "CREATE TABLE pokemon(id INTEGER PRIMARY KEY autoincrement, nombre TEXT, numero TEXT, rdesc TEXT, tipo TEXT, altura TEXT, peso TEXT, descr TEXT);";

    String INSERT_POKEMON1 = "INSERT INTO pokemon (nombre, numero, rdesc, tipo, altura, peso, descr)"+
            "VALUES ('Bulbasaur', 'N.°001', 'Pokemon semilla', 'Planta/Veneno', '0.7 m', '6.9 kg', 'Una rara semilla fue plantada en su espalda al nacer. La planta brota y crece con este Pokémon.')";
    public PokemonDb(@Nullable Context context) {
        super(context, DATABASE_NAME,null,VERSION);
    }

    //nombre;
    //numero;
    //rdescripcion;
    //tipo;
    //altura;
    //peso;
    //descripcion;

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_POKEMON);
        Log.i("OpenHelper","se creo tabla de pokemons");

        db.execSQL(INSERT_POKEMON1);

        Log.i("OpenHelper","Insertar Pokemon");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
