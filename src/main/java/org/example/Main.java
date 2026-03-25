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

            String sql = "SELECT * " +
                    "FROM EMPLEADO " +
                    "ORDER BY SALARIO DESC";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
               String nombre = resultSet.getString("NOMBRE");
               double salario = resultSet.getDouble("SALARIO");

               System.out.println("ID: "+id + " - Nombre: " + nombre + " ->> " + salario+ "€");
            }
        } catch (SQLException e){
            System.out.println("ERROR -> "+e.getMessage());
        }
    }
}
