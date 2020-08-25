package classes.optionaltask.objects;

public class Order {

    private int orderNumber;
    private int customerNumber;
    private Pizza[] pizzas;


    public Order(int customerNumber, Pizza[] pizzas) {
        this.orderNumber = orderNumber;
        this.customerNumber = customerNumber;
        this.pizzas = pizzas;
    }

    public Order() {
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int max = 10;
            stringBuilder.append((int) (Math.random() * ++max));
        }
        this.orderNumber = Integer.valueOf(String.valueOf(stringBuilder));
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Pizza[] getPizzas() {
        return pizzas;
    }

    public void setPizzas(Pizza[] pizzas) {
        this.pizzas = pizzas;
    }
}
