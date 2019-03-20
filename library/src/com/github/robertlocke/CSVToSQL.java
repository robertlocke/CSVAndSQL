package com.github.robertlocke;


import com.github.utils.Settings;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CSVToSQL {

    public static void main(String[] args) {
        if (args == null) throw new IllegalArgumentException("args cannot be null");
        if (args.length < 2) throw new IllegalArgumentException("expected two arguments, file1 for the file to read, and file2 for the file to write");

        File f1 = new File(args[0]);
        File f2 = new File(args[1]);

        if (!f1.exists() && !f2.exists()){
            System.out.println("File not Found");
            System.exit(1);
        }

        try {
            Configuration configuration = new Configuration();

            System.out.println("Connecting to a selected database...");
            Connection con = DriverManager.getConnection(configuration.getURL(), configuration.getUSERNAME(), configuration.getPASSWORD());
            System.out.println("Connected database successfully...");

            System.out.println("Creating Statement to Execute...");
            Statement stmt = con.createStatement();

            Settings rw = new Settings();

            rw.setInputFilePath(f1.getAbsolutePath());
            rw.setOutputFilePath(f2.getAbsolutePath());


            try {
                PrintWriter writer = new PrintWriter(rw.getOutputFilePath(), "UTF-8");

                File file = new File(rw.getInputFilePath());

                try {
                    Scanner sc = new Scanner(file);
                    if (!sc.hasNextLine()) {
                        throw new IllegalStateException("file was empty!");
                    }

                    String line = sc.nextLine(); // don't want to loop first line
                    String[] fields;
                    SQLPerformanceSample sample;
                    SQLPerformanceSample sample2;



                    /* while (sc.hasNextLine()) {
                        line = sc.nextLine();

                        fields = line.split("\t");
                        sample = new SQLPerformanceSample(fields);
                       System.out.println(sample.toSQL()); // console
                        writer.println(sample.toSQL()); // file

                    } */


                    while (sc.hasNextLine()) {
                        line = sc.nextLine();

                        fields = line.split("\t");
                        sample = new SQLPerformanceSample(fields);
                        System.out.println(sample.toSQL()); // console

                        stmt.executeUpdate(sample.toSQL()); // Database
                        System.out.println("Execution Complete");

                    }


                    con.commit();
                    con.close();

                } catch (FileNotFoundException ex) {

                    System.out.println("Read File Not Found" + ex.getMessage());
                } finally {
                    writer.close();
                }


            } catch (IOException e) {

                System.out.println("Write File Not Found" + e.getMessage());

            }

        }catch(java.sql.SQLException ex){

        }
    }
}
