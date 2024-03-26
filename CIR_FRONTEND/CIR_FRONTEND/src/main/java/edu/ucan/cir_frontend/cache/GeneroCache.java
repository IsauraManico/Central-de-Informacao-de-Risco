/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucan.cir_frontend.controllers.http.RespostaHttp;
import edu.ucan.cir_frontend.controllers.http.WebClientManagerBean;
import edu.ucan.cir_frontend.entities.Genero;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author Isaura
 * Data : 03 - 11 - 2023
 * 
 */

@Named(value = "generoCache")
@ApplicationScoped
public class GeneroCache implements Serializable {
    
     @Inject
     private WebClientManagerBean webClientManagerBean;
     private Genero pkgenero;
     private List<Genero> generoLista;

    public GeneroCache() {
    }
    
      
    @PostConstruct
    public void init() {
        
        carregarListaDeGenero();
   
    }
    
    public void carregarListaDeGenero() {

        try {
            
            RespostaHttp response = (RespostaHttp) webClientManagerBean.getSingleEntity("/genero/find_all_genero", null,
                    RespostaHttp.class);

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            Genero [] listaDeGenero = objectMapper.readValue(jsonobject.get("data").toString(), Genero[].class);

            this.generoLista = Arrays.asList(listaDeGenero);
            
            System.out.println("genero lista tosTRING "+this.generoLista.toString());

        } catch (Exception ex) {
            Logger.getLogger(LocalidadeCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Genero getPkgenero() {
        return pkgenero;
    }

    public void setPkgenero(Genero pkgenero) {
        this.pkgenero = pkgenero;
    }

    public List<Genero> getGeneroLista() {
        return generoLista;
    }

    public void setGeneroLista(List<Genero> generoLista) {
        this.generoLista = generoLista;
    }
    
    
    

  
    
}
