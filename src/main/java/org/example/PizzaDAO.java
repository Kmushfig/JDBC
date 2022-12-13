package org.example;

import java.sql.SQLException;

public interface PizzaDAO {
    void addPizza(Pizza pizza) throws SQLException;
    void updatePizzaPrice(int price, int id) throws SQLException;
    void readPizzas(int price, int id, String name) throws SQLException;
    void readPizzas() throws SQLException;
    void delete() throws SQLException;
}
