/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fox.db;

import br.com.fox.util.DateFormatter;
import com.towel.el.annotation.Resolvable;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dvr
 */
@Entity
@Table(name = "alarme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alarme.findAll", query = "SELECT a FROM Alarme a"),
    @NamedQuery(name = "Alarme.findByIdalarme", query = "SELECT a FROM Alarme a WHERE a.idalarme = :idalarme"),
    @NamedQuery(name = "Alarme.findByDataHora", query = "SELECT a FROM Alarme a WHERE a.dataRecebimento = :dataRecebimento"),
    @NamedQuery(name = "Alarme.findByReceiver", query = "SELECT a FROM Alarme a WHERE a.receiver = :receiver"),
    @NamedQuery(name = "Alarme.findByLinha", query = "SELECT a FROM Alarme a WHERE a.linha = :linha"),
    @NamedQuery(name = "Alarme.findByParticao", query = "SELECT a FROM Alarme a WHERE a.particao = :particao"),
    @NamedQuery(name = "Alarme.findByStatus", query = "SELECT a FROM Alarme a WHERE a.status = :status"),
    @NamedQuery(name = "Alarme.findByDuracao", query = "SELECT a FROM Alarme a WHERE a.duracao = :duracao")})
public class Alarme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalarme")
    private Integer idalarme;
    @Column(name = "data_recebimento")
    @Resolvable(colName = "Data", formatter=DateFormatter.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRecebimento;
    @Column(name = "data_espera")
    @Resolvable(colName = "Data", formatter=DateFormatter.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEspera;
    @Column(name = "data_encerramento")
    @Resolvable(colName = "Data", formatter=DateFormatter.class)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEncerramento;
    @Column(name = "receiver")
    @Resolvable(colName = "Receiver")
    private Integer receiver;
    @Column(name = "linha")
    @Resolvable(colName = "Linha")
    private Integer linha;
    @Column(name = "particao")
    @Resolvable(colName = "Partição")
    private Integer particao;
    @Lob
    @Column(name = "log")
    @Resolvable(colName = "Log")
    private String log;
    @Column(name = "status")
    @Resolvable(colName = "Status")
    private String status;
    @Column(name = "duracao")
    @Resolvable(colName = "Duração")
    private String duracao;
    @Column(name = "zona")
    @Resolvable(colName = "Zona")
    private Integer zona;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private Users username;
    @Resolvable(colName = "Evento")
    @JoinColumn(name = "idprotocolo", referencedColumnName = "idprotocolo")
    @ManyToOne
    private Protocolo idprotocolo;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne
    private Cliente idcliente;

    public Alarme() {
    }

    public Alarme(Integer idalarme) {
        this.idalarme = idalarme;
    }

    public Integer getIdalarme() {
        return idalarme;
    }

    public void setIdalarme(Integer idalarme) {
        this.idalarme = idalarme;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Date getDataEspera() {
        return dataEspera;
    }

    public void setDataEspera(Date dataEspera) {
        this.dataEspera = dataEspera;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    public Integer getLinha() {
        return linha;
    }

    public void setLinha(Integer linha) {
        this.linha = linha;
    }

    public Integer getParticao() {
        return particao;
    }

    public void setParticao(Integer particao) {
        this.particao = particao;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Integer getZona() {
        return zona;
    }

    public void setZona(Integer zona) {
        this.zona = zona;
    }

    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
        this.username = username;
    }

    public Protocolo getIdprotocolo() {
        return idprotocolo;
    }

    public void setIdprotocolo(Protocolo idprotocolo) {
        this.idprotocolo = idprotocolo;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalarme != null ? idalarme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alarme other = (Alarme) obj;
        if (this.receiver != other.receiver && (this.receiver == null || !this.receiver.equals(other.receiver))) {
            return false;
        }
        if (this.linha != other.linha && (this.linha == null || !this.linha.equals(other.linha))) {
            return false;
        }
        if (this.particao != other.particao && (this.particao == null || !this.particao.equals(other.particao))) {
            return false;
        }
        if (this.zona != other.zona && (this.zona == null || !this.zona.equals(other.zona))) {
            return false;
        }
        if (this.idprotocolo != other.idprotocolo && (this.idprotocolo == null || !this.idprotocolo.equals(other.idprotocolo))) {
            return false;
        }
        if (this.idcliente != other.idcliente && (this.idcliente == null || !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(idcliente.getFantasia());
    }
    
}
