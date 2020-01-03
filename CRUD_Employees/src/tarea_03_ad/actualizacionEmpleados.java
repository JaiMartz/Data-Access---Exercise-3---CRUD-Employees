/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea_03_ad;

//PASO 1: importar clases
import java.sql.*;
/**
 *
 * @author Jairo
 */
public class actualizacionEmpleados {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Load drivers
        //PASO 2: Cargar drivers
        Class.forName("com.mysql.jdbc.Driver");
        //Get connection with DB
        //Paso 3: Establecer la conexion con la BD: URL, USUARIO, CONTRASEÑA
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/gestionLaboral1819","foc","fomento");
        //Prepare statement
        //Paso 4: Preparar la sentencia
        Statement sentencia = conexion.createStatement();
        //Launch statement
        //Paso 5: Lanzar la sentencia
        String op = "UPDATE empleados SET salario = salario+50  WHERE salario<1500";
        int filas = sentencia.executeUpdate(op);
        //Check if the rows has been  updated
        //Paso 6: Comprobamos que las filas se han actualizado
        System.out.println("Mediante la sentencia de actualizacion "+op+" se han actualizado "+filas+" filas");
        //Free resources
        //Paso 7: liberar los recursos
        sentencia.close();
        conexion.close();
    }
}
