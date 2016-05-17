package ru.JDBC.DaoJdbcImpl;



import java.sql.*;
import java.sql.Connection;


public class JdbcUtil {
    private static boolean initialized;
    public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/test";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "password";


    public static synchronized void initDriver(String driverClass){
        if (!initialized){
            try {
                Class.forName(driverClass);
            }catch (ClassNotFoundException e){
                System.out.println("������� �� ��������");
            }
            initialized = true;
        }
    }
    public Connection getConnection()  {
        initDriver(DRIVER_CLASS_NAME);
        try {
            return DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
