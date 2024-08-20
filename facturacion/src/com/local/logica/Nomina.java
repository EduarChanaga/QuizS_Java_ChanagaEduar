/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.local.logica;

/**
 *
 * @author camper
 */
public class Nomina extends Tarjeta{

    public Nomina(String numeroDeCuenta, double valorApertura, String mes) {
        super(numeroDeCuenta, valorApertura, mes);
    }

    @Override
    public double cuotaDeManejo() {
        System.out.println("");
        return 0;
    }
    
}
