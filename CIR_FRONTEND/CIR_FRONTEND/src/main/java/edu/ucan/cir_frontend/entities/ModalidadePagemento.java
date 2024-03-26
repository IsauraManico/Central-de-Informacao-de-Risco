/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Isaura
 */
@Entity
@Table(name = "modalidade_pagemento", catalog = "cir_db", schema = "public")
@NamedQueries({
    @NamedQuery(name = "ModalidadePagemento.findAll", query = "SELECT m FROM ModalidadePagemento m"),
    @NamedQuery(name = "ModalidadePagemento.findByPkModalidadePagemento", query = "SELECT m FROM ModalidadePagemento m WHERE m.pkModalidadePagemento = :pkModalidadePagemento"),
    @NamedQuery(name = "ModalidadePagemento.findByValor", query = "SELECT m FROM ModalidadePagemento m WHERE m.valor = :valor"),
    @NamedQuery(name = "ModalidadePagemento.findByDesignacao", query = "SELECT m FROM ModalidadePagemento m WHERE m.designacao = :designacao")})
public class ModalidadePagemento implements Serializable {

    @Size(max = 2147483647)
    @Column(name = "designacao", length = 2147483647)
    private String designacao;
    @OneToMany(mappedBy = "fkModalidadePagemento")
    private List<Produto> produtoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_modalidade_pagemento", nullable = false)
    private Integer pkModalidadePagemento;
    @Column(name = "valor")
    private Integer valor;

    public ModalidadePagemento() {
    }

    public ModalidadePagemento(Integer pkModalidadePagemento) {
        this.pkModalidadePagemento = pkModalidadePagemento;
    }

    public Integer getPkModalidadePagemento() {
        return pkModalidadePagemento;
    }

    public void setPkModalidadePagemento(Integer pkModalidadePagemento) {
        this.pkModalidadePagemento = pkModalidadePagemento;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkModalidadePagemento != null ? pkModalidadePagemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModalidadePagemento)) {
            return false;
        }
        ModalidadePagemento other = (ModalidadePagemento) object;
        if ((this.pkModalidadePagemento == null && other.pkModalidadePagemento != null) || (this.pkModalidadePagemento != null && !this.pkModalidadePagemento.equals(other.pkModalidadePagemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ucan.cir_frontend.entities.ModalidadePagemento[ pkModalidadePagemento=" + pkModalidadePagemento + " ]";
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }
    
}
