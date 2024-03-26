/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Isaura
 */
@Entity
@Table(name = "categoria", catalog = "cir_db", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByPkCategoria", query = "SELECT c FROM Categoria c WHERE c.pkCategoria = :pkCategoria"),
    @NamedQuery(name = "Categoria.findByDesignacao", query = "SELECT c FROM Categoria c WHERE c.designacao = :designacao")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_categoria", nullable = false)
    private Integer pkCategoria;
    @Size(max = 2147483647)
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
        return "edu.ucan.cir_frontend.entities.Categoria[ pkCategoria=" + pkCategoria + " ]";
    }
    
}
