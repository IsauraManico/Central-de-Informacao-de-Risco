/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucan.cir_frontend.controllers.http.RespostaHttp;
import edu.ucan.cir_frontend.controllers.http.WebClientManagerBean;
import edu.ucan.cir_frontend.entities.Genero;
import edu.ucan.cir_frontend.entities.Nacionalidade;
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
 * Data : 05 - 11 - 2023
 *
 */

@Named(value = "nacionalidadeCache")
@ApplicationScoped

public class NacionalidadeCache implements Serializable {
    
     @Inject
     private WebClientManagerBean webClientManagerBean;
     private Nacionalidade pknaciolidade;
     private List<Nacionalidade> nacionalidadeLista;
     
     
        
    @PostConstruct
    public void init() {
        
       carregarListaDeNacionalidade();
   
    }
    
    
        public void carregarListaDeNacionalidade() {

        try {
            
            
            RespostaHttp response = (RespostaHttp) webClientManagerBean.getSingleEntity("/nacionalidade/find_all_nacionalidade", null,
                    RespostaHttp.class);

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            Nacionalidade [] listaDeNacionalidade = objectMapper.readValue(jsonobject.get("data").toString(), Nacionalidade[].class);

            this.nacionalidadeLista = Arrays.asList(listaDeNacionalidade);
            
            System.out.println("Nacionalidade lista tosTRING "+this.nacionalidadeLista.toString());

        } catch (Exception ex) {
            Logger.getLogger(LocalidadeCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public Nacionalidade getPknaciolidade() {
        return pknaciolidade;
    }

    public void setPknaciolidade(Nacionalidade pknaciolidade) {
        this.pknaciolidade = pknaciolidade;
    }

    public List<Nacionalidade> getNacionalidadeLista() {
        return nacionalidadeLista;
    }

    public void setNacionalidadeLista(List<Nacionalidade> nacionalidadeLista) {
        this.nacionalidadeLista = nacionalidadeLista;
    }
     
     
     
     
     
    
    
    
}
