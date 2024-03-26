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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Isaura
 */
@Entity
@Table(name = "nacionalidade", catalog = "cir_db", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Nacionalidade.findAll", query = "SELECT n FROM Nacionalidade n"),
    @NamedQuery(name = "Nacionalidade.findByPkNacionalidade", query = "SELECT n FROM Nacionalidade n WHERE n.pkNacionalidade = :pkNacionalidade"),
    @NamedQuery(name = "Nacionalidade.findByDescricao", query = "SELECT n FROM Nacionalidade n WHERE n.descricao = :descricao")})
public class Nacionalidade implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String descricao;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_nacionalidade", nullable = false)
    private Integer pkNacionalidade;
    @OneToMany(mappedBy = "fkNacionalidade")
    private List<Pessoa> pessoaList;

    public Nacionalidade() {
    }

    public Nacionalidade(Integer pkNacionalidade) {
        this.pkNacionalidade = pkNacionalidade;
    }

    public Nacionalidade(Integer pkNacionalidade, String descricao) {
        this.pkNacionalidade = pkNacionalidade;
        this.descricao = descricao;
    }

    public Integer getPkNacionalidade() {
        return pkNacionalidade;
    }

    public void setPkNacionalidade(Integer pkNacionalidade) {
        this.pkNacionalidade = pkNacionalidade;
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
        hash += (pkNacionalidade != null ? pkNacionalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nacionalidade)) {
            return false;
        }
        Nacionalidade other = (Nacionalidade) object;
        if ((this.pkNacionalidade == null && other.pkNacionalidade != null) || (this.pkNacionalidade != null && !this.pkNacionalidade.equals(other.pkNacionalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ucan.cir_frontend.entities.Nacionalidade[ pkNacionalidade=" + pkNacionalidade + " ]";
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
