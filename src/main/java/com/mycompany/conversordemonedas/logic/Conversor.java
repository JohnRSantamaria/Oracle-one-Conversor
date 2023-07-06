/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conversordemonedas.logic;

import java.text.DecimalFormat;

/**
 *
 * @author ResetStoreX
 */
public class Conversor {
    private static final double PRECIO_ACTUAL_DOLAR = 4181.50;
    private static final double PRECIO_ACTUAL_EURO = 4553.01;
    private static final DecimalFormat FORMATO = new DecimalFormat("#.##");

    public static String convertirPesoADolar(double cantidad) {
        return FORMATO.format(cantidad / PRECIO_ACTUAL_DOLAR);
    }

    public static String convertirDolarAPeso(double cantidad) {
        return FORMATO.format(cantidad * PRECIO_ACTUAL_DOLAR);
    }

    public static String convertirPesoAEuro(double cantidad) {
        return FORMATO.format(cantidad / PRECIO_ACTUAL_EURO);
    }

    public static String convertirEuroAPeso(double cantidad) {
        return FORMATO.format(cantidad * PRECIO_ACTUAL_EURO);
    }
}
