package com.github.robertlocke;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database{
   private Connection connection;
   private Class driver;
   private Configuration configuration;

   public Database(Configuration config){
       this.configuration = config;
       try {
           this.driver = Class.forName(configuration.getDriver());
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            System.exit(0);
       }
   }

   public void open() throws java.sql.SQLException {
       connection = DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(), configuration.getPassword());
       connection.setAutoCommit(false);
   }

   public void close(){
       try {
           connection.close();
       }catch(SQLException ex){
           ex.printStackTrace();
       }
   }

   public void commit() throws SQLException{
           connection.commit();
   }

   public Statement getStatement() throws SQLException{
       Statement stmt = connection.createStatement();
       return stmt;
    }


}