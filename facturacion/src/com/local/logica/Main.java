/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.local.logica;

import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
         boolean repeticion = true;
        Scanner scanner = new Scanner(System.in);
        while (repeticion) {
            // Mostrar opciones al usuario
            System.out.println("Selecciona una opción:");
            System.out.println("1 - Insertar tarjeta");
            System.out.println("2 - Ver tarjetas");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1 -> {Cartera.agregarTarjeta();}
                case 2 -> {Cartera.imprimirListaDeTarjetas();}
            }
        }
        
     }
    
}
