package br.com.fox.util;

import com.towel.bean.Formatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dvr
 */
public class HoraFormatter implements Formatter {

    private final static SimpleDateFormat fhora = new SimpleDateFormat("HH:mm:ss");
    
    @Override
    public Object format(Object o) {
        Date date = (Date) o;
        return fhora.format(date);
    }

    @Override
    public Object parse(Object o) {
        Date date = null;
        try {
            date = fhora.parse(o.toString());
        } catch (ParseException ex) {
            Logger.getLogger(HoraFormatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
