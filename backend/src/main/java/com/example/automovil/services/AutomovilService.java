package com.example.automovil.services;

import org.springframework.stereotype.Service;

import com.example.automovil.model.Automovil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.*;

@Service
public class AutomovilService {
    private static final List<String> MARCAS = Arrays.asList("Toyota", "Ford", "Chevrolet", "Hyundai", "Nissan");
    private static final List<String> COLORES = Arrays.asList("Rojo", "Azul", "Negro", "Blanco", "Gris");
    private static final List<String> TIPOS = Arrays.asList("Sedan", "Camioneta", "SUV");
    private static final Map<String, List<String>> MOTORES = Map.of(
            "Sedan", Arrays.asList("1.4cc", "1.6cc", "2.0cc"),
            "Camioneta", Arrays.asList("2.4cc", "3.0cc", "4.0cc"),
            "SUV", Arrays.asList("1.8cc", "2.2cc", "2.8cc"));

    private List<Automovil> automoviles = new ArrayList<>();
    private int currentId = 1;
    private final Random random = new Random();

    public List<Automovil> generarAutomoviles(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Automovil auto = new Automovil();
            auto.setId(currentId++);
            auto.setMarca(MARCAS.get(random.nextInt(MARCAS.size())));
            auto.setAño(random.nextInt(2023 - 2015 + 1) + 2015);
            auto.setColor(COLORES.get(random.nextInt(COLORES.size())));
            auto.setPrecio(random.nextInt(30000000 - 8000000 + 1) + 8000000);
            auto.setTurbo(random.nextBoolean());
            String tipo = TIPOS.get(random.nextInt(TIPOS.size()));
            auto.setTipo(tipo);
            auto.setMotor(MOTORES.get(tipo).get(random.nextInt(MOTORES.get(tipo).size())));

            if ("Camioneta".equals(tipo)) {
                auto.setCabinas(random.nextInt(2) + 1);
            }
            if ("SUV".equals(tipo)) {
                auto.setSunroof(random.nextBoolean());
            }
            auto.setPopularidad(0);
            automoviles.add(auto);
        }
        return automoviles;
    }

    public List<Automovil> obtenerTodosAutomoviles() {
        return automoviles;
    }

    public Automovil obtenerAutomovilPorId(int id) {
        return automoviles.stream()
                .filter(auto -> auto.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
