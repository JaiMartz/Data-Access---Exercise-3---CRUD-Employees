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
public class consultaEmpleados {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Load drivers
        //PASO 2: Cargar drivers
        Class.forName("com.mysql.jdbc.Driver");
        //Get connection
        //Paso 3: Establecer la conexion
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/gestionLaboral1819","foc","fomento");
        //Prepare statement
        //Paso 4: Preparar la consulta
        Statement sentencia = conexion.createStatement();
        //Launch statement
        //Paso 5: Lanzar la consulta
        ResultSet resultado = sentencia.executeQuery("SELECT * FROM empleados");
        //Pick the collection to see every row while we have information
        //Paso 6: recogemos la colecion para visualizar cada fila
        //Hacemos un bucle mientras que haya registros
        
        while(resultado.next()){
            System.out.println(resultado.getInt(1)+"\t\t"
                    +resultado.getString(2)+"\t\t"
                    +resultado.getString(3)+"\t\t"
                    +resultado.getString(4)+"\t\t"
                    +resultado.getFloat(5)+"\t\t"
            );
        }
        //Free resources
        //Paso 7: liberar los recursos
        resultado.close();
        sentencia.close();
        conexion.close();
    }
}
