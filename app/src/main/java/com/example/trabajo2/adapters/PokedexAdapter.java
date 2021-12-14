package com.example.trabajo2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.trabajo2.R;
import com.example.trabajo2.models.Pokemon;

import java.util.List;

public class PokedexAdapter extends ArrayAdapter<Pokemon> {
    Context context;
    List<Pokemon> objects;

    public PokedexAdapter(@NonNull Context context, int resource, @NonNull List<Pokemon> objects) {
        super(context, resource, objects);

        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Pokemon pokemon = objects.get(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.pokemon_item, null);
        TextView tvNombre = view.findViewById(R.id.tvNombreItem);
        TextView tvNumero = view.findViewById(R.id.tvNumeroItem);

        String nombre = pokemon.getNombre();
        String numero = pokemon.getNumero();

        tvNombre.setText(nombre);
        tvNumero.setText(numero);

        return view;
    }
}
