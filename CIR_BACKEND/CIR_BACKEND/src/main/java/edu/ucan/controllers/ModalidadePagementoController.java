/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.controllers;

import edu.ucan.entities.ModalidadePagemento;
import edu.ucan.http.RespostaHttp;
import edu.ucan.http.RespostaHttpBuilder;
import edu.ucan.respositories.ModalidadePagementoRepository;
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
 * Data 21 - 11 - 2023
 */

@RestController
@RequestMapping(value = "/modalidade_pagemento")
@Api(value = "API para criação da modalidade de pagamento ")
@CrossOrigin(origins = "*")
public class ModalidadePagementoController {
    
    @Autowired
    private ModalidadePagementoRepository modalidadePagementoRepository; 
    
    @GetMapping(value = "/find_all_modalidade_pagamento")
    public ResponseEntity<RespostaHttp> findAllModalidadeDePagamento() {
        
        List<ModalidadePagemento> listaDeModalidadesDePagamento = modalidadePagementoRepository.findAll();
        
        return !listaDeModalidadesDePagamento.isEmpty() ? RespostaHttpBuilder.sucesso("Lista de Modalidade não encontradas", listaDeModalidadesDePagamento)
                : RespostaHttpBuilder.naoEncontrado("Nenhum Modalidade encontrada", null);
    }
    
    
    
}
