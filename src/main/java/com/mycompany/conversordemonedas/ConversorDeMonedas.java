/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conversordemonedas;

import javax.swing.JOptionPane;
import com.mycompany.conversordemonedas.logic.Conversor;

/**
 *
 * @author JohnS  
 */
public class ConversorDeMonedas {

     public static void main(String[] args) {
        menuPrincipal();
    }
    
    public static void menuPrincipal() {
         String opciones[] = {"Conversor de Moneda"};
         
         String op = (String) JOptionPane.showInputDialog(null, "Seleccione una opción de conversión", "Menu", JOptionPane.DEFAULT_OPTION, null, opciones, opciones[0]);
         
         if (op != null) {
            switch (op) {
                case "Conversor de Moneda" -> conversorDeMoneda(op);
                default -> errorMessage();
            }
         } else {
            errorMessage();
        }                 
    }
    
    public static void conversorDeMoneda(String op) {
        
        double cantidadAConvertir = 0.0;
        String opcionDeConversion; 
        boolean inputValido = false;
        boolean cerrado = false;
        
        while (!inputValido && !cerrado) {
            try {
                String input = JOptionPane.showInputDialog(null, "Ingresa la cantidad de dinero que deseas convertir: ");
                if(input != null){
                    cantidadAConvertir = Double.parseDouble(input);
                    inputValido = true; 
                }else{                    
                    cerrado = true;                    
                }
            } catch (NumberFormatException e) {        
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
            }
        }            
        
        if(cerrado) {
           errorMessage();
        }else{            
            opcionDeConversion = opcionesDeMonedas();
            conversor(opcionDeConversion,cantidadAConvertir);
        }              
    }
    
    /**
     *
     * @return 
     */
    public static String opcionesDeMonedas() {        
        String opciones[] = {"De Pesos a Dólar", "De Dolar a Peso", "De Peso a Euro","De Euro a Peso"};
        String opcionDeMoneda = "";         
        boolean inputInvalido = false;
        
        while(!inputInvalido){            
            opcionDeMoneda = (String) JOptionPane.showInputDialog(null, "Seleccione una opción de conversión", "Menu", JOptionPane.DEFAULT_OPTION, null, opciones, opciones[0]);
            if(opcionDeMoneda != null){
                inputInvalido = true;
            }            
        }                      
        return opcionDeMoneda;
    }
    
    public static void conversor(String opcionDeConversion, double cantidadAConvertir){ 
        String resultado = ""; 
        switch (opcionDeConversion) {
            case "De Pesos a Dólar" -> resultado = Conversor.convertirPesoADolar(cantidadAConvertir);                                                        
            case "De Dolar a Peso" -> resultado = Conversor.convertirDolarAPeso(cantidadAConvertir);
            case "De Peso a Euro" -> resultado = Conversor.convertirPesoAEuro(cantidadAConvertir);
            case "De Euro a Peso" -> resultado = Conversor.convertirEuroAPeso(cantidadAConvertir);            
            default -> errorMessage();                
        }   
        
        JOptionPane.showMessageDialog(null, resultado);
    }
    
    public static void errorMessage(){       
       JOptionPane.showMessageDialog(null,"Error: No se seleccionó ninguna opción");        
    }
    
   
    
}



