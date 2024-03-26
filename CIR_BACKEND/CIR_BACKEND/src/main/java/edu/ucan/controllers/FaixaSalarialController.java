/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.controllers;


import edu.ucan.entities.FaixaSalarial;
import edu.ucan.http.RespostaHttp;
import edu.ucan.http.RespostaHttpBuilder;
import edu.ucan.respositories.FaixaSalarialRepository;
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
@RequestMapping(value = "/faixa_salarial")
@Api(value = "API para aceder a lista de faixa salarial")
@CrossOrigin(origins = "*")

public class FaixaSalarialController {
    
    
    @Autowired
    private FaixaSalarialRepository faixaSalarialRepository;
    
    @GetMapping(value = "/find_all_faixa_salarial")
    public ResponseEntity<RespostaHttp> findAllGenero()
    {
        
        List <FaixaSalarial> listaDeFaixaSalarial = this.faixaSalarialRepository.findAll();
        
        return !listaDeFaixaSalarial.isEmpty() ? RespostaHttpBuilder.sucesso("Lista de faixas salarial carregada com sucesso", listaDeFaixaSalarial)
                : RespostaHttpBuilder.naoEncontrado("Lista não encontrada", null);
    }
    
    
}
