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
@Table(name = "profissao", catalog = "cir_db", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Profissao.findAll", query = "SELECT p FROM Profissao p"),
    @NamedQuery(name = "Profissao.findByPkProfissao", query = "SELECT p FROM Profissao p WHERE p.pkProfissao = :pkProfissao"),
    @NamedQuery(name = "Profissao.findByDescricao", query = "SELECT p FROM Profissao p WHERE p.descricao = :descricao")})
public class Profissao implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String descricao;
    @OneToMany(mappedBy = "fkProfissao")
    private List<HistoricoProfissional> historicoProfissionalList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_profissao", nullable = false)
    private Integer pkProfissao;

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
        return "edu.ucan.cir_frontend.entities.Profissao[ pkProfissao=" + pkProfissao + " ]";
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<HistoricoProfissional> getHistoricoProfissionalList() {
        return historicoProfissionalList;
    }

    public void setHistoricoProfissionalList(List<HistoricoProfissional> historicoProfissionalList) {
        this.historicoProfissionalList = historicoProfissionalList;
    }
    
}
