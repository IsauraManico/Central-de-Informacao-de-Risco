/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.controllers;

import edu.ucan.entities.Genero;
import edu.ucan.http.RespostaHttp;
import edu.ucan.http.RespostaHttpBuilder;
import edu.ucan.respositories.GeneroRepository;
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
 */

@RestController
@RequestMapping(value = "/genero")
@Api(value = "API para aceder o genero")
@CrossOrigin(origins = "*")

public class GeneroController {
    
    @Autowired
    private GeneroRepository generoRepository;
    
    @GetMapping(value = "/find_all_genero")
    public ResponseEntity<RespostaHttp> findAllGenero()
    {
        
        List <Genero> listaDeGenero = this.generoRepository.findAll();
        
        return !listaDeGenero.isEmpty() ? RespostaHttpBuilder.sucesso("Lista Carregada com sucesso", listaDeGenero)
                : RespostaHttpBuilder.naoEncontrado("Lista não encontrada", null);
    }
    
 
}
