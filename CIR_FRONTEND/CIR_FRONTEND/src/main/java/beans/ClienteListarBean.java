/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucan.cir_frontend.cache.LocalidadeCache;
import edu.ucan.cir_frontend.controllers.http.RespostaHttp;
import edu.ucan.cir_frontend.controllers.http.WebClientManagerBean;
import edu.ucan.cir_frontend.entities.Conta;
import edu.ucan.cir_frontend.utils.Mensagem;
import javax.inject.Named;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author Isaura
 */
@Named(value = "clienteListarBean")
@ViewScoped
public class ClienteListarBean implements Serializable {

    /**
     * Creates a new instance of ClienteListarBean
     */
    @Inject
    private WebClientManagerBean webClientManagerBean;

    private List<Conta> listaDeClientes;

    public ClienteListarBean() {
    }

    @PostConstruct
    public void init() {

        carregarListaDeClientes();

    }

    public void carregarListaDeClientes() {

        try {

            RespostaHttp response = (RespostaHttp) webClientManagerBean.getSingleEntity("/contaController/find_all_contas", null,
                    RespostaHttp.class);

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            Conta[] lista_conta = objectMapper.readValue(jsonobject.get("data").toString(), Conta[].class);

            sleep(1000);

            this.listaDeClientes = Arrays.asList(lista_conta);

            System.out.println(" Lista de Clientes tosTRING " + this.listaDeClientes.toString());

        } catch (Exception ex) {
            Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public void clienteDesativar(Conta conta) {

        try {

            sleep(1000);
            RespostaHttp response = (RespostaHttp) webClientManagerBean.postSingleEntity("/contaController/conta_desativar", conta,
                    RespostaHttp.class);

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            Conta[] contaLista = objectMapper.readValue(jsonobject.get("data").toString(), Conta[].class);

            listaDeClientes = Arrays.asList(contaLista);
            Mensagem.sucessoMsg("Status OK", "Cliente Desactivado");

        } catch (Exception ex) {

            Logger.getLogger(LocalidadeCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clienteActivar(Conta conta) {

        try {

            RespostaHttp response = (RespostaHttp) webClientManagerBean.postSingleEntity("/contaController/conta_activar", conta,
                    RespostaHttp.class);

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            Conta[] contaLista = objectMapper.readValue(jsonobject.get("data").toString(), Conta[].class);

            listaDeClientes = Arrays.asList(contaLista);
            Mensagem.sucessoMsg("Status OK", "Cliente Activado");

        } catch (Exception ex) {

            Logger.getLogger(LocalidadeCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Conta> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(List<Conta> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

}
