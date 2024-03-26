/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucan.cir_frontend.controllers.http.RespostaHttp;
import edu.ucan.cir_frontend.controllers.http.WebClientManagerBean;
import edu.ucan.cir_frontend.entities.Produto;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author Isaura
 */
@Named(value = "produtoCadastrarBean")
@ViewScoped
public class ProdutoCadastrarBean implements Serializable {

    /**
     * Creates a new instance of ProdutoCadastrarBean
     */
    @Inject
    private WebClientManagerBean webClientManagerBean;

    private Produto produto;
    private List<Produto> listaDeProdutos;
    
    FacesContext context = FacesContext.getCurrentInstance();
    ExternalContext externalContext = context.getExternalContext();

    public ProdutoCadastrarBean() {
    }

    @PostConstruct
    public void init() {

       
        novoProduto();

    }

    private void novoProduto() {
        produto = new Produto();
    }

    // Método que salva 
    public void salvar() {

        System.out.println("entrei");
        try {

            RespostaHttp response = (RespostaHttp) webClientManagerBean.postSingleEntity("/produtoController/produto_cadastrar", produto,
                    RespostaHttp.class);

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(" DB1 " + response.data);
            System.out.println(response.getMessage());
          
            Produto[] produtos = objectMapper.readValue(jsonobject.get("data").toString(), Produto[].class);
            
            System.out.println("DB2");

            List<Produto>  produtoRecebido = Arrays.asList(produtos);
            System.out.println("DB4");
            
            System.out.println("Produto Recebido > " + produtoRecebido.toString());
            
            if (produtoRecebido != null) {
                
                System.out.println("Produto criado com sucesso");
                
                externalContext.redirect("/CIR_FRONTEND-1.0-SNAPSHOT/produto/produto.xhtml");
            } else {
                System.out.println("ERRO ao criar o produto");
            }

        } catch (Exception ex) {
            Logger.getLogger(ProdutoCadastrarBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
