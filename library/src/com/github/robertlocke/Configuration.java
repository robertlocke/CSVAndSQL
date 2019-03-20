package com.github.robertlocke;

public class Configuration {


    private static final String USERNAME = "PK_MON_DEV";
    private static final String PASSWORD = "PK_M_DEV";
    private String URL = "jdbc:oracle:thin:@192.168.99.100:1521:xe";


    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public String getURL() {
        return URL;
    }


}
