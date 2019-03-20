package com.github.robertlocke;



import com.github.utils.Settings;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ImportSQL {


    public static void main(String[] args) {

        Settings set = new Settings();
        set.setOutputFilePath("E:\\sqlToCSV.txt");

        Configuration config = new Configuration();




        try {
            Connection con = DriverManager.getConnection(config.getURL(), config.getUSERNAME(), config.getPASSWORD());


            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from sql_performance");
            while (rs.next()){
                System.out.println(rs.getInt(1) + "  " + rs.getDate(2) + "  " + rs.getDate(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getInt(7) + " " + rs.getFloat(8) + " " + rs.getFloat(9) + " " + rs.getFloat(10) + " " + rs.getString(11) + " " + rs.getFloat(12) + " " + rs.getFloat(13) + " " + rs.getFloat(14) + " " + rs.getString(15) + " " + rs.getLong(16) + " " + rs.getLong(17) + " " + rs.getLong(18) + " " + rs.getInt(19) + " " + rs.getInt(20));
            }
            stmt.close();
            rs.close();
            con.close();

        } catch (java.sql.SQLException e) {
            System.out.println(e + " problem b");
        }

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e + " problem a");
        }



    }
}