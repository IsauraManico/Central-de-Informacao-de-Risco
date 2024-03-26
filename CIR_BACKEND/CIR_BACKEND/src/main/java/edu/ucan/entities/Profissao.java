/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.entities;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Isaura
 */
@Entity
@Table(name = "profissao", catalog = "cir_db", schema = "public")
@XmlRootElement

public class Profissao implements Serializable {

    @OneToMany(mappedBy = "fkProfissao")
    private List<HistoricoProfissional> historicoProfissionalList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_profissao", nullable = false)
    private Integer pkProfissao;
    @Basic(optional = false)
    @Column(name = "descricao", nullable = false, length = 2147483647)
    private String descricao;

    public Profissao() {
    }

    public Profissao(Integer pkProfissao) {
        this.pkProfissao = pkProfissao;
    }

    public Profissao(Integer pkProfissao, String descricao) {
        this.pkProfissao = pkProfissao;
        this.descricao = descricao;
    }

    public Integer getPkProfissao() {
        return pkProfissao;
    }

    public void setPkProfissao(Integer pkProfissao) {
        this.pkProfissao = pkProfissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProfissao != null ? pkProfissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profissao)) {
            return false;
        }
        Profissao other = (Profissao) object;
        if ((this.pkProfissao == null && other.pkProfissao != null) || (this.pkProfissao != null && !this.pkProfissao.equals(other.pkProfissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ucan.entities.Profissao[ pkProfissao=" + pkProfissao + " ]";
    }

    @XmlTransient
    public List<HistoricoProfissional> getHistoricoProfissionalList() {
        return historicoProfissionalList;
    }

    public void setHistoricoProfissionalList(List<HistoricoProfissional> historicoProfissionalList) {
        this.historicoProfissionalList = historicoProfissionalList;
    }
    
}
