package com.example.trabajo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.trabajo2.adapters.PokedexAdapter;
import com.example.trabajo2.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvPokedex;
    List<Pokemon> pokemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("POKEDEX");

        lvPokedex = findViewById(R.id.lvPokedex);

        pokemons = new ArrayList<>();

        Pokemon pokemon001 = new Pokemon();
        pokemon001.setNombre("Bulbasaur");
        pokemon001.setNumero("N.°001");
        pokemon001.setRdescripcion("Pokemon semilla");
        pokemon001.setTipo("Planta/Veneno");
        pokemon001.setAltura("0.7 m");
        pokemon001.setPeso("6.9 kg");
        pokemon001.setDescripcion("Una rara semilla fue plantada en su espalda al nacer. La planta brota y crece con este Pokémon.");

        Pokemon pokemon002 = new Pokemon();
        pokemon002.setNombre("Ivysaur");
        pokemon002.setNumero("N.°002");
        pokemon002.setRdescripcion("Pokemon semilla");
        pokemon002.setTipo("Planta/Veneno");
        pokemon002.setAltura("1.0 m");
        pokemon002.setPeso("13.0 kg");
        pokemon002.setDescripcion("Cuando el bulbo de su espalda crece, parece no poder ponerse de pie sobre sus patas traseras.");

        Pokemon pokemon003 = new Pokemon();
        pokemon003.setNombre("Venusaur");
        pokemon003.setNumero("N.°003");
        pokemon003.setRdescripcion("Pokemon semilla");
        pokemon003.setTipo("Planta/Veneno");
        pokemon003.setAltura("2.0 m");
        pokemon003.setPeso("100.0 kg");
        pokemon003.setDescripcion("La planta florece cuando absorbe energía solar. Ésta le obliga a ponerse en busca de la luz solar.");

        Pokemon pokemon004 = new Pokemon();
        pokemon004.setNombre("Charmander");
        pokemon004.setNumero("N.°004");
        pokemon004.setRdescripcion("Pokemon Lagartija");
        pokemon004.setTipo("Fuego");
        pokemon004.setAltura("0.6 m");
        pokemon004.setPeso("8.5 kg");
        pokemon004.setDescripcion("Prefiere los sitios calientes. Dicen que cuando llueve sale vapor de la punta de su cola.");

        Pokemon pokemon005 = new Pokemon();
        pokemon005.setNombre("Charmeleon");
        pokemon005.setNumero("N.°005");
        pokemon005.setRdescripcion("Pokemon Llama");
        pokemon005.setTipo("Fuego");
        pokemon005.setAltura("1.1 m");
        pokemon005.setPeso("19.0 kg");
        pokemon005.setDescripcion("Cuando está luchando su llama arde vivamente, esto eleva las temperaturas.");

        pokemons.add(pokemon001);
        pokemons.add(pokemon002);
        pokemons.add(pokemon003);
        pokemons.add(pokemon004);
        pokemons.add(pokemon005);


        //ArrayAdapter<Contacto> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactos);

        ArrayAdapter<Pokemon> adapter = new PokedexAdapter(this,R.layout.pokemon_item,pokemons);

        lvPokedex.setAdapter(adapter);
        lvPokedex.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Pokemon pokemon = pokemons.get(i);
        String nombre = pokemon.getNombre();
        Log.i("MainActivity","Nombre: "+ nombre);
        Toast.makeText(this,"Click en item" + i,Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,DetalleActivity.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("pokemon", pokemon);

        startActivity(intent);

    }
}