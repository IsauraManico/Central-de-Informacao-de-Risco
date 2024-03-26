/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Isaura
 */
@Entity
@Table(name = "categoria", catalog = "cir_db", schema = "public")
@XmlRootElement

public class Categoria implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCategoria")
    @JsonIgnore
    private List<Produto> produtoList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_categoria", nullable = false)
    private Integer pkCategoria;
    @Column(name = "designacao", length = 2147483647)

    private String designacao;

    public Categoria() {
    }

    public Categoria(Integer pkCategoria) {
        this.pkCategoria = pkCategoria;
    }

    public Integer getPkCategoria() {
        return pkCategoria;
    }

    public void setPkCategoria(Integer pkCategoria) {
        this.pkCategoria = pkCategoria;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCategoria != null ? pkCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.pkCategoria == null && other.pkCategoria != null) || (this.pkCategoria != null && !this.pkCategoria.equals(other.pkCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ucan.entities.Categoria[ pkCategoria=" + pkCategoria + " ]";
    }

    @XmlTransient
    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }
    
 
    
}
