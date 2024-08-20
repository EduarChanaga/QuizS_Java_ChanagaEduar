package com.local.logica;
import MySQL_Conection.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;



public class Cartera{
    private final ConexionMySQL conexion;
    public Cartera(){
        conexion = new ConexionMySQL();
    }
    
    
     public static void agregarTarjeta(){
            Cartera dao = new Cartera();
            Scanner scanner = new Scanner(System.in);
   
            System.out.println("Ingresar datos de la tarjeta:");
            System.out.print("Numero de cuenta: ");
            int n_cuenta = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Cuota manejo: ");
            int cuota = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Tipo (Joven, Nomina, Visa): ");
            String tipo = scanner.nextLine();
            
            System.out.print("mes (01,02...): ");
            int mes = scanner.nextInt();
            scanner.nextLine();
            
            dao.insertarTarjeta(n_cuenta,cuota,tipo,mes);
     }
            
            public void insertarTarjeta(int n_cuenta, int cuota, String tipo, int mes){
                Connection conn = null;
                PreparedStatement pstmt = null;

                try {
                    conn = conexion.conectarMySQL();
                    String query = "INSERT INTO tarjeta (numero_cuenta,cuota_manejo,tipo,mes) VALUES (?,?,?,?)";
                    pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, n_cuenta);
                    pstmt.setInt(2, cuota);
                    pstmt.setString(3, tipo);
                    pstmt.setInt(4, mes);
                    pstmt.executeUpdate();
                    System.out.println("Tarjeta agregada correctamente.");
                } catch (SQLException e) {
                    System.out.println("");
                } finally {
                    if (pstmt != null) {
                        try {
                            pstmt.close();
                        } catch (SQLException e) {
                        }
                    }
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException e) {
                        }
                    }
                }
            }
            
            
            
        
        
   
     
      public static void imprimirListaDeTarjetas(){
          Cartera dao = new Cartera();
          Connection conn = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          try {
            conn = dao.conexion.conectarMySQL();
            String query = "SELECT * FROM tarjeta";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            System.out.println("Lista de tarjetas:");
            while (rs.next()) {
                int numero_cuenta = rs.getInt("numero_cuenta");
                int cuota_manejo = rs.getInt("cuota_manejo"); 
                String tipo = rs.getString("tipo");
                int mes = rs.getInt("mes");
                System.out.println("n° cuenta: " + numero_cuenta + ", Cuota manejo: " + cuota_manejo + ", TIpo: " + tipo + ", Mes:" + mes);
            }
            System.out.println("----------");
        } catch (SQLException e) {
            System.out.println("Error al recuperar los datos de las tarjetas: " + e.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar el PreparedStatement: " + e.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }


    }   
     
   
   



   
