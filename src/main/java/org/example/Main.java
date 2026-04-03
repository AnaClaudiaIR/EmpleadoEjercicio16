package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection connection = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()
        );  Statement statement = connection.createStatement()) {

            //String con la sentencia
            String sql = "SELECT NOMBRE_EMP FROM EMPLEADO2 WHERE ID_DEP = 1";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Mientras haya resultados, los guarda en las variables
            while (resultSet.next()) {
                String empleado = resultSet.getString("NOMBRE_EMP");
                System.out.println("Empleado: " + empleado);
            }
        } catch (SQLException e){
            System.out.println("ERROR --> "+e.getMessage());
        }
    }
}
