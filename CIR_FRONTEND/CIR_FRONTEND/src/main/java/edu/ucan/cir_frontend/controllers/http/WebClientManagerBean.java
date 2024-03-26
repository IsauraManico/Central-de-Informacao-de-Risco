/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.controllers.http;

import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

/**
 *
 * @author Isaura
 */
@Named(value = "webClientManagerBean")
@RequestScoped
public class WebClientManagerBean implements Serializable
{

    private WebClient client;   
    private final String BASE_URL = "http://localhost:8088/";

//    @Inject
//    private UsuarioSessaoBean usuarioSessaoBean;

    @PostConstruct
    protected void init()
    {
        try
        {
            this.client = this.criarCliente();
        }
        catch (Exception e)
        {
            this.client = null;
            System.err.println("WebClientManagerBean: init() : " + e.getMessage());
        }
    }

    private ClientHttpConnector connector()
    {
        return new ReactorClientHttpConnector(HttpClient.create(ConnectionProvider.newConnection()));
    }

    private WebClient criarCliente()
    {
     
        return WebClient
            .builder()
            .clientConnector(this.connector())
            .baseUrl(BASE_URL)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();
    }

    public Object getSingleEntity(String url,
        HashMap<String, String> params,
        Class entityClass
    ) throws URISyntaxException, Exception
    {
//        System.err.println( this.usuarioSessaoBean.getTokenAcesso() );

        if (client == null)
        {
            throw new Exception("Cliente não foi inicializado.");
        }

        int contador = 0;
        String parametros = "";
        if (params != null)
        {
            parametros = "?";
            for (Map.Entry<String, String> item : params.entrySet())
            {
                if (contador > 0)
                {
                    parametros += "&";
                }
                parametros += item.getKey() + "=" + item.getValue();
                contador++;
            }
        }

        String token = null;
//        if (this.usuarioSessaoBean.getTokenAcesso() != null)
//        {
//            token = "Bearer " + this.usuarioSessaoBean.getTokenAcesso().getToken();
//        }

        return this.client
            // carrega
            .get()
            .uri(url + parametros)
            // passagem do token para autenticação
            .header("Authorization", token)
            .accept(MediaType.APPLICATION_JSON) 
            // confirmação da requisição
            .retrieve()
            // informaçao da classe q vai ser reconstruída
            .bodyToMono(entityClass)
            // reconstruir o objecto (desserialização)
            .block();
    }

    public Object postSingleEntity(String url, Object object, Class entityClass)
        throws URISyntaxException, Exception
    {
        //System.err.println(this.usuarioSessaoBean.getTokenAcesso());
        if (client == null)
        {
            throw new Exception("Cliente não foi inicializado.");
        }

        String token = null;
//        if (this.usuarioSessaoBean.getTokenAcesso() != null)
//        {
//            token = "Bearer " + this.usuarioSessaoBean.getTokenAcesso().getToken();
//        }

        return this.client
            .post()
            .uri(url)
            .header("Authorization", token)
            .body(Mono.just(object), object.getClass())
            .retrieve()
            .bodyToMono(entityClass)
            .block();
    }

    public Object putSingleEntity(String url,
        HashMap<String, String> params,
        Object body,
        Class entityClass
    ) throws URISyntaxException, Exception
    {
//        System.err.println( this.usuarioSessaoBean.getTokenAcesso() );

        if (client == null)
        {
            throw new Exception("Cliente não foi inicializado.");
        }

        int contador = 0;
        String parametros = "";
        if (params != null)
        {
            parametros = "?";
            for (Map.Entry<String, String> item : params.entrySet())
            {
                if (contador > 0)
                {
                    parametros += "&";
                }
                parametros += item.getKey() + "=" + item.getValue();
                contador++;
            }
        }

        String token = null;
//        if (this.usuarioSessaoBean.getTokenAcesso() != null)
//        {
//            // 888888888888888888888888888888888888888888888888888888 padrao do token
//            token = "Bearer " + this.usuarioSessaoBean.getTokenAcesso().getToken();
//        }

        // 888888888888888888888888888888888888888888888888888888
        return this.client
            .put()
            .uri(url + parametros)
            .header("Authorization", token)
            .accept(MediaType.APPLICATION_JSON)
            .body(Mono.just(body), entityClass)
            .retrieve()
            .bodyToMono(entityClass)
            .block();
    }

    public Object deleteSingleEntity(String url, Object object, Class entityClass)
        throws URISyntaxException, Exception
    {
//        System.err.println(this.usuarioSessaoBean.getTokenAcesso());
        if (client == null)
        {
            throw new Exception("Cliente não foi inicializado.");
        }

        String token = null;
//        if (this.usuarioSessaoBean.getTokenAcesso() != null)
//        {
//            token = "Bearer " + this.usuarioSessaoBean.getTokenAcesso().getToken();
//        }

        return client.
            delete().
            uri(url).
            header("Authorization", token).
            retrieve().
            bodyToMono(entityClass).block();
    }

    public List<Object> getListEntity(String url,
        HashMap<String, String> params,
        Class entityClass)
        throws URISyntaxException, Exception
    {
//        System.err.println(this.usuarioSessaoBean.getTokenAcesso());
        if (client == null)
        {
            throw new Exception("Cliente não foi inicializado.");
        }

        int contador = 0;
        String parametros = "";
        if (params != null)
        {
            parametros = "?";
            for (Map.Entry<String, String> item : params.entrySet())
            {
                if (contador > 0)
                {
                    parametros += "&";
                }
                parametros += item.getKey() + "=" + item.getValue();
            }
        }

        String token = null;
//        if (this.usuarioSessaoBean.getTokenAcesso() != null)
//        {
//            token = "Bearer " + this.usuarioSessaoBean.getTokenAcesso().getToken();
//        }

        return (List) this.client
            .get()
            .uri(url + parametros)
            .header("Authorization", token)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .toEntityList(entityClass)
            .block();
    }

}
