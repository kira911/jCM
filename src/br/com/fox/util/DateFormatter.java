package br.com.fox.util;

import com.towel.bean.Formatter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dvr
 */
public class DateFormatter implements Formatter {

    private final static SimpleDateFormat fdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    @Override
    public String format(Object o) {
        Date date = (Date) o;
        return fdate.format(date);
    }

    @Override
    public Object parse(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
