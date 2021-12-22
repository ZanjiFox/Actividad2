package com.example.trabajo2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.trabajo2.adapters.PokedexAdapter;
import com.example.trabajo2.db.PokemonDataSource;
import com.example.trabajo2.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final int REQUEST_CODE_AGRAGAR_POKEMON = 1001;
    public static final int REQUEST_CODE_DETALLE_ACTIVITY = 1002;
    ListView lvPokedex;
    List<Pokemon> pokemons;
    PokemonDataSource dataSource;
    ArrayAdapter<Pokemon> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("POKEDEX");

        lvPokedex = findViewById(R.id.lvPokedex);

        dataSource = new PokemonDataSource(this);
        dataSource.openDB();

        pokemons = dataSource.obtenerPokemons();
        dataSource.closeDB();
        //pertenece a actividad2
        /*Pokemon pokemon001 = new Pokemon();
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

         */


        //ArrayAdapter<Contacto> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactos);

        adapter = new PokedexAdapter(this,R.layout.pokemon_item,pokemons);

        lvPokedex.setAdapter(adapter);
        lvPokedex.setOnItemClickListener(this);





    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Pokemon pokemon = pokemons.get(i);
        String nombre = pokemon.getNombre();
        Log.i("MainActivity","Nombre: "+ nombre);
        //Toast.makeText(this,"Click en item" + i,Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,DetalleActivity.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("pokemon", pokemon);

        startActivityForResult(intent, REQUEST_CODE_DETALLE_ACTIVITY);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch(id){
            case R.id.action_agregar_pokemon:

                Intent intent = new Intent(this, AgregarPokemonActivity.class);
                //startActivity(intent);
                startActivityForResult(intent,REQUEST_CODE_AGRAGAR_POKEMON);
                break;

            default:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_AGRAGAR_POKEMON && resultCode == 1){

            Log.i("MainActivity","actualizar");

            actaulizarPokemon();

        }

        if(requestCode == REQUEST_CODE_DETALLE_ACTIVITY && resultCode == -1){

            //actualizar
        }
    }

    public void actaulizarPokemon(){

        dataSource.openDB();
        pokemons = dataSource.obtenerPokemons();
        dataSource.closeDB();

        adapter.clear();
        adapter.addAll(pokemons);
        adapter.notifyDataSetChanged();

    }
}