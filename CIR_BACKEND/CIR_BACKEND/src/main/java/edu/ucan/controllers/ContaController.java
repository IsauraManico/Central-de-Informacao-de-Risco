/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.controllers;

import edu.ucan.entities.Conta;
import edu.ucan.entities.HistoricoProfissional;
import edu.ucan.entities.Pessoa;
import edu.ucan.http.RespostaHttp;
import edu.ucan.http.RespostaHttpBuilder;
import edu.ucan.respositories.ContaRepository;
import edu.ucan.respositories.HistoricoProfissionalRepository;
import edu.ucan.respositories.PessoaRepository;
import io.swagger.annotations.Api;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Isaura Data : 30 - 10 - 2023 Objejctivo : O conta controller
 */
@RequestMapping(value = "/contaController")
@RestController
@Api(value = "Conta Controller")
@CrossOrigin(origins = "*")

public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private HistoricoProfissionalRepository historicoProfissionalRepository;
    
    

    @PostMapping(value = "/conta_cadastrar")
    public ResponseEntity<RespostaHttp> cadastrarConta(@RequestBody Conta conta) {

        if (cadastrarPessoa(conta.getFkPessoa())) {
            

            conta.setDataCadastro(new Date());
            conta.setEstado(Boolean.TRUE);

            conta = contaRepository.save(conta);

            if (conta != null) {
                return RespostaHttpBuilder.sucesso("Conta Criada com sucesso", conta);
            }

            pessoaRepository.delete(conta.getFkPessoa());

        }

        return RespostaHttpBuilder.erro("Erro ao criar conta", null);
    }

    @GetMapping(value = "/find_all_contas")
    public ResponseEntity< RespostaHttp> findAllConta() {
        List<Conta> listaDeContas = this.contaRepository.findAll();

        return !listaDeContas.isEmpty() ? RespostaHttpBuilder.sucesso("Contas encontradas", listaDeContas)
                : RespostaHttpBuilder.naoEncontrado("Lista nao encontrada", null);

    }

    private boolean cadastrarPessoa(Pessoa pessoa) {
        pessoa = pessoaRepository.save(pessoa);
        return pessoa != null;
    }

    private boolean cadastrarHistoricoProfissional(HistoricoProfissional historicoProfissional) {

        historicoProfissional = historicoProfissionalRepository.save(historicoProfissional);
        return historicoProfissional != null;

    }

}
