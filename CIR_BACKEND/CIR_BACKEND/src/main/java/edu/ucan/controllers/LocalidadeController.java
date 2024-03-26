/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.controllers;

import edu.ucan.entities.Localidade;
import edu.ucan.http.RespostaHttp;
import edu.ucan.http.RespostaHttpBuilder;
import edu.ucan.respositories.LocalidadeRepository;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Isaura
 */

@RestController
@RequestMapping(value = "/localidadeController")
@Api(value = "API para aceder a Localidade")
@CrossOrigin(origins = "*")

public class LocalidadeController {
    
    @Autowired
    LocalidadeRepository localidadeRepository;

    @GetMapping(value = "/find_all_paises")
    public ResponseEntity<RespostaHttp> findAllPaisesOrderByDesignacao() {

        List<Localidade> listaDePaises = localidadeRepository.findAllPaisesOrderByDesignacao();
        return !listaDePaises.isEmpty() ? RespostaHttpBuilder.sucesso("Lista de Paises", listaDePaises)
                : RespostaHttpBuilder.erro("Nenhum pais encontrado", null);

    }

    @GetMapping(value = "/find_all_localidades_by_pklocalidade/{pkPai}")
    public ResponseEntity<RespostaHttp> findAllLocalidadesByPkLocalidadePaiOrderByDesignacao(@PathVariable(value = "pkPai") String pkPai) {

        List<Localidade> listaDePaises = localidadeRepository.findAllLocalidadesByPkLocalidadePaiOrderByDesignacao(pkPai);
        return !listaDePaises.isEmpty() ? RespostaHttpBuilder.sucesso("Lista de Localidade", listaDePaises)
                : RespostaHttpBuilder.erro("Nenhuma Localidade encontrada", null);

    }
    
    
}
