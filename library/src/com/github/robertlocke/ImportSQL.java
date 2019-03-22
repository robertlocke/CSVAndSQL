package com.github.robertlocke;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ImportSQL {

    static Logger log = LogManager.getLogger(ImportSQL.class);


    public static void main(String[] args) {
        if (args == null || args.length == 0)
            throw new IllegalArgumentException("1 argument with the path to a .SQL file to import is required");

        String path = args[0];

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File not Found");
            System.exit(1);
        }

        Configuration configuration = new Configuration();
        Database db = new Database(configuration);

        try {
            log.info("Connecting to DB...");
            db.open();
            log.info("Connection Succesful...");

            Scanner sc = new Scanner(file);
            if (!sc.hasNextLine()) {
                throw new IllegalStateException("file was empty!");
            }

            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();

                if (line.isBlank()) continue;

                if (line.contains(";")) {
                    line = line.substring(0, line.lastIndexOf(";"));
                }

                System.out.println("Executing `" + line + "`");

                Statement stmt = db.getStatement();
                stmt.executeUpdate(line);
                stmt.close();

                log.info("Insert Executed");
            }

            db.commit();
            System.out.println("Execution Complete");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(2);
        } finally {
            db.close();
        }
    }

}
