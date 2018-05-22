package br.com.poo.fatecpg.poo;

import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SampleConnector {
    
    public static ArrayList<Customer> getCustomers() throws ClassNotFoundException, SQLException{
        ArrayList<Customer> list = new ArrayList<>();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String pass = "app";
        Connection con = DriverManager.getConnection(url, user, pass);
        //Já está conectado ao banco
        Statement stst = con.createStatement();
        ResultSet rs = stst.executeQuery("SELECT * FROM CUSTOMER");
        //Varre todos os registros
        while(rs.next()){
            Customer c = new Customer(rs.getString("CUSTOMER_ID"), rs.getString("NAME"), rs.getDouble("CREDIT_LIMIT"));
            list.add(c);
        }
        return list;
    }
    
        public static ArrayList<Customer> getBestCustomers() throws ClassNotFoundException, SQLException{
        ArrayList<Customer> list = new ArrayList<>();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String pass = "app";
        Connection con = DriverManager.getConnection(url, user, pass);
        //Já está conectado ao banco
        Statement stst = con.createStatement();
        ResultSet rs = stst.executeQuery("SELECT * FROM CUSTOMER ORDER BY CREDIT_LIMIT DESC");
        //Varre todos os registros
        while(rs.next()){
            Customer c = new Customer(rs.getString("CUSTOMER_ID"), rs.getString("NAME"), rs.getDouble("CREDIT_LIMIT"));
            list.add(c);
        }
        return list;
    }
}
