package com.example.trabajo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;



import com.example.trabajo2.models.Pokemon;


public class DetalleActivity extends AppCompatActivity {

    TextView tvNombre, tvEspecie,tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        setTitle("INFO");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Pokemon pokemon = (Pokemon) intent.getSerializableExtra("pokemon");
        String nombre = pokemon.getNumero() +" "+pokemon.getNombre();
        String Descripcion = pokemon.getRdescripcion() + " | "+pokemon.getTipo()+" | ["+pokemon.getAltura()+" ] [ "+pokemon.getPeso()+" ]";
        tvNombre = findViewById(R.id.tvNombre);
        tvEspecie = findViewById(R.id.tvEspecie);
        tvDescripcion = findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvEspecie.setText(Descripcion);
        tvDescripcion.setText(pokemon.getDescripcion());


        Log.i("DetalleActivity","Nombre recibido:" + nombre);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case android.R.id.home:
                finish();

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}