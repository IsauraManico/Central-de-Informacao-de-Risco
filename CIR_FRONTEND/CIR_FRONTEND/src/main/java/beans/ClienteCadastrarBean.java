/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucan.cir_frontend.cache.LocalidadeCache;
import edu.ucan.cir_frontend.controllers.http.RespostaHttp;
import edu.ucan.cir_frontend.controllers.http.WebClientManagerBean;
import edu.ucan.cir_frontend.entities.Cliente;
import edu.ucan.cir_frontend.entities.Conta;
import edu.ucan.cir_frontend.entities.HistoricoProfissional;
import edu.ucan.cir_frontend.entities.Pessoa;
import edu.ucan.cir_frontend.entities.Profissao;
import javax.inject.Named;

import java.io.Serializable;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author Isaura Data : 08 - 08 - 2023
 */
@Named(value = "clienteCadastrarBean")
@ViewScoped
public class ClienteCadastrarBean implements Serializable {

    /**
     * Creates a new instance of ClienteCadastrarBean
     */
    @Inject
    private WebClientManagerBean webClientManagerBean;

    private Pessoa pessoa;
    private Conta conta;
    private HistoricoProfissional historicoProfissional;
    private Cliente cliente;
    private Profissao profissao;

    public ClienteCadastrarBean() {
    }

    @PostConstruct
    public void init() {

        novaPessoa();
        novaConta();
        novoCliente();
        novaProfissao();
     
    }

    private void novaPessoa(){
        
        pessoa = new Pessoa();
    }
    
    private void novoCliente(){
        
        cliente = new Cliente();
        
    }

   
    private void novoHistoricoProfissional()
    {
        historicoProfissional = new HistoricoProfissional();
        historicoProfissional.setFkCliente(cliente);
    }
    

    
    private void novaProfissao(){
        
        profissao = new Profissao();
    }

    private void novaConta() {

        conta = new Conta();
        conta.setFkPessoa(pessoa);

    }

    // Método que salva 
    public void salvar() {

        try {
            
            System.out.println("Entrei agora");
           

            RespostaHttp response = (RespostaHttp) webClientManagerBean.postSingleEntity("/contaController/conta_cadastrar", conta,
                    RespostaHttp.class);

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            Conta[] conta = objectMapper.readValue(jsonobject.get("data").toString(), Conta[].class);

            Conta contaRecebida = Arrays.asList(conta).get(0);
            System.out.println("contaRecebida > " + contaRecebida.toString());
            if (contaRecebida != null) {
                System.out.println("CONTA CRIADA");
            } else {
                System.out.println("ERRO AO CRAIR CONTA CONTA");
            }

        } catch (Exception ex) {
            Logger.getLogger(LocalidadeCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

 
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public HistoricoProfissional getHistoricoProfissional() {
        return historicoProfissional;
    }

    public void setHistoricoProfissional(HistoricoProfissional historicoProfissional) {
        this.historicoProfissional = historicoProfissional;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    
   
}
