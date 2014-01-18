package br.com.fox.camera;

import br.com.fox.db.Alarme;
import br.com.fox.db.SinalRouter;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Dvr
 */
public class CoresAlert extends JLabel implements ListCellRenderer {

    public CoresAlert() {
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        if (value instanceof SinalRouter) {
            SinalRouter sr = (SinalRouter) value;

            setText(sr.getNor());

            if ("VIPER".equals(sr.getOrg())) {
                if (isSelected) {
                    setBackground(list.getSelectionBackground());
                    setForeground(new java.awt.Color(204, 0, 0));
                } else {
                    setBackground(list.getBackground());
                    setForeground(new java.awt.Color(204, 0, 0));
                }
            } else {
                if ("TRAVA".equals(sr.getOrg())) {
                    if (isSelected) {
                        setBackground(list.getSelectionBackground());
                        setForeground(new java.awt.Color(0, 153, 0));
                    } else {
                        setBackground(list.getBackground());
                        setForeground(new java.awt.Color(0, 153, 0));
                    }
                } else {
                    if ("Teste".equals(sr.getOrg())) {
                        if (isSelected) {
                            setBackground(list.getSelectionBackground());
                            setForeground(new java.awt.Color(0, 0, 204));
                        } else {
                            setBackground(list.getBackground());
                            setForeground(new java.awt.Color(0, 0, 204));
                        }
                    } else {
                        if (isSelected) {
                            setBackground(list.getSelectionBackground());
                            setForeground(list.getSelectionForeground());
                        } else {
                            setBackground(list.getBackground());
                            setForeground(list.getForeground());
                        }
                    }
                }
            }
        } else {
            Alarme alarme = (Alarme) value;

            setText(alarme.getIdcliente().getFantasia());

            String prioridade = alarme.getIdprotocolo().getCuc().getPrioridade();

            if (prioridade.equals("BAIXA")) {
                if (isSelected) {
                    setBackground(list.getSelectionBackground());
                    setForeground(new java.awt.Color(0, 0, 204));
                } else {
                    setBackground(list.getBackground());
                    setForeground(new java.awt.Color(0, 0, 204));
                }
            } else {
                if (prioridade.equals("NORMAL")) {
                    if (isSelected) {
                        setBackground(list.getSelectionBackground());
                        setForeground(new java.awt.Color(153, 153, 0));
                    } else {
                        setBackground(list.getBackground());
                        setForeground(new java.awt.Color(153, 153, 0));
                    }
                } else {
                    if (prioridade.equals("MÉDIA")) {
                        if (isSelected) {
                            setBackground(list.getSelectionBackground());
                            setForeground(new java.awt.Color(0, 153, 0));
                        } else {
                            setBackground(list.getBackground());
                            setForeground(new java.awt.Color(0, 153, 0));
                        }
                    } else {
                        if (prioridade.equals("ALTA")) {
                            if (isSelected) {
                                setBackground(list.getSelectionBackground());
                                setForeground(new java.awt.Color(204, 0, 0));
                            } else {
                                setBackground(list.getBackground());
                                setForeground(new java.awt.Color(204, 0, 0));
                            }
                        } else {
                            if (isSelected) {
                                setBackground(list.getSelectionBackground());
                                setForeground(list.getSelectionForeground());
                            } else {
                                setBackground(list.getBackground());
                                setForeground(list.getForeground());
                            }
                        }
                    }
                }
            }
        }

        setFont(list.getFont());
        setOpaque(true);

        return this;
    }
}
