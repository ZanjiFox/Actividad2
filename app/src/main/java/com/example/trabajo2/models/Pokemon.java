package com.example.trabajo2.models;

import java.io.Serializable;

public class Pokemon implements Serializable {

    long id;
    String nombre;
    String numero;
    String rdescripcion;
    String tipo;
    String altura;
    String peso;
    String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRdescripcion() {
        return rdescripcion;
    }

    public void setRdescripcion(String rdescripcion) {
        this.rdescripcion = rdescripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "N.°"+ numero +"             "+ nombre;
    }


}

