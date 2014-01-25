package br.com.fox.Hibernate.DAO;

import br.com.fox.util.EventosSensor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.TransactionException;

/**
 *
 * @author VAN
 */
public class EventosSensorDAO { 
    private Session session;
    
    public EventosSensorDAO(Session session) {
        this.session = session;
    }
    
    public List<EventosSensor> getListEventosSensor(Integer idCliente, Date startDate, Date endDate, Integer limit) {
        String sql = "select " +
                    "alarme.data_recebimento as alarme_data_recebimento, " +
                    "protocolo.evento as protocolo_evento, " +
                    "protocolo.descricao as protocolo_descricao, " +
                    "alarme.receiver, " +
                    "alarme.linha, " +
                    "alarme.particao, " +
                    "case cuc.auxiliar " +
                        "when " +
                            "'Zona' " +
                        "then " +
                            "(select " +
                                "case count(num_zona) " +
                                    "when 0 then alarme.zona " +
                                    "else num_zona " +
                                "end as num_zona " +
                            "from " +
                                "zona " +
                            "where " +
                                "num_zona = alarme.zona and idcliente = alarme.idcliente " +
                                "limit 1) " +
                        "when " +
                            "'Usuário' " +
                        "then " +
                            "(select " +
                                "case count(codigo) " +
                                    "when 0 then alarme.zona " +
                                        "else codigo " +
                                    "end as codigo " +
                                "from " +
                                     "usuario " +
                                "where " +
                                    "codigo = alarme.zona and idcliente = alarme.idcliente " +
                                "limit 1) " +
                        "when 'Nenhum' then '' " +
                    "end as id_auxiliar, " +
                    "case cuc.auxiliar " +
                        "when " +
                            "'Zona' " +
                        "then " +
                            "(select " +
                                    "case count(areas) " +
                                        "when 0 then 'Zona não cadastrada' " +
                                        "else areas " +
                                    "end as codigo " +
                            "from " +
                                "zona " +
                            "where " +
                                "num_zona = alarme.zona and idcliente = alarme.idcliente " +
                            "limit 1) " +
                    "when " +
                        "'Usuário' " +
                    "then " +
                         "(select " +
                            "case count(nome) " +
                                "when 0 then 'Usuário não cadastrado' " +
                                "else nome " +
                        "end as codigo " +
                "from " +
                    "usuario " +
                "where " +
                    "codigo = alarme.zona and idcliente = alarme.idcliente " +
                "limit 1) " +
                    "when 'Nenhum' then '' " +
                "end as auxiliar, " +
                "alarme.status as alarme_status, " +
                "users.username as users_username, " +
                "alarme.duracao as alarme_duracao, " +
                 "alarme.log as alarme_log " +
            "from " +
                 "protocolo protocolo " +
                 "inner join alarme alarme on protocolo.idprotocolo = alarme.idprotocolo " +
                 "inner join cuc cuc on protocolo.cuc = cuc.idcuc " +
                 "inner join users users on alarme.username = users.username " +
                 "inner join cliente cliente on alarme.idcliente = cliente.idcliente " +
                 "inner join usuario usuario on cliente.idcliente = usuario.idcliente " +
                 "inner join zona zona on cliente.idcliente = zona.idcliente " +
             "where alarme.idcliente = :idCliente " +
                 " and cast(alarme.data_recebimento as Date) >= :startDate " +
                 "and cast(alarme.data_recebimento as Date) <= :endDate " +
            "group by alarme.idalarme " +
            "order by alarme.data_recebimento ";
        
        try {
            this.session.beginTransaction();
            ListIterator iterator = this.session.createSQLQuery(sql).setParameter("idCliente", 21)
                                                                    .setParameter("startDate", startDate)
                                                                    .setParameter("endDate", endDate).setMaxResults(limit).list().listIterator();            
            List<EventosSensor> listaEventos = new ArrayList<EventosSensor>();
            //Converting the return into as eventosSensor
            while(iterator.hasNext()) {
                Object[] row = (Object[]) iterator.next();
                EventosSensor eventosSensor = new EventosSensor();
                eventosSensor.setAlarmeDataRecebimento((Date) row[0]);
                eventosSensor.setProtocoloEvento((String) row[1]);
                eventosSensor.setProtocoloDescricao((String) row[2]);
                eventosSensor.setReceiver((Integer) row[3]);
                eventosSensor.setLinha((Integer) row[4]);
                eventosSensor.setParticao((Integer) row[5]);
                eventosSensor.setIdAuxiliar((String) row[6].toString());
                eventosSensor.setAuxiliar((String) row[7]);
                eventosSensor.setAlarmeStatus((String) row[8]);
                eventosSensor.setUsersUsername((String) row[9]);
                eventosSensor.setAlarmeDuracao((String) row[10]);
                eventosSensor.setAlarmeLog((String) row[11]);
                
                listaEventos.add(eventosSensor);
            }
            
            return listaEventos;
        }catch(HibernateException ex) {
            ex.printStackTrace();
            return null;
        }catch(NullPointerException ex) {
            ex.printStackTrace();            
            return null;
        }finally {
            try {
                this.session.getTransaction().commit();
            }catch(TransactionException ex) {
                ex.printStackTrace();
            }
        }
    }
}
