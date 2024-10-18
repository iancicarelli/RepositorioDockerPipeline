package com.example.automovil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.automovil.services.AutomovilService;
import com.example.automovil.model.Automovil;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/automoviles")
public class AutomovilController {

    @Autowired
    private AutomovilService automovilService;

    @GetMapping("/generar/{cantidad}")
    public List<Automovil> generarAutomoviles(@PathVariable int cantidad) {
        return automovilService.generarAutomoviles(cantidad);
    }

    @GetMapping("/todos")
    public List<Automovil> obtenerTodosAutomoviles() {
        return automovilService.obtenerTodosAutomoviles();
    }

    @GetMapping("/{id}")
    public Automovil obtenerAutomovilPorId(@PathVariable int id) {
        Automovil auto = automovilService.obtenerAutomovilPorId(id);
        if (auto == null) {
            throw new RuntimeException("Automóvil no encontrado con ID: " + id);
        }
        return auto;
    }
}
