//Mariana Costa da Luz CB3021653
//Ronald Pereira Evangelista CB3020282
package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

public class OrderDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public OrderDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
    
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    
    public boolean insertOrder(Order order) throws SQLException {
    	String sql = "INSERT INTO orders (purch_amt, ord_date, customer_id, salesman_id) VALUES (?, ?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setFloat(1, order.getPurch_amt());
        statement.setDate(2, order.getOrd_date());
        statement.setInt(3, order.getCustomer_id());
        statement.setInt(4, order.getSalesman_id());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public List<Order> listAllOrders() throws SQLException {
        List<Order> listOrder = new ArrayList<>();
         
        String sql = "SELECT * FROM orders";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int ord_no = resultSet.getInt("ord_no");
            float purch_amt = resultSet.getFloat("purch_amt");
            Date ord_date = resultSet.getDate("ord_date");
            int customer_id = resultSet.getInt("customer_id");
            int salesman_id = resultSet.getInt("salesman_id");
             
            Order order = new Order(ord_no, purch_amt, ord_date, customer_id, salesman_id);
            listOrder.add(order);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listOrder;
    }
    
    public boolean deleteOrder(Order order) throws SQLException {
        String sql = "DELETE FROM orders where ord_no = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, order.getCustomer_id());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
    
    public boolean updateOrder(Order order) throws SQLException {
        String sql = "UPDATE orders SET purch_amt = ?, ord_date = ?, customer_id = ?, salesman_id = ?";
        sql += " WHERE ord_no = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setFloat(1, order.getPurch_amt());
        statement.setDate(2, order.getOrd_date());
        statement.setInt(3, order.getCustomer_id());
        statement.setInt(4, order.getSalesman_id());
        statement.setInt(5, order.getOrd_no());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    public Order getOrder(int ord_no) throws SQLException {
        Order order = null;
        String sql = "SELECT * FROM orders WHERE ord_no = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, ord_no);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	Float purch_amt = resultSet.getFloat("purch_amt");
            Date ord_date = resultSet.getDate("ord_date");
            int customer_id = resultSet.getInt("customer_id");
            int salesman_id = resultSet.getInt("salesman_id");
            
            order = new Order(ord_no, purch_amt, ord_date, customer_id, salesman_id);
        }
         
        resultSet.close();
        statement.close();
         
        return order;
    }
    
}
