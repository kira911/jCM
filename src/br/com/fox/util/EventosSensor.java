package br.com.fox.util;

import java.util.Date;

/**
 *
 * @author VAN
 */
public class EventosSensor {
    private Date alarmeDataRecebimento;
    private String protocoloEvento;
    private String protocoloDescricao;
    private Integer receiver;
    private Integer linha;
    private Integer particao;
    private String idAuxiliar;
    private String auxiliar;
    private String alarmeStatus;
    private String usersUsername;
    private String alarmeDuracao;
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
}
