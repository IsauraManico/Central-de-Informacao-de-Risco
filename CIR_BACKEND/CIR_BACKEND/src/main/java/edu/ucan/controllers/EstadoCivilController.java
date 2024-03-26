/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.controllers;

import edu.ucan.entities.EstadoCivil;
import edu.ucan.http.RespostaHttp;
import edu.ucan.http.RespostaHttpBuilder;
import edu.ucan.respositories.EstadoCivilRespository;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Isaura
 * Data 28 - 10 - 2023
 * Objectivo : Construir o controller do estado civil 
 * 
 */

@RestController
@RequestMapping(value = "/estado_civil")
@Api(value = "API para criação do estado civil ")
@CrossOrigin(origins = "*")

public class EstadoCivilController {
    
    @Autowired
    private EstadoCivilRespository estadoCivilRespository;
    
    @GetMapping(value = "/find_all_estado_civil")
    public ResponseEntity<RespostaHttp> findAllEstadoCivil() {
        
        List<EstadoCivil> listaDeEstadoCivil = estadoCivilRespository.findAll();
        
        return !listaDeEstadoCivil.isEmpty() ? RespostaHttpBuilder.sucesso("Lista de Estado Civil", listaDeEstadoCivil)
                : RespostaHttpBuilder.naoEncontrado("Nenhum estado encontrado", null);
    }
    
    
}
