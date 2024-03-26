/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.controllers;

import edu.ucan.entities.Nacionalidade;
import edu.ucan.http.RespostaHttp;
import edu.ucan.http.RespostaHttpBuilder;
import edu.ucan.respositories.NacionalidadeRepository;
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
 * Data : 29 - 10 
 */

@RestController
@RequestMapping(value = "/nacionalidade")
@Api(value ="API para aceder a nacionalidade")
@CrossOrigin(origins = "*")

public class NacionalidadeController {
    
    
    @Autowired
    private NacionalidadeRepository nacionalidadeRepository;
    
    @GetMapping(value = "/find_all_nacionalidade")
    public ResponseEntity<RespostaHttp> findaAllNacionalidade()
    {
        
        List<Nacionalidade> listaDeNacionalidade = this.nacionalidadeRepository.findAll();
        return !listaDeNacionalidade.isEmpty() ? RespostaHttpBuilder.sucesso("Sucesso", listaDeNacionalidade)
                : RespostaHttpBuilder.naoEncontrado("nao encontrado", null);
        
    }

    
}
