/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ucan.cir_frontend.controllers.http.RespostaHttp;
import edu.ucan.cir_frontend.controllers.http.WebClientManagerBean;
import edu.ucan.cir_frontend.entities.Categoria;
import edu.ucan.cir_frontend.entities.Conta;
import edu.ucan.cir_frontend.entities.Produto;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Inject;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author Isaura
 */
@Named(value = "produtoListarBean")
@ViewScoped
public class ProdutoListarBean implements Serializable {

    /**
     * Creates a new instance of ListarProdutoBeans
     */
    @Inject
    private WebClientManagerBean webClientManagerBean;

    private List<Produto> listaDeProdutos;

    // filtros
    private Categoria categoriaSelecionada;
    private Date dataPagamento;
    private Double taxaJuro;
    private int estado;
    private Produto produtoSelecionado;
    private int categoriaRecebida;

    public ProdutoListarBean() {
    }
    
    

    @PostConstruct
    public void init() {

        carregarListaDeProdutos();

    }

    public void carregarListaDeProdutos() {

        try {

            RespostaHttp response = (RespostaHttp) webClientManagerBean.getSingleEntity("/produtoController/find_all_produtos", null,
                    RespostaHttp.class);

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            Produto[] lista_produtos = objectMapper.readValue(jsonobject.get("data").toString(), Produto[].class);

            this.listaDeProdutos = Arrays.asList(lista_produtos);

            System.out.println(" Lista de Produtos tosTRING " + this.listaDeProdutos.toString());

        } catch (Exception ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String conversaoDeData(Date data) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(data);
    }

    public void findAllProdutoByCategoriaAndDataPagamentoAndEstado() {

        try {

            RespostaHttp response;
            System.out.println("DB1");
                
            
            System.out.println(dataPagamento.toString());
        
            

            if (estado == -1) {

                response = (RespostaHttp) webClientManagerBean.getSingleEntity("/produtoController/find_all_produtos_by_categoria_and_dataPagamento" + "/" + categoriaRecebida  + "/" + conversaoDeData(dataPagamento),
                        null, RespostaHttp.class);
                

            } else {

                response = (RespostaHttp) webClientManagerBean.getSingleEntity("/produtoController/find_all_produtos_by_categoria_and_dataPagamento_and_estado" + "/" +  categoriaRecebida + "/" + conversaoDeData(dataPagamento) + "/"
                        + (estado == 1 ? true : false), null,
                        RespostaHttp.class);
            }

            JSONObject jsonobject = new JSONObject(response);
            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.data);

            Produto[] lista_produtos = objectMapper.readValue(jsonobject.get("data").toString(), Produto[].class);

            this.listaDeProdutos = Arrays.asList(lista_produtos);

            System.out.println(" Lista de Produtos tosTRING " + this.listaDeProdutos.toString());

        } catch (Exception ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(List<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getTaxaJuro() {
        return taxaJuro;
    }

    public void setTaxaJuro(Double taxaJuro) {
        this.taxaJuro = taxaJuro;
    }

    public int getCategoriaRecebida() {
        return categoriaRecebida;
    }

    public void setCategoriaRecebida(int categoriaRecebida) {
        this.categoriaRecebida = categoriaRecebida;
    }
    
    

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public Categoria getCategoriaSelecionada() {
        return categoriaSelecionada;
    }

    public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
        this.categoriaSelecionada = categoriaSelecionada;
    }
    
    

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

}
