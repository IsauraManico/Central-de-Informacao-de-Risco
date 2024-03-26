/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import edu.ucan.cir_frontend.entities.Conta;
import javax.inject.Named;
import java.io.Serializable;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author Isaura
 */
@Named(value = "clienteEditarBean")
@ViewScoped
public class ClienteEditarBean implements Serializable {

    /**
     * Creates a new instance of ClienteEditarBean
     */
    
     
    private Conta clienteSelecionado;
    public ClienteEditarBean() {
        
    }

    public Conta getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Conta clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }
    
    
    
}
