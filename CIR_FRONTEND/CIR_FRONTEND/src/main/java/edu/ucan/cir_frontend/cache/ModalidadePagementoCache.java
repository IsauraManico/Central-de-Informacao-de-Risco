/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucan.cir_frontend.controllers.http.RespostaHttp;
import edu.ucan.cir_frontend.controllers.http.WebClientManagerBean;
import edu.ucan.cir_frontend.entities.ModalidadePagemento;
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
@Named(value = "modalidadePagamentoCache")
@ApplicationScoped
public class ModalidadePagementoCache implements Serializable {

    @Inject
    private WebClientManagerBean webClientManagerBean;

    private int pk_modalidade_pagamento;
    private List<ModalidadePagemento> modalidadePagementaLista;

    public ModalidadePagementoCache() {
    }
    

    @PostConstruct
    public void init() {
        
        carregarListaDeModalidadeDePagamento();
   
    }
    
    public void carregarListaDeModalidadeDePagamento() {

        try {
            RespostaHttp response = (RespostaHttp) webClientManagerBean.getSingleEntity("/modalidade_pagemento/find_all_modalidade_pagamento", null,
                    RespostaHttp.class);

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            ModalidadePagemento [] listaDeModalidadeDePagamento = objectMapper.readValue(jsonobject.get("data").toString(), ModalidadePagemento[].class);

            this.modalidadePagementaLista = Arrays.asList(listaDeModalidadeDePagamento);
            
            System.out.println(" Lista de Modalidade de Pagamento tosTRING "+this.modalidadePagementaLista.toString());

        } catch (Exception ex) {
            Logger.getLogger(ModalidadePagementoCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getPk_modalidade_pagamento() {
        return pk_modalidade_pagamento;
    }

    public void setPk_modalidade_pagamento(int pk_modalidade_pagamento) {
        this.pk_modalidade_pagamento = pk_modalidade_pagamento;
    }

    public List<ModalidadePagemento> getModalidadePagementaLista() {
        return modalidadePagementaLista;
    }

    public void setModalidadePagementaLista(List<ModalidadePagemento> modalidadePagementaLista) {
        this.modalidadePagementaLista = modalidadePagementaLista;
    }
    
    
    

    
    
    
    
    

    
}
