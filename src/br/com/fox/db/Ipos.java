/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fox.db;

import com.towel.el.annotation.Resolvable;
import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dvr
 */
@Entity
@Table(name = "ipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ipos.findAll", query = "SELECT i FROM Ipos i"),
    @NamedQuery(name = "Ipos.findByIdipos", query = "SELECT i FROM Ipos i WHERE i.idipos = :idipos"),
    @NamedQuery(name = "Ipos.findByQtd", query = "SELECT i FROM Ipos i WHERE i.qtd = :qtd"),
    @NamedQuery(name = "Ipos.findByDescricao", query = "SELECT i FROM Ipos i WHERE i.descricao = :descricao"),
    @NamedQuery(name = "Ipos.findByValor", query = "SELECT i FROM Ipos i WHERE i.valor = :valor"),
    @NamedQuery(name = "Ipos.findByValorTotal", query = "SELECT i FROM Ipos i WHERE i.valorTotal = :valorTotal")})
public class Ipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idipos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idipos;
    @Resolvable(colName = "Quantidade")
    @Column(name = "qtd")
    private Integer qtd;
    @Resolvable(colName = "Descrição")
    @Column(name = "descricao")
    private String descricao;
    @Resolvable(colName = "Vl. Unitário")
    @Column(name = "valor")
    private Double valor;
    @Resolvable(colName = "Vl. Total")
    @Column(name = "valor_total")
    private Double valorTotal;
    @JoinColumn(name = "idos", referencedColumnName = "idos")
    @ManyToOne
    private Os idos;

    public Ipos() {
    }

    public Ipos(Integer idipos) {
        this.idipos = idipos;
    }

    public Integer getIdipos() {
        return idipos;
    }

    public void setIdipos(Integer idipos) {
        this.idipos = idipos;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Os getIdos() {
        return idos;
    }

    public void setIdos(Os idos) {
        this.idos = idos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idipos != null ? idipos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ipos)) {
            return false;
        }
        Ipos other = (Ipos) object;
        if ((this.idipos == null && other.idipos != null) || (this.idipos != null && !this.idipos.equals(other.idipos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fox.db.Ipos[ idipos=" + idipos + " ]";
    }
}
