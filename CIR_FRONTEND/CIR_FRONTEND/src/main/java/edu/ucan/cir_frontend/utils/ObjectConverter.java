/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucan.cir_frontend.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author
 */
@FacesConverter("objectConverter")
public class ObjectConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        return componente.getAttributes().get(valor);
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object valor) {
        String valorEmString = null;
        if (valor != null) {
            valorEmString = Integer.toString(System.identityHashCode(valor));
            componente.getAttributes().put(valorEmString, valor);
        }
        return valorEmString;
    }

}