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
@Table(name = "estado_civil", catalog = "cir_db", schema = "public")
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e"),
    @NamedQuery(name = "EstadoCivil.findByPkEstadoCivil", query = "SELECT e FROM EstadoCivil e WHERE e.pkEstadoCivil = :pkEstadoCivil"),
    @NamedQuery(name = "EstadoCivil.findByDescricao", query = "SELECT e FROM EstadoCivil e WHERE e.descricao = :descricao")})
public class EstadoCivil implements Serializable {

    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String descricao;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_estado_civil", nullable = false)
    private Integer pkEstadoCivil;
    @OneToMany(mappedBy = "fkEstadoCivil")
    private List<Pessoa> pessoaList;

    public EstadoCivil() {
    }

    public EstadoCivil(Integer pkEstadoCivil) {
        this.pkEstadoCivil = pkEstadoCivil;
    }

    public Integer getPkEstadoCivil() {
        return pkEstadoCivil;
    }

    public void setPkEstadoCivil(Integer pkEstadoCivil) {
        this.pkEstadoCivil = pkEstadoCivil;
    }


    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkEstadoCivil != null ? pkEstadoCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.pkEstadoCivil == null && other.pkEstadoCivil != null) || (this.pkEstadoCivil != null && !this.pkEstadoCivil.equals(other.pkEstadoCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ucan.cir_frontend.entities.EstadoCivil[ pkEstadoCivil=" + pkEstadoCivil + " ]";
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
