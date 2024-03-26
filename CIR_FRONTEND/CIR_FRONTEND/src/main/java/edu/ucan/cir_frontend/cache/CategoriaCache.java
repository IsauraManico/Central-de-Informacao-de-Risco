/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucan.cir_frontend.controllers.http.RespostaHttp;
import edu.ucan.cir_frontend.controllers.http.WebClientManagerBean;
import edu.ucan.cir_frontend.entities.Categoria;
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


@Named(value = "categoriaCache")
@ApplicationScoped
public class CategoriaCache {
    
    
    @Inject
     private WebClientManagerBean webClientManagerBean;
     private Categoria pkCategoria;
     private List<Categoria> categoriaLista;

    public CategoriaCache() {
    }
     

      
    @PostConstruct
    public void init() {
        
        carregarListaDeCategoria();
   
    }
    
    public void carregarListaDeCategoria() {

        try {
            
            RespostaHttp response = (RespostaHttp) webClientManagerBean.getSingleEntity("/categoria/find_all_categoria", null,
                    RespostaHttp.class);

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            Categoria [] listaDeCategoria = objectMapper.readValue(jsonobject.get("data").toString(), Categoria[].class);

            this.categoriaLista = Arrays.asList(listaDeCategoria);
            
            System.out.println("Categoria lista tosTRING "+this.categoriaLista.toString());

        } catch (Exception ex) {
            Logger.getLogger(CategoriaCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Categoria getPkCategoria() {
        return pkCategoria;
    }

    public void setPkCategoria(Categoria pkCategoria) {
        this.pkCategoria = pkCategoria;
    }

    public List<Categoria> getCategoriaLista() {
        return categoriaLista;
    }

    public void setCategoriaLista(List<Categoria> categoriaLista) {
        this.categoriaLista = categoriaLista;
    }
    
    
    
    
    
}
