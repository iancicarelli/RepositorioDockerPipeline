package com.example.automovil.model;

import lombok.Data;

@Data
public class Automovil {

    private int id;
    private String marca;
    private int año;
    private String color;
    private double precio;
    private boolean turbo;
    private String tipo;
    private String motor;
    private int cabinas;
    private boolean sunroof;
    private int popularidad;
}
