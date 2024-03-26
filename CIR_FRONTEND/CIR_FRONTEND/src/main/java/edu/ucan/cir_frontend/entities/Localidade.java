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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "localidade", catalog = "cir_db", schema = "public")

public class Localidade implements Serializable {

    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String designacao;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "pk_localidade", nullable = false, length = 2147483647)
    private String pkLocalidade;
    @OneToMany(mappedBy = "fkLocalidade")
    private List<Pessoa> pessoaList;
    @OneToMany(mappedBy = "fkLocalidadePai")
    private List<Localidade> localidadeList;
    @JoinColumn(name = "fk_localidade_pai", referencedColumnName = "pk_localidade")
    @ManyToOne
    private Localidade fkLocalidadePai;

    public Localidade() {
    }

    public Localidade(String pkLocalidade) {
        this.pkLocalidade = pkLocalidade;
    }

    public String getPkLocalidade() {
        return pkLocalidade;
    }

    public void setPkLocalidade(String pkLocalidade) {
        this.pkLocalidade = pkLocalidade;
    }




    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public List<Localidade> getLocalidadeList() {
        return localidadeList;
    }

    public void setLocalidadeList(List<Localidade> localidadeList) {
        this.localidadeList = localidadeList;
    }

    public Localidade getFkLocalidadePai() {
        return fkLocalidadePai;
    }

    public void setFkLocalidadePai(Localidade fkLocalidadePai) {
        this.fkLocalidadePai = fkLocalidadePai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkLocalidade != null ? pkLocalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidade)) {
            return false;
        }
        Localidade other = (Localidade) object;
        if ((this.pkLocalidade == null && other.pkLocalidade != null) || (this.pkLocalidade != null && !this.pkLocalidade.equals(other.pkLocalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ucan.cir_frontend.entities.Localidade[ pkLocalidade=" + pkLocalidade + " ]";
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
    
}
