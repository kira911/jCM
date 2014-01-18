package br.com.fox.util;

import br.com.fox.db.Alarme;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Dvr
 */
public class TestDateTime {

    public static void main(String[] args) {

        DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");
        
        DateTime start = DateTime.parse("17-09-2012 00:00:00", dateFormatter);
        DateTime end = new DateTime(new Date());
        
        Duration duration = new Duration(start, end);

        String days = String.format("%3d", duration.getStandardDays()%365);
        String hours = String.format("%02d", duration.getStandardHours()%24);
        String minutes = String.format("%02d", duration.getStandardMinutes()%60);
        String seconds = String.format("%02d", duration.getStandardSeconds()%60);
        
        StringBuilder tempo = new StringBuilder();
        tempo.append(days).append("d ").append(hours).append(":").append(minutes).append(":").append(seconds);
        
        System.out.println(tempo.toString().trim());
    }
}
