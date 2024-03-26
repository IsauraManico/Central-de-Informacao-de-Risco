/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.ucan.cir_frontend.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucan.cir_frontend.controllers.http.RespostaHttp;
import edu.ucan.cir_frontend.controllers.http.WebClientManagerBean;
import edu.ucan.cir_frontend.entities.EstadoCivil;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author Isaura
 */
@Named(value = "estadoCivilCache")
@ApplicationScoped
public class EstadoCivilCache implements Serializable {
    
   
   @Inject
   private WebClientManagerBean webClientManagerBean;
   
   private int pk_estado_civil;
   private List<EstadoCivil> estadoCilvilLista;
   

    /**
     * Creates a new instance of EstadoCivilBean
     */
    public EstadoCivilCache() {
    }
    
      @PostConstruct
    public void init() {
        
        carregarListaDeEstadoCivil();
   
    }
    
    public void carregarListaDeEstadoCivil() {

        try {
            RespostaHttp response = (RespostaHttp) webClientManagerBean.getSingleEntity("/estado_civil/find_all_estado_civil", null,
                    RespostaHttp.class);

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            EstadoCivil [] listaEstadoCivil = objectMapper.readValue(jsonobject.get("data").toString(), EstadoCivil[].class);

            this.estadoCilvilLista = Arrays.asList(listaEstadoCivil);
            
            System.out.println(" Lista de estados civis tosTRING "+this.estadoCilvilLista.toString());

        } catch (Exception ex) {
            Logger.getLogger(LocalidadeCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    

 
    public int getPk_estado_civil() {
        return pk_estado_civil;
    }

    public void setPk_estado_civil(int pk_estado_civil) {
        this.pk_estado_civil = pk_estado_civil;
    }

    public List<EstadoCivil> getEstadoCilvilLista() {
        return estadoCilvilLista;
    }

    public void setEstadoCilvilLista(List<EstadoCivil> estadoCilvilLista) {
        this.estadoCilvilLista = estadoCilvilLista;
    }
    
    
    
    
    
    
    
    
}
