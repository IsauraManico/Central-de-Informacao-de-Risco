/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.entities;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Isaura
 */
@Entity
@Table(name = "faixa_salarial", catalog = "cir_db", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaixaSalarial.findAll", query = "SELECT f FROM FaixaSalarial f"),
    @NamedQuery(name = "FaixaSalarial.findByPkFaixaSalarial", query = "SELECT f FROM FaixaSalarial f WHERE f.pkFaixaSalarial = :pkFaixaSalarial"),
    @NamedQuery(name = "FaixaSalarial.findByDesignacao", query = "SELECT f FROM FaixaSalarial f WHERE f.designacao = :designacao")})
public class FaixaSalarial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_faixa_salarial", nullable = false)
    private Integer pkFaixaSalarial;
    @Basic(optional = false)
    @Column(name = "designacao", nullable = false, length = 2147483647)
    private String designacao;

    public FaixaSalarial() {
    }

    public FaixaSalarial(Integer pkFaixaSalarial) {
        this.pkFaixaSalarial = pkFaixaSalarial;
    }

    public FaixaSalarial(Integer pkFaixaSalarial, String designacao) {
        this.pkFaixaSalarial = pkFaixaSalarial;
        this.designacao = designacao;
    }

    public Integer getPkFaixaSalarial() {
        return pkFaixaSalarial;
    }

    public void setPkFaixaSalarial(Integer pkFaixaSalarial) {
        this.pkFaixaSalarial = pkFaixaSalarial;
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
        hash += (pkFaixaSalarial != null ? pkFaixaSalarial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaixaSalarial)) {
            return false;
        }
        FaixaSalarial other = (FaixaSalarial) object;
        if ((this.pkFaixaSalarial == null && other.pkFaixaSalarial != null) || (this.pkFaixaSalarial != null && !this.pkFaixaSalarial.equals(other.pkFaixaSalarial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ucan.entities.FaixaSalarial[ pkFaixaSalarial=" + pkFaixaSalarial + " ]";
    }
    
}
