package com.github.robertlocke;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.Statement;

public class FindAllInDatabase {
    static Logger log = LogManager.getLogger(ImportSQL.class);

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        Database db = new Database(configuration);

        try {

            db.open();

            Statement stmt = db.getStatement();
            ResultSet rs = stmt.executeQuery("select * from sql_performance");

            while (rs.next()){
                System.out.println(rs.getInt(1) + "  " + rs.getDate(2) + "  " + rs.getDate(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getInt(7) + " " + rs.getFloat(8) + " " + rs.getFloat(9) + " " + rs.getFloat(10) + " " + rs.getString(11) + " " + rs.getFloat(12) + " " + rs.getFloat(13) + " " + rs.getFloat(14) + " " + rs.getString(15) + " " + rs.getLong(16) + " " + rs.getLong(17) + " " + rs.getLong(18) + " " + rs.getInt(19) + " " + rs.getInt(20));
            }
            stmt.close();
            rs.close();

            db.commit();

        } catch (java.sql.SQLException e) {
            log.error(e + " Query Issue");
        }finally{
            db.close();
        }




    }
}