package br.com.fox.camera;

import com.towel.el.annotation.Resolvable;
import java.io.Serializable;
import javax.persistence.Column;

/**
 *
 * @author Dvr
 */
public class SinalRouter implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String ini;
    @Column(name = "ori")
    @Resolvable(colName = "Origem")
    private String ori;
    @Column(name = "idr")
    @Resolvable(colName = "Id. do Router")
    private String idr;
    @Column(name = "nor")
    @Resolvable(colName = "Nome do Router")
    private String nor;
    @Column(name = "cod")
    @Resolvable(colName = "Cod. do alarme")
    private String cod;
    @Column(name = "dat")
    @Resolvable(colName = "Data/Hora")
    private String dat;
    @Column(name = "nuc")
    @Resolvable(colName = "Nº da câmera")
    private String nuc;
    @Column(name = "apl")
    @Resolvable(colName = "Nome da aplicação")
    private String apl;
    @Column(name = "ins")
    @Resolvable(colName = "Nº da instância da aplicação")
    private String ins;
    @Column(name = "org")
    @Resolvable(colName = "Origem")
    private String org;
    @Column(name = "ext")
    @Resolvable(colName = "Outras informações")
    private String ext;

    public SinalRouter() {
    }

    public String getApl() {
        return apl;
    }

    public void setApl(String apl) {
        this.apl = apl;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getIdr() {
        return idr;
    }

    public void setIdr(String idr) {
        this.idr = idr;
    }

    public String getIni() {
        return ini;
    }

    public void setIni(String ini) {
        this.ini = ini;
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins;
    }

    public String getNor() {
        return nor;
    }

    public void setNor(String nor) {
        this.nor = nor;
    }

    public String getNuc() {
        return nuc;
    }

    public void setNuc(String nuc) {
        this.nuc = nuc;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getOri() {
        return ori;
    }

    public void setOri(String ori) {
        this.ori = ori;
    }
    
    @Override
    public String toString() {
        return nor;
        //return "SinalRouter{" + "ini=" + ini + ", idr=" + idr + ", nor=" + nor + ", cod=" + cod + ", dat=" + dat + ", nuc=" + nuc + ", apl=" + apl + ", ins=" + ins + ", org=" + org + ", ext=" + ext + '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    
}
