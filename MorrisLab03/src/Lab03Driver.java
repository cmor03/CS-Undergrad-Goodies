
public class Lab03Driver {

	public static void main(String[] args) {
		//task1
		PizzaOrder order1 = new PizzaOrder();
		//task2
		Pizza pizza1 = new Pizza(PizzaSize.LARGE,1,1,2);
		Pizza pizza2 = new Pizza(PizzaSize.MEDIUM,11,1,10);
		order1.addPizza(pizza1);
		order1.addPizza(pizza2);
		order1.printOrder();
		
		//task3
		PizzaOrder order2 = new PizzaOrder();
		Pizza pizza3 = new Pizza(PizzaSize.SMALL,10,10,10);
		Pizza pizza4 = new Pizza(PizzaSize.LARGE, 1,2,3);
		Pizza pizza5 = new Pizza(PizzaSize.LARGE, 5,6,3);
		order2.addPizza(pizza3);
		order2.addPizza(pizza4);
		order2.addPizza(pizza5);
		order2.printOrder();
		
		//task 4
		PizzaOrder order3 = order2;
		order3.printOrder();
		
		//task 5
		order1.changePizzaToppings(1, 22, 2, 2);
		order1.printOrder();
		
		//task 6
		order2.changePizzaToppings(1, 4, 4, 4);
		order2.printOrder();
		order3.printOrder();

	}
}
