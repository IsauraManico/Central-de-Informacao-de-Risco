/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucan.cir_frontend.controllers.http.RespostaHttp;
import edu.ucan.cir_frontend.controllers.http.WebClientManagerBean;
import edu.ucan.cir_frontend.entities.Profissao;
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
 */


@Named(value = "profissaoCache")
@ApplicationScoped
public class ProfissaoCache implements Serializable {
    
    @Inject
     private WebClientManagerBean webClientManagerBean;
     private Profissao pkProfissao;
     private List<Profissao> profissaoLista;
     

    public ProfissaoCache() {
    }

    
      
    @PostConstruct
    public void init() {
        
        carregarListaDeProfissao();
   
    }
    
    public void carregarListaDeProfissao() {

        try {
            
            RespostaHttp response = (RespostaHttp) webClientManagerBean.getSingleEntity("/profissao/find_all_profissao", null,
                    RespostaHttp.class);

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            Profissao [] listaDeProfissao = objectMapper.readValue(jsonobject.get("data").toString(), Profissao[].class);

            this.profissaoLista = Arrays.asList(listaDeProfissao);
            
            System.out.println(" lista de profissao tosTRING "+this.profissaoLista.toString());

        } catch (Exception ex) {
            Logger.getLogger(LocalidadeCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Profissao getPkProfissao() {
        return pkProfissao;
    }

    public void setPkProfissao(Profissao pkProfissao) {
        this.pkProfissao = pkProfissao;
    }

    public List<Profissao> getProfissaoLista() {
        return profissaoLista;
    }

    public void setProfissaoLista(List<Profissao> profissaoLista) {
        this.profissaoLista = profissaoLista;
    }
    
    
    


    
    
    
    
}
