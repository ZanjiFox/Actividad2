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

import com.example.trabajo2.models.Contacto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvContactos;
    List<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Contactos");

        lvContactos = findViewById(R.id.lvContactos);

        contactos = new ArrayList<>();

        Contacto contacto = new Contacto();
        contacto.setNombre("Fransisco");
        contacto.setPaterno("Araneda");
        contacto.setMaterno("Duran");
        contacto.setTelefono("+56912345678");

        Contacto contacto2 = new Contacto();
        contacto2.setNombre("Martin");
        contacto2.setPaterno("Carrasco");
        contacto2.setMaterno("Gude");
        contacto2.setTelefono("+56987654321");

        contactos.add(contacto);
        contactos.add(contacto2);

        ArrayAdapter<Contacto> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactos);

        lvContactos.setAdapter(adapter);
        lvContactos.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Contacto contacto = contactos.get(i);
        String nombre = contacto.getNombre();
        Log.i("MainActivity","Nombre: "+ nombre);
        Toast.makeText(this,"Click en item" + i,Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,DetalleActivity.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("contacto", contacto);
        startActivity(intent);

    }
}