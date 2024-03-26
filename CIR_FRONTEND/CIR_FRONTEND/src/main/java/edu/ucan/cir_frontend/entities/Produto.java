/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Isaura
 */
@Entity
@Table(name = "produto", catalog = "cir_db", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByPkProduto", query = "SELECT p FROM Produto p WHERE p.pkProduto = :pkProduto"),
    @NamedQuery(name = "Produto.findByDesignacao", query = "SELECT p FROM Produto p WHERE p.designacao = :designacao"),
    @NamedQuery(name = "Produto.findByTaxaJuro", query = "SELECT p FROM Produto p WHERE p.taxaJuro = :taxaJuro"),
    @NamedQuery(name = "Produto.findByDataCadastro", query = "SELECT p FROM Produto p WHERE p.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "Produto.findByEstado", query = "SELECT p FROM Produto p WHERE p.estado = :estado")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_produto", nullable = false)
    private Integer pkProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "designacao", nullable = false, length = 2147483647)
    private String designacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "taxa_juro", precision = 17, scale = 17)
    private Double taxaJuro;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "fk_categoria", referencedColumnName = "pk_categoria", nullable = false)
    @ManyToOne(optional = false)
    private Categoria fkCategoria;
    @JoinColumn(name = "fk_modalidade_pagemento", referencedColumnName = "pk_modalidade_pagemento")
    @ManyToOne
    private ModalidadePagemento fkModalidadePagemento;

    public Produto() {
    }

    public Produto(Integer pkProduto) {
        this.pkProduto = pkProduto;
    }

    public Produto(Integer pkProduto, String designacao) {
        this.pkProduto = pkProduto;
        this.designacao = designacao;
    }

    public Integer getPkProduto() {
        return pkProduto;
    }

    public void setPkProduto(Integer pkProduto) {
        this.pkProduto = pkProduto;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public Double getTaxaJuro() {
        return taxaJuro;
    }

    public void setTaxaJuro(Double taxaJuro) {
        this.taxaJuro = taxaJuro;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getFkCategoria() {
        return fkCategoria;
    }

    public void setFkCategoria(Categoria fkCategoria) {
        this.fkCategoria = fkCategoria;
    }

    public ModalidadePagemento getFkModalidadePagemento() {
        return fkModalidadePagemento;
    }

    public void setFkModalidadePagemento(ModalidadePagemento fkModalidadePagemento) {
        this.fkModalidadePagemento = fkModalidadePagemento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProduto != null ? pkProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.pkProduto == null && other.pkProduto != null) || (this.pkProduto != null && !this.pkProduto.equals(other.pkProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ucan.cir_frontend.entities.Produto[ pkProduto=" + pkProduto + " ]";
    }
    
}
