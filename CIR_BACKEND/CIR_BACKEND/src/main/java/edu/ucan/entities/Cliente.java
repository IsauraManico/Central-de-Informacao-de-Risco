/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cliente", catalog = "cir_db", schema = "public")
@XmlRootElement

public class Cliente implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCliente")
    private List<HistoricoProfissional> historicoProfissionalList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cliente", nullable = false)
    private Integer pkCliente;
    @JoinColumn(name = "fk_pessoa", referencedColumnName = "pk_pessoa")
    @ManyToOne
    private Pessoa fkPessoa;

    public Cliente() {
    }

    public Cliente(Integer pkCliente) {
        this.pkCliente = pkCliente;
    }

    public Integer getPkCliente() {
        return pkCliente;
    }

    public void setPkCliente(Integer pkCliente) {
        this.pkCliente = pkCliente;
    }

    public Pessoa getFkPessoa() {
        return fkPessoa;
    }

    public void setFkPessoa(Pessoa fkPessoa) {
        this.fkPessoa = fkPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCliente != null ? pkCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.pkCliente == null && other.pkCliente != null) || (this.pkCliente != null && !this.pkCliente.equals(other.pkCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ucan.entities.Cliente[ pkCliente=" + pkCliente + " ]";
    }

    @XmlTransient
    public List<HistoricoProfissional> getHistoricoProfissionalList() {
        return historicoProfissionalList;
    }

    public void setHistoricoProfissionalList(List<HistoricoProfissional> historicoProfissionalList) {
        this.historicoProfissionalList = historicoProfissionalList;
    }
    
}
