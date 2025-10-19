package Lab8;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=J5Shop;encrypt=false;trustServerCertificate=true";
        String user = "sa";
        String pass = "123";
        Connection conn = DriverManager.getConnection(url, user, pass);
        System.out.println("✅ Connected: " + conn.getMetaData().getDatabaseProductVersion());
        conn.close();
    }
}
