/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Isaura
 */
@Entity
@Table(name = "historico_profissional", catalog = "cir_db", schema = "public")
@NamedQueries({
    @NamedQuery(name = "HistoricoProfissional.findAll", query = "SELECT h FROM HistoricoProfissional h"),
    @NamedQuery(name = "HistoricoProfissional.findByPkHistoricoProfissional", query = "SELECT h FROM HistoricoProfissional h WHERE h.pkHistoricoProfissional = :pkHistoricoProfissional"),
    @NamedQuery(name = "HistoricoProfissional.findByDataInicio", query = "SELECT h FROM HistoricoProfissional h WHERE h.dataInicio = :dataInicio"),
    @NamedQuery(name = "HistoricoProfissional.findByDataTermino", query = "SELECT h FROM HistoricoProfissional h WHERE h.dataTermino = :dataTermino"),
    @NamedQuery(name = "HistoricoProfissional.findByUrlDeclaracaoTrabalho", query = "SELECT h FROM HistoricoProfissional h WHERE h.urlDeclaracaoTrabalho = :urlDeclaracaoTrabalho"),
    @NamedQuery(name = "HistoricoProfissional.findByEmpresa", query = "SELECT h FROM HistoricoProfissional h WHERE h.empresa = :empresa")})
public class HistoricoProfissional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_historico_profissional", nullable = false)
    private Integer pkHistoricoProfissional;
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "data_termino")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "url_declaracao_trabalho", nullable = false, length = 2147483647)
    private String urlDeclaracaoTrabalho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(nullable = false, length = 2147483647)
    private String empresa;
    @JoinColumn(name = "fk_cliente", referencedColumnName = "pk_cliente", nullable = false)
    @ManyToOne(optional = false)
    private Cliente fkCliente;
    @JoinColumn(name = "fk_faixa_salarial", referencedColumnName = "pk_faixa_salarial", nullable = false)
    @ManyToOne(optional = false)
    private FaixaSalarial fkFaixaSalarial;
    @JoinColumn(name = "fk_profissao", referencedColumnName = "pk_profissao")
    @ManyToOne
    private Profissao fkProfissao;

    public HistoricoProfissional() {
    }

    public HistoricoProfissional(Integer pkHistoricoProfissional) {
        this.pkHistoricoProfissional = pkHistoricoProfissional;
    }

    public HistoricoProfissional(Integer pkHistoricoProfissional, String urlDeclaracaoTrabalho, String empresa) {
        this.pkHistoricoProfissional = pkHistoricoProfissional;
        this.urlDeclaracaoTrabalho = urlDeclaracaoTrabalho;
        this.empresa = empresa;
    }

    public Integer getPkHistoricoProfissional() {
        return pkHistoricoProfissional;
    }

    public void setPkHistoricoProfissional(Integer pkHistoricoProfissional) {
        this.pkHistoricoProfissional = pkHistoricoProfissional;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getUrlDeclaracaoTrabalho() {
        return urlDeclaracaoTrabalho;
    }

    public void setUrlDeclaracaoTrabalho(String urlDeclaracaoTrabalho) {
        this.urlDeclaracaoTrabalho = urlDeclaracaoTrabalho;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Cliente getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this.fkCliente = fkCliente;
    }

    public FaixaSalarial getFkFaixaSalarial() {
        return fkFaixaSalarial;
    }

    public void setFkFaixaSalarial(FaixaSalarial fkFaixaSalarial) {
        this.fkFaixaSalarial = fkFaixaSalarial;
    }

    public Profissao getFkProfissao() {
        return fkProfissao;
    }

    public void setFkProfissao(Profissao fkProfissao) {
        this.fkProfissao = fkProfissao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkHistoricoProfissional != null ? pkHistoricoProfissional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoProfissional)) {
            return false;
        }
        HistoricoProfissional other = (HistoricoProfissional) object;
        if ((this.pkHistoricoProfissional == null && other.pkHistoricoProfissional != null) || (this.pkHistoricoProfissional != null && !this.pkHistoricoProfissional.equals(other.pkHistoricoProfissional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ucan.cir_frontend.entities.HistoricoProfissional[ pkHistoricoProfissional=" + pkHistoricoProfissional + " ]";
    }
    
}
