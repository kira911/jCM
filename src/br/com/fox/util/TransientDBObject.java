package br.com.fox.util;

import java.util.List;

/**
 *
 * @author VAN
 */

//Essa classe serve para carregar qualquer retorno do banco que não tenha um objeto definido
public class TransientDBObject {
    private Integer id;
    private List columnList;
    private List valueList;
    
    public Integer getID() {
        return this.id;
    }
    public void setID(Integer id) {
        this.id = id;
    }
    
    public List getColumnList() {
        return this.columnList;
    }
    public void setColumnList(List columnList) {
        this.columnList = columnList;
    }
    
    public List getValueList() {
        return this.valueList;
    }
    public void setValueList(List valueList) {
        this.valueList = valueList;
    }
}
