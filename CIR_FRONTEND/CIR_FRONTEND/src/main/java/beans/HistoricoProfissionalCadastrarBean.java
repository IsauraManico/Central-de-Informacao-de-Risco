/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import edu.ucan.cir_frontend.entities.HistoricoProfissional;
import java.io.Serializable;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author Isaura
 * Data 13 - 11 - 2023 
 * 
 */
@Named(value = "historicoProfissionalCadastrarBean")
@ViewScoped
public class HistoricoProfissionalCadastrarBean implements Serializable {

    private HistoricoProfissional historicoProfissional;

    public HistoricoProfissional getHistoricoProfissional() {
        return historicoProfissional;
    }

    public void setHistoricoProfissional(HistoricoProfissional historicoProfissional) {
        this.historicoProfissional = historicoProfissional;
    }

}
