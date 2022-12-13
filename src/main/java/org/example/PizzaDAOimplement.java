package org.example;

import java.sql.*;
import java.util.ArrayList;

public class PizzaDAOimplement implements PizzaDAO {
    private final Connection connection;

    public PizzaDAOimplement(String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection(url, user, password);
    }

    @Override
    public void addPizza(Pizza pizza) throws SQLException {
        String sql = "insert into pizza(id, name, price) values(?,?,?)";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, pizza.getId());
        preparedStatement.setString(2, pizza.getName());
        preparedStatement.setInt(3, pizza.getPrice());

        preparedStatement.execute();
    }
    @Override
    public void updatePizzaPrice(int price, int id) throws SQLException {
        String sql = "update pizza set price = ? where id = ?";

        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, price);
        preparedStatement.setInt(2, id);

        preparedStatement.execute();
    }

    @Override
    public void readPizzas(int price, int id, String name) throws SQLException {

    }

    @Override
    public void readPizzas() throws SQLException {
        String sql = "select * from pizza";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = preparedStatement.executeQuery();
        ArrayList<String> pizzzza = new ArrayList<>();
        while (rs.next()){
            System.out.println(rs.getString("name"));
            pizzzza.add(rs.getString("name"));
        }
    }

    @Override
    public void delete() throws SQLException {

    }

    public void delete(int id) throws SQLException {

        String sqlDelete = "delete from pizza where id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sqlDelete, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,id);
        preparedStatement.execute();
    }

}
