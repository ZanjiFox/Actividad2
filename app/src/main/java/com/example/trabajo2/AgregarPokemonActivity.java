package com.example.trabajo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabajo2.db.PokemonDataSource;
import com.example.trabajo2.models.Pokemon;

public class AgregarPokemonActivity extends AppCompatActivity {

    EditText etNombre, etNumero, etRdescripcion, etTipo, etAltura, etPeso, etDescripcion;
    PokemonDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setTitle("AGREGAR A POKEDEX");
        setContentView(R.layout.activity_agregar_pokemon);


        dataSource = new PokemonDataSource(this);

        etNombre = findViewById(R.id.etNombre);
        etNumero = findViewById(R.id.etNumero);
        etRdescripcion = findViewById(R.id.etEspecie);
        etTipo = findViewById(R.id.etTipo);
        etAltura = findViewById(R.id.etAltura);
        etPeso = findViewById(R.id.etPeso);
        etDescripcion = findViewById(R.id.etDescripcion);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_agregar_pokemon_activity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_guardar_pokemon:
                Toast.makeText(this, "Guardar",Toast.LENGTH_SHORT).show();
                dataSource.openDB();
                guardarPokemon();
                dataSource.closeDB();
                finish();
                break;

            case android.R.id.home:
                finish();


            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void guardarPokemon(){

        String nombre = etNombre.getText().toString();
        String numero = "N.°" + etNumero.getText().toString();
        String rdescripcion = etRdescripcion.getText().toString();
        String tipo = etTipo.getText().toString();
        String altura = etAltura.getText().toString() + " m";
        String peso = etPeso.getText().toString() + " kg";
        String descripcion = etDescripcion.getText().toString();

        if(crearPokemon(nombre, numero, rdescripcion, tipo , altura , peso , descripcion) != -1){
            Toast.makeText(this,"Pokemon agregado!",Toast.LENGTH_SHORT).show();
        }
        else{
            Log.i("AgregarPokemonActivity", "error");
        }

    }

    public long crearPokemon(String nombre, String numero, String rdescripcion, String tipo , String altura , String peso , String descripcion){
        Pokemon pokemon =new Pokemon();
        pokemon.setNombre(nombre);
        pokemon.setNumero(numero);
        pokemon.setRdescripcion(rdescripcion);
        pokemon.setTipo(tipo);
        pokemon.setAltura(altura);
        pokemon.setPeso(peso);
        pokemon.setDescripcion(descripcion);

        pokemon = dataSource.InsertarPokemons(pokemon);

        return pokemon.getId();

    }
}

