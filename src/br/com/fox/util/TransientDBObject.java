package br.com.fox.util;

import java.util.List;

/**
 *
 * @author VAN
 */

//This class is meant to load any database return which has no defined object
public class TransientDBObject {
    private String column;
    private List<String> listValues;

    public String getColumn() {
        return this.column;
    }
    public void setColumn(String column) {
        this.column = column;
    }

    public List<String> getListValues() {
        return this.listValues;
    }
    public void setListValues(List<String> listValues) {
        this.listValues = listValues;
    }
}
