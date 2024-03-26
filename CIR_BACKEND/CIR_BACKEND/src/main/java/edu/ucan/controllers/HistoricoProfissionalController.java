/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.controllers;

import edu.ucan.entities.Genero;
import edu.ucan.entities.HistoricoProfissional;
import edu.ucan.http.RespostaHttp;
import edu.ucan.http.RespostaHttpBuilder;
import edu.ucan.respositories.HistoricoProfissionalRepository;
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
 * Data 
 */

@RestController
@RequestMapping(value = "/historico_profissional")
@Api(value = "API para aceder o ")
@CrossOrigin(origins = "*")
public class HistoricoProfissionalController {
    
    
    @Autowired
    private HistoricoProfissionalRepository historicoProfissionalRepository;
    
     @GetMapping(value = "/find_all_historico_profissional")
    public ResponseEntity<RespostaHttp> findAllHistoricoProfissional()
    {
        
        List <HistoricoProfissional> listaDeHistoricoProfissional = this.historicoProfissionalRepository.findAll();
        
        return !listaDeHistoricoProfissional.isEmpty() ? RespostaHttpBuilder.sucesso("Lista de historico profissional Carregada com sucesso", listaDeHistoricoProfissional)
                : RespostaHttpBuilder.naoEncontrado("Lista não encontrada", null);
    }
    
    
    
    
}
