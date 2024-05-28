package com.example.learningjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class LearningJpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(LearningJpaApplication.class, args);
//        try {
//            Connection connection = DriverManager.getConnection(
//                    "jdbc:postgresql://localhost:5432/simple",
//                    "postgres",
//                    "1234"
//            );
//            if (connection != null) {
//                System.out.println("Connected to the database!");
//                connection.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}
