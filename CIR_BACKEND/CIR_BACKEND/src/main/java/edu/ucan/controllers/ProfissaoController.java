/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.controllers;

import edu.ucan.entities.Genero;
import edu.ucan.entities.Profissao;
import edu.ucan.http.RespostaHttp;
import edu.ucan.http.RespostaHttpBuilder;
import edu.ucan.respositories.ProfissaoRepository;
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
 * Data 11/11/2023
 */
@RestController
@RequestMapping(value = "/profissao")
@Api(value = "API para aceder o genero")
@CrossOrigin(origins = "*")


public class ProfissaoController {
    
    @Autowired
    private ProfissaoRepository profissaoRepository;
    
     @GetMapping(value = "/find_all_profissao")
    public ResponseEntity<RespostaHttp> findAllProfissao()
    {
        
        List <Profissao> listaDeProfissao = this.profissaoRepository.findAll();
        
        return !listaDeProfissao.isEmpty() ? RespostaHttpBuilder.sucesso("Lista Carregada com sucesso", listaDeProfissao)
                : RespostaHttpBuilder.naoEncontrado("Lista não encontrada", null);
    }
    
}
