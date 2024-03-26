/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucan.cir_frontend.controllers.http.RespostaHttp;
import edu.ucan.cir_frontend.controllers.http.WebClientManagerBean;
import edu.ucan.cir_frontend.entities.Localidade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.shaded.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@Named(value = "localidadeCache")
@ApplicationScoped
public class LocalidadeCache implements Serializable {

    @Inject
    private WebClientManagerBean webClientManagerBean;

    private List<Localidade> listaDePaises;
    private List<Localidade> listaDeProvincias;
    private List<Localidade> listaDeMunicipios;

    private String paisSelecionado;
    private String provinciaSelecionada;
    private String municipiosSelecionado;

    
    @PostConstruct
    public void init() {
        
        
        
       carregarPaises();

        if (!listaDePaises.isEmpty()) {
            paisSelecionado = listaDePaises.get(0).getPkLocalidade();
            carregarProvinciasByPaisSelecionado();

        }

    }

    public void carregarPaises() {
        
        this.listaDePaises = new ArrayList<>();

        try {
           
            System.out.println("DB1: ");
            
            RespostaHttp response = (RespostaHttp) webClientManagerBean.getSingleEntity("/localidadeController/find_all_paises", null,
                    RespostaHttp.class);
             System.out.println("DB2: ");

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            Localidade[] localidades = objectMapper.readValue(jsonobject.get("data").toString(), Localidade[].class);

             System.out.println("DB3: ");
            this.listaDePaises = Arrays.asList(localidades);

        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }

    public void carregarProvinciasByPaisSelecionado() {

        System.out.println("Entrei");
        this.listaDeProvincias = carregarLocalidadeByPkLocalidadePai(paisSelecionado);
        if (!listaDeProvincias.isEmpty()) {
            provinciaSelecionada = listaDeProvincias.get(0).getPkLocalidade();
            carregarMunicipioByProvinciaSelecionado();
        }

    }

    public void carregarMunicipioByProvinciaSelecionado() {

        System.out.println("Entrei3");
        this.listaDeMunicipios = carregarLocalidadeByPkLocalidadePai(provinciaSelecionada);
        
    }

    private List<Localidade> carregarLocalidadeByPkLocalidadePai(String pkPai) {

        try {

            RespostaHttp response = (RespostaHttp) webClientManagerBean.getSingleEntity("/localidadeController/find_all_localidades_by_pklocalidade/" + pkPai, null,
                    RespostaHttp.class);

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            Localidade[] localidades = objectMapper.readValue(jsonobject.get("data").toString(), Localidade[].class);

            List<Localidade> tmp = new ArrayList<>();
            
            tmp = Arrays.asList(localidades);
            
            return tmp != null ? tmp : new ArrayList<>();

        } catch (Exception ex) {
            
            Logger.getLogger(LocalidadeCache.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public List<Localidade> getListaDePaises() {
        
        return listaDePaises;
    }

    public void setListaDePaises(List<Localidade> listaDePaises) {
        
        this.listaDePaises = listaDePaises;
    }

    public List<Localidade> getListaDeProvincias() {
        
        return listaDeProvincias;
    }

    public void setListaDeProvincias(List<Localidade> listaDeProvincias) {
        
        this.listaDeProvincias = listaDeProvincias;
    }

    public List<Localidade> getListaDeMunicipios() {
        
        return listaDeMunicipios;
    }

    public void setListaDeMunicipios(List<Localidade> listaDeMunicipios) {
        
        this.listaDeMunicipios = listaDeMunicipios;
    }

    public String getPaisSelecionado() {
        
        return paisSelecionado;
    }

    public void setPaisSelecionado(String paisSelecionado) {
        
        this.paisSelecionado = paisSelecionado;
    }

    public String getProvinciaSelecionada() {
        return provinciaSelecionada;
    }

    public void setProvinciaSelecionada(String provinciaSelecionada) {
        
        this.provinciaSelecionada = provinciaSelecionada;
    }

    public String getMunicipiosSelecionado() {
        return municipiosSelecionado;
    }

    public void setMunicipiosSelecionado(String municipiosSelecionado) {
        this.municipiosSelecionado = municipiosSelecionado;
    }

}
