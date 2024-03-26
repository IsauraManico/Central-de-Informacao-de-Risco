/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Isaura
 */
@Entity
@Table(name = "tipo_conta", catalog = "cir_db", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TipoConta.findAll", query = "SELECT t FROM TipoConta t"),
    @NamedQuery(name = "TipoConta.findByPkTipoConta", query = "SELECT t FROM TipoConta t WHERE t.pkTipoConta = :pkTipoConta"),
    @NamedQuery(name = "TipoConta.findByDescricao", query = "SELECT t FROM TipoConta t WHERE t.descricao = :descricao")})
public class TipoConta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_tipo_conta", nullable = false)
    private Integer pkTipoConta;
    @Size(max = 2147483647)
    @Column(name = "descricao", length = 2147483647)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkTipoConta")
    private List<Conta> contaList;

    public TipoConta() {
    }

    public TipoConta(Integer pkTipoConta) {
        this.pkTipoConta = pkTipoConta;
    }

    public Integer getPkTipoConta() {
        return pkTipoConta;
    }

    public void setPkTipoConta(Integer pkTipoConta) {
        this.pkTipoConta = pkTipoConta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Conta> getContaList() {
        return contaList;
    }

    public void setContaList(List<Conta> contaList) {
        this.contaList = contaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTipoConta != null ? pkTipoConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoConta)) {
            return false;
        }
        TipoConta other = (TipoConta) object;
        if ((this.pkTipoConta == null && other.pkTipoConta != null) || (this.pkTipoConta != null && !this.pkTipoConta.equals(other.pkTipoConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ucan.cir_frontend.entities.TipoConta[ pkTipoConta=" + pkTipoConta + " ]";
    }
    
}
