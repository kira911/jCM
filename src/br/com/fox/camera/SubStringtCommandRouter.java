/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fox.camera;

/**
 *
 * @author Dvr
 */
public class SubStringtCommandRouter {
    public static void main(String[] args) {
        //String sinal =  "#XI3PALERTR1000  teste felipe                                      78        13/07/2012 11:17:42 002IAPP      1 VIPER          0    0           192.168.0.8                   9540  |";
        String sinal = "#XI3PALERTR4154  teste felipe                                                16/08/2012 16:22:14    ROUTER      TRAVAIAPP                                                           |";
        
        String ini = sinal.substring(0, 10);
        String ori = sinal.substring(10, 11);
        String idr = sinal.substring(11, 17);
        String nor = sinal.substring(17, 67);
        String cod = sinal.substring(67, 77);
        String dat = sinal.substring(77, 97);
        String nuc = sinal.substring(97, 100);
        String apl = sinal.substring(100, 110);
        String ins = sinal.substring(110, 112);
        String org = sinal.substring(112, 117);
        String sub = sinal.substring(117, 127);
        String nsb = sinal.substring(127, 132);
        String sbn = sinal.substring(132, 142);
        String cor = sinal.substring(142, 144);
        String ips = sinal.substring(144, 174);
        String pos = sinal.substring(174, 180);
        
        System.out.println(ini);
        System.out.println("ori = "+ori);
        System.out.println("idr = "+idr);
        System.out.println("nor = "+nor);
        System.out.println("cod = "+cod);
        System.out.println("dat = "+dat);
        System.out.println("nuc = "+nuc);
        System.out.println("apl = "+apl);
        System.out.println("ins = "+ins);
        System.out.println("org = "+org);
        System.out.println("sub = "+sub);
        System.out.println("nsb = "+nsb);
        System.out.println("sbn = "+sbn);
        System.out.println("cor = "+cor);
        System.out.println("ips = "+ips);
        System.out.println("pos = "+pos);
        
    }
}
