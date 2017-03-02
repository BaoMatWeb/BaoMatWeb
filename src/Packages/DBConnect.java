package Packages;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnecttion() {
        Connection cons = null;
        try {
        	String dbname="db_webnckh";
        	String dbuser="root";
        	String dbpass="123456";
            Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/"+dbname+"?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8", dbuser, dbpass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }
 
    public static void main(String[] args) {
        System.out.println(getConnecttion());
    }

}

