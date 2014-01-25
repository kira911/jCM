package br.com.fox.util;

import com.towel.el.annotation.Resolvable;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author VAN
 */
public class EventosSensor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Resolvable(colName = "Alarme Data Recebimento")
    private Date alarmeDataRecebimento;
    @Resolvable(colName = "Protocolo Evento")
    private String protocoloEvento;
    @Resolvable(colName = "Protocolo Descricao")
    private String protocoloDescricao;
    @Resolvable(colName = "Receiver")
    private Integer receiver;
    @Resolvable(colName = "Linha")
    private Integer linha;
    @Resolvable(colName = "Particao")
    private Integer particao;
    @Resolvable(colName = "ID Auxiliar")
    private String idAuxiliar;
    @Resolvable(colName = "Auxiliar")
    private String auxiliar;
    @Resolvable(colName = "Alarme Status")
    private String alarmeStatus;
    @Resolvable(colName = "Usuario")
    private String usersUsername;
    @Resolvable(colName = "Duracao Alarme")
    private String alarmeDuracao;
    @Resolvable(colName = "Alarme Log")
    private String alarmeLog;

    public Date getAlarmeDataRecebimento() {
        return alarmeDataRecebimento;
    }
    public void setAlarmeDataRecebimento(Date alarmeDataRecebimento) {
        this.alarmeDataRecebimento = alarmeDataRecebimento;
    }

    public String getProtocoloEvento() {
        return protocoloEvento;
    }
    public void setProtocoloEvento(String protocoloEvento) {
        this.protocoloEvento = protocoloEvento;
    }

    public String getProtocoloDescricao() {
        return protocoloDescricao;
    }
    public void setProtocoloDescricao(String protocoloDescricao) {
        this.protocoloDescricao = protocoloDescricao;
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

    public String getIdAuxiliar() {
        return idAuxiliar;
    }
    public void setIdAuxiliar(String idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
    }

    public String getAuxiliar() {
        return auxiliar;
    }
    public void setAuxiliar(String auxiliar) {
        this.auxiliar = auxiliar;
    }

    public String getAlarmeStatus() {
        return alarmeStatus;
    }
    public void setAlarmeStatus(String alarmeStatus) {
        this.alarmeStatus = alarmeStatus;
    }
    
    public String getUsersUsername() {
        return usersUsername;
    }
    public void setUsersUsername(String usersUsername) {
        this.usersUsername = usersUsername;
    }

    public String getAlarmeDuracao() {
        return alarmeDuracao;
    }
    public void setAlarmeDuracao(String alarmeDuracao) {
        this.alarmeDuracao = alarmeDuracao;
    }

    public String getAlarmeLog() {
        return alarmeLog;
    }
    public void setAlarmeLog(String alarmeLog) {
        this.alarmeLog = alarmeLog;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        final EventosSensor other = (EventosSensor) obj;
        if((this.idAuxiliar == null) ? (other.idAuxiliar != null) : !this.idAuxiliar.equals(other.idAuxiliar)) {
            return false;
        }
        
        return true;
    }
    
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.idAuxiliar != null ? this.idAuxiliar.hashCode(): 0);
        
        return hash;
    }
    
    @Override    
    public String toString() {
        return "EventosSensor{" + "alarmeDataRecebimento=" + alarmeDataRecebimento + ", protocoloEvento=" + protocoloEvento + ", protocoloDescricao=" + protocoloDescricao + ", receiver=" + receiver + ", linha=" + linha + ", particao=" + particao + ",idAuxiliar=" + idAuxiliar + ", auxiliar=" + auxiliar + ", alarmeStatus=" + alarmeStatus + ", usersUsername=" + usersUsername + ", alarmeDuracao=" + alarmeDuracao + ", alarmeLog=" + alarmeLog + '}';
    }
}
