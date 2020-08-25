package classes.optionaltask;

import classes.optionaltask.objects.Ingredient;
import classes.optionaltask.objects.Order;
import classes.optionaltask.objects.Pizza;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Palmetto {

    private final static int maxNumberIngredients = 7;
    private final static int maxQuantityPizza = 10;
    private static Map<String, Double> baseIngredientsPizza;

    public static void main(String[] args) {

        //Data filling
        baseIngredientsPizza = new HashMap<>();
        baseIngredientsPizza.put("Base", 1.0);
        baseIngredientsPizza.put("Calzone", 0.5);
        baseIngredientsPizza.put("Tomato Paste", 1.0);
        baseIngredientsPizza.put("Cheese", 1.0);
        baseIngredientsPizza.put("Salami", 1.5);
        baseIngredientsPizza.put("Bacon", 1.2);
        baseIngredientsPizza.put("Garlic", 0.3);
        baseIngredientsPizza.put("Corn", 0.7);
        baseIngredientsPizza.put("Pepperoni", 0.6);
        baseIngredientsPizza.put("Olives", 0.5);

        //The order of the First customer
        String[] ingredientsToOrderPizzaMargarita = {"Tomato Paste", "Pepperoni", "Garlic", "Bacon"};
        String[] ingredientsToOrderPizzaPepperoniOro = {"Tomato Paste", "Cheese", "Salami", "Olives"};
        Pizza pizzaMargarita = choosePizza("Margarita", "Calzone", 2, ingredientVerification(ingredientsToOrderPizzaMargarita));
        Pizza pizzaPepperoniOro = choosePizza("PepperoniOro", "", 3, ingredientVerification(ingredientsToOrderPizzaPepperoniOro));

        Pizza[] pizzasFirstCustomer = new Pizza[2];
        pizzasFirstCustomer[0] = pizzaMargarita;
        pizzasFirstCustomer[1] = pizzaPepperoniOro;

        makeOrder(7717, pizzasFirstCustomer);

        //The order of the Second customer
        String[] ingredientsToOrderPizzaBasePZZ = {"Corn", "Tomato Paste", "Tomato Paste", "Cheese", "Salami", "Olives", "Bacon", "Garlic", "Pepperoni"};
        Pizza pizzaBasePZZ = choosePizza("BasePZZ", "", 12, ingredientVerification(ingredientsToOrderPizzaBasePZZ));

        Pizza[] pizzasSecondCustomer = new Pizza[1];
        pizzasSecondCustomer[0] = pizzaBasePZZ;

        makeOrder(4372, pizzasSecondCustomer);

        //The order of the Third customer
        String[] ingredientsToOrderPizzaNone = {"Tomato Paste", "Cheese", "Salami", "Corn"};
        String[] ingredientsToOrderPizzaDog = {"Corn", "Tomato Paste", "Tomato Paste"};
        Pizza pizzaNone = choosePizza("", "", 4, ingredientVerification(ingredientsToOrderPizzaNone));
        Pizza pizzaDog = choosePizza("", "Calzone", 11, ingredientVerification(ingredientsToOrderPizzaDog));

        Pizza[] pizzasThirdCustomer = new Pizza[2];
        pizzasThirdCustomer[0] = pizzaNone;
        pizzasThirdCustomer[1] = pizzaDog;

        makeOrder(6571, pizzasThirdCustomer);
    }

    private static String[] ingredientVerification(String[] ingredients) {
        Set<String> set = new HashSet<>();
        for (String item : ingredients) {
            if (set.contains(item)) {
                System.out.println("Please check the order, the ingredient " + item.toUpperCase() + " are repeated");
            } else {
                if (set.size() < maxNumberIngredients) {
                    set.add(item);
                } else System.out.println("The pizza is full, you can't add ingredient " + item.toUpperCase());
            }
        }
        return set.toArray(new String[set.size()]);
    }


    private static Pizza choosePizza(String namePizza, String typePizza, int quantityPizza, String[] ingredientsToOrderPizza) {
        Pizza pizza = new Pizza();
        pizza.setNamePizza(namePizza);
        pizza.setIngredients(addIngredient(ingredientsToOrderPizza, baseIngredientsPizza));
        pizza.setTypePizza(typePizza);
        pizza.setQuantity(quantityPizza);
        return pizza;
    }


    private static void makeOrder(int customerNumber, Pizza[] pizzas) {

        Order order = new Order();
        order.setOrderNumber();
        order.setCustomerNumber(customerNumber);

        namePizzaVerification(pizzas, order);

        for (Pizza pizza : pizzas) {
            if (pizza.getQuantity() > maxQuantityPizza) {
                System.out.println("You can only order " + maxQuantityPizza + " pizzas " + pizza.getNamePizza().toUpperCase());
            }
        }

        changeQuantityPizza(pizzas);

        order.setPizzas(pizzas);
        printPizzaAttributes(order);
        printСheck(order);

        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    private static void changeQuantityPizza(Pizza[] pizzas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your pizza:");

        for (int i = 0; i < pizzas.length; i++) {
            System.out.println(i + " " + pizzas[i].getNamePizza() + " - " + pizzas[i].getQuantity());
        }


        System.out.println("Do you want to change the quantity of pizzas?");
        System.out.println("Select YES(input 'Y') or NO(input 'N')");
        String answer = scanner.nextLine();
        int numberPizza;

        if ("Y".equals(answer)) {
            System.out.println("Input number of pizza:");
            numberPizza = scanner.nextInt();
            System.out.println("Input quantity of pizza:");
            int quantity = scanner.nextInt();
            pizzas[numberPizza].setQuantity(quantity);
            System.out.println("Quantity pizza " + pizzas[numberPizza].getNamePizza().toUpperCase() + "  has been changed");
        } else {
            for (Pizza pizza : pizzas) {
                if (pizza.getQuantity() > maxQuantityPizza) {
                    pizza.setQuantity(maxQuantityPizza);
                    System.out.println("The quantity pizza " + pizza.getNamePizza().toUpperCase() + " is automatically reduced to " + maxQuantityPizza);
                }
            }
        }
    }

    private static void namePizzaVerification(Pizza[] pizzas, Order order) {

        for (int i = 0; i < pizzas.length; i++) {
            if (pizzas[i].getNamePizza().isEmpty() ||
                    pizzas[i].getNamePizza().length() < 4 ||
                    pizzas[i].getNamePizza().length() > 20 ||
                    !pizzas[i].getNamePizza().matches("^[a-zA-Z0-9]+$")) {
                String namePizzaNew = order.getCustomerNumber() + "_" + (i + 1);
                pizzas[i].setNamePizza(namePizzaNew);
            }
        }
    }


    private static void printСheck(Order order) {
        System.out.println("\n********************************");
        System.out.println("Заказ: " + order.getOrderNumber());
        System.out.println("Клиент: " + order.getCustomerNumber());
        double totalSum = 0.0;

        for (Pizza pizza : order.getPizzas()) {
            System.out.println("Название: " + pizza.getNamePizza());
            System.out.println("--------------------------------");
            String str = "\t";
            if (pizza.getTypePizza().equals("Calzone")) {
                str = " (Calzone)";
            }
            double sumСostPizza = 0.0;
            double pizzaBasePrise = getPizzaBasePrice(pizza.getTypePizza());
            System.out.println("Pizza Base" + str + "\t" + pizzaBasePrise + " €");
            sumСostPizza = sumСostPizza + pizzaBasePrise;

            for (Ingredient ingredient : pizza.getIngredients()) {
                System.out.println("\t" + ingredient.getName() + "\t\t" + ingredient.getPrice() + " €");
                sumСostPizza = sumСostPizza + ingredient.getPrice();
            }

            System.out.println("--------------------------------");
            System.out.println("Всего: \t" + sumСostPizza + " €");
            System.out.println("Кол-во: \t" + pizza.getQuantity());
            System.out.println("--------------------------------");
            BigDecimal decimal = BigDecimal.valueOf(sumСostPizza);
            totalSum = decimal.multiply(BigDecimal.valueOf(pizza.getQuantity())).add(BigDecimal.valueOf(totalSum)).doubleValue();
        }

        System.out.println("Общая сумма: \t" + totalSum + " €");
        System.out.println("********************************");
    }


    private static void printPizzaAttributes(Order order) {
        for (Pizza pizza : order.getPizzas()) {
            System.out.println("[" + order.getOrderNumber() + " : " + order.getCustomerNumber() + " : " + pizza.getNamePizza() + " : " + pizza.getQuantity() + "]");
        }
    }


    private static double getPizzaBasePrice(String typePizza) {
        double priceBase = baseIngredientsPizza.get("Base");
        if (typePizza.equals("Calzone")) {
            return priceBase + baseIngredientsPizza.get(typePizza);
        } else return priceBase;
    }


    private static Ingredient[] addIngredient(String[] ingredientsToOrder, Map<String, Double> baseIingredientsPizza) {

        List<Ingredient> listIngredient = new ArrayList<>();
        for (String nameIngr : ingredientsToOrder) {
            double priceIng = baseIingredientsPizza.get(nameIngr);
            listIngredient.add(new Ingredient(nameIngr, priceIng));
        }
        return listIngredient.toArray(new Ingredient[listIngredient.size()]);
    }
}
