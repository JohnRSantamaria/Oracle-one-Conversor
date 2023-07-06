/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conversordemonedas;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;


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
        switch (opcionDeConversion) {
            case "De Pesos a Dólar" -> conversorPesoADolar(cantidadAConvertir);                                                        
            case "De Dolar a Peso" -> conversorDolarAPeso(cantidadAConvertir);            
            case "De Peso a Euro" -> conversorPesoAEuro(cantidadAConvertir);
            case "De Euro a Peso" -> conversorEuroAPeso(cantidadAConvertir);
            default -> errorMessage();                
        }        
    }
    
    public static void errorMessage(){       
       JOptionPane.showMessageDialog(null,"Error: No se seleccionó ninguna opción");        
    }
    
    /**
     * Title: convertor de Peso a dollar
     * @param cantidadAConvertir
     */
    public static void conversorPesoADolar(double cantidadAConvertir){
        double precioActualDolar = 4181.50;
        DecimalFormat formato = new DecimalFormat("#.##");        
        double conversion = cantidadAConvertir  / precioActualDolar;                        
        JOptionPane.showMessageDialog(null, formato.format(conversion));        
    }
     /**
     * Title: convertor de dollar a Peso 
     * @param cantidadAConvertir
     */
    public static void conversorDolarAPeso(double cantidadAConvertir){
        double precioActualDolar = 4181.50;
        DecimalFormat formato = new DecimalFormat("#.##");        
        double conversion = cantidadAConvertir  * precioActualDolar;                        
        JOptionPane.showMessageDialog(null, formato.format(conversion));        
    }
       /**
     * Title: convertor de Peso a Euro
     * @param cantidadAConvertir
     */
    public static void conversorPesoAEuro(double cantidadAConvertir){
        DecimalFormat formato = new DecimalFormat("#.##"); 
        double precioActualDolar = 4553.01;
        
        double conversion = cantidadAConvertir  / precioActualDolar;  
        JOptionPane.showMessageDialog(null, formato.format(conversion));  
    }
    /**
     * Title: convertor de Euro a Peso 
     * @param cantidadAConvertir
     */
    public static void conversorEuroAPeso(double cantidadAConvertir){
        DecimalFormat formato = new DecimalFormat("#.##"); 
        double precioActualDolar = 4553.01;
        
        double conversion = cantidadAConvertir  * precioActualDolar;  
        JOptionPane.showMessageDialog(null, formato.format(conversion));  
    }
    
}



