package com.github.robertlocke;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Configuration {

    public static final String PATH = "settings.conf";

    private Map<String, String> properties = new HashMap<>();

    private String url;
    private String username;
    private String password;
    private String driver;

    public static final String createTable = " SQL_PERFORMANCE( ID int, CREATETIME timestamp, PERSISTTIME timestamp, SITE varchar(200), CONFIG varchar(200), QUERY varchar(200), NUMROWS int, FETCH float, TOTAL float, EXECUTION float, INSTANCE varchar(200), OPEN float, COMMIT float, CLOSE float, SUPPORTMODE varchar(200), LOCALID int, SERVERID int, QUEUEID int, ALERTLEVEL int, ALERTMAX int )";

    public Configuration() {
        this(PATH);
    }

    public Configuration(final String path) {
        try {
            if (path == null) throw new IOException("path is not set");
            readConfigFile(path);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(2);
        }
    }

    public String getUrl() {
        if (url == null) {
            this.url = properties.get("url");
        }

        return url;
    }

    public String getUsername() {
        if (username == null) {
            this.username = properties.get("username");
        }
        return username;
    }

    public String getPassword() {
        if (password == null) {
            this.password = properties.get("password");
        }
        return password;
    }

    public String getDriver() {
        if (driver == null) {
            this.driver = properties.get("driver");
        }
        return driver;
    }

    protected Map<String, String> getProperties() {
        return properties;
    }

    private void readConfigFile(String path) throws IOException {
        Pattern pattern = Pattern.compile("(\\w+)\\=(.*)");

        File file = new File(path);
        Scanner sc = new Scanner(file);
        String line;
        Matcher matcher;
        String name, value;
        while (sc.hasNextLine()) {
            line = sc.nextLine();

            matcher = pattern.matcher(line);

            if (matcher.find()) {
                name = matcher.group(1);
                value = matcher.group(2);

                properties.put(name, value);
            }
        }
    }

    public static void main(String... args) {
        Configuration config = new Configuration("settings.conf");
        System.out.println(config.getProperties());
        System.out.println(config.getUrl());
    }

}
