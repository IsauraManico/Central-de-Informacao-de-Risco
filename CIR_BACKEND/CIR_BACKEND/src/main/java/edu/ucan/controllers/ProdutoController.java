/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.controllers;

import edu.ucan.entities.Produto;

import edu.ucan.http.RespostaHttp;
import edu.ucan.http.RespostaHttpBuilder;
import edu.ucan.respositories.ProdutoRepository;
import io.swagger.annotations.Api;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Isaura
 */
@RequestMapping(value = "/produtoController")
@RestController
@Api(value = "Produto Controller")
@CrossOrigin(origins = "*")

public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping(value = "/produto_cadastrar")
    public ResponseEntity<RespostaHttp> cadastrarProduto(@RequestBody Produto produto) {

        System.out.println("Entrei 11");

        produto.setDataCadastro(new Date());
        produto.setEstado(Boolean.TRUE);

        produto = produtoRepository.save(produto);

        if (produto != null) {

            System.out.println(produto.toString());
            return RespostaHttpBuilder.sucesso("Produto Criado com sucesso", produto);

        }

        return RespostaHttpBuilder.erro("Erro ao criar o produto", null);

    }

    // Método para listar todos os produtos 
    @GetMapping(value = "/find_all_produtos")
    public ResponseEntity<RespostaHttp> findAllProdutos() {

        List<Produto> listaDeProdutos = this.produtoRepository.findAll();

        return !listaDeProdutos.isEmpty() ? RespostaHttpBuilder.sucesso("Lista de Produtos", listaDeProdutos)
                : RespostaHttpBuilder.naoEncontrado("Nenhum Produto encontrado", null);
    }

    

}
