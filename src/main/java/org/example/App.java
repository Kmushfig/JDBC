package org.example;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/pizza";
        String user = "postgres";
        String password = "1234";

        PizzaDAOimplement pizzaDAOimplement = new PizzaDAOimplement(url, user, password);
        Pizza pizza = new Pizza();

        Pizza pizza5 = new Pizza();
        pizza5.setId(5);
        pizza5.setName("Pepperoni");
        pizza5.setPrice(22);

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if (a == 1) {
            pizzaDAOimplement.updatePizzaPrice(10555, 3);
        } else if (a == 2) {
            pizzaDAOimplement.readPizzas(pizza.getPrice(), pizza.getId(), pizza.getName());
        } else if (a == 3) {
            pizzaDAOimplement.delete(2);
        } else if (a == 4) {
            pizzaDAOimplement.addPizza(pizza5);
        }else
            System.out.println("Error");

//        pizzaDAOimplement.readPizzas();
//        pizzaDAOimplement.delete(4);


//        pizzaDAOimplement.updatePizzaPrice(13, 1); //ZMR

//        Pizza pizza = new Pizza();
//        pizza.setId(1);
//        pizza.setName("Marqarita");
//        pizza.setPrice(12);
//
//        Pizza pizza1 = new Pizza();
//        pizza1.setId(2);
//        pizza1.setName("Mexicano");
//        pizza1.setPrice(15);
//
//        Pizza pizza3 = new Pizza();
//        pizza3.setId(3);
//        pizza3.setName("Forseason");
//        pizza3.setPrice(18);
//
//        Pizza pizza4 = new Pizza();
//        pizza4.setId(4);
//        pizza4.setName("Barbeque");
//        pizza4.setPrice(20);
//

//
//        pizzaDAOimplement.addPizza(pizza);
//        pizzaDAOimplement.addPizza(pizza1);
//        pizzaDAOimplement.addPizza(pizza3);
//        pizzaDAOimplement.addPizza(pizza4);
//        pizzaDAOimplement.addPizza(pizza5);


    }


}
