package br.com.poo.fatecpg.poo;

import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SampleConnector {

    // Conecta ao banco de dados e retorna a conexão
    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String pass = "app";
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;
    }

    // Obtém a relação de todos os customers
    public static ArrayList<Customer> getCustomers() throws ClassNotFoundException, SQLException {
        ArrayList<Customer> list = new ArrayList<>();
        try (Connection con = getConnection()) {
            Statement stst = con.createStatement();
            ResultSet rs = stst.executeQuery("SELECT * FROM CUSTOMER");
            //Varre todos os registros
            while (rs.next()) {
                Customer c = new Customer(rs.getString("CUSTOMER_ID"), rs.getString("NAME"), rs.getDouble("CREDIT_LIMIT"));
                list.add(c);
            }
        }
        return list;
    }

    // Obtém a relação dos melhores clientes em limite de crédito
    public static ArrayList<Customer> getBestCustomers() throws ClassNotFoundException, SQLException {
        ArrayList<Customer> list = new ArrayList<>();
        try (Connection con = getConnection()) {
            Statement stst = con.createStatement();
            ResultSet rs = stst.executeQuery("SELECT * FROM CUSTOMER ORDER BY CREDIT_LIMIT DESC");
            //Varre todos os registros
            while (rs.next()) {
                Customer c = new Customer(rs.getString("CUSTOMER_ID"), rs.getString("NAME"), rs.getDouble("CREDIT_LIMIT"));
                list.add(c);
            }
        }
        return list;
    }

    // Obtém a relação dos clientes pelo campo desejado
    public static ArrayList<Customer> getCustomersOrderBy(String field) throws ClassNotFoundException, SQLException {
        ArrayList<Customer> list = new ArrayList<>();
        try (Connection con = getConnection()) {
            Statement stst = con.createStatement();
            ResultSet rs = stst.executeQuery("SELECT * FROM CUSTOMER ORDER BY " + field + " DESC");
            //Varre todos os registros
            while (rs.next()) {
                Customer c = new Customer(rs.getString("CUSTOMER_ID"), rs.getString("NAME"), rs.getDouble("CREDIT_LIMIT"));
                list.add(c);
            }
        }
        return list;
    }
}
