/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import javax.inject.Named;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.omnifaces.cdi.ViewScoped;


/**
 *
 * @author Isaura
 */
@Named(value = "stepsBean")
@ViewScoped
public class StepsBean implements Serializable {

  private Integer currentStep;

  
    @PostConstruct
    public void init(){
        this.currentStep = Integer.valueOf(0);
    }
  
    public void nextStep() {
        currentStep++;
       // Stay on the same page
    }

    public void previousStep() {
        currentStep--;
      
    }

    public boolean isCurrentStep(int step) {
        return currentStep.intValue() == step;
    }
    
    
    // Getters and setters for currentStep

    public Integer getCurrentStep() {
        return currentStep;
    }

   

  
    
}
