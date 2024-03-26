/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.controllers;

import edu.ucan.entities.Categoria;
import edu.ucan.entities.Genero;
import edu.ucan.http.RespostaHttp;
import edu.ucan.http.RespostaHttpBuilder;
import edu.ucan.respositories.CategoriaRepository;
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
 * Data 13 - 11 - 2023
 */

@RestController
@RequestMapping(value = "/categoria")
@Api(value = "API para aceder a categoria")
@CrossOrigin(origins = "*")

public class CategoriaController {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
        @GetMapping(value = "/find_all_categoria")
    public ResponseEntity<RespostaHttp> findAllCategoria()
    {
        
        List <Categoria> listaDeCategoria = this.categoriaRepository.findAll();
        
        return !listaDeCategoria.isEmpty() ? RespostaHttpBuilder.sucesso("Lista Carregada com sucesso", listaDeCategoria)
                : RespostaHttpBuilder.naoEncontrado("Lista não encontrada", null);
    }
    
    
}
