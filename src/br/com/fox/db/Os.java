/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fox.db;

import br.com.fox.util.DateFormatter;
import com.towel.el.annotation.Resolvable;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dvr
 */
@Entity
@Table(name = "os")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Os.findAll", query = "SELECT o FROM Os o"),
    @NamedQuery(name = "Os.findByIdos", query = "SELECT o FROM Os o WHERE o.idos = :idos"),
    @NamedQuery(name = "Os.findByData", query = "SELECT o FROM Os o WHERE o.data = :data"),
    @NamedQuery(name = "Os.findByVerificar", query = "SELECT o FROM Os o WHERE o.verificar = :verificar"),
    @NamedQuery(name = "Os.findBySolicitado", query = "SELECT o FROM Os o WHERE o.solicitado = :solicitado"),
    @NamedQuery(name = "Os.findByDataChegada", query = "SELECT o FROM Os o WHERE o.dataChegada = :dataChegada"),
    @NamedQuery(name = "Os.findByDataTermino", query = "SELECT o FROM Os o WHERE o.dataTermino = :dataTermino"),
    @NamedQuery(name = "Os.findByStatus", query = "SELECT o FROM Os o WHERE o.status = :status"),
    @NamedQuery(name = "Os.findByTecnico", query = "SELECT o FROM Os o WHERE o.tecnico = :tecnico")})
public class Os implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idos")
    @Resolvable(colName = "Nº OS")
    private Integer idos;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    @Resolvable(colName = "Data", formatter=DateFormatter.class)
    private Date data;
    @Column(name = "verificar")
    @Resolvable(colName = "Verificar")
    private String verificar;
    @Column(name = "solicitado")
    @Resolvable(colName = "Solicitado por")
    private String solicitado;
    @Lob
    @Column(name = "descricao")
    @Resolvable(colName = "Descrição")
    private String descricao;
    @Column(name = "data_chegada")
    @Temporal(TemporalType.TIMESTAMP)
    @Resolvable(colName = "Data chegada", formatter=DateFormatter.class)
    private Date dataChegada;
    @Column(name = "data_termino")
    @Temporal(TemporalType.TIMESTAMP)
    @Resolvable(colName = "Data término", formatter=DateFormatter.class)
    private Date dataTermino;
    @Column(name = "status")
    @Resolvable(colName = "Status")
    private String status;
    @Column(name = "tecnico")
    @Resolvable(colName = "Técnico")
    private String tecnico;
    @Column(name = "responsavel")
    @Resolvable(colName = "Responsável")
    private String responsavel;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private Users username;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private Cliente idcliente;
    @OneToMany(mappedBy = "idos")
    private List<Ipos> iposList;

    public Os() {
    }

    public Os(Integer idos) {
        this.idos = idos;
    }

    public Integer getIdos() {
        return idos;
    }

    public void setIdos(Integer idos) {
        this.idos = idos;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getVerificar() {
        return verificar;
    }

    public void setVerificar(String verificar) {
        this.verificar = verificar;
    }

    public String getSolicitado() {
        return solicitado;
    }

    public void setSolicitado(String solicitado) {
        this.solicitado = solicitado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    
    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
        this.username = username;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @XmlTransient
    public List<Ipos> getIposList() {
        return iposList;
    }

    public void setIposList(List<Ipos> iposList) {
        this.iposList = iposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idos != null ? idos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Os)) {
            return false;
        }
        Os other = (Os) object;
        if ((this.idos == null && other.idos != null) || (this.idos != null && !this.idos.equals(other.idos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fox.db.Os[ idos=" + idos + " ]";
    }
}
