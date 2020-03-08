package ru.sbertech.javaschoolrnd.d1zab;

import java.sql.*;

public class Driver {
    public static void main(String[] a)
            throws Exception {
        Connection conn = DriverManager.
                getConnection("jdbc:h2:~/test", "user1", "");
        // add application code here
        conn.close();
    }
}