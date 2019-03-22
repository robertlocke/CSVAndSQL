package com.github.robertlocke;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConvertCSVToSQL {

    public static class Settings {
        private String inputFilePath;
        private String outputFilePath;

        public String getInputFilePath() {
            return inputFilePath;
        }

        public void setInputFilePath(String inputFilePath) {
            this.inputFilePath = inputFilePath;
        }

        public String getOutputFilePath() {
            return outputFilePath;
        }

        public void setOutputFilePath(String outputFilePath) {
            this.outputFilePath = outputFilePath;
        }
    }

    static Logger log = LogManager.getLogger(ImportSQL.class);

    public static void main(String[] args) {



        File f1 = new File(args[0]);
        File f2 = new File(args[1]);

        if (!f1.exists() && !f2.exists()){
            log.error("File not Found"); // log4j2  ... log.debug()
            System.exit(1); // log4j2.xml configure appenders
        }

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
                SQLPerformanceSample sample3;

               sample2 = new SQLPerformanceSample();
                System.out.println(sample2.deleteTable());
                writer.println(sample2.deleteTable());

                sample3 = new SQLPerformanceSample();
                System.out.println(sample3.createTable());
                writer.println(sample3.createTable());


                while(sc.hasNextLine()){
                    line = sc.nextLine();

                    fields = line.split("\t");
                    sample = new SQLPerformanceSample(fields);
                    System.out.println(sample.toSQL()); // console
                    writer.println(sample.toSQL()); // file
                }

            } catch (FileNotFoundException ex) {

                log.error("Read File Not Found" + ex.getMessage());
            }finally{
                writer.close();
            }


        } catch (IOException e) {

            log.error("Write File Not Found" + e.getMessage());

        }

    }
}
