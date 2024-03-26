/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.controllers.http;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Isaura
 */
public class RespostaHttpBuilder
{

    public static ResponseEntity<RespostaHttp> sucesso(String mensagem,
        Object informacao)
    {
        RespostaHttp response = new RespostaHttp();
        response.code = HttpStatus.OK.value();
        response.message = mensagem;
        response.status = HttpStatus.OK;
        response.data = informacao;
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public static ResponseEntity<RespostaHttp> erro(String mensagem,
        Object informacao)
    {
        RespostaHttp response = new RespostaHttp();
        response.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        response.message = mensagem;
        response.status = HttpStatus.INTERNAL_SERVER_ERROR;
        response.data = informacao;
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
            body(response);
    }

    public static ResponseEntity<RespostaHttp> naoEncontrado(String mensagem,
        Object informacao)
    {
        RespostaHttp response = new RespostaHttp();
        response.code = HttpStatus.NOT_FOUND.value();
        response.message = mensagem;
        response.status = HttpStatus.NOT_FOUND;
        response.data = informacao;
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    public static ResponseEntity<RespostaHttp> naoPermitido(String mensagem,
        Object informacao)
    {
        RespostaHttp response = new RespostaHttp();
        response.code = HttpStatus.FORBIDDEN.value();
        response.message = mensagem;
        response.status = HttpStatus.FORBIDDEN;
        response.data = informacao;
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    public static Map<String, Object> toMap(ResponseEntity<?> entity)
    {
        RespostaHttp resposta = (RespostaHttp) entity.getBody();
        HashMap<String, Object> hash = new LinkedHashMap<>();
        hash.put("code", resposta.code);
        hash.put("message", resposta.message);
        hash.put("status", resposta.status);
        hash.put("data", resposta.data);
        return hash;
    }
}
