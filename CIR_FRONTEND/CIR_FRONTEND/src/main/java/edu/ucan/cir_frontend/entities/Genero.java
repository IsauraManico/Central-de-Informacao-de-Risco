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
@Table(name = "genero", catalog = "cir_db", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g"),
    @NamedQuery(name = "Genero.findByPkGenero", query = "SELECT g FROM Genero g WHERE g.pkGenero = :pkGenero"),
    @NamedQuery(name = "Genero.findByDescricao", query = "SELECT g FROM Genero g WHERE g.descricao = :descricao")})
public class Genero implements Serializable {

    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String descricao;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_genero", nullable = false)
    private Integer pkGenero;
    @OneToMany(mappedBy = "fkGenero")
    private List<Pessoa> pessoaList;

    public Genero() {
    }

    public Genero(Integer pkGenero) {
        this.pkGenero = pkGenero;
    }

    public Integer getPkGenero() {
        return pkGenero;
    }

    public void setPkGenero(Integer pkGenero) {
        this.pkGenero = pkGenero;
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
        hash += (pkGenero != null ? pkGenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.pkGenero == null && other.pkGenero != null) || (this.pkGenero != null && !this.pkGenero.equals(other.pkGenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ucan.cir_frontend.entities.Genero[ pkGenero=" + pkGenero + " ]";
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
